package com.ljtao3.dbbase.dao.master;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ljtao3 on 2020/3/20
 */
public interface UserRoleDao {
    public List<Integer> getRoleIdsByUserId(@Param("userId") int userId);
}
