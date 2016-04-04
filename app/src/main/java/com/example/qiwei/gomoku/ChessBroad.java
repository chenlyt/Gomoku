package com.example.qiwei.gomoku;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiwei on 2016/2/28.
 */
public class ChessBroad extends ImageView{

    private Paint mPaint;
    private final  int mPadding = getDimensFromeRes(R.dimen.broad_marge);
    private final  int mCellNum = 14;
    private int mLineLength;
    private int mCellLength;
    private int mFistCellX;
    private int mFistCellY;

    private List<ChessPieces> mPiecesList = new ArrayList<>();
    public ChessBroad(Context context) {
        this(context,null);
    }

    public ChessBroad(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChessBroad(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(getDimensFromeRes(R.dimen.broad_line_width));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawChessBroad(canvas);
    }
    private void drawChessBroad(Canvas canvas){
        int cellLength = getmCellLength();
        int fistCellX = getmFistCellX();
        int fistCellY = getmFistCellY();

        mPaint.setAlpha(200);
        //画线
        for(int i = 0; i <15;i++){
            int startX = fistCellX + i * cellLength;
            int startY = fistCellY;
            int endX = startX;
            int endY = fistCellY + mCellNum * cellLength;
            canvas.drawLine(startX,startY,endX,endY,mPaint);
        }

        for (int i = 0; i < 15; i++){
            int startX = fistCellX;
            int startY = fistCellY + i * cellLength;
            int endX = startX + mCellNum * cellLength;
            int endY = startY;
            canvas.drawLine(startX,startY,endX,endY,mPaint);
        }
        //画圆点
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        for(int i = 0 ;i < 4; i++){
            int x = fistCellX + 3 * cellLength;
            int y = fistCellY + 3 * cellLength;
            int distance =  8 * cellLength;
            int row = i % 2;
            int col = i / 2;
            canvas.drawCircle(x + row * distance,y + col * distance ,getDimensFromeRes(R.dimen.circle__radiu),mPaint);
        }

        canvas.drawCircle(fistCellX +  mCellNum  * cellLength / 2,
                fistCellY + mCellNum * cellLength / 2,getDimensFromeRes(R.dimen.circle__radiu),mPaint);

        //画棋子
        drawPieces(canvas);
    }

    private int getDimensFromeRes(int id){
        return getContext().getResources().getDimensionPixelOffset(id);
    }

    private void drawPieces(Canvas canvas){

        Paint paint = new Paint();
        for (ChessPieces pieces : mPiecesList){
            int x = pieces.getmPointX();
            int y = pieces.getmPointY();
            int radiu = pieces.getmPiecesRadiu();
            Rect rect = new Rect( x, y, x + radiu * 4, y + radiu * 4);
            canvas.drawBitmap(pieces.getPiecesBitmap() ,null ,rect ,paint);
        }
    }

    public int getmLineLength() {
        if(mLineLength == 0) {
            int width = getMeasuredWidth();
            int height = getMeasuredHeight();
            int padding = (int) getContext().getResources().getDisplayMetrics().density * mPadding;
            mLineLength = Math.min(width, height) - padding * 2;
        }
        return mLineLength;
    }

    public int getmCellLength() {
        if(mCellLength == 0){
            mCellLength =  getmLineLength() /mCellNum;
        }
        return mCellLength;
    }

    public int getmFistCellX() {
        if(mFistCellX == 0){
            mFistCellX = (getMeasuredWidth() - getmLineLength()) /2;
        }
        return mFistCellX;
    }

    public int getmFistCellY() {
        if(mFistCellY == 0){
            mFistCellY = (getMeasuredHeight() - getmLineLength()) /2;
        }
        return mFistCellY;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int fistCellX = getmFistCellX();
        int fistCellY = getmFistCellY();
        int cellWidth = getmCellLength();
        Point point = TouchUtill.getPointByTouch(event, fistCellX, fistCellY,
                getmCellLength(), mCellNum);

        if(point != null){
            int x = fistCellX + point.x * cellWidth - cellWidth / 2;
            int y = fistCellY + point.y * cellWidth - cellWidth / 2;
            ChessPieces pieces = new ChessPieces(getContext(),x,y);
            pieces.setmIsWhite(true);
            pieces.setmPiecesRadiu(cellWidth / 4);
            mPiecesList.add(pieces);
            invalidate();
        }
        return super.onTouchEvent(event);
    }
}
