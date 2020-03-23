package com.ljtao3.dbbase.service;

import com.ljtao3.dbbase.dao.master.UserDao;
import com.ljtao3.dbbase.entity.master.Role;
import com.ljtao3.dbbase.entity.master.User;
import com.ljtao3.dbbase.entity.master.User_Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ljtao3 on 2020/3/16
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public User findByName(String name){
        return userDao.findByName(name);
    }
    public User userInfo(){
        User user=new User();
        user.setId(1);
        user.setDescription("test");
        user.setUserName("admin");
        Role role=new Role();

        User_Role ur=new User_Role();

        return user;
    }
}
