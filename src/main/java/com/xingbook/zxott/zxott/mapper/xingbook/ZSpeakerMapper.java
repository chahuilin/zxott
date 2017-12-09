package com.xingbook.zxott.zxott.mapper.xingbook;

import com.xingbook.zxott.zxott.entity.ZSpeaker;
import com.xingbook.zxott.zxott.entity.ZSpeakerExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ZSpeakerMapper {
    long countByExample(ZSpeakerExample example);

    int deleteByExample(ZSpeakerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ZSpeaker record);

    int insertSelective(ZSpeaker record);

    List<ZSpeaker> selectByExample(ZSpeakerExample example);

    ZSpeaker selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ZSpeaker record, @Param("example") ZSpeakerExample example);

    int updateByExample(@Param("record") ZSpeaker record, @Param("example") ZSpeakerExample example);

    int updateByPrimaryKeySelective(ZSpeaker record);

    int updateByPrimaryKey(ZSpeaker record);
}