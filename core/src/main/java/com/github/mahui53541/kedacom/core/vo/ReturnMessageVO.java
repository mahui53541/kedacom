package com.github.mahui53541.kedacom.core.vo;

/**
 * @description:返回值
 * @author: MaHui
 * @created: 2018/1/2 12:20
 * @version:1.0.0
 */
public class ReturnMessageVO {
    public static final int SUCCESS = 1;

    public static final int FAIL = -1;

    private int code;

    private String msg;

    private Object data;

    public ReturnMessageVO(){}

    public ReturnMessageVO(int code) {
        this.code = code;
    }

    public ReturnMessageVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ReturnMessageVO(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ReturnMessageVO success(){
        return new ReturnMessageVO(ReturnMessageVO.SUCCESS);
    }
    public static ReturnMessageVO success(String msg){
        return new ReturnMessageVO(ReturnMessageVO.SUCCESS,msg);
    }
    public static ReturnMessageVO success(String msg,Object data){
        return new ReturnMessageVO(ReturnMessageVO.SUCCESS,msg,data);
    }

    public static ReturnMessageVO fail(){
        return new ReturnMessageVO(ReturnMessageVO.FAIL);
    }
    public static ReturnMessageVO fail(String msg){
        return new ReturnMessageVO(ReturnMessageVO.FAIL,msg);
    }
    public static ReturnMessageVO fail(String msg,Object data){
        return new ReturnMessageVO(ReturnMessageVO.FAIL,msg,data);
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
