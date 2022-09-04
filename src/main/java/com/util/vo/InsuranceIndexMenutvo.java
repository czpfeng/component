package com.util.vo;

import java.io.Serializable;
import java.util.List;

public class InsuranceIndexMenutvo implements Serializable {//返回到前台的菜单数据格式
   private String userCode;//账号

    public InsuranceIndexMenutvo() {
    }

    public InsuranceIndexMenutvo(String userCode) {
        this.userCode = userCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Override
    public String toString() {
        return "InsuranceIndexMenutvo{" +
                "userCode='" + userCode + '\'' +
                '}';
    }
}
