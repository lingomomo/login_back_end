package com.practice.p0208manager.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Limits {
    private int loginId;
    private String roleName;
    @JsonFormat(timezone = "Asia/Tokyo")
    private Date validPeriodStart;
    @JsonFormat(timezone = "Asia/Tokyo")
    private Date validPeriodEnd;
    private int addressId;

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getValidPeriodStart() {
        return validPeriodStart;
    }

    public void setValidPeriodStart(Date validPeriodStart) {
        this.validPeriodStart = validPeriodStart;
    }

    public Date getValidPeriodEnd() {
        return validPeriodEnd;
    }

    public void setValidPeriodEnd(Date validPeriodEnd) {
        this.validPeriodEnd = validPeriodEnd;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "Limits{" +
                "loginId=" + loginId +
                ", roleName='" + roleName + '\'' +
                ", validPeriodStart=" + validPeriodStart +
                ", validPeriodEnd=" + validPeriodEnd +
                ", addressId=" + addressId +
                '}';
    }
}
