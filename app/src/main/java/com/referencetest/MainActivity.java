

package com.referencetest;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        A a = new A();

        ReferenceQueue<A> rq = new ReferenceQueue<A>();
        PhantomReference<A> prA = new PhantomReference<A>(a, rq);

        Log.d(TAG, "prA.get():" + prA.get());
        Log.d(TAG, "rq:item" + rq.poll());

        a = null;

        System.gc();

        try{
            Thread.sleep(1);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.d(TAG, "prA.get():" + prA.get());
        Log.d(TAG, "rq:item" + rq.poll());
    }
    class A {

    }


}
