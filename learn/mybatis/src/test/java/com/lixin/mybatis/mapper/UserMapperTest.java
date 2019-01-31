package com.lixin.mybatis.mapper;

import com.alibaba.fastjson.JSON;
import com.lixin.mybatis.bean.User;
import com.lixin.mybatis.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

//    @Autowired
//    private UserMapper userMapper;

    @Autowired
    private UserDao userDao;

    @Test
    public void testSelect() {
//        User user = userMapper.selectUser("1");
//        System.out.println(JSON.toJSONString(user));
    }

    @Test
    public void testUserDao() {
        User user = userDao.select(1);
        System.out.println(JSON.toJSONString(user));
    }
}