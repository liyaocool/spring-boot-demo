package com.thinrain.springbootdemo.model;

import lombok.Data;

@Data
public class AjaxResponse {
    private Integer code;
    private String message;
    private Object data;

    private AjaxResponse(){}

    //无数据相应响应
    public static AjaxResponse sucess(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("sucess");
        return ajaxResponse;
    }


    //有数据响应请求
    public static AjaxResponse sucess(Object data){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("sucess");
        ajaxResponse.setData(data);
        return ajaxResponse;
    }

    //请求错误
    public static AjaxResponse reqError(Object data){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(400);
        ajaxResponse.setMessage("bad request");
        ajaxResponse.setData(data);
        return ajaxResponse;
    }

    //响应错误
    public static AjaxResponse resError(Object data){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(500);
        ajaxResponse.setMessage("response error");
        ajaxResponse.setData(data);
        return ajaxResponse;
    }
}
