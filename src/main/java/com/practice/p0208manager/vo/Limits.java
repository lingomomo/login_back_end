package com.practice.p0208manager.vo;

import java.util.Date;

public class Limits {
    private int loginId;
    private String roleName;
    private Date validPeriodStart;
    private Date validPeriodEnd;
    private String title;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Limits{" +
                "loginId=" + loginId +
                ", roleName='" + roleName + '\'' +
                ", validPeriodStart=" + validPeriodStart +
                ", validPeriodEnd=" + validPeriodEnd +
                ", title='" + title + '\'' +
                '}';
    }
}
