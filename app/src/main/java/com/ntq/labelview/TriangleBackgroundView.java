package com.ntq.labelview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Tuan Nguyen Anh on 12/28/2015.
 * NTQ Solution JSC
 * tuan.nguyen.anh@ntq-solution.com.vn
 */
public class TriangleBackgroundView extends View {
    private Paint paint;
    private Paint paintText;
    float textSize;

    public TriangleBackgroundView(Context context) {
        super(context);
        init();
    }

    public TriangleBackgroundView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TriangleBackgroundView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        this.setBackgroundColor(Color.TRANSPARENT);

        paint = new Paint();
        paint.setStrokeWidth(1);
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(getResources().getColor(android.R.color.holo_green_dark));

        paintText = new Paint();
        textSize = getResources().getDimensionPixelSize(R.dimen.textSize);
        paintText.setTextSize(textSize);
        paintText.setStyle(Paint.Style.FILL);
        paintText.setColor(getResources().getColor(android.R.color.white));
        paintText.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int h = getMeasuredHeight();
        int w = getMeasuredWidth();

        Path path = new Path();
        path.moveTo(0, 0);
        path.lineTo(w, 0);
        path.lineTo(w, h);
        path.lineTo(0, 0);
        path.close();
        canvas.save();
        canvas.drawPath(path, paint);

        float x = w / 2 + 20;
        float y = h / 2 - 20;
        canvas.rotate(45, x, y);
        canvas.drawText("新 着", x, y, paintText);
        canvas.restore();
    }
}
