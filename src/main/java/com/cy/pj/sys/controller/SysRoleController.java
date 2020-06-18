package com.cy.pj.sys.controller;

import com.cy.pj.sys.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role/")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 修改更新角色和菜单的关联信息
     * @param entity
     * @param menuIds
     * @return
     */
    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysRole entity,Integer...menuIds){
        sysRoleService.doUpdateObject(entity,menuIds);
        return new JsonResult("update ok!");
    }
    /**
     * 基于id查询角色信息
     */
    @RequestMapping("doFindObjectById")
    public JsonResult doFindObjectById(Integer id){
        return new JsonResult(sysRoleService.doFindObjectById(id));
    }
    /**
     * 新增 角色信息
     * @param entity
     * @param menuIds
     * @return
     */
    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(SysRole entity,Integer...menuIds){
        sysRoleService.doSaveObject(entity,menuIds);
        return new JsonResult("save ok!");
    }

    /**
     * 基于id删除角色信息
     */
    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer id){
        sysRoleService.doDeleteObject(id);
        return new JsonResult("delete ok!");
    }
    /**
     * 初始化查询角色信息
     * @param name
     * @param pageCurrent
     * @return
     */
    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(String name,Integer pageCurrent){
        return new JsonResult(sysRoleService.doFindPageObjects(name,pageCurrent));
    }
}
