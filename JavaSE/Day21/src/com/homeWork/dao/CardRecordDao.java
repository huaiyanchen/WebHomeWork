package com.homeWork.dao;


import com.homeWork.bean.CardRecord;
import com.homeWork.utils.PageInfo;
import com.homeWork.bean.vo.CardRecordVO;

import java.util.List;

public interface CardRecordDao {
    /**
     *  @author: chy
     *  @Date: 2021/4/20 21:12
     *  @Description: 添加打卡记录
     */
    boolean addCardRecord(CardRecord cardRecord);

    /**
     * 根据员工编号返回所有的打卡记录
     * @param id
     * @return
     */
    List<CardRecordVO> getRecordByEmpId(Integer id);

    /**
     * 分页查询
     * @param id
     * @param pageInfo
     * @return
     */
    List<CardRecordVO> getRecordByEmpIdAndPage(Integer id, PageInfo pageInfo);

    /**
     * 获取总条数
     * @return
     */
    Integer getCount();

}