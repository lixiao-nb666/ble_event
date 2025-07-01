package com.nrmyw.ble_event_lib;

import android.graphics.Bitmap;

import com.nrmyw.ble_event_lib.type.BleSendBitmapQualityType;
import com.nrmyw.ble_event_lib.type.BleSendFileType;

import java.io.File;

public interface BleCmdSendListen {

        public void nowSendCmd(byte[] bytes);

        public void sendImage(Bitmap bitmap, BleSendBitmapQualityType qualityType);

        public void sendFile(File file, BleSendFileType fileType);
}