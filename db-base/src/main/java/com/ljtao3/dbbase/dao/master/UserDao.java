package com.ljtao3.dbbase.dao.master;


import com.ljtao3.dbbase.entity.master.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
	User findByName(String name);
	User getById(@Param("id") int id);
}
