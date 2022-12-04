package com.chinacreator.hosp.service;

import java.util.List;
import com.chinacreator.c2.dao.mybatis.enhance.Page;
import com.chinacreator.hosp.pojo.entity.CrfEventFormRelation;

/**
 * 事件与单关联Service接口
 * 
 * @author hc
 * @date 2022-10-11
 */
public interface ICrfEventFormRelationService 
{
    /**
     * 根据关联关系编号查询事件与单关联
     * 
     * @param relationId
     * @return
     */
    public CrfEventFormRelation selectCrfEventFormRelationById(String relationId);

    /**
     * 查询事件与单关联集合
     * 
     * @param crfEventFormRelation
     * @return
     */
    public List<CrfEventFormRelation> selectCrfEventFormRelationList(CrfEventFormRelation crfEventFormRelation);

    /**
     * 分页查询事件与单关联集合
     *
     * @param crfEventFormRelation
     * @return
     */
    public Page<CrfEventFormRelation> selectCrfEventFormRelationPage(CrfEventFormRelation crfEventFormRelation);

    /**
     * 新增事件与单关联
     * 
     * @param crfEventFormRelation
     * @return
     */
    public int insertCrfEventFormRelation(CrfEventFormRelation crfEventFormRelation);

    /**
     * 批量新增事件与单关联
     *
     * @param crfEventFormRelationList
     * @return
     */
    public int insertBatchCrfEventFormRelation(List<CrfEventFormRelation> crfEventFormRelationList);

    /**
     * 更新事件与单关联
     * 
     * @param crfEventFormRelation
     * @return
     */
    public int updateCrfEventFormRelation(CrfEventFormRelation crfEventFormRelation);

    /**
     * 批量更新事件与单关联
     *
     * @param crfEventFormRelationList
     * @return
     */
    public int updateBatchCrfEventFormRelation(List<CrfEventFormRelation> crfEventFormRelationList);

    /**
     * 删除事件与单关联
     *
     * @param relationId
     * @return
     */
    public int deleteCrfEventFormRelation(String relationId);

    /**
     * 批量删除事件与单关联
     * 
     * @param relationIds
     * @return
     */
    public int deleteBatchCrfEventFormRelation(List<String> relationIds);
}
