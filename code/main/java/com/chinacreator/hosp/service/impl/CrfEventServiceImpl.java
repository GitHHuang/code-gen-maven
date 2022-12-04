package com.chinacreator.hosp.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.chinacreator.hosp.pojo.entity.CrfEvent;
import com.chinacreator.hosp.service.ICrfEventService;
import com.chinacreator.c2.dao.DaoFactory;
import com.chinacreator.c2.dao.mybatis.enhance.Page;
import com.chinacreator.c2.dao.mybatis.enhance.Pageable;
import com.chinacreator.c2.dao.mybatis.enhance.Sortable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 事件Service业务层处理
 * 
 * @author hc
 * @date 2022-10-11
 */
@Service
public class CrfEventServiceImpl implements ICrfEventService 
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 根据事件编号查询事件
     * 
     * @param eventId
     * @return
     */
    @Override
    public CrfEvent selectCrfEventById(String eventId) {
        return DaoFactory.create(CrfEvent.class).selectByID(eventId);
    }

    /**
     * 查询事件集合
     * 
     * @param crfEvent
     * @return
     */
    @Override
    public List<CrfEvent> selectCrfEventList(CrfEvent crfEvent) {
        return DaoFactory.create(CrfEvent.class).select(crfEvent);
    }

    /**
     * 分页查询事件集合
     *
     * @param crfEvent
     * @return
     */
    @Override
    public Page<CrfEvent> selectCrfEventPage(CrfEvent crfEvent) {
        return DaoFactory.create(CrfEvent.class).selectByPage(crfEvent, new Pageable(1, 10), new Sortable(), true);
    }

    /**
     * 新增事件
     * 
     * @param crfEvent
     * @return
     */
    @Override
    public int insertCrfEvent(CrfEvent crfEvent) {
        return DaoFactory.create(CrfEvent.class).insert(crfEvent);
    }

    /**
     * 批量新增事件
     *
     * @param crfEventList
     * @return
     */
    @Override
    public int insertBatchCrfEvent(List<CrfEvent> crfEventList) {
        return DaoFactory.create(CrfEvent.class).insertBatch(crfEventList);
    }

    /**
     * 更新事件
     * 
     * @param crfEvent
     * @return
     */
    @Override
    public int updateCrfEvent(CrfEvent crfEvent) {
        return DaoFactory.create(CrfEvent.class).update(crfEvent);
    }

    /**
     * 批量更新事件
     *
     * @param crfEventList
     * @return
     */
    @Override
    public int updateBatchCrfEvent(List<CrfEvent> crfEventList) {
        return DaoFactory.create(CrfEvent.class).updateBatch(crfEventList);
    }

    /**
     * 删除事件
     *
     * @param eventId
     * @return
     */
    @Override
    public int deleteCrfEvent(String eventId) {
        return DaoFactory.create(CrfEvent.class).delete(eventId);
    }

    /**
     * 批量删除事件
     * 
     * @param eventIds
     * @return
     */
    @Override
    public int deleteBatchCrfEvent(List<String> eventIds) {
        return DaoFactory.create(CrfEvent.class).deleteBatch(eventIds);
    }
}
