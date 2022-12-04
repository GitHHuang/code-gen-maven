package com.chinacreator.hosp.pojo.entity;

import com.chinacreator.c2.annotation.Column;
import com.chinacreator.c2.annotation.ColumnType;
import com.chinacreator.c2.annotation.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 事件对象 crf_event
 *
 * @author hc
 * @date 2022-10-11
 */
@Entity(id = "entity:com.chinacreator.hosp.pojo.entity.CrfEvent", table = "crf_event", ds = "dev", cache = false)
@ApiModel(value = "CrfEvent", description = "事件")
public class CrfEvent implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 事件编号 */
    @Column(id = "event_id")
    @ApiModelProperty(value = "事件编号", required = true)
    private String eventId;

    /** 事件名称 */
    @Column(id = "event_name")
    @ApiModelProperty(value = "事件名称")
    private String eventName;

    /** 事件类型（0：基线事件；1：普通事件） */
    @Column(id = "event_type")
    @ApiModelProperty(value = "事件类型（0：基线事件；1：普通事件）")
    private Integer eventType;

    /** 事件备注 */
    @Column(id = "event_desc")
    @ApiModelProperty(value = "事件备注")
    private String eventDesc;

    /** 事件状态（0：正常） */
    @Column(id = "event_status")
    @ApiModelProperty(value = "事件状态（0：正常）")
    private Integer eventStatus;

    /** 窗口期（单位默认为天） */
    @Column(id = "window_period")
    @ApiModelProperty(value = "窗口期（单位默认为天）")
    private Long windowPeriod;

    /** 窗口期单位（天、周、月、年） */
    @Column(id = "window_period_unit")
    @ApiModelProperty(value = "窗口期单位（天、周、月、年）")
    private String windowPeriodUnit;

    /** 入组时长（单位默认为天） */
    @Column(id = "join_duration")
    @ApiModelProperty(value = "入组时长（单位默认为天）")
    private Long joinDuration;

    /** 入组时长单位（天、周、月、年） */
    @Column(id = "join_duration_unit")
    @ApiModelProperty(value = "入组时长单位（天、周、月、年）")
    private String joinDurationUnit;

    /** 分组编号 */
    @Column(id = "group_id")
    @ApiModelProperty(value = "分组编号")
    private String groupId;

    /** 分组名称 */
    @Column(id = "group_name")
    @ApiModelProperty(value = "分组名称")
    private String groupName;

    /** 项目编号 */
    @Column(id = "project_id")
    @ApiModelProperty(value = "项目编号")
    private String projectId;

    /** 项目名称 */
    @Column(id = "project_name")
    @ApiModelProperty(value = "项目名称")
    private String projectName;

    /** 创建时间 */
    @Column(id = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /** 创建人编号 */
    @Column(id = "create_user_id")
    @ApiModelProperty(value = "创建人编号")
    private String createUserId;

    /** 创建人姓名 */
    @Column(id = "create_user_name")
    @ApiModelProperty(value = "创建人姓名")
    private String createUserName;

    /** 修改时间 */
    @Column(id = "update_time")
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    /** 修改人编号 */
    @Column(id = "update_user_id")
    @ApiModelProperty(value = "修改人编号")
    private String updateUserId;

    /** 修改人姓名 */
    @Column(id = "update_user_name")
    @ApiModelProperty(value = "修改人姓名")
    private String updateUserName;

    /** 排序 */
    @Column(id = "sort")
    @ApiModelProperty(value = "排序")
    private Long sort;

    /** 逻辑删除（0：正常；1：删除） */
    @Column(id = "deleted")
    @ApiModelProperty(value = "逻辑删除（0：正常；1：删除）")
    private Integer deleted;


    public void setEventId(String eventId) 
    {
        this.eventId = eventId;
    }

    public String getEventId() 
    {
        return eventId;
    }
    public void setEventName(String eventName) 
    {
        this.eventName = eventName;
    }

    public String getEventName() 
    {
        return eventName;
    }
    public void setEventType(Integer eventType) 
    {
        this.eventType = eventType;
    }

    public Integer getEventType() 
    {
        return eventType;
    }
    public void setEventDesc(String eventDesc) 
    {
        this.eventDesc = eventDesc;
    }

    public String getEventDesc() 
    {
        return eventDesc;
    }
    public void setEventStatus(Integer eventStatus) 
    {
        this.eventStatus = eventStatus;
    }

    public Integer getEventStatus() 
    {
        return eventStatus;
    }
    public void setWindowPeriod(Long windowPeriod) 
    {
        this.windowPeriod = windowPeriod;
    }

    public Long getWindowPeriod() 
    {
        return windowPeriod;
    }
    public void setWindowPeriodUnit(String windowPeriodUnit) 
    {
        this.windowPeriodUnit = windowPeriodUnit;
    }

    public String getWindowPeriodUnit() 
    {
        return windowPeriodUnit;
    }
    public void setJoinDuration(Long joinDuration) 
    {
        this.joinDuration = joinDuration;
    }

    public Long getJoinDuration() 
    {
        return joinDuration;
    }
    public void setJoinDurationUnit(String joinDurationUnit) 
    {
        this.joinDurationUnit = joinDurationUnit;
    }

    public String getJoinDurationUnit() 
    {
        return joinDurationUnit;
    }
    public void setGroupId(String groupId) 
    {
        this.groupId = groupId;
    }

    public String getGroupId() 
    {
        return groupId;
    }
    public void setGroupName(String groupName) 
    {
        this.groupName = groupName;
    }

    public String getGroupName() 
    {
        return groupName;
    }
    public void setProjectId(String projectId) 
    {
        this.projectId = projectId;
    }

    public String getProjectId() 
    {
        return projectId;
    }
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setCreateTime(Date createTime) 
    {
        this.createTime = createTime;
    }

    public Date getCreateTime() 
    {
        return createTime;
    }
    public void setCreateUserId(String createUserId) 
    {
        this.createUserId = createUserId;
    }

    public String getCreateUserId() 
    {
        return createUserId;
    }
    public void setCreateUserName(String createUserName) 
    {
        this.createUserName = createUserName;
    }

    public String getCreateUserName() 
    {
        return createUserName;
    }
    public void setUpdateTime(Date updateTime) 
    {
        this.updateTime = updateTime;
    }

    public Date getUpdateTime() 
    {
        return updateTime;
    }
    public void setUpdateUserId(String updateUserId) 
    {
        this.updateUserId = updateUserId;
    }

    public String getUpdateUserId() 
    {
        return updateUserId;
    }
    public void setUpdateUserName(String updateUserName) 
    {
        this.updateUserName = updateUserName;
    }

    public String getUpdateUserName() 
    {
        return updateUserName;
    }
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }
    public void setDeleted(Integer deleted) 
    {
        this.deleted = deleted;
    }

    public Integer getDeleted() 
    {
        return deleted;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("eventId", getEventId())
            .append("eventName", getEventName())
            .append("eventType", getEventType())
            .append("eventDesc", getEventDesc())
            .append("eventStatus", getEventStatus())
            .append("windowPeriod", getWindowPeriod())
            .append("windowPeriodUnit", getWindowPeriodUnit())
            .append("joinDuration", getJoinDuration())
            .append("joinDurationUnit", getJoinDurationUnit())
            .append("groupId", getGroupId())
            .append("groupName", getGroupName())
            .append("projectId", getProjectId())
            .append("projectName", getProjectName())
            .append("createTime", getCreateTime())
            .append("createUserId", getCreateUserId())
            .append("createUserName", getCreateUserName())
            .append("updateTime", getUpdateTime())
            .append("updateUserId", getUpdateUserId())
            .append("updateUserName", getUpdateUserName())
            .append("sort", getSort())
            .append("deleted", getDeleted())
            .toString();
    }
}
