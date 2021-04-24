package generate;

import generate.Empinfo;

public interface EmpinfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Empinfo record);

    int insertSelective(Empinfo record);

    Empinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Empinfo record);

    int updateByPrimaryKey(Empinfo record);
}