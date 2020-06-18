package com.cy.pj.sys.controller;

import com.cy.pj.sys.common.vo.JsonResult;
import com.cy.pj.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/user/")
@RestController
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;


    @RequestMapping("doValidById")
    public JsonResult doValidById(Integer id,Integer valid){
        sysUserService.doValidById(id,valid);
        return new JsonResult("update ok");
    }
    /**
     * 初始化用户信息
     * @param pageCurrent
     * @param username
     * @return
     */
    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(Integer pageCurrent,String username){
        return new JsonResult(sysUserService.doFindPageObject(pageCurrent,username));
    }
}
