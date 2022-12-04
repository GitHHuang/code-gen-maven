package codegen;

/**
 * @author Administrator
 */

import codegen.business.GenConfig;
import codegen.business.domain.GenTable;
import codegen.business.domain.GenTableColumn;
import codegen.business.utils.GenUtils;
import codegen.business.utils.StringUtils;
import codegen.business.utils.VelocityUtils;

import javax.sql.DataSource;
import java.io.*;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CodeGenApplication {

    private static GenConfig config = GenConfig.getConfig();

    private static volatile DataSource dataSource = null;

    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        // 创建连接并查询表信息
        Connection connection = getConnection();
        String tableSql = "select table_name, table_comment, create_time, update_time from information_schema.tables where table_schema = (select database()) and table_name in ( " + config.getGenTable() + " )";
        System.out.println("tablesql:"+tableSql);
        PreparedStatement statement = connection.prepareStatement(tableSql);
        ResultSet result = statement.executeQuery();
        List<GenTable> tableList = new ArrayList<>();
        while (result.next()) {
            tableList = (List<GenTable>) getBeans(result, GenTable.class);
        }

        for (GenTable table : tableList) {
            table.setPackageName(config.getPackageName());
            GenUtils.initTable(table, null);
            System.out.println(table);

            // 查询表字段信息
            String columnSql = "select column_name, (case when (is_nullable = 'no' && column_key != 'PRI') then '1' else null end) as is_required, (case when column_key = 'PRI' then '1' else '0' end) as is_pk,  column_comment, (case when extra = 'auto_increment' then '1' else '0' end) as is_increment, column_type\n" +
                    "\t\tfrom information_schema.columns where table_schema = (select database()) and table_name = '"+table.getTableName()+"'\n" +
                    "\t\torder by ordinal_position";
            System.out.println("columnSql:"+columnSql);
            PreparedStatement columnStatement = connection.prepareStatement(columnSql);
            ResultSet columnResult = columnStatement.executeQuery();
            List<GenTableColumn> columnList = new ArrayList<>();
            while (columnResult.next()) {
                columnList = (List<GenTableColumn>) getBeans(columnResult, GenTableColumn.class);
                for (GenTableColumn genTableColumn : columnList) {
                    GenUtils.initColumnField(genTableColumn, table);
                    System.out.println(genTableColumn);
                }
            }
            close(null, columnStatement, null);
            // 获得完整表结构信息
            table.setColumns(columnList);
            table.setPkColumn(columnList.get(0));

            // 初始化Velocity模板引擎
            VelocityUtils.initVelocity();
            VelocityContext context = VelocityUtils.prepareContext(table);

            // 获取模板列表
            List<String> templates = VelocityUtils.getTemplateList(table.getTplCategory());
            for (String template : templates) {
                // 渲染模板
                StringWriter sw = new StringWriter();
                Template tpl = Velocity.getTemplate(template, "UTF-8");
                tpl.merge(context, sw);
                try {
                    // 添加到zip
                    zip.putNextEntry(new ZipEntry(VelocityUtils.getFileName(template, table)));
                    IOUtils.write(sw.toString(), zip, "UTF-8");
                    IOUtils.closeQuietly(sw);
                    zip.flush();
                    zip.closeEntry();
                } catch (IOException e) {
                    System.out.println("渲染模板失败，表名：" + table.getTableName());
                }
            }
        }
        IOUtils.closeQuietly(zip);
        // 生成压缩包文件
        File file = new File("code.zip");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(outputStream.toByteArray());
        // 关闭连接
        close(connection, statement, result);
    }

    /**
     * 创建数据源
     *
     * @return
     */
    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (CodeGenApplication.class) {
                if (dataSource == null) {
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource) dataSource).setURL(config.getJdbcUrl());
                    ((MysqlDataSource) dataSource).setUser(config.getJdbcUsername());
                    ((MysqlDataSource) dataSource).setPassword(config.getJdbcPassword());
                }
            }
        }
        return dataSource;
    }

    /**
     * 创建数据库连接
     *
     * @return
     */
    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("数据库连接失败, 请检查数据库是否启动正确, url 是否正确");
        return null;
    }

    /**
     * 关闭数据库连接
     *
     * @param connection
     * @param statement
     * @param resultSet
     */
    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 映射结果集到JavaBean
     *
     * @param resultSet
     * @param clazz
     * @return
     * @throws Exception
     */
    public static Object getBeans(ResultSet resultSet, Class clazz) throws Exception {
        //获取要封装的javabean声明的属性
        Field[] fields = clazz.getDeclaredFields();
        //获取ResultSetMetaData(包含ResultSet中列的名称和类型的信息)
        ResultSetMetaData metaData = resultSet.getMetaData();
        //光标移到最后
        resultSet.last();
        //获取结果数据条数
        int rows = resultSet.getRow();
        //光标移到第一条数据前
        resultSet.beforeFirst();
        //获取查询结果列数
        int columnCount = metaData.getColumnCount();
        if (rows > 1) {
            List<Object> list = new ArrayList<>();
            //遍历ResultSet
            while (resultSet.next()) {
                //调用无参构造实例化对象
                Object object = clazz.newInstance();
                for (int j = 1; j <= columnCount; j++) {
                    //获取列名
                    String columnName = metaData.getColumnName(j);
                    //匹配JavaBean的属性,然后赋值
                    for (Field field : fields) {
                        field.setAccessible(true);
                        if (field.getName().equalsIgnoreCase(StringUtils.toCamelCase(columnName))) {
                            field.set(object, resultSet.getObject(columnName));
                        }
                    }
                }
                list.add(object);
            }
            return list;
        } else {
            Object object = clazz.newInstance();
            //遍历ResultSet
            while (resultSet.next()) {
                for (int j = 1; j <= columnCount; j++) {
                    String columnName = metaData.getColumnName(j);
                    for (Field field : fields) {
                        field.setAccessible(true);
                        if (field.getName().equalsIgnoreCase(StringUtils.toCamelCase(columnName))) {
                            field.set(object, resultSet.getObject(columnName));
                        }
                    }
                }
            }
            return object;
        }
    }
}