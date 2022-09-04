package com.util.vo;

import java.io.Serializable;

public class InsurancePagevo implements Serializable {
    private String userCode;//用户账号
   private  Integer orgCode;//占位
   private  Integer pageSize;
   private  Integer currentPage;

    public InsurancePagevo() {
    }

    public InsurancePagevo(String userCode, Integer orgCode, Integer pageSize, Integer currentPage) {
        this.userCode = userCode;
        this.orgCode = orgCode;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Integer getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(Integer orgCode) {
        this.orgCode = orgCode;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "InsurancePagevo{" +
                "userCode='" + userCode + '\'' +
                ", orgCode=" + orgCode +
                ", pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                '}';
    }
}
