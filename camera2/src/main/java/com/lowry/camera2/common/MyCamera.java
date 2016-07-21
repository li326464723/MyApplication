package com.lowry.camera2.common;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;

import com.lowry.camera2.MyApplication;
import com.lowry.camera2.common.util.log.ULog;

/**
 * Created by lowry on 16/6/29.
 */
public class MyCamera {
    public static MyCamera instance = null;
    private CameraManager myCameraManager = null;

    public static MyCamera getInstance(){
        if(instance == null){
            instance = new MyCamera();
        }
        return instance;
    }

    public MyCamera(){
        myCameraManager = (CameraManager) MyApplication.MY_APPLICATION_CONTEXT.getSystemService(MyApplication.MY_APPLICATION_CONTEXT.CAMERA_SERVICE);
    }

    public CameraCharacteristics getCameraCapabilities(String cameraID){
        try {
            return myCameraManager.getCameraCharacteristics(cameraID);
        } catch (CameraAccessException e) {
            ULog.i("lowry",e.getMessage());
            return null;
        }
    }

    public String[] getCameraIDList(){
        try {
            return myCameraManager.getCameraIdList();
        } catch (CameraAccessException e) {
            ULog.i("lowry",e.getMessage());
            return null;
        }
    }
}
