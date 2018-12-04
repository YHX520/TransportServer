package com.huaxuan.imageserver.dao;

import com.huaxuan.imageserver.datamode.PhoneValidate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PhoneValidateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PhoneValidate record);

    int insertSelective(PhoneValidate record);

    PhoneValidate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PhoneValidate record);

    int updateByPrimaryKey(PhoneValidate record);
    PhoneValidate selectPhoneAndValidate(String phoneNumber);
}