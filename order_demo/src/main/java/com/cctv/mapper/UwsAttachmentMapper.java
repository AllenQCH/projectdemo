package com.cctv.mapper;

import com.cctv.pojo.UwsAttachment;
import com.cctv.pojo.UwsAttachmentExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UwsAttachmentMapper {
    long countByExample(UwsAttachmentExample example);

    int deleteByExample(UwsAttachmentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UwsAttachment record);

    int insertSelective(UwsAttachment record);

    List<UwsAttachment> selectByExample(UwsAttachmentExample example);

    UwsAttachment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UwsAttachment record, @Param("example") UwsAttachmentExample example);

    int updateByExample(@Param("record") UwsAttachment record, @Param("example") UwsAttachmentExample example);

    int updateByPrimaryKeySelective(UwsAttachment record);

    int updateByPrimaryKey(UwsAttachment record);
}