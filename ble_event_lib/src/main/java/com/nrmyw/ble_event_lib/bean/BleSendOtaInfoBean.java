package com.nrmyw.ble_event_lib.bean;

import java.io.Serializable;
import java.util.Arrays;

public class BleSendOtaInfoBean implements Serializable {

    private String fileName;

    private String filePath;

    private byte[] readyOkBytes;
    private byte[] sendIndexOkBytes;
    private byte[] needResendBytes;

    private byte[] sendEndBytes;


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



    public byte[] getReadyOkBytes() {
        return readyOkBytes;
    }

    public void setReadyOkBytes(byte[] readyOkBytes) {
        this.readyOkBytes = readyOkBytes;
    }

    public byte[] getSendEndBytes() {
        return sendEndBytes;
    }

    public void setSendEndBytes(byte[] sendEndBytes) {
        this.sendEndBytes = sendEndBytes;
    }

    public byte[] getNeedResendBytes() {
        return needResendBytes;
    }

    public void setNeedResendBytes(byte[] needResendBytes) {
        this.needResendBytes = needResendBytes;
    }

    public byte[] getSendIndexOkBytes() {
        return sendIndexOkBytes;
    }

    public void setSendIndexOkBytes(byte[] sendIndexOkBytes) {
        this.sendIndexOkBytes = sendIndexOkBytes;
    }

    @Override
    public String toString() {
        return "BleSendOtaInfoBean{" +
                "fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", readyOkBytes=" + Arrays.toString(readyOkBytes) +
                ", sendIndexOkBytes=" + Arrays.toString(sendIndexOkBytes) +
                ", needResendBytes=" + Arrays.toString(needResendBytes) +
                ", sendEndBytes=" + Arrays.toString(sendEndBytes) +
                '}';
    }
}
