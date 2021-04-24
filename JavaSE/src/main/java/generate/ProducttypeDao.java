package generate;

import generate.Producttype;

public interface ProducttypeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Producttype record);

    int insertSelective(Producttype record);

    Producttype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Producttype record);

    int updateByPrimaryKey(Producttype record);
}