package com.nightssky.baiduforanr;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ANRService extends Service {
    public ANRService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("msg","====================");
        try {
            //模拟耗时操作
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);

    }
}
