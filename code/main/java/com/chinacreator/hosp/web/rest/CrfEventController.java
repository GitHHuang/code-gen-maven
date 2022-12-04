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
import com.chinacreator.hosp.pojo.entity.CrfEvent;
import com.chinacreator.hosp.service.ICrfEventService;


/**
 * 事件Controller
 * 
 * @author hc
 * @date 2022-10-11
 */
@Controller
@Path("hosp/v1/crfEvent")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api("事件管理")
public class CrfEventController {
    @Autowired
    private ICrfEventService crfEventService;

    @POST
    @Path("/list")
    @ApiOperation(value = "分页查询事件列表", tags = "事件管理", notes = "根据条件查询事件表")
    public Response<Page<CrfEvent>> list(@ApiParam CrfEvent queryParam) {
        Page<CrfEvent> crfEventPage = crfEventService.selectCrfEventPage(queryParam);
        return Response.success(crfEventPage);
    }

    @GET
    @Path("/{eventId}")
    @ApiOperation(value = "查询指定事件信息", tags = "事件管理", notes = "根据事件表id查询事件信息")
    public Response get(@ApiParam(value = "事件表id") @PathParam(value = "eventId") String eventId) {
        return Response.success(crfEventService.selectCrfEventById(eventId));
    }

    @POST
    @Path("")
    @Validated
    @ApiOperation(value = "新增事件信息", tags = "事件管理", notes = "新增事件信息")
    public Response insert(@ApiParam(value = "事件信息") @Valid CrfEvent crfEvent) {
        return Response.success(crfEventService.insertCrfEvent(crfEvent));
    }

    @PUT
    @Path("")
    @Validated
    @ApiOperation(value = "更新事件信息", tags = "事件管理", notes = "更新事件信息")
    public Response update(@ApiParam(value = "事件信息") @Valid CrfEvent crfEvent) {
        return Response.success(crfEventService.updateCrfEvent(crfEvent));
    }

    @DELETE
    @Path("/{eventId}")
    @ApiOperation(value = "删除事件信息", tags = "事件管理", notes = "删除事件信息")
    public Response delete(@ApiParam(value = "事件表id") @PathParam(value = "eventId") String eventId) {
        return Response.success(crfEventService.deleteCrfEvent(eventId));
    }

    @DELETE
    @Path("")
    @ApiOperation(value = "批量删除事件信息", tags = "事件管理", notes = "根据事件表id集合批量删除事件信息")
    public Response deleteBatch(@ApiParam(value = "事件表id集合") @QueryParam(value = "eventIds")
                                   @NotEmpty(message = "事件编号不能为空") List<String> eventIds) {
        return Response.success(crfEventService.deleteBatchCrfEvent(eventIds));
    }

    @GET
    @Path("")
    @ApiOperation(value = "分页查询事件信息", tags = "事件管理", notes = "根据条件查询事件表")
    public Page<CrfEvent> getListByPage(@ApiParam(value = "页号") @QueryParam(value = "page") int page,
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
        CrfEvent entity = parseRequestParams(request);

        return DaoFactory.create(CrfEvent.class).selectPageByCondition(entity, conditions, pageable, sortable, true);

    }

    private CrfEvent parseRequestParams(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("eventId", request.getParameter("eventId"));
        map.put("eventName", request.getParameter("eventName"));
        map.put("eventType", request.getParameter("eventType"));
        map.put("eventDesc", request.getParameter("eventDesc"));
        map.put("eventStatus", request.getParameter("eventStatus"));
        map.put("windowPeriod", request.getParameter("windowPeriod"));
        map.put("windowPeriodUnit", request.getParameter("windowPeriodUnit"));
        map.put("joinDuration", request.getParameter("joinDuration"));
        map.put("joinDurationUnit", request.getParameter("joinDurationUnit"));
        map.put("groupId", request.getParameter("groupId"));
        map.put("groupName", request.getParameter("groupName"));
        map.put("projectId", request.getParameter("projectId"));
        map.put("projectName", request.getParameter("projectName"));
        map.put("createTime", request.getParameter("createTime"));
        map.put("createUserId", request.getParameter("createUserId"));
        map.put("createUserName", request.getParameter("createUserName"));
        map.put("updateTime", request.getParameter("updateTime"));
        map.put("updateUserId", request.getParameter("updateUserId"));
        map.put("updateUserName", request.getParameter("updateUserName"));
        map.put("sort", request.getParameter("sort"));
        map.put("deleted", request.getParameter("deleted"));
        return JSON.parseObject(JSON.toJSONString(map), CrfEvent.class);
    }
}
