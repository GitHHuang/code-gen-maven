package com.chinacreator.hosp.service;

import java.util.List;
import com.chinacreator.c2.dao.mybatis.enhance.Page;
import com.chinacreator.hosp.pojo.entity.CrfEvent;

/**
 * 事件Service接口
 * 
 * @author hc
 * @date 2022-10-11
 */
public interface ICrfEventService 
{
    /**
     * 根据事件编号查询事件
     * 
     * @param eventId
     * @return
     */
    public CrfEvent selectCrfEventById(String eventId);

    /**
     * 查询事件集合
     * 
     * @param crfEvent
     * @return
     */
    public List<CrfEvent> selectCrfEventList(CrfEvent crfEvent);

    /**
     * 分页查询事件集合
     *
     * @param crfEvent
     * @return
     */
    public Page<CrfEvent> selectCrfEventPage(CrfEvent crfEvent);

    /**
     * 新增事件
     * 
     * @param crfEvent
     * @return
     */
    public int insertCrfEvent(CrfEvent crfEvent);

    /**
     * 批量新增事件
     *
     * @param crfEventList
     * @return
     */
    public int insertBatchCrfEvent(List<CrfEvent> crfEventList);

    /**
     * 更新事件
     * 
     * @param crfEvent
     * @return
     */
    public int updateCrfEvent(CrfEvent crfEvent);

    /**
     * 批量更新事件
     *
     * @param crfEventList
     * @return
     */
    public int updateBatchCrfEvent(List<CrfEvent> crfEventList);

    /**
     * 删除事件
     *
     * @param eventId
     * @return
     */
    public int deleteCrfEvent(String eventId);

    /**
     * 批量删除事件
     * 
     * @param eventIds
     * @return
     */
    public int deleteBatchCrfEvent(List<String> eventIds);
}
