package com.example.qiwei.test;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private SoundPool pool;
    private int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);

       i =  pool.load(this,R.raw.putt,1);
        findViewById(R.id.sss).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(i,1,1,0,1,1);
            }
        });
    }
}
