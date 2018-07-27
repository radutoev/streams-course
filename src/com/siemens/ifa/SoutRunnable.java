package com.siemens.ifa;

/**
 * Created by Radu Toev on 27.07.2018.
 */
public class SoutRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("another thread");
    }
}
