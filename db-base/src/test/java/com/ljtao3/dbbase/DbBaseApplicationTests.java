package com.ljtao3.dbbase;

import com.ljtao3.dbbase.service.DeptService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.Target;

@SpringBootTest
class DbBaseApplicationTests {

    @Autowired
    private DeptService deptService;
    //测试用程序递归查询指定所有子部门
    @Test
    public void fun1(){

        long l = System.currentTimeMillis();
        System.out.println(deptService.getDeptChildListById(0).size());
        System.out.println("耗时："+(System.currentTimeMillis()-l));
    }
    //测试用mysql cte 表达式递归查询指定所有子部门
    @Test
    public void fun2(){

        long l = System.currentTimeMillis();
        System.out.println(deptService.getDeptChildListByIdByMysqlCTE(0).size());
        System.out.println("耗时："+(System.currentTimeMillis()-l));
    }

    @Test
    void contextLoads() {
        System.out.println(deptService);
    }

}
