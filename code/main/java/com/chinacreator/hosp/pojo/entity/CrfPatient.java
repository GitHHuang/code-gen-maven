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
 * 患者对象 crf_patient
 *
 * @author hc
 * @date 2022-10-11
 */
@Entity(id = "entity:com.chinacreator.hosp.pojo.entity.CrfPatient", table = "crf_patient", ds = "dev", cache = false)
@ApiModel(value = "CrfPatient", description = "患者")
public class CrfPatient implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 患者编号 */
    @Column(id = "patient_id")
    @ApiModelProperty(value = "患者编号", required = true)
    private String patientId;

    /** 患者姓名 */
    @Column(id = "patient_name")
    @ApiModelProperty(value = "患者姓名")
    private String patientName;

    /** 患者性别 */
    @Column(id = "patient_sex")
    @ApiModelProperty(value = "患者性别")
    private Integer patientSex;

    /** 患者年龄 */
    @Column(id = "patient_age")
    @ApiModelProperty(value = "患者年龄")
    private Long patientAge;

    /** 患者身份证号 */
    @Column(id = "patient_idcard")
    @ApiModelProperty(value = "患者身份证号")
    private String patientIdcard;

    /** 患者联系电话 */
    @Column(id = "patient_phone")
    @ApiModelProperty(value = "患者联系电话")
    private String patientPhone;

    /** 患者地址省市区 */
    @Column(id = "patient_area")
    @ApiModelProperty(value = "患者地址省市区")
    private String patientArea;

    /** 患者详细地址 */
    @Column(id = "patient_address")
    @ApiModelProperty(value = "患者详细地址")
    private String patientAddress;

    /** 项目编号 */
    @Column(id = "project_id")
    @ApiModelProperty(value = "项目编号")
    private String projectId;

    /** 项目名称 */
    @Column(id = "project_name")
    @ApiModelProperty(value = "项目名称")
    private String projectName;

    /** 下次随访时间 */
    @Column(id = "next_follow_date")
    @ApiModelProperty(value = "下次随访时间")
    private Date nextFollowDate;

    /** 下次事件编号 */
    @Column(id = "next_event_id")
    @ApiModelProperty(value = "下次事件编号")
    private String nextEventId;

    /** 下次窗口期开始 */
    @Column(id = "next_window_date_start")
    @ApiModelProperty(value = "下次窗口期开始")
    private Date nextWindowDateStart;

    /** 下次窗口期结束 */
    @Column(id = "next_window_date_end")
    @ApiModelProperty(value = "下次窗口期结束")
    private Date nextWindowDateEnd;

    /** 共享状态（0：未共享；1：已共享） */
    @Column(id = "share_status")
    @ApiModelProperty(value = "共享状态（0：未共享；1：已共享）")
    private Integer shareStatus;

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


    public void setPatientId(String patientId) 
    {
        this.patientId = patientId;
    }

    public String getPatientId() 
    {
        return patientId;
    }
    public void setPatientName(String patientName) 
    {
        this.patientName = patientName;
    }

    public String getPatientName() 
    {
        return patientName;
    }
    public void setPatientSex(Integer patientSex) 
    {
        this.patientSex = patientSex;
    }

    public Integer getPatientSex() 
    {
        return patientSex;
    }
    public void setPatientAge(Long patientAge) 
    {
        this.patientAge = patientAge;
    }

    public Long getPatientAge() 
    {
        return patientAge;
    }
    public void setPatientIdcard(String patientIdcard) 
    {
        this.patientIdcard = patientIdcard;
    }

    public String getPatientIdcard() 
    {
        return patientIdcard;
    }
    public void setPatientPhone(String patientPhone) 
    {
        this.patientPhone = patientPhone;
    }

    public String getPatientPhone() 
    {
        return patientPhone;
    }
    public void setPatientArea(String patientArea) 
    {
        this.patientArea = patientArea;
    }

    public String getPatientArea() 
    {
        return patientArea;
    }
    public void setPatientAddress(String patientAddress) 
    {
        this.patientAddress = patientAddress;
    }

    public String getPatientAddress() 
    {
        return patientAddress;
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
    public void setNextFollowDate(Date nextFollowDate) 
    {
        this.nextFollowDate = nextFollowDate;
    }

    public Date getNextFollowDate() 
    {
        return nextFollowDate;
    }
    public void setNextEventId(String nextEventId) 
    {
        this.nextEventId = nextEventId;
    }

    public String getNextEventId() 
    {
        return nextEventId;
    }
    public void setNextWindowDateStart(Date nextWindowDateStart) 
    {
        this.nextWindowDateStart = nextWindowDateStart;
    }

    public Date getNextWindowDateStart() 
    {
        return nextWindowDateStart;
    }
    public void setNextWindowDateEnd(Date nextWindowDateEnd) 
    {
        this.nextWindowDateEnd = nextWindowDateEnd;
    }

    public Date getNextWindowDateEnd() 
    {
        return nextWindowDateEnd;
    }
    public void setShareStatus(Integer shareStatus) 
    {
        this.shareStatus = shareStatus;
    }

    public Integer getShareStatus() 
    {
        return shareStatus;
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
            .append("patientId", getPatientId())
            .append("patientName", getPatientName())
            .append("patientSex", getPatientSex())
            .append("patientAge", getPatientAge())
            .append("patientIdcard", getPatientIdcard())
            .append("patientPhone", getPatientPhone())
            .append("patientArea", getPatientArea())
            .append("patientAddress", getPatientAddress())
            .append("projectId", getProjectId())
            .append("projectName", getProjectName())
            .append("nextFollowDate", getNextFollowDate())
            .append("nextEventId", getNextEventId())
            .append("nextWindowDateStart", getNextWindowDateStart())
            .append("nextWindowDateEnd", getNextWindowDateEnd())
            .append("shareStatus", getShareStatus())
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
