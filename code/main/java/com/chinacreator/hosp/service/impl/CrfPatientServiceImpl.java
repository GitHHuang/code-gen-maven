package com.chinacreator.hosp.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.chinacreator.hosp.pojo.entity.CrfPatient;
import com.chinacreator.hosp.service.ICrfPatientService;
import com.chinacreator.c2.dao.DaoFactory;
import com.chinacreator.c2.dao.mybatis.enhance.Page;
import com.chinacreator.c2.dao.mybatis.enhance.Pageable;
import com.chinacreator.c2.dao.mybatis.enhance.Sortable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 患者Service业务层处理
 * 
 * @author hc
 * @date 2022-10-11
 */
@Service
public class CrfPatientServiceImpl implements ICrfPatientService 
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 根据患者编号查询患者
     * 
     * @param patientId
     * @return
     */
    @Override
    public CrfPatient selectCrfPatientById(String patientId) {
        return DaoFactory.create(CrfPatient.class).selectByID(patientId);
    }

    /**
     * 查询患者集合
     * 
     * @param crfPatient
     * @return
     */
    @Override
    public List<CrfPatient> selectCrfPatientList(CrfPatient crfPatient) {
        return DaoFactory.create(CrfPatient.class).select(crfPatient);
    }

    /**
     * 分页查询患者集合
     *
     * @param crfPatient
     * @return
     */
    @Override
    public Page<CrfPatient> selectCrfPatientPage(CrfPatient crfPatient) {
        return DaoFactory.create(CrfPatient.class).selectByPage(crfPatient, new Pageable(1, 10), new Sortable(), true);
    }

    /**
     * 新增患者
     * 
     * @param crfPatient
     * @return
     */
    @Override
    public int insertCrfPatient(CrfPatient crfPatient) {
        return DaoFactory.create(CrfPatient.class).insert(crfPatient);
    }

    /**
     * 批量新增患者
     *
     * @param crfPatientList
     * @return
     */
    @Override
    public int insertBatchCrfPatient(List<CrfPatient> crfPatientList) {
        return DaoFactory.create(CrfPatient.class).insertBatch(crfPatientList);
    }

    /**
     * 更新患者
     * 
     * @param crfPatient
     * @return
     */
    @Override
    public int updateCrfPatient(CrfPatient crfPatient) {
        return DaoFactory.create(CrfPatient.class).update(crfPatient);
    }

    /**
     * 批量更新患者
     *
     * @param crfPatientList
     * @return
     */
    @Override
    public int updateBatchCrfPatient(List<CrfPatient> crfPatientList) {
        return DaoFactory.create(CrfPatient.class).updateBatch(crfPatientList);
    }

    /**
     * 删除患者
     *
     * @param patientId
     * @return
     */
    @Override
    public int deleteCrfPatient(String patientId) {
        return DaoFactory.create(CrfPatient.class).delete(patientId);
    }

    /**
     * 批量删除患者
     * 
     * @param patientIds
     * @return
     */
    @Override
    public int deleteBatchCrfPatient(List<String> patientIds) {
        return DaoFactory.create(CrfPatient.class).deleteBatch(patientIds);
    }
}
