package com.sun.demo.license;


import java.io.Serializable;

/**
 * @author 钱善良
 * @date 2021/7/6 10:57 上午
 */
public class LicenseBo implements Serializable {
    /**
     * 序列号（cpu，硬盘，ip，mac）
     */
    private String serialNo;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 有效期
     */
    private Integer duration;
    /**
     * 客户名称
     */
    private String customer;
    /**
     * 项目名称
     */
    private String project;
    /**
     * 加密信息
     */
    private String encryption;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getEncryption() {
        return encryption;
    }

    public void setEncryption(String encryption) {
        this.encryption = encryption;
    }

    @Override
    public String toString() {
        return "LicenseBo{" +
                "serialNo='" + serialNo + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime='" + createTime + '\'' +
                ", startTime='" + startTime + '\'' +
                ", duration=" + duration +
                ", customer='" + customer + '\'' +
                ", project='" + project + '\'' +
                ", encryption='" + encryption + '\'' +
                '}';
    }
}
