package com.nrmyw.ble_event_lib.bean;

import java.io.Serializable;

public class BleDeviceBean implements Serializable {
    private String deviceName;
    private int deviceType;
    private String deviceTitle;
    private String deviceBody;

    private int manufacturerSpecificId;
    private String manufacturerSpecificData;

    private String bleName;

    private BlePairFuntionType pairFuntionType;
    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceTitle() {
        return deviceTitle;
    }

    public void setDeviceTitle(String deviceTitle) {
        this.deviceTitle = deviceTitle;
    }

    public String getDeviceBody() {
        return deviceBody;
    }

    public void setDeviceBody(String deviceBody) {
        this.deviceBody = deviceBody;
    }



    public String getBleName() {
        return bleName;
    }

    public void setBleName(String bleName) {
        this.bleName = bleName;
    }

    public BlePairFuntionType getPairFuntionType() {
        return pairFuntionType;
    }

    public void setPairFuntionType(BlePairFuntionType pairFuntionType) {
        this.pairFuntionType = pairFuntionType;
    }

    public int getManufacturerSpecificId() {
        return manufacturerSpecificId;
    }

    public void setManufacturerSpecificId(int manufacturerSpecificId) {
        this.manufacturerSpecificId = manufacturerSpecificId;
    }

    public String getManufacturerSpecificData() {
        return manufacturerSpecificData;
    }

    public void setManufacturerSpecificData(String manufacturerSpecificData) {
        this.manufacturerSpecificData = manufacturerSpecificData;
    }

    @Override
    public String toString() {
        return "BleDeviceBean{" +
                "deviceName='" + deviceName + '\'' +
                ", deviceType=" + deviceType +
                ", deviceTitle='" + deviceTitle + '\'' +
                ", deviceBody='" + deviceBody + '\'' +
                ", manufacturerSpecificId=" + manufacturerSpecificId +
                ", manufacturerSpecificData='" + manufacturerSpecificData + '\'' +
                ", bleName='" + bleName + '\'' +
                ", pairFuntionType=" + pairFuntionType +
                '}';
    }
}
