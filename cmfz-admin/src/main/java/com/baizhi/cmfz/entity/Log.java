package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-10 12:05:16
 **/
public class Log implements Serializable{
    private String logId;
    private String logUser;
    @JSONField(format = "yyyy-MM-dd")
    private Date logTime;
    private String logAction;
    private String logResource;
    private String logMessage;
    private String logResult;

    public Log() {
    }

    public Log(String logId, String logUser, Date logTime, String logResource, String logAction, String logMessage, String logResult) {
        this.logId = logId;
        this.logUser = logUser;
        this.logTime = logTime;
        this.logResource = logResource;
        this.logAction = logAction;
        this.logMessage = logMessage;
        this.logResult = logResult;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId='" + logId + '\'' +
                ", logUser='" + logUser + '\'' +
                ", logTime=" + logTime +
                ", logResource='" + logResource + '\'' +
                ", logAction='" + logAction + '\'' +
                ", logMessage='" + logMessage + '\'' +
                ", logResult='" + logResult + '\'' +
                '}';
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getLogUser() {
        return logUser;
    }

    public void setLogUser(String logUser) {
        this.logUser = logUser;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getLogResource() {
        return logResource;
    }

    public void setLogResource(String logResource) {
        this.logResource = logResource;
    }

    public String getLogAction() {
        return logAction;
    }

    public void setLogAction(String logAction) {
        this.logAction = logAction;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public String getLogResult() {
        return logResult;
    }

    public void setLogResult(String logResult) {
        this.logResult = logResult;
    }
}
