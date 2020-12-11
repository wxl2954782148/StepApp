package com.wang.frame;

import android.app.Activity;
import android.app.Application;
import android.os.Process;

import com.wang.execptionHandle.ErrorHandler;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wxl
 */
public class FrameApplication extends Application {
    public static Set<Activity> activities = new HashSet<>();

    /**
     * 获取返回栈中的Activity
     *
     * @return
     */
    public static Set<Activity> getActivities() {
        return activities;
    }

    /**
     * 添加Activity到List中
     *
     * @param activity
     */
    public static void addActivity(Activity activity) {
        if (activity != null) {
            activities.add(activity);
        }
    }

    /**
     * 移除Activity
     *
     * @param activity
     */
    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /**
     * 移除所有Activity
     */
    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    /**
     * 完全退出程序
     */
    public static void exitApp(){
        try {
            finishAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.exit(0);
            android.os.Process.killProcess(Process.myPid());
        }
    }

    private  ErrorHandler errorHandler;
    @Override
    public void onCreate() {
        super.onCreate();
        errorHandler = ErrorHandler.getInstance();
    }
}
