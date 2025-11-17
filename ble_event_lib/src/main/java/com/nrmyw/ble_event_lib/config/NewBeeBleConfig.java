package com.nrmyw.ble_event_lib.config;

import android.bluetooth.le.ScanRecord;
import android.text.TextUtils;

import com.nrmyw.ble_event_lib.bean.BleDeviceBean;
import com.nrmyw.ble_event_lib.bean.BlePairFuntionType;
import com.nrmyw.ble_event_lib.util.BleByteUtil;

import java.util.List;

public class NewBeeBleConfig {
    private static NewBeeBleConfig blueToothGattConfig;
    private boolean autoConnect ;
    private int mtu=517;
    private int realMtu;
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
        this.serviceID=serviceID;
        this.writeID=writeID;
        this.noticeID=noticeID;
        this.bleDeviceList=bleDeviceList;
    }




    public void setRealMtu(int mtu) {
       this.realMtu=mtu;
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



//    public int getMtu() {
//        return mtu;
//    }


    public int getMtu() {
        return mtu;
    }

    public int getRealMtu() {
        if(realMtu==0){
            return mtu;
        }
        return realMtu;
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
            if(chechBleDeviceUseName(bleDevice,bleName)){
                return bleDevice;
            }

        }
        return null;
    }

    private boolean chechBleDeviceUseName(BleDeviceBean bleDevice,String bleName){
        if(!TextUtils.isEmpty(bleDevice.getDeviceTitle())&&bleName.contains(bleDevice.getDeviceTitle())){
            if(TextUtils.isEmpty(bleDevice.getDeviceBody())||bleName.contains(bleDevice.getDeviceBody())){
                //有名字只需要名字匹配即可,没有的话，后面也要匹配上
                bleDevice.setPairFuntionType(BlePairFuntionType.NAME);
                return true;
            }
        }
        return false;
    }

    private boolean chechBleDeviceUsetManufacturerSpecificData(BleDeviceBean bleDevice,ScanRecord record){
        if(!TextUtils.isEmpty(bleDevice.getManufacturerSpecificData())&&bleDevice.getManufacturerSpecificId()>0){
            byte[] manufacturerBytes= record.getManufacturerSpecificData(bleDevice.getManufacturerSpecificId());
            if(null!=manufacturerBytes&&manufacturerBytes.length>0){
                String manufacturerString= BleByteUtil.parseByte2HexStr(manufacturerBytes);
                if(!TextUtils.isEmpty(manufacturerString)&&manufacturerString.equals(bleDevice.getManufacturerSpecificData())){
                    bleDevice.setPairFuntionType(BlePairFuntionType.MANUFACTURER);
                    return true;
                }
            }
        }
        return false;
    }

    public BleDeviceBean checkBleScanRecord(ScanRecord record){

        if(null==record){
            return null;
        }
        String bleName=record.getDeviceName();
        if(TextUtils.isEmpty(bleName)){
            return null;
        }
        if(null==bleDeviceList||bleDeviceList.size()==0){
            return null;
        }
        for(BleDeviceBean bleDevice:bleDeviceList){
            if(chechBleDeviceUsetManufacturerSpecificData(bleDevice,record)){
                return bleDevice;
            }
            if(chechBleDeviceUseName(bleDevice,bleName)){
                return bleDevice;
            }
        }
        return null;
    }

//    public BleDeviceBean checkBleManufacturerString(String manufacturerString){
//        if(TextUtils.isEmpty(manufacturerString)){
//            return null;
//        }
//        if(null==bleDeviceList||bleDeviceList.size()==0){
//            return null;
//        }
//        for(BleDeviceBean bleDevice:bleDeviceList){
//            if(!TextUtils.isEmpty(bleDevice.getManufacturerSpecificData())&&manufacturerString.equals(manufacturerString)){
//                bleDevice.setPairFuntionType(BlePairFuntionType.MANUFACTURER);
//                return bleDevice;
//            }
//        }
//        return null;
//    }


}
