package com.huangyujie.demo.entity;

import java.util.Map;
public class ImgResult {

    private Integer code;            //图片的保存状态信息（成功或者失败）
    private String msg;              //要传回给前台的提示信息
    private Map<String, String> data;//这里存的是图片路径等信息

    private Integer totalCount=0;    //这里作为后期要做多图片上传的总数的记录
    private Integer successCount=0;  //这里作为后期要做多图片上传的成功总数的记录
    private Integer failCount=0;     //这里作为后期要做多图片上传的失败总数的记录

    public ImgResult() {
    }

    public ImgResult(Integer code, String msg, Map<String, String> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(Integer successCount) {
        this.successCount = successCount;
    }

    public Integer getFailCount() {
        return failCount;
    }

    public void setFailCount(Integer failCount) {
        this.failCount = failCount;
    }

}

