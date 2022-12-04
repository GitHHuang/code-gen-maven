package com.chinacreator.hosp.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.chinacreator.hosp.pojo.entity.CrfEventFormRelation;
import com.chinacreator.hosp.service.ICrfEventFormRelationService;
import com.chinacreator.c2.dao.DaoFactory;
import com.chinacreator.c2.dao.mybatis.enhance.Page;
import com.chinacreator.c2.dao.mybatis.enhance.Pageable;
import com.chinacreator.c2.dao.mybatis.enhance.Sortable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 事件与单关联Service业务层处理
 * 
 * @author hc
 * @date 2022-10-11
 */
@Service
public class CrfEventFormRelationServiceImpl implements ICrfEventFormRelationService 
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 根据关联关系编号查询事件与单关联
     * 
     * @param relationId
     * @return
     */
    @Override
    public CrfEventFormRelation selectCrfEventFormRelationById(String relationId) {
        return DaoFactory.create(CrfEventFormRelation.class).selectByID(relationId);
    }

    /**
     * 查询事件与单关联集合
     * 
     * @param crfEventFormRelation
     * @return
     */
    @Override
    public List<CrfEventFormRelation> selectCrfEventFormRelationList(CrfEventFormRelation crfEventFormRelation) {
        return DaoFactory.create(CrfEventFormRelation.class).select(crfEventFormRelation);
    }

    /**
     * 分页查询事件与单关联集合
     *
     * @param crfEventFormRelation
     * @return
     */
    @Override
    public Page<CrfEventFormRelation> selectCrfEventFormRelationPage(CrfEventFormRelation crfEventFormRelation) {
        return DaoFactory.create(CrfEventFormRelation.class).selectByPage(crfEventFormRelation, new Pageable(1, 10), new Sortable(), true);
    }

    /**
     * 新增事件与单关联
     * 
     * @param crfEventFormRelation
     * @return
     */
    @Override
    public int insertCrfEventFormRelation(CrfEventFormRelation crfEventFormRelation) {
        return DaoFactory.create(CrfEventFormRelation.class).insert(crfEventFormRelation);
    }

    /**
     * 批量新增事件与单关联
     *
     * @param crfEventFormRelationList
     * @return
     */
    @Override
    public int insertBatchCrfEventFormRelation(List<CrfEventFormRelation> crfEventFormRelationList) {
        return DaoFactory.create(CrfEventFormRelation.class).insertBatch(crfEventFormRelationList);
    }

    /**
     * 更新事件与单关联
     * 
     * @param crfEventFormRelation
     * @return
     */
    @Override
    public int updateCrfEventFormRelation(CrfEventFormRelation crfEventFormRelation) {
        return DaoFactory.create(CrfEventFormRelation.class).update(crfEventFormRelation);
    }

    /**
     * 批量更新事件与单关联
     *
     * @param crfEventFormRelationList
     * @return
     */
    @Override
    public int updateBatchCrfEventFormRelation(List<CrfEventFormRelation> crfEventFormRelationList) {
        return DaoFactory.create(CrfEventFormRelation.class).updateBatch(crfEventFormRelationList);
    }

    /**
     * 删除事件与单关联
     *
     * @param relationId
     * @return
     */
    @Override
    public int deleteCrfEventFormRelation(String relationId) {
        return DaoFactory.create(CrfEventFormRelation.class).delete(relationId);
    }

    /**
     * 批量删除事件与单关联
     * 
     * @param relationIds
     * @return
     */
    @Override
    public int deleteBatchCrfEventFormRelation(List<String> relationIds) {
        return DaoFactory.create(CrfEventFormRelation.class).deleteBatch(relationIds);
    }
}
