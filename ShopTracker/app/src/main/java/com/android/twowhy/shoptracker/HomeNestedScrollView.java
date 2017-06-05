package com.android.twowhy.shoptracker;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by yoon on 2017. 6. 5..
 */

public class HomeNestedScrollView extends NestedScrollView {

    private HomeNestedScrollChangedListener mNestedScrollChangedListener;
    private boolean isScrollable = true;

    public HomeNestedScrollView(Context context) {
        super(context);
    }

    public HomeNestedScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HomeNestedScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public boolean isScrollable() {
        return isScrollable;
    }

    @Override
    public boolean isNestedScrollingEnabled() {
        return super.isNestedScrollingEnabled();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if ((!isScrollable))
            return false;
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        if (mNestedScrollChangedListener != null) {
            mNestedScrollChangedListener.onNestedScrollChanged(this, l, t, oldl, oldt);
        }
        super.onScrollChanged(l, t, oldl, oldt);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction() & 0xFF) {
            default:
                return super.onTouchEvent(ev);
            case 0:
        }
        if (isScrollable)
            return super.onTouchEvent(ev);
        return isScrollable;
    }

    public void setOnScrollChangedListener(HomeNestedScrollChangedListener nestedScrollChangedListener) {
        mNestedScrollChangedListener = nestedScrollChangedListener;
    }

    @Override
    public void setNestedScrollingEnabled(boolean enabled) {
        isScrollable = enabled;
//        super.setNestedScrollingEnabled(enabled);
    }

    public static abstract interface HomeNestedScrollChangedListener {

        public abstract void onNestedScrollChanged(
                NestedScrollView nestedScrollView, int l, int t, int oldl, int oldt);
    }
}
