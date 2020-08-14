package com.example.weather2.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RotateDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.weather2.R;
import com.example.weather2.util.DensityUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PollutionView extends LinearLayout {
    @BindView(R.id.float_triangle)
    TextView floatTriangle;
    @BindView(R.id.linear_root)
    LinearLayout linearRoot;

    public void setPollutionRank(int pollutionRank) {
        this.pollutionRank = pollutionRank;
    }

    private int pollutionRank=0;
    Context mContext;

    public PollutionView(Context context) {
        super(context);
         init(context);
    }

    public PollutionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.pollutionRank);
            this.pollutionRank = ta.getInt(R.styleable.pollutionRank_rankValue,0);
            ta.recycle();
            Log.i("PollutionView","pollutionRank:"+pollutionRank);
        }
        init(context);
    }

    public PollutionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.pollutionRank);
            this.pollutionRank = ta.getInt(R.styleable.pollutionRank_rankValue,0);
            ta.recycle();
            Log.i("PollutionView","pollutionRank:"+pollutionRank);
        }

        init(context);
    }


    private void init(Context context) {
        mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.layout_pollution, this, true);
        ButterKnife.bind(view);

        // if()
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();

        Log.i("PollutionView","onFinishInflate childCount----------"+childCount);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        //int rootViewWidth = linearRoot.getMeasuredWidth();
        Log.i("PollutionView","onMeasure childCount----------"+childCount);
        int rootViewWidth = getChildAt(0).getMeasuredWidth();
        Log.i("PollutionView","linearRoot rootViewWidth:"+rootViewWidth);


        int colorResource = R.color.pollutionColor1;
        int index=0;
        if(pollutionRank>=0 && pollutionRank<=50){
            index=0;
            colorResource = R.color.pollutionColor1;
        }else if(pollutionRank>=51 && pollutionRank<=100){
            index=1;
            colorResource = R.color.pollutionColor2;
        }else if(pollutionRank>=101 && pollutionRank<=150){
            index=2;
            colorResource = R.color.pollutionColor3;
        }else if(pollutionRank>=151 && pollutionRank<=200){
            index=3;
            colorResource = R.color.pollutionColor4;
        }else if(pollutionRank>=201 && pollutionRank<=300){
            index=4;
            colorResource = R.color.pollutionColor5;
        }else if(pollutionRank>=301){
            index=5;
            colorResource = R.color.pollutionColor6;
        }
        float x = rootViewWidth/6/2 - DensityUtil.dip2px(mContext,16)/2;

        floatTriangle.setX(x+index*rootViewWidth/6);
        LayerDrawable layerDrawable = (LayerDrawable) floatTriangle.getBackground();
        RotateDrawable rotateDrawable = (RotateDrawable) layerDrawable.getDrawable(0);
        GradientDrawable gradientDrawable = (GradientDrawable) rotateDrawable.getDrawable();
        gradientDrawable.setColor(mContext.getResources().getColor(colorResource));
    }


}
