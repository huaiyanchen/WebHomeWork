package generate;

import generate.Orderdetails;

public interface OrderdetailsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Orderdetails record);

    int insertSelective(Orderdetails record);

    Orderdetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orderdetails record);

    int updateByPrimaryKey(Orderdetails record);
}