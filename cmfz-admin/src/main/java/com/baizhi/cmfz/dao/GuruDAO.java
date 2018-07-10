package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Guru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-08 22:01:43
 **/
public interface GuruDAO {
    public List<Guru> selectAllGuru(@Param("page") Integer page, @Param("rows") Integer rows);

    public Integer count();

    public int insertGuru(Guru guru);

    public int updateGuru(Guru guru);

    public int insertBatch(@Param("gurus") List<Guru> gurus);

    public List<Guru> selectAll();

    public List<Guru> selectAllGuruByKey(@Param("name") String name,@Param("value") String value,@Param("page") Integer page, @Param("rows") Integer rows);

    public int countByKey(@Param("name") String name,@Param("value") String value);

    public List<Guru> selectGuruIdAndName();
}
