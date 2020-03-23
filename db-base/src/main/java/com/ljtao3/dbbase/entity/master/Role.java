package com.ljtao3.dbbase.entity.master;

/**
 * @author ljtao3 on 2020/3/16
 */
public class Role {
    private int id;
    private String name;
    private int webSiteId;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWebSite() {
        return webSiteId;
    }

    public void setWebSite(int webSite) {
        this.webSiteId = webSite;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
