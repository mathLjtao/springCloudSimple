package com.ljtao3.dbbase.dao.master;

import com.ljtao3.dbbase.entity.master.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptDao {
    List<Dept> getByParentId(@Param("parentId") int parentId);
    List<Dept> getDeptChildListById(@Param("parentId") int parentId);
}
