package codegen.business;


import codegen.CodeGenApplication;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 获取配置信息
 */
public class GenConfig
{
    private static final GenConfig genConfig = new GenConfig();
    public static GenConfig getConfig()
    {
        return genConfig;
    }

    public String jdbcUrl;
    public String jdbcUsername;
    public String jdbcPassword;
    /** 待生成代码表 */
    public String genTable;

    /** 作者 */
    public String author;

    /** 生成包路径 */
    public String packageName;

    /** 自动去除表前缀，默认是false */
    public boolean autoRemovePre;

    /** 表前缀(类名不会包含表前缀) */
    public String tablePrefix;

    GenConfig() {
        Map<String, Object> yml = getYml();
        // 获取JDBC连接数据
        jdbcUrl = (String) yml.get("jdbcUrl");
        jdbcUsername = (String) yml.get("jdbcUsername");
        jdbcPassword = String.valueOf(yml.get("jdbcPassword"));
        genTable = (String) yml.get("genTable");
        author = (String) yml.get("genAuthor");
        packageName = (String) yml.get("genPackage");
        autoRemovePre = (Boolean) yml.get("genRemovePre");
        tablePrefix = (String) yml.get("genPrefix");
    }

    /**
     * 获取yml配置
     *
     * @return
     * @throws IOException
     */
    public Map<String, Object> getYml() {
        String path = new CodeGenApplication().getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        String[] pathSplit = path.split("/");
        String jarName = pathSplit[pathSplit.length - 1];
        String jarPath = path.replace(jarName, "");
        String pathName = jarPath + "config.yml";
        System.out.println("配置文件路径：" + jarPath);

        //读取配置文件
        try {
        Yaml yml = new Yaml();
        FileReader reader = new FileReader(pathName);
        BufferedReader buffer = new BufferedReader(reader);
        Map<String,Object> map = yml.load(buffer);
        buffer.close();
        reader.close();
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>(1);
        }
    }

    // GenConfig() {
    //     Properties properties = getProperties();
    //     // 获取JDBC连接数据
    //     jdbcUrl = properties.getProperty("jdbc.url");
    //     jdbcUsername = properties.getProperty("jdbc.username");
    //     jdbcPassword = properties.getProperty("jdbc.password");
    //     genTable = properties.getProperty("gen.table");
    //     author = properties.getProperty("gen.author");
    //     packageName = properties.getProperty("gen.package");
    //     autoRemovePre = new Boolean(properties.getProperty("gen.removePre"));
    //     tablePrefix = properties.getProperty("gen.prefix");
    // }

    // /**
    //  * 获取properties配置
    //  *
    //  * @return
    //  * @throws IOException
    //  */
    // public Properties getProperties() {
    //     String path = new CodeGenApplication().getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
    //     String[] pathSplit = path.split("/");
    //     String jarName = pathSplit[pathSplit.length - 1];
    //     String jarPath = path.replace(jarName, "");
    //     String pathName = jarPath + "config.properties";
    //     System.out.println("配置文件路径：" + jarPath);
    //
    //     //读取配置文件
    //     Properties properties = new Properties();
    //     try {
    //         File file = new File(pathName);
    //         FileInputStream fis = new FileInputStream(file);
    //         properties.load(fis);
    //         fis.close();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    //     return properties;
    // }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcUsername() {
        return jdbcUsername;
    }

    public void setJdbcUsername(String jdbcUsername) {
        this.jdbcUsername = jdbcUsername;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }

    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }

    public String getGenTable() {
        return genTable;
    }

    public void setGenTable(String genTable) {
        this.genTable = genTable;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public boolean getAutoRemovePre() {
        return autoRemovePre;
    }

    public void setAutoRemovePre(boolean autoRemovePre) {
        this.autoRemovePre = autoRemovePre;
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }
}
