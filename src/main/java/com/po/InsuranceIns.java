package com.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsuranceIns implements Serializable {
    private Integer  id;//'主键',
    private String insName ;// '保险名称',
    private String insType ;// '险种',
    private String details ;// '保险介绍（保存附文本）',
    private String buycondition ;//'购买条件',
    private BigDecimal payAmount ;//'支付金额',
    private String endDate ;//'保险时间',
    private String creationDate ;// '发布时间'
    private Date creationDate1 ;// '发布时间'
    private String url;//路径

    public InsuranceIns() {
    }

       public InsuranceIns(Integer id, String insName, String insType, String details, String buycondition, BigDecimal payAmount, String endDate, String creationDate) {
        this.id = id;
        this.insName = insName;
        this.insType = insType;
        this.details = details;
        this.buycondition = buycondition;
        this.payAmount = payAmount;
        this.endDate = endDate;
        this.creationDate = creationDate;
    }

    public InsuranceIns(Integer id, String insName, String insType, String details, String buycondition, BigDecimal payAmount, String endDate, String creationDate, Date creationDate1, String url) {
        this.id = id;
        this.insName = insName;
        this.insType = insType;
        this.details = details;
        this.buycondition = buycondition;
        this.payAmount = payAmount;
        this.endDate = endDate;
        this.creationDate = creationDate;
        this.creationDate1 = creationDate1;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInsName() {
        return insName;
    }

    public void setInsName(String insName) {
        this.insName = insName;
    }

    public String getInsType() {
        return insType;
    }

    public void setInsType(String insType) {
        this.insType = insType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getBuycondition() {
        return buycondition;
    }

    public void setBuycondition(String buycondition) {
        this.buycondition = buycondition;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCreationDate() {
        creationDate=new SimpleDateFormat("yyyy-MM-dd").format(this.creationDate1);
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        try {
            this.creationDate1=new SimpleDateFormat("yyyy-MM-dd").parse(creationDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.creationDate = creationDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreationDate1() {
        return creationDate1;
    }

    public void setCreationDate1(Date creationDate1) {
        this.creationDate1 = creationDate1;
    }

    @Override
    public String toString() {
        return "InsuranceIns{" +
                "id=" + id +
                ", insName='" + insName + '\'' +
                ", insType='" + insType + '\'' +
                ", details='" + details + '\'' +
                ", buycondition='" + buycondition + '\'' +
                ", payAmount=" + payAmount +
                ", endDate='" + endDate + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", creationDate1=" + creationDate1 +
                ", url='" + url + '\'' +
                '}';
    }
}
