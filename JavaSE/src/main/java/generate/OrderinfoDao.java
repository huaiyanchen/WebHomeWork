package generate;

import generate.Orderinfo;

public interface OrderinfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Orderinfo record);

    int insertSelective(Orderinfo record);

    Orderinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orderinfo record);

    int updateByPrimaryKey(Orderinfo record);
}