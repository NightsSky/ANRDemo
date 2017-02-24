package com.nightssky.baiduforanr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ANRReceiver extends BroadcastReceiver {
    public ANRReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        // an Intent broadcast.
        Log.d("msg","receiver=====");
        try {
            //模拟耗时操作
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
