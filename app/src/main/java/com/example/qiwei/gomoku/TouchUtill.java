package com.example.qiwei.gomoku;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;

/**
 * Created by qiwei on 2016/3/6.
 */
public class TouchUtill {

    public  static Point getPointByTouch(MotionEvent event ,int fistCellX ,int fistCellY ,int cellWidth,
                                         int cellNum){
        float x = event.getX() - fistCellX + cellWidth / 2;
        float y = event.getY() - fistCellY + cellWidth / 2;
        int col  = (int)((x + cellWidth / 2) /cellWidth);
        int row =  (int)((y + cellWidth / 2)) /cellWidth;
        if(col < 0 || col > cellNum  || row < 0 || row > cellNum){
            return null;
        }
        return new Point(col,row);
    }
}
