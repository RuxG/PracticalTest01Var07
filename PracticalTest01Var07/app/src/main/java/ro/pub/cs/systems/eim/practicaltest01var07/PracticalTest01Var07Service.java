package ro.pub.cs.systems.eim.practicaltest01var07;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

public class PracticalTest01Var07Service extends Service {
    Thread dedicatedThread;

    public PracticalTest01Var07Service() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Started Service", "onCreate() method was invoked");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("Started Service", "onBind() method was invoked");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("Started Service", "onUnbind() method was invoked");
        return true;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d("Started Service", "onRebind() method was invoked");
    }

    @Override
    public void onDestroy() {
        Log.d("Started Service", "onDestroy() method was invoked");

        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        dedicatedThread = new Thread(new Runnable() {
            @Override
            public void run() {

                Random rand = new Random();
                int val1, val2, val3, val4;

                while (true) {
                    val1 = rand.nextInt() % 10;
                    val2 = rand.nextInt() % 10;
                    val3 = rand.nextInt() % 10;
                    val4 = rand.nextInt() % 10;

                    Intent intent = new Intent();
                    intent.setAction("ro.pub.cs.systems.eim.practicaltest01var07");
                    intent.putExtra("row1col1", String.valueOf(val1));
                    intent.putExtra("row1col2", String.valueOf(val2));
                    intent.putExtra("row2col1", String.valueOf(val3));
                    intent.putExtra("row2col2", String.valueOf(val4));
                    sendBroadcast(intent);

                    try {
                        Thread.sleep(5000);
                    } catch (Exception e) {

                    }

                }
            }
        });
        dedicatedThread.start();
        return START_REDELIVER_INTENT;
    }
}