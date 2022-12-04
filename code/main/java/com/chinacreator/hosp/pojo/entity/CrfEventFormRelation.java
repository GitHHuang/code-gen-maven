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
 * 事件与单关联对象 crf_event_form_relation
 *
 * @author hc
 * @date 2022-10-11
 */
@Entity(id = "entity:com.chinacreator.hosp.pojo.entity.CrfEventFormRelation", table = "crf_event_form_relation", ds = "dev", cache = false)
@ApiModel(value = "CrfEventFormRelation", description = "事件与单关联")
public class CrfEventFormRelation implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 关联关系编号 */
    @Column(id = "relation_id")
    @ApiModelProperty(value = "关联关系编号", required = true)
    private String relationId;

    /** 事件编号 */
    @Column(id = "event_id")
    @ApiModelProperty(value = "事件编号")
    private String eventId;

    /** 表单版本编号 */
    @Column(id = "form_version_id")
    @ApiModelProperty(value = "表单版本编号")
    private String formVersionId;


    public void setRelationId(String relationId) 
    {
        this.relationId = relationId;
    }

    public String getRelationId() 
    {
        return relationId;
    }
    public void setEventId(String eventId) 
    {
        this.eventId = eventId;
    }

    public String getEventId() 
    {
        return eventId;
    }
    public void setFormVersionId(String formVersionId) 
    {
        this.formVersionId = formVersionId;
    }

    public String getFormVersionId() 
    {
        return formVersionId;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("relationId", getRelationId())
            .append("eventId", getEventId())
            .append("formVersionId", getFormVersionId())
            .toString();
    }
}
