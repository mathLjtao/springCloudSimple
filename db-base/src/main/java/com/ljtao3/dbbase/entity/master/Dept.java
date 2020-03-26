package com.ljtao3.dbbase.entity.master;

/**
 * @author ljtao3 on 2020/3/24
 */
public class Dept {
    private int id;
    private String deptName;
    private int parentId;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private int status;

    public int getId() {
        return id;
    }

    public void setId(int deptId) {
        this.id = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
