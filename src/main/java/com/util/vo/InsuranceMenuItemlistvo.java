package com.util.vo;

import java.io.Serializable;
import java.util.List;

public class InsuranceMenuItemlistvo implements Serializable {//返回到前台的菜单数据格式
   private String mouduleurl;//页面路径
   private String text;//菜单名称
   private String index;//菜单标识
   private List<InsuranceMenuItemlistvo> nodes;//包含的子菜单

    public InsuranceMenuItemlistvo() {
    }
    public InsuranceMenuItemlistvo(String mouduleurl, String text, String index, List<InsuranceMenuItemlistvo> nodes) {
        this.mouduleurl = mouduleurl;
        this.text = text;
        this.index = index;
        this.nodes = nodes;
    }

    public String getMouduleurl() {
        return mouduleurl;
    }

    public void setMouduleurl(String mouduleurl) {
        this.mouduleurl = mouduleurl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public List<InsuranceMenuItemlistvo> getNodes() {
        return nodes;
    }

    public void setNodes(List<InsuranceMenuItemlistvo> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "InsuranceMenuItemlistvo{" +
                "mouduleurl='" + mouduleurl + '\'' +
                ", text='" + text + '\'' +
                ", index='" + index + '\'' +
                ", nodes=" + nodes +
                '}';
    }
}
