package com.example.esteban.client2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.esteban.wallet.service.ICounterService;

public class MainActivity extends AppCompatActivity {

    private ICounterService counterService;

    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            counterService = ICounterService.Stub.asInterface(service);
            incrementAndUpdate();
        }

        public void onServiceDisconnected(ComponentName className) {
            counterService = null;
        }
    };

    private void incrementAndUpdate() {
        try {
            TextView textView = (TextView) findViewById(R.id.counter);
            textView.setText(Integer.valueOf(counterService.incrementAndGet()).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        incrementAndUpdate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent()
                .setComponent(new ComponentName(
                        "com.example.esteban.wallet",
                        "com.example.esteban.wallet.service.CounterServiceProvider"));

        boolean d2 = bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }
}
