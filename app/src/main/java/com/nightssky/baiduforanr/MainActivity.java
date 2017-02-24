package com.nightssky.baiduforanr;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mainThread;
    private Button broadcast;
    private Button service;
    private ANRReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initRevicer();
    }
    //注册receiver
    private void initRevicer() {
        receiver=new ANRReceiver();
        IntentFilter filter=new IntentFilter();
        filter.addAction("android.intent.action.MY_BROADCAST");

        registerReceiver(receiver, filter);
    }

    private void initView() {
        mainThread = (Button) findViewById(R.id.mainThread);
        broadcast = (Button) findViewById(R.id.broadcast);
        service = (Button) findViewById(R.id.service);

        mainThread.setOnClickListener(this);
        broadcast.setOnClickListener(this);
        service.setOnClickListener(this);
    }

    /**
     *  默认情况下，在android中Activity的最长执行时间是5秒，
     *  BroadcastReceiver的最长执行时间则是10秒。
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mainThread:
                try {
                    //模拟耗时操作
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.broadcast:

                Intent reciver = new Intent("android.intent.action.MY_BROADCAST");
                reciver.putExtra("msg", "hello receiver.");
                sendBroadcast(reciver);
                break;
            case R.id.service:

                Intent intent = new Intent(this,ANRService.class);
                startService(intent);
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
