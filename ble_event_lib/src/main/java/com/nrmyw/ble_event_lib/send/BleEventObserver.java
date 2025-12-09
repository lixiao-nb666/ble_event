package com.nrmyw.ble_event_lib.send;//package com.newbee.ble_lib.event.send;



import com.nrmyw.ble_event_lib.bean.BleSendFileInfoBean;
import com.nrmyw.ble_event_lib.bean.BleSendImageInfoBean;



/**
 * Created by lixiao on 2017/5/12.
 * about:
 */

public interface BleEventObserver {

    //获取权限初始化蓝牙
    public void havePermissionInitBle();

    //扫描并连接蓝牙
    public void startSearchBle();

    //断开蓝牙
    public void disconnectedBle();

    //发送字节指令
    public  void sendCmd(byte[] bytes);

    //发送图标的开始和结束指令，线程自动处理的时候有回调
    public void sendBytesIndexCmd(int index,byte[] bytes);

    //发送图标
    public void sendImage(BleSendImageInfoBean sendImageInfoBean);


    //发送文件
    public void sendFile(BleSendFileInfoBean sendFileInfoBean);
}
