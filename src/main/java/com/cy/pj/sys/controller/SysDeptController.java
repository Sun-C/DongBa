package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.sys.common.vo.JsonResult;
import com.cy.pj.sys.service.SysDeptService;

@RestController
@RequestMapping("/dept/")
public class SysDeptController {
	@Autowired
	private SysDeptService sysDeptService;
	@RequestMapping("doFindZTreeNodes")
	public JsonResult doFindZTreeNodes() {
		return new JsonResult(sysDeptService.doFindZTreeNodes());
	}
}
