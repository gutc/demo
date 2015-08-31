package com.ifeng.demo.action;

import com.ifeng.demo.dao.UserDao;
import com.ifeng.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gutc on 2015/8/28.
 */
@Service(value = "helloAction")
public class HelloAction extends ActionBase{
    @Autowired
    private UserDao userDao;
    String remsg = "";

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getRemsg() {
        return remsg;
    }

    public void setRemsg(String remsg) {
        this.remsg = remsg;
    }

    public String hello() {
        try{
            User user = new User();
            user.setUserName("gutc");
            user.setPassword("000");
            userDao.insertUser(user);
           remsg = "lala";
        }catch (Exception e){
            e.printStackTrace();
        }
      return "success";
  }

    public void prepare() throws Exception {

    }
}
