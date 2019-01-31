package com.lixin.mybatis.dao;

import com.lixin.mybatis.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    User select(@Param("id") int id);
}
