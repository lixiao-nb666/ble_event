package com.nrmyw.ble_event_lib.send;//package com.newbee.ble_lib.event.send;


import android.graphics.Bitmap;
import android.util.Log;


import com.nrmyw.ble_event_lib.bean.BleSendFileInfoBean;
import com.nrmyw.ble_event_lib.bean.BleSendImageInfoBean;
import com.nrmyw.ble_event_lib.bean.BleSendOtaInfoBean;
import com.nrmyw.ble_event_lib.type.BleSendBitmapQualityType;

import java.util.ArrayList;
import java.util.List;


public class BleEventSubscriptionSubject implements BleEventSubject {

    private List<BleEventObserver> observers;
    private static BleEventSubscriptionSubject subscriptionSubject;

    private BleEventSubscriptionSubject() {
        observers = new ArrayList<>();
    }

    public static BleEventSubscriptionSubject getInstance() {
        if (subscriptionSubject == null) {
            synchronized (BleEventSubscriptionSubject.class) {
                if (subscriptionSubject == null)
                    subscriptionSubject = new BleEventSubscriptionSubject();
            }
        }
        return subscriptionSubject;

    }

    @Override
    public void attach(BleEventObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(BleEventObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void havePermissionInitBle() {
        for (BleEventObserver observer:observers){
            observer.havePermissionInitBle();
        }
    }

    @Override
    public void startSearchBle() {
        for (BleEventObserver observer:observers){
            observer.startSearchBle();
        }
    }

    @Override
    public void disconnectedBle() {
        for (BleEventObserver observer:observers){
            observer.disconnectedBle();
        }
    }

    @Override
    public void sendCmd(byte[] bytes) {
        for (BleEventObserver observer:observers){
            observer.sendCmd(bytes);
        }
    }

    @Override
    public void sendBytesIndexCmd(int index, byte[] bytes) {
        for (BleEventObserver observer:observers){
            observer.sendBytesIndexCmd(index,bytes);
        }
    }

    @Override
    public void sendImage(BleSendImageInfoBean sendImageInfoBean) {
        for (BleEventObserver observer:observers){

            observer.sendImage(sendImageInfoBean);
        }
    }

    @Override
    public void sendFile(BleSendFileInfoBean sendFileInfoBean) {
        for (BleEventObserver observer:observers){

            observer.sendFile(sendFileInfoBean);
        }
    }

    @Override
    public void sendOta(BleSendOtaInfoBean sendOtaInfoBean) {
        for (BleEventObserver observer:observers){
            observer.sendOta(sendOtaInfoBean);
        }
    }


}
