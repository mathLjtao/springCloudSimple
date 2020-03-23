package com.ljtao3.dbbase.dao.master;

import com.ljtao3.dbbase.entity.master.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ljtao3 on 2020/3/16
 */
public interface RoleDao {
    public Role  getRoleById(@Param("id") int id);
}
