package com.example.qiwei.gomoku;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by qiwei on 2016/3/6.
 */
public class ChessPieces {
    private boolean mIsWhite;
    private int mPointX;
    private int mPointY;
    private Bitmap mBlackPieces;
    private Bitmap mWhitePieces;
    private int mPiecesRadiu;
    private Context mContext;

    public ChessPieces(Context context,int x,int y){
        mContext = context;
        mPointX = x;
        mPointY = y;
        init();
    }
    private void init(){
        mBlackPieces = BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.blackchess);
        mWhitePieces = BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.whitechess);
    }

    public Bitmap getPiecesBitmap(){
        return mIsWhite ? mWhitePieces : mBlackPieces;
    }

    public int getmPiecesRadiu() {
        return mPiecesRadiu;
    }

    public void setmPiecesRadiu(int mPiecesRadiu) {
        this.mPiecesRadiu = mPiecesRadiu;
    }

    public int getmPointX() {
        return mPointX;
    }

    public int getmPointY() {
        return mPointY;
    }

    public boolean ismIsWhite() {
        return mIsWhite;
    }

    public void setmIsWhite(boolean mIsWhite) {
        this.mIsWhite = mIsWhite;
    }
}
