package com.cy.pj.sys.controller;

import com.cy.pj.sys.common.vo.JsonResult;
import com.cy.pj.sys.common.bo.PageObject;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log/")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;
    @RequestMapping("doDeleteObjects")
    public JsonResult doDeleteSysLogByIds(Integer...ids){
        sysLogService.deleteSysLogByIds(ids);
        return new JsonResult("删除成功");
    }


    /**
     * 分页查询 或按照用户名 分页查询
     * @param username
     * @param pageCurrent
     * @return
     */
    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObject(String username,Integer pageCurrent){
        PageObject<SysLog> pageObjects = sysLogService.findPageObjects(username, pageCurrent);
        return new JsonResult(pageObjects);//DispatcherServlet
    }

}
