package com.nrmyw.ble_event_lib.bean;

import java.io.Serializable;

public class BleSendFileInfoBean implements Serializable {

    private String fileName;

    private String filePath;

    private byte cmdTitle;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public byte getCmdTitle() {
        return cmdTitle;
    }

    public void setCmdTitle(byte cmdTitle) {
        this.cmdTitle = cmdTitle;
    }

    @Override
    public String toString() {
        return "BleSendFileInfoBean{" +
                "fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", cmdTitle=" + cmdTitle +
                '}';
    }
}
