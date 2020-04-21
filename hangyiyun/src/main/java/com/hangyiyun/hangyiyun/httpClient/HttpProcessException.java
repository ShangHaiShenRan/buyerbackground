package com.hangyiyun.hangyiyun.httpClient;

   /**
    * @创建人: wangcc
    * @创建时间: 2020/4/19
    * @描述:
    **/
    public class HttpProcessException extends Exception {

    public HttpProcessException(Exception e){
        super(e);
    }

    /**
     * @param msg	消息
     */
    public HttpProcessException(String msg) {
        super(msg);
    }

    /**
     * @param message	异常消息
     * @param e			异常
     */
    public HttpProcessException(String message, Exception e) {
        super(message, e);
    }

}
