package com.nrmyw.ble_event_lib.type;

public enum BleSendBitmapQualityType {
    ULTRA_LOW(6),//超低
    LOW(15),//低
    DEF(30),//一般
    HIGH(50),//高
    ULTRA_HIGH(70),//超高
    PROGRESS(1),//进度条专属
    ;
    private int qualityV;//1-100
    private float zoomScaling=0.6;
    private BleSendBitmapQualityType(int qualityV){
        this.qualityV=qualityV;
    }

    public int getQualityV() {
        return qualityV;
    }

    public void setQualityV(int qualityV) {
        this.qualityV = qualityV;
    }

    public void setZoomScaling(float zoomScaling) {
        if(zoomScaling>1){
            this.zoomScaling=1;
        }else {
            this.zoomScaling = zoomScaling;
        }


    }

    public float getZoomScaling() {
        return zoomScaling;
    }
}
