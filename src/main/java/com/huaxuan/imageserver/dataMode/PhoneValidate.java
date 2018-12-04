package com.huaxuan.imageserver.dataMode;

import java.util.Date;

public class PhoneValidate {
    private Integer id;

    private String phonenumber;

    private String validatenumber;

    private Date date;

    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getValidatenumber() {
        return validatenumber;
    }

    public void setValidatenumber(String validatenumber) {
        this.validatenumber = validatenumber == null ? null : validatenumber.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}