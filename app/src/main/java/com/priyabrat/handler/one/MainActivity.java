package com.priyabrat.handler.one;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Thread thread;
    private Handler handler;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        handler = new Handler();
    }

    public void startThread(View view) {
        thread = new Thread(new MyThread());
        thread.start();
    }


    public class MyThread implements Runnable {

        @Override
        public void run() {
            for (int i=0;i<100;i++){
                final int val = i;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(val+"");
                    }
                });

            }
        }
    }
}
