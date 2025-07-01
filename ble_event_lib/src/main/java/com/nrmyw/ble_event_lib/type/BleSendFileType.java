package com.nrmyw.ble_event_lib.type;

public enum BleSendFileType {
    DEF,
    OTA1,
    OTA2,
    ;
    int ord;

    private BleSendFileType(){

    }

    public int getOrd() {
        return ord;
    }

    public void setOrd(int ord) {
        this.ord = ord;
    }

    
}
