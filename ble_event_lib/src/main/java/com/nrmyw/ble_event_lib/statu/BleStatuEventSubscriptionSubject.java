package com.nrmyw.ble_event_lib.statu;



import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class BleStatuEventSubscriptionSubject implements BleStatuEventSubject {

    private List<BleStatuEventObserver> observers;
    private static BleStatuEventSubscriptionSubject subscriptionSubject;

    private BleStatuEventSubscriptionSubject() {
        observers = new ArrayList<>();
    }

    public static BleStatuEventSubscriptionSubject getInstance() {
        if (subscriptionSubject == null) {
            synchronized (BleStatuEventSubscriptionSubject.class) {
                if (subscriptionSubject == null)
                    subscriptionSubject = new BleStatuEventSubscriptionSubject();
            }
        }
        return subscriptionSubject;

    }

    @Override
    public void attach(BleStatuEventObserver observer) {
        observers.add(observer);
        Log.d("","sendBleStatu:attach"+"----"+observer);
    }

    @Override
    public void detach(BleStatuEventObserver observer) {
        observers.remove(observer);
        Log.d("","sendBleStatu:detach"+"----"+observer);
    }

    @Override
    public void sendBleStatu(BleStatu bleStatu, Object... objects) {
        for (BleStatuEventObserver observer:observers){

            Log.d("","sendBleStatu:"+bleStatu+"----"+observer);
            observer.sendBleStatu(bleStatu,objects);
        }
    }


}
