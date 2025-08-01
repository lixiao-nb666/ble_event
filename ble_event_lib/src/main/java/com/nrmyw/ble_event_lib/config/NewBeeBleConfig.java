package com.nrmyw.ble_event_lib.config;

import android.text.TextUtils;

import com.nrmyw.ble_event_lib.bean.BleDeviceBean;

import java.util.List;

public class NewBeeBleConfig {
    private static NewBeeBleConfig blueToothGattConfig;
    private boolean autoConnect ;
    private int mtu;
    private int sendFileMtu;
    private String serviceID ;
    private String writeID ;
    private String noticeID ;
    private boolean disconnectAutoConnect;

    private List<BleDeviceBean> bleDeviceList;



    private NewBeeBleConfig(){

    }

    public static NewBeeBleConfig getInstance(){
        if(null==blueToothGattConfig){
            synchronized (NewBeeBleConfig.class){
                if(null==blueToothGattConfig){
                    blueToothGattConfig=new NewBeeBleConfig();
                }
            }
        }
        return blueToothGattConfig;
    }

//    public void init(  boolean isAutomatic , int mtu,String serviceID , String writeID , String noticeID ,BleDeviceBean bleDeviceBean){
//        this.isAutomatic=isAutomatic;
//        this.mtu=mtu;
//        sendDataMtu=mtu-5;
//        this.serviceID=serviceID;
//        this.writeID=writeID;
//        this.noticeID=noticeID;
//        this.bleDeviceList=new ArrayList<>();
//        this.bleDeviceList.add(bleDeviceBean);
//        isConnect=false;
//    }

    public void init(  boolean autoConnect , int mtu,String serviceID , String writeID , String noticeID , List<BleDeviceBean> bleDeviceList){
        this.autoConnect=autoConnect;
        this.mtu=mtu;
        sendFileMtu=mtu-5;
        this.serviceID=serviceID;
        this.writeID=writeID;
        this.noticeID=noticeID;
        this.bleDeviceList=bleDeviceList;
    }




    public void setMtu(int mtu) {
        this.mtu = mtu;
        sendFileMtu=mtu-5;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public void setWriteID(String writeID) {
        this.writeID = writeID;
    }

    public void setNoticeID(String noticeID) {
        this.noticeID = noticeID;
    }

    public boolean isAutoConnect() {
        return autoConnect;
    }

    public void setAutoConnect(boolean autoConnect) {
        this.autoConnect = autoConnect;
    }



    public int getMtu() {
        return mtu;
    }

    public int getSendFileMtu() {
        return sendFileMtu;
    }



    public String getServiceID() {
        return serviceID;
    }

    public String getWriteID() {
        return writeID;
    }

    public String getNoticeID() {
        return noticeID;
    }

    public boolean isDisconnectAutoConnect() {
        return disconnectAutoConnect;
    }

    public void setDisconnectAutoConnect(boolean disconnectAutoConnect) {
        this.disconnectAutoConnect = disconnectAutoConnect;
    }





    public BleDeviceBean checkBleName(String bleName){
        if(TextUtils.isEmpty(bleName)){
            return null;
        }
        if(null==bleDeviceList||bleDeviceList.size()==0){
            return null;
        }
        for(BleDeviceBean bleDevice:bleDeviceList){
            if(!TextUtils.isEmpty(bleDevice.getDeviceTitle())&&bleName.contains(bleDevice.getDeviceTitle())){
                if(TextUtils.isEmpty(bleDevice.getDeviceBody())||bleName.contains(bleDevice.getDeviceBody())){
                    //有名字只需要名字匹配即可,没有的话，后面也要匹配上
                    return bleDevice;
                }
            }
        }
        return null;
    }


}
