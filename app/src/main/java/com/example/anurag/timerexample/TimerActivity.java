package com.example.anurag.timerexample;

import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    //private TextView hour,minute,sec;
    //private int a=0,b=0,c=16;

    private int time = -15;

    private boolean pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        pause = false;

        //sec = findViewById(R.id.sec);
        //minute = findViewById(R.id.minute);
        //hour = findViewById(R.id.hour);

        final Handler handler = new Handler();
        final Handler handler1 = new Handler();


       /*handler1.postDelayed(new Runnable() {
            @Override
            public void run() {

                if(pause){
                    handler1.postDelayed(this, 1000);
                    return;
                }

                sec.setText(--c + "");

                if(c==0){

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(pause){
                                handler.postDelayed(this, 1000);
                                return;
                            }
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

        }, 1000); */

       final TextView min = findViewById(R.id.minute);

       handler.postDelayed(new Runnable() {
           @Override
           public void run() {

               if(pause){
                   handler.postDelayed(this, 1000);
                   return;
               }

               int t = time++;

               if(t == -3){
                   //BEEP...
                   ToneGenerator toneGen1 = new ToneGenerator(AudioManager.STREAM_MUSIC, 1000);
                   toneGen1.startTone(ToneGenerator.TONE_CDMA_EMERGENCY_RINGBACK,2000);
               }

               t = Math.abs(t);

               min.setText("" + ((t/3600)%24) + " : " + ((t/60) % 60) + " : " + (t%60)   );
               handler.postDelayed(this, 1000);


           }
       }, 1000);


       findViewById(R.id.base).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               pause = !pause;
           }
       });

    }

}
