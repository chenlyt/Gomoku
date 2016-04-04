package com.example.qiwei.gomoku;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2016/4/4 0004.
 */
public class MusicService extends Service {

    private MediaPlayer mMediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if(mMediaPlayer != null){
            mMediaPlayer = MediaPlayer.create(this,R.raw.backmusic);
            mMediaPlayer.setLooping(true);
            mMediaPlayer.start();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMediaPlayer.stop();
    }
}
