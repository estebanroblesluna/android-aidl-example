package com.example.esteban.wallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.esteban.wallet.service.CounterService;
import com.example.esteban.wallet.service.CounterServiceProvider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) this.findViewById(R.id.counter);
        textView.setText(Integer.valueOf(CounterService.getInstance().incrementAndGet()).toString());
    }
}
