package com.ljtao3.dbbase.controller;

import com.ljtao3.dbbase.service.DeptService;
import com.ljtao3.dbbase.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljtao3 on 2020/3/24
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;
    @GetMapping("/getDeptChildList")
    public JsonData getDeptChildListById(int deptId){
        deptService.getDeptChildListById(deptId);
        return JsonData.success();
    }
}
