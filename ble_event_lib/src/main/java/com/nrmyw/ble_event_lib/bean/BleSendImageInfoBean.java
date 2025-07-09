package com.nrmyw.ble_event_lib.bean;

import android.graphics.Bitmap;

import java.io.Serializable;

public class BleSendImageInfoBean implements Serializable {
    private int type;//图片种类标识
    private String name;//可以为空
    private int maxW;//显示最大宽
    private int maxH;//显示最大长
    private Bitmap bitmap;
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxW() {
        return maxW;
    }

    public void setMaxW(int maxW) {
        this.maxW = maxW;
    }

    public int getMaxH() {
        return maxH;
    }

    public void setMaxH(int maxH) {
        this.maxH = maxH;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    @Override
    public String toString() {
        return "BleSendImageInfoBean{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", maxW=" + maxW +
                ", maxH=" + maxH +
                '}';
    }
}
