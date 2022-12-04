package com.chinacreator.hosp.service;

import java.util.List;
import com.chinacreator.c2.dao.mybatis.enhance.Page;
import com.chinacreator.hosp.pojo.entity.CrfPatient;

/**
 * 患者Service接口
 * 
 * @author hc
 * @date 2022-10-11
 */
public interface ICrfPatientService 
{
    /**
     * 根据患者编号查询患者
     * 
     * @param patientId
     * @return
     */
    public CrfPatient selectCrfPatientById(String patientId);

    /**
     * 查询患者集合
     * 
     * @param crfPatient
     * @return
     */
    public List<CrfPatient> selectCrfPatientList(CrfPatient crfPatient);

    /**
     * 分页查询患者集合
     *
     * @param crfPatient
     * @return
     */
    public Page<CrfPatient> selectCrfPatientPage(CrfPatient crfPatient);

    /**
     * 新增患者
     * 
     * @param crfPatient
     * @return
     */
    public int insertCrfPatient(CrfPatient crfPatient);

    /**
     * 批量新增患者
     *
     * @param crfPatientList
     * @return
     */
    public int insertBatchCrfPatient(List<CrfPatient> crfPatientList);

    /**
     * 更新患者
     * 
     * @param crfPatient
     * @return
     */
    public int updateCrfPatient(CrfPatient crfPatient);

    /**
     * 批量更新患者
     *
     * @param crfPatientList
     * @return
     */
    public int updateBatchCrfPatient(List<CrfPatient> crfPatientList);

    /**
     * 删除患者
     *
     * @param patientId
     * @return
     */
    public int deleteCrfPatient(String patientId);

    /**
     * 批量删除患者
     * 
     * @param patientIds
     * @return
     */
    public int deleteBatchCrfPatient(List<String> patientIds);
}
