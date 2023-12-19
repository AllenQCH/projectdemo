package com.cctv.mapper;

import com.cctv.pojo.DemoTest;
import com.cctv.pojo.DemoTestExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DemoTestMapper {
    long countByExample(DemoTestExample example);

    int deleteByExample(DemoTestExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DemoTest record);

    int insertSelective(DemoTest record);

    List<DemoTest> selectByExample(DemoTestExample example);

    DemoTest selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DemoTest record, @Param("example") DemoTestExample example);

    int updateByExample(@Param("record") DemoTest record, @Param("example") DemoTestExample example);

    int updateByPrimaryKeySelective(DemoTest record);

    int updateByPrimaryKey(DemoTest record);
}