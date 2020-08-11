package com.example.weather2.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.weather2.R;

public class PollutionView extends View {
    private int pollutionRank;
    public PollutionView(Context context) {
        super(context);
    }

    public PollutionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.pollutionRank);
        this.pollutionRank = ta.getIndex(R.styleable.pollutionRank_rankValue);
        ta.recycle();
    }

    public PollutionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PollutionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }
}
