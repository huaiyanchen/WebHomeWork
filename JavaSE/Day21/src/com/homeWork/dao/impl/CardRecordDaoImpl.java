package com.homeWork.dao.impl;

import com.homeWork.bean.CardRecord;
import com.homeWork.utils.PageInfo;
import com.homeWork.bean.vo.CardRecordVO;
import com.homeWork.dao.CardRecordDao;
import com.homeWork.utils.DBUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/20-19:48
 * @Since:jdk1.8
 * @Description:TODO
 */

public class CardRecordDaoImpl implements CardRecordDao {
    @Override
    public boolean addCardRecord(CardRecord cardRecord) {
        String sql = "insert into cardrecord values (null,?,?,?)";
        return DBUtils.executeUpdate(sql, cardRecord.getEmpId(), cardRecord.getCardTime(), cardRecord.getIsNormal());
    }

    @Override
    public List<CardRecordVO> getRecordByEmpId(Integer id) {
        String sql = "select cd.id, eo.name, eo.sex, eo.entryTime, cd.cardTime, cd.isNormal\n" +
                "from cardrecord cd,\n" +
                "     empinfo eo\n" +
                "where cd.empId = eo.id\n" +
                "  and cd.empId = ?";
        return DBUtils.executeQuery(sql, CardRecordVO.class, id);

    }

    @Override
    public List<CardRecordVO> getRecordByEmpIdAndPage(Integer id, PageInfo pageInfo) {
        String sql = "select cd.id, eo.name, eo.sex, eo.entryTime, cd.cardTime, cd.isNormal\n" +
                "from cardrecord cd,\n" +
                "     empinfo eo\n" +
                "where cd.empId = eo.id\n" +
                "  and cd.empId = ?\n" +
                "limit ?,?";
        return DBUtils.executeQuery(sql, CardRecordVO.class, id, pageInfo.getPage() * pageInfo.getCount(), pageInfo.getCount());
    }

    @Override
    public Integer getCount() {
        String sql = "select count(*) from cardrecord";
        Connection con = DBUtils.getCon();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int anInt = 0;
        try {
            preparedStatement = con.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                anInt = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeCon(con, preparedStatement, resultSet);
        }
        return anInt;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();

        list.add(12);
        //这里直接添加会报错

        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        //但是通过反射添加，是可以的
        add.invoke(list, "kl");

        System.out.println(list);
    }

}