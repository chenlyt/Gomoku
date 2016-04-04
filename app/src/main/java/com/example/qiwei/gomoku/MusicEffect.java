package com.example.qiwei.gomoku;

import android.content.Context;
import android.media.SoundPool;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by qiwei on 2016/3/13.
 */
public class MusicEffect extends SoundPool{

    private HashMap<Integer,Integer> mSoundMap = new HashMap<>();
    /**
     * Constructor. Constructs a SoundPool object with the following
     * characteristics:
     *
     * @param maxStreams the maximum number of simultaneous streams for this
     *                   SoundPool object
     * @param streamType the audio stream type as described in AudioManager
     *                   For example, game applications will normally use
     *                   {@link AudioManager#STREAM_MUSIC}.
     * @param srcQuality the sample-rate converter quality. Currently has no
     *                   effect. Use 0 for the default.
     * @return a SoundPool object, or null if creation failed
     * @deprecated use {@link Builder} instead to create and configure a
     * SoundPool instance
     */
    public MusicEffect(int maxStreams, int streamType, int srcQuality) {
        super(maxStreams, streamType, srcQuality);
    }

    public void loadSound(Context context,int res,int tag){
        int soundId = load(context,res,1);
        mSoundMap.put(tag, soundId);
        Log.i("123","----------" + soundId);
    }

    public void playSound(int id,int loop){
        Log.i("123","++++++++++" + mSoundMap.get(id));
        play(mSoundMap.get(id), 1, 1, 0, loop, 1);
    }
}
