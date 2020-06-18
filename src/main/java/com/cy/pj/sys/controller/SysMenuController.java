package com.cy.pj.sys.controller;

import com.cy.pj.sys.common.vo.JsonResult;
import com.cy.pj.sys.common.vo.zTree;
import com.cy.pj.sys.entity.SysMenu;
import com.cy.pj.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/menu/")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;
    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysMenu entity){
        sysMenuService.doUpdateObject(entity);
        return new JsonResult("update ok!");
    }

    /**
     * 菜单添加接口实现
     */
    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(SysMenu entity){
        int rows = sysMenuService.doSaveObject(entity);
        return new JsonResult("save ok!");
    }

    /**
     * 基于id查询Node节点对象 就是 选择上级菜单的vo对象
     */
    @RequestMapping("doFindZtreeMenuNodes")
    public JsonResult doFindZtreeMenuNodes(){
        List<zTree> data = sysMenuService.doFindZtreeMenuNodes();
        return new JsonResult(data);
    }

    /**
     * 基于id删除菜单信息
     */
    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer id){
        sysMenuService.doDeleteObject(id);
        return new JsonResult("delete ok!");
    }

    /**
     * 菜单管理数据初始化
     * @return
     */
    @RequestMapping("doFindObjects")
    public JsonResult doFindObjects(){
        return new JsonResult(sysMenuService.doFindObjects());
    }
}
