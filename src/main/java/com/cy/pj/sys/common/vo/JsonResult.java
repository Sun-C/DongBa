package com.cy.pj.sys.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * VO: (View Object.ValueObject),在当前项目中我们可以借助VO封装视图层要呈现的数据
 */
@Data
public class JsonResult implements Serializable {

    private static final long serialVersionUID = -7795815851642138272L;
    /**状态码*/
    private int state;//= 1 不建议给对象属性初始化 ;//1.表示success,0表示error
    /**状态信息*/
    private String message;  // = "ok";
    /**正确数据*/
    private Object data;
    public JsonResult(){
    }
    public JsonResult(String message){
        this.state=1;
        this.message=message;
    }
    /**一般查询调用,封装查询结果*/
    public JsonResult(Object data){
        this.state=1;
        this.message="ok";
        this.data=data;
    }
    /**出现异常时调用*/
    public JsonResult(Throwable e){
        this.state=0;
        this.message=e.getMessage();
    }
}
