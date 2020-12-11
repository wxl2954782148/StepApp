package com.wang;

import android.os.Bundle;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wang.frame.FrameApplication;

/**
 * @author Administrator
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameApplication.addActivity(this);
    }

    /**
     * 初始化View
     */
    protected abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FrameApplication.removeActivity(this);
    }
}
