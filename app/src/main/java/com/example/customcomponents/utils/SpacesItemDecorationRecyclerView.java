package com.example.customcomponents.utils;


import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class SpacesItemDecorationRecyclerView extends RecyclerView.ItemDecoration {

    private int space;

    public SpacesItemDecorationRecyclerView(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;
        outRect.top = space;

    }
}

