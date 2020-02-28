package com.stornit.e_commerceapp.others;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    private int SpanCount;
    private int Spacing;
    private boolean IncludeEdge;

    public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
        SpanCount = spanCount;
        Spacing = spacing;
        IncludeEdge = includeEdge;
    }

    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view); // item position
        int column = position % SpanCount; // item column

        if (IncludeEdge) {
            outRect.left = Spacing - column * Spacing / SpanCount;
            outRect.right = (column + 1) * Spacing / SpanCount;
            if (position < SpanCount) {
                outRect.top = Spacing;
            }
            outRect.bottom = Spacing;
        } else {
            outRect.left = column * Spacing / SpanCount;
            outRect.right = Spacing - (column + 1) * Spacing / SpanCount;
            if (position >= SpanCount)
                outRect.top = Spacing;
        }
    }
}
