package com.wang.config;

import android.nfc.Tag;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 日志配置工具类
 * @author Administrator
 */
public class LogConfig {

    /**
     * 把日志写入文件
     * @param TAG
     * @param msg
     */
    public static void log2File(final String TAG, String msg){
        final String FILE_PATH = Environment.getExternalStorageDirectory().getPath() + "/stepAppLog.txt";
        File file = new File(FILE_PATH);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(TAG + ":" + msg);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
