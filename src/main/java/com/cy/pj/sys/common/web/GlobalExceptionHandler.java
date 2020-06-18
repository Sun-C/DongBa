package com.cy.pj.sys.common.web;

import com.cy.pj.sys.common.vo.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ControllerAdvice 描述的类为全局异常处理类
 * 1)假如xxxController类的方法出现了异常,此异常没有try{}cath操作 而是继续抛出了
 * 这个异常会抛给Controller方法调用者(DispatcherServlet),此对象会检测抛出异常的controller类中
 * 是否有定义异常处理方法(@ExceptionHandler),这个方法能够处理抛出异常,
 * 假如不可以,那么 DispatcherServlet对象还会检测是否有全聚德异常处理类,假如有
 * 则调用全局异常处理类中的相关异常处理方法来处理异常
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public JsonResult doHandleIllegalArgumentException(IllegalArgumentException e){
        System.out.println("抛出异常的优先级是从局部到全局 还有 异常类型查找 先找对应的异常处理" +
                "要是没找到就找下面的RuntimeException 来处理 也就是父类查找");
        e.printStackTrace();//也可以写日志异常信息
        return new JsonResult(e);//封装
    }
    //JDK中自带的日志API
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public JsonResult doHandleRuntimeException(RuntimeException e){
        e.printStackTrace();//也可以写日志异常信息
        return new JsonResult(e);//封装
    }
}
