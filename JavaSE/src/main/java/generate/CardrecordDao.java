package generate;

import generate.Cardrecord;

public interface CardrecordDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Cardrecord record);

    int insertSelective(Cardrecord record);

    Cardrecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cardrecord record);

    int updateByPrimaryKey(Cardrecord record);
}