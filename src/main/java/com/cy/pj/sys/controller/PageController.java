package com.cy.pj.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class PageController {
    @RequestMapping("doIndexUI")
    public String doIndexUI(){
        return "starter";
    }

    /**
     *  rest风格的url定义 (软件编码架构风格)
     *  语法定义格式:{path1}/{path2}/...;其中{}内容可以理解为一个变量
     * @PathVariable 注解可以描述方法的参数,用于获取url中与方法参数相同的变量值
     */
    @RequestMapping("{module}/{moduleUI}")
    public String doModuleUI(@PathVariable String moduleUI) {
        return "sys/"+moduleUI;
    }

    @RequestMapping("doPageUI")
    public String doPageUI(){
        return "common/page";
    }
}
