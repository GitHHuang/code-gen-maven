package com.chinacreator.hosp.web.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import com.alibaba.fastjson.JSON;
import com.chinacreator.c2.dao.DaoFactory;
import com.chinacreator.c2.dao.mybatis.enhance.Conditions;
import com.chinacreator.c2.dao.mybatis.enhance.Page;
import com.chinacreator.c2.dao.mybatis.enhance.Pageable;
import com.chinacreator.c2.dao.mybatis.enhance.Sortable;
import com.chinacreator.c2.web.util.ConditionsUtil;
import com.chinacreator.c2.web.util.SortableUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import com.chinacreator.hosp.common.Response;
import com.chinacreator.hosp.pojo.entity.CrfPatient;
import com.chinacreator.hosp.service.ICrfPatientService;


/**
 * 患者Controller
 * 
 * @author hc
 * @date 2022-10-11
 */
@Controller
@Path("hosp/v1/crfPatient")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api("患者管理")
public class CrfPatientController {
    @Autowired
    private ICrfPatientService crfPatientService;

    @POST
    @Path("/list")
    @ApiOperation(value = "分页查询患者列表", tags = "患者管理", notes = "根据条件查询患者表")
    public Response<Page<CrfPatient>> list(@ApiParam CrfPatient queryParam) {
        Page<CrfPatient> crfPatientPage = crfPatientService.selectCrfPatientPage(queryParam);
        return Response.success(crfPatientPage);
    }

    @GET
    @Path("/{patientId}")
    @ApiOperation(value = "查询指定患者信息", tags = "患者管理", notes = "根据患者表id查询患者信息")
    public Response get(@ApiParam(value = "患者表id") @PathParam(value = "patientId") String patientId) {
        return Response.success(crfPatientService.selectCrfPatientById(patientId));
    }

    @POST
    @Path("")
    @Validated
    @ApiOperation(value = "新增患者信息", tags = "患者管理", notes = "新增患者信息")
    public Response insert(@ApiParam(value = "患者信息") @Valid CrfPatient crfPatient) {
        return Response.success(crfPatientService.insertCrfPatient(crfPatient));
    }

    @PUT
    @Path("")
    @Validated
    @ApiOperation(value = "更新患者信息", tags = "患者管理", notes = "更新患者信息")
    public Response update(@ApiParam(value = "患者信息") @Valid CrfPatient crfPatient) {
        return Response.success(crfPatientService.updateCrfPatient(crfPatient));
    }

    @DELETE
    @Path("/{patientId}")
    @ApiOperation(value = "删除患者信息", tags = "患者管理", notes = "删除患者信息")
    public Response delete(@ApiParam(value = "患者表id") @PathParam(value = "patientId") String patientId) {
        return Response.success(crfPatientService.deleteCrfPatient(patientId));
    }

    @DELETE
    @Path("")
    @ApiOperation(value = "批量删除患者信息", tags = "患者管理", notes = "根据患者表id集合批量删除患者信息")
    public Response deleteBatch(@ApiParam(value = "患者表id集合") @QueryParam(value = "patientIds")
                                   @NotEmpty(message = "患者编号不能为空") List<String> patientIds) {
        return Response.success(crfPatientService.deleteBatchCrfPatient(patientIds));
    }

    @GET
    @Path("")
    @ApiOperation(value = "分页查询患者信息", tags = "患者管理", notes = "根据条件查询患者表")
    public Page<CrfPatient> getListByPage(@ApiParam(value = "页号") @QueryParam(value = "page") int page,
                                            @ApiParam(value = "页大小") @QueryParam(value = "rows") int rows,
                                            @ApiParam(value = "排序字段") @QueryParam(value = "sidx") String sidx,
                                            @ApiParam(value = "排序方式asc、desc") @QueryParam(value = "sord") String sord,
                                            @ApiParam(value = "查询条件") @QueryParam(value = "cond") String cond, @Context HttpServletRequest request) {
        //创建分页对象
        Pageable pageable = new Pageable(page, rows);
        //创建排序对象
        Sortable sortable = SortableUtil.getSortable(sidx, sord);
        /*创建高级查询对象*/
        Conditions conditions = null;
        if (StringUtils.isNotBlank(cond)) {
            conditions = ConditionsUtil.getConditions(cond, "filters");
        }
        /*初始化实体对象*/
        CrfPatient entity = parseRequestParams(request);

        return DaoFactory.create(CrfPatient.class).selectPageByCondition(entity, conditions, pageable, sortable, true);

    }

    private CrfPatient parseRequestParams(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("patientId", request.getParameter("patientId"));
        map.put("patientName", request.getParameter("patientName"));
        map.put("patientSex", request.getParameter("patientSex"));
        map.put("patientAge", request.getParameter("patientAge"));
        map.put("patientIdcard", request.getParameter("patientIdcard"));
        map.put("patientPhone", request.getParameter("patientPhone"));
        map.put("patientArea", request.getParameter("patientArea"));
        map.put("patientAddress", request.getParameter("patientAddress"));
        map.put("projectId", request.getParameter("projectId"));
        map.put("projectName", request.getParameter("projectName"));
        map.put("nextFollowDate", request.getParameter("nextFollowDate"));
        map.put("nextEventId", request.getParameter("nextEventId"));
        map.put("nextWindowDateStart", request.getParameter("nextWindowDateStart"));
        map.put("nextWindowDateEnd", request.getParameter("nextWindowDateEnd"));
        map.put("shareStatus", request.getParameter("shareStatus"));
        map.put("createTime", request.getParameter("createTime"));
        map.put("createUserId", request.getParameter("createUserId"));
        map.put("createUserName", request.getParameter("createUserName"));
        map.put("updateTime", request.getParameter("updateTime"));
        map.put("updateUserId", request.getParameter("updateUserId"));
        map.put("updateUserName", request.getParameter("updateUserName"));
        map.put("sort", request.getParameter("sort"));
        map.put("deleted", request.getParameter("deleted"));
        return JSON.parseObject(JSON.toJSONString(map), CrfPatient.class);
    }
}
