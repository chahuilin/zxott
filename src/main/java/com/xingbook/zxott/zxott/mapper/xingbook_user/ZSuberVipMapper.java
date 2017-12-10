package com.xingbook.zxott.zxott.mapper.xingbook_user;

import com.xingbook.zxott.zxott.entity.ZSuberVip;
import com.xingbook.zxott.zxott.entity.ZSuberVipExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface ZSuberVipMapper {
    long countByExample(ZSuberVipExample example);

    int deleteByExample(ZSuberVipExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ZSuberVip record);

    int insertSelective(ZSuberVip record);

    List<ZSuberVip> selectByExample(ZSuberVipExample example);

    ZSuberVip selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ZSuberVip record, @Param("example") ZSuberVipExample example);

    int updateByExample(@Param("record") ZSuberVip record, @Param("example") ZSuberVipExample example);

    int updateByPrimaryKeySelective(ZSuberVip record);

    int updateByPrimaryKey(ZSuberVip record);
}