package com.lowry.camera2;

import android.hardware.camera2.CameraCharacteristics;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lowry.camera2.common.MyCamera;
import com.lowry.camera2.common.util.log.ULog;

public class MainActivity extends AppCompatActivity {
    private MyCamera myCamera = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myCamera = MyCamera.getInstance();
        String[] strs = myCamera.getCameraIDList();
        CameraCharacteristics cs = myCamera.getCameraCapabilities("0");
        if( cs.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)== CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY){}
        ULog.i("lowry","===========>>>" + cs.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL));

    }
}
