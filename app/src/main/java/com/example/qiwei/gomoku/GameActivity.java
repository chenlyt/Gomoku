package com.example.qiwei.gomoku;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by qiwei on 2016/2/28.
 */
public class GameActivity extends AppCompatActivity{

    public final static int MUSIC_PUT = 1;
    private SoundPool pool;
    private int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        pool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        i =  pool.load(this,R.raw.putt,1);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            pool.play(i, 1, 1, 0, 0, 1);
        }
        return super.onTouchEvent(event);

    }
}
