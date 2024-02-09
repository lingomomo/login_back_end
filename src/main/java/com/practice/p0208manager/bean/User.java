package com.practice.p0208manager.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private Integer loginId;
    private String userName;
    private String password;
    private String address;
    private Integer tel;
    private Integer userRoleCode;
    private Date valid_period_start;
    private Date valid_period_end;
    private Date registration_date;
    private Date update_date;

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

    public Date getValid_period_start() {
        return valid_period_start;
    }

    public void setValid_period_start(Date valid_period_start) {
        this.valid_period_start = valid_period_start;
    }

    public Date getValid_period_end() {
        return valid_period_end;
    }

    public void setValid_period_end(Date valid_period_end) {
        this.valid_period_end = valid_period_end;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    @Override
    public String toString() {
        return "User{" +
                "loginId=" + loginId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", tel=" + tel +
                ", userRoleCode=" + userRoleCode +
                ", valid_period_start=" + valid_period_start +
                ", valid_period_end=" + valid_period_end +
                ", registration_date=" + registration_date +
                ", update_date=" + update_date +
                '}';
    }
}
