package com.example.weather2.common;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.weather2.util.DensityUtil;

public class RecyclerGridDivider extends RecyclerView.ItemDecoration{
    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        float dp8 = DensityUtil.dip2px(view.getContext(),8.0f);
        int valueDp8 = (int)dp8;
        outRect.set(valueDp8,0,valueDp8,valueDp8);
    }
}
