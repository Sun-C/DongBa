package com.cy.pj.sys.controller;

import com.cy.pj.sys.common.vo.JsonResult;
import com.cy.pj.sys.service.SysUserService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/user/")
@RestController
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;
	/**
	 * 根据用户id查询修改用户信息
	 * @param id
	 * @return
	 */
	@RequestMapping("doFindObjectById")
	public JsonResult doFindObjectById(Integer id) {
		return new JsonResult(sysUserService.doFinObjectById(id));
	}

	/**
	 * 修改用户的启用禁用状态
	 * @param id
	 * @param valid
	 * @return
	 */
	@RequestMapping("doValidById")
	public JsonResult doValidById(@Param("id")Integer id,
			@Param("valid")Integer valid,
			@Param("modifiedUser")String modifiedUser){
		String msg = sysUserService.doValidById(id,valid,modifiedUser);
		return new JsonResult(msg);
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
