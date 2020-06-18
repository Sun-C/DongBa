package com.cy.pj.sys.common.exception;

/**
 * 在当前方法中需要的ServiceException是一个自己定义的异常,
 * 通过自定义异常可更好的实现对业务问题的描述，同时可以更好的提高用户体验。
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -3220039822364604847L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
