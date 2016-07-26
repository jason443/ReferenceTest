/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.referencetest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Created by Jason on 2016/7/26.
 */
public class TestActivity extends Activity{

    private MyHandler mMyHandler = new MyHandler(this);

    private static class MyHandler extends Handler {
        private WeakReference<TestActivity> activityWeakReference;

        public MyHandler(TestActivity activity) {
            this.activityWeakReference = new WeakReference<TestActivity>(activity);
        }

        public void handleMessage(Message msg) {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //...
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                Message message1 = Message.obtain();
                Message message2 = mMyHandler.obtainMessage();
                message.what = 1;
                mMyHandler.sendMessage(message);
            }
        }).start();
    }
}
