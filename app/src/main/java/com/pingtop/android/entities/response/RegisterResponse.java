package com.pingtop.android.entities.response;

/**
 * Created by wuhaojie on 2016/7/21 21:37.
 */
public class RegisterResponse {

    /**
     * tittle : 注册
     * content : token
     * exrInfo : UUgi933Lak+OYDLbbM7gtg==
     */

    private String tittle;
    private String content;
    private String exrInfo;

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExrInfo() {
        return exrInfo;
    }

    public void setExrInfo(String exrInfo) {
        this.exrInfo = exrInfo;
    }

    @Override
    public String toString() {
        return "RegisterResponse{" +
                "tittle='" + tittle + '\'' +
                ", content='" + content + '\'' +
                ", exrInfo='" + exrInfo + '\'' +
                '}';
    }
}
