package com.ljtao3.dbbase.controller;

import com.ljtao3.dbbase.dao.master.RoleDao;
import com.ljtao3.dbbase.dao.master.UserDao;
import com.ljtao3.dbbase.dao.master.UserRoleDao;
import com.ljtao3.dbbase.entity.master.Role;
import com.ljtao3.dbbase.entity.master.User;
import com.ljtao3.dbbase.service.UserService;
import com.ljtao3.dbbase.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ljtao3 on 2020/3/16
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @GetMapping("userInfo")
    public JsonData userInfo(String id){
        System.out.println(id);
        User user = userDao.getById(1);
        List<Role> roleList=new ArrayList<>();
        List<Integer> roleIdList = userRoleDao.getRoleIdsByUserId(user.getId());
        for (Integer roleId:roleIdList){
            roleList.add(roleDao.getRoleById(roleId));
        }
        user.setRoles(roleList);
        return JsonData.success(user);
    }
    @PostMapping("userInfo2")
    public JsonData userInfo2(@RequestParam("id") String id,@RequestParam("name") String name,Integer age){
         System.out.println(id);
        User user = userDao.getById(1);
        List<Role> roleList=new ArrayList<>();
        List<Integer> roleIdList = userRoleDao.getRoleIdsByUserId(user.getId());
        for (Integer roleId:roleIdList){
            roleList.add(roleDao.getRoleById(roleId));
        }
        user.setRoles(roleList);
        return JsonData.success(user);
    }
    @PostMapping("userInfo3")
    public JsonData userInfo2(@RequestBody HashMap map){
        return JsonData.success(map);
    }
}
