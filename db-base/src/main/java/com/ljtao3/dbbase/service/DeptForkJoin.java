package com.ljtao3.dbbase.service;

import com.ljtao3.dbbase.dao.master.DeptDao;
import com.ljtao3.dbbase.entity.master.Dept;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author ljtao3 on 2020/3/24
 */
public class DeptForkJoin {
    public static  List<Dept> getDeptChildListById(int deptId, DeptDao deptDao){
        ForkJoinPool forkJoinPool=new ForkJoinPool(10,
                ForkJoinPool.defaultForkJoinWorkerThreadFactory,null,true);
        List<Dept> list=new CopyOnWriteArrayList<Dept>();
        DeptTask deptTask=new DeptTask(deptId,deptDao);
        ForkJoinTask<List<Dept>> submit = forkJoinPool.submit(deptTask);
        try {
            list=submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return list;
    }
}
class DeptTask extends RecursiveTask<List<Dept>>{

     private DeptDao deptDao;
     private int deptId;

    public  DeptTask( int deptId, DeptDao deptDao){
        this.deptId=deptId;
        this.deptDao=deptDao;
    }


    @Override
    protected List<Dept> compute() {
        List<Dept> byParentIdList = deptDao.getByParentId(deptId);
        //System.out.println(Thread.currentThread().getName());
        if(byParentIdList==null || byParentIdList.size()<1){
            return new ArrayList();
        }
        else{
            //这里没有进行拆分，只有一个线程在执行
            List<Dept> copyOnWriteArrayList=new CopyOnWriteArrayList();
            for (Dept dept : byParentIdList){
                if(dept.getStatus()==1){
                    copyOnWriteArrayList.add(dept);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    DeptTask deptTask=new DeptTask(dept.getId(),deptDao);
                    deptTask.fork();
                    copyOnWriteArrayList.addAll(deptTask.join());
                }
            }

            return copyOnWriteArrayList;
        }




    }
}
