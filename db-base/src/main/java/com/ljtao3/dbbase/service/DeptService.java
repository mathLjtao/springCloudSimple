package com.ljtao3.dbbase.service;

import com.ljtao3.dbbase.dao.master.DeptDao;
import com.ljtao3.dbbase.entity.master.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ljtao3 on 2020/3/24
 */
@Service
public class DeptService {
    @Autowired
    private DeptDao deptDao;
    public List<Dept> getDeptChildListById(int parentId) {


        //用fork/join框架写的不好
        //return DeptForkJoin.getDeptChildListById(parentId,deptDao);

        //这里查询慢，关键应该是在查询多次数据库的瓶颈上。
        List<Dept> list =new ArrayList<>();
        return getDeptChildListById(list,parentId);
    }

    //
    private List<Dept> getDeptChildListById(List<Dept> list,int deptParent){

        List<Dept> byParentIdList = deptDao.getByParentId(deptParent);
        if(byParentIdList!=null && byParentIdList.size()>0){
            for (Dept dept : byParentIdList){
                if(dept.getStatus()==1){
                    list.add(dept);
                    getDeptChildListById(list,dept.getId());
                }
            }
        }
        return list;
    }

    public List<Dept> getDeptChildListByIdByMysqlCTE(int deptParent){

        List<Dept> list = deptDao.getDeptChildListById(deptParent);
        if(list!=null && list.size()>0){
            return list;
        }
        return new ArrayList<>();
    }
}
