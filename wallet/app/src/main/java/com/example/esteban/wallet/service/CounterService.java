package com.example.esteban.wallet.service;

import java.util.concurrent.atomic.AtomicInteger;


public class CounterService extends ICounterService.Stub {

    private static CounterService INSTANCE;

    public static CounterService getInstance() {
        if (INSTANCE == null) {
            synchronized (CounterService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CounterService();
                }
            }
        }

        return INSTANCE;
    }

    private AtomicInteger value = new AtomicInteger(0);

    public int incrementAndGet(){
        return value.incrementAndGet();
    }
}
