package com.example.esteban.wallet.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

public class CounterServiceProvider extends Service {

    public CounterServiceProvider() {
        super();
        Log.i("aaa","bbb");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return CounterService.getInstance();
    }
}
