package com.nrmyw.ble_event_lib.bean;

import java.io.Serializable;

public class BleSendImageStartInfoBean implements Serializable {
    private int type;//图片种类标识
    private String name;//可以为空
    private int w;
    private int h;
    private int size;




    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

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

    @Override
    public String toString() {
        return "BleSendImageStartInfoBean{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", w=" + w +
                ", h=" + h +
                ", size=" + size +
                '}';
    }
}
