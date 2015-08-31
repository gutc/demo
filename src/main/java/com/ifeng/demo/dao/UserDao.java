package com.ifeng.demo.dao;

import com.ifeng.demo.entities.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by gutc on 2015/8/28.
 */
@Repository
public class UserDao {
    private final String INSERT_USER = "insertUser";
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    public int insertUser(User user)throws Exception{
       return sqlSessionTemplate.insert(INSERT_USER,user);
    }


}
