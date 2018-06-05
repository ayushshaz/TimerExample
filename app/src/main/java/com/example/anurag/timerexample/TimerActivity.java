package com.example.anurag.timerexample;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    private TextView hour,minute,sec;
    private int a=0,b=0,c=15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        sec = findViewById(R.id.sec);
        minute = findViewById(R.id.minute);
        hour = findViewById(R.id.hour);

        final Handler handler = new Handler();
        final Handler handler1 = new Handler();


       handler1.postDelayed(new Runnable() {
            @Override
            public void run() {

                sec.setText(--c + "");

                if(c==0){

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            sec.setText(++c + "");
                            if(c==60)
                            {

                                minute.setText(++b + "");
                                if(b==60){
                                    hour.setText(++a + "");
                                    b-=60;

                                }
                                c-=60;

                            }
                            handler.postDelayed(this, 1000);
                        }
                    }, 1000);



                }
                else{

                    handler1.postDelayed(this, 1000);
                }
            }


        }, 1000);









    }
}
