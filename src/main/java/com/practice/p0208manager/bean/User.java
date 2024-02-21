package com.practice.p0208manager.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private Integer loginId;
    private String userName;
    private String roleName;
    private String password;
    private String address;
    private Integer tel;
    private Integer userRoleCode;
    private Date validPeriodStart;
    private Date validPeriodEnd;
    private Date registrationDate;
    private Date updateDate;

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public Integer getUserRoleCode() {
        return userRoleCode;
    }

    public void setUserRoleCode(Integer userRoleCode) {
        this.userRoleCode = userRoleCode;
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

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "loginId=" + loginId +
                ", userName='" + userName + '\'' +
                ", roleName='" + roleName + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", tel=" + tel +
                ", userRoleCode=" + userRoleCode +
                ", validPeriodStart=" + validPeriodStart +
                ", validPeriodEnd=" + validPeriodEnd +
                ", registrationDate=" + registrationDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
