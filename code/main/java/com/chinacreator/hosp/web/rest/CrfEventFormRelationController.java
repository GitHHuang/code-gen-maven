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
import com.chinacreator.hosp.pojo.entity.CrfEventFormRelation;
import com.chinacreator.hosp.service.ICrfEventFormRelationService;


/**
 * 事件与单关联Controller
 * 
 * @author hc
 * @date 2022-10-11
 */
@Controller
@Path("hosp/v1/crfEventFormRelation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api("事件与单关联管理")
public class CrfEventFormRelationController {
    @Autowired
    private ICrfEventFormRelationService crfEventFormRelationService;

    @POST
    @Path("/list")
    @ApiOperation(value = "分页查询事件与单关联列表", tags = "事件与单关联管理", notes = "根据条件查询事件与单关联表")
    public Response<Page<CrfEventFormRelation>> list(@ApiParam CrfEventFormRelation queryParam) {
        Page<CrfEventFormRelation> crfEventFormRelationPage = crfEventFormRelationService.selectCrfEventFormRelationPage(queryParam);
        return Response.success(crfEventFormRelationPage);
    }

    @GET
    @Path("/{relationId}")
    @ApiOperation(value = "查询指定事件与单关联信息", tags = "事件与单关联管理", notes = "根据事件与单关联表id查询事件与单关联信息")
    public Response get(@ApiParam(value = "事件与单关联表id") @PathParam(value = "relationId") String relationId) {
        return Response.success(crfEventFormRelationService.selectCrfEventFormRelationById(relationId));
    }

    @POST
    @Path("")
    @Validated
    @ApiOperation(value = "新增事件与单关联信息", tags = "事件与单关联管理", notes = "新增事件与单关联信息")
    public Response insert(@ApiParam(value = "事件与单关联信息") @Valid CrfEventFormRelation crfEventFormRelation) {
        return Response.success(crfEventFormRelationService.insertCrfEventFormRelation(crfEventFormRelation));
    }

    @PUT
    @Path("")
    @Validated
    @ApiOperation(value = "更新事件与单关联信息", tags = "事件与单关联管理", notes = "更新事件与单关联信息")
    public Response update(@ApiParam(value = "事件与单关联信息") @Valid CrfEventFormRelation crfEventFormRelation) {
        return Response.success(crfEventFormRelationService.updateCrfEventFormRelation(crfEventFormRelation));
    }

    @DELETE
    @Path("/{relationId}")
    @ApiOperation(value = "删除事件与单关联信息", tags = "事件与单关联管理", notes = "删除事件与单关联信息")
    public Response delete(@ApiParam(value = "事件与单关联表id") @PathParam(value = "relationId") String relationId) {
        return Response.success(crfEventFormRelationService.deleteCrfEventFormRelation(relationId));
    }

    @DELETE
    @Path("")
    @ApiOperation(value = "批量删除事件与单关联信息", tags = "事件与单关联管理", notes = "根据事件与单关联表id集合批量删除事件与单关联信息")
    public Response deleteBatch(@ApiParam(value = "事件与单关联表id集合") @QueryParam(value = "relationIds")
                                   @NotEmpty(message = "事件与单关联编号不能为空") List<String> relationIds) {
        return Response.success(crfEventFormRelationService.deleteBatchCrfEventFormRelation(relationIds));
    }

    @GET
    @Path("")
    @ApiOperation(value = "分页查询事件与单关联信息", tags = "事件与单关联管理", notes = "根据条件查询事件与单关联表")
    public Page<CrfEventFormRelation> getListByPage(@ApiParam(value = "页号") @QueryParam(value = "page") int page,
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
        CrfEventFormRelation entity = parseRequestParams(request);

        return DaoFactory.create(CrfEventFormRelation.class).selectPageByCondition(entity, conditions, pageable, sortable, true);

    }

    private CrfEventFormRelation parseRequestParams(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("relationId", request.getParameter("relationId"));
        map.put("eventId", request.getParameter("eventId"));
        map.put("formVersionId", request.getParameter("formVersionId"));
        return JSON.parseObject(JSON.toJSONString(map), CrfEventFormRelation.class);
    }
}
