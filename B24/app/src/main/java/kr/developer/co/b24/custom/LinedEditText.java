package kr.developer.co.b24.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import kr.developer.co.b24.R;

public class LinedEditText extends android.support.v7.widget.AppCompatEditText{
    private Rect mRect;
    private Paint mPaint;

    public LinedEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        mRect = new Rect();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        }

    @Override
    protected void onDraw(Canvas canvas) {
        int height = getHeight();
        int line_height = getLineHeight();

        int count = 4;

        if (getLineCount() > count)
            count = getLineCount();

        Rect r = mRect;
        Paint paint = mPaint;
        int baseline = getLineBounds(0, r);

        for (int i = 0; i < count; i++) {

            canvas.drawLine(r.left, baseline + 4, r.right, baseline + 4, paint);
            baseline += getLineHeight();
        }
        super.onDraw(canvas);

    }

}
