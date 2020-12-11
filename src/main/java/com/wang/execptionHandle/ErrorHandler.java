package com.wang.execptionHandle;

import android.content.Context;

import androidx.annotation.NonNull;

import com.wang.config.LogConfig;

/**
 * 未捕获异常处理类
 * @author Administrator
 */
public class ErrorHandler implements Thread.UncaughtExceptionHandler{
    private static final String TAG = "ErrorHandler";
    private static ErrorHandler instance;
    @Override
    public void uncaughtException(@NonNull Thread t, @NonNull Throwable e) {
        LogConfig.log2File(TAG,e.getMessage());
    }
    private ErrorHandler(){
        instance = new ErrorHandler();
    }
    public static ErrorHandler getInstance(){
        if (instance == null){
            instance = new ErrorHandler();
        }
        return instance;
    }

    /**
     * 设置异常处理器
     * @param context
     */
    public void setErrorHandler(Context context){
        Thread.setDefaultUncaughtExceptionHandler(this);
    }
}
