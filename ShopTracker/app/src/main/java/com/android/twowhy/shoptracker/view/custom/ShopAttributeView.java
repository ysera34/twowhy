package com.android.twowhy.shoptracker.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

import com.android.twowhy.shoptracker.R;

/**
 * Created by yoon on 2017. 6. 30..
 */

public class ShopAttributeView extends TextView {

    private ShopAttributeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ShopAttributeView(Context context, AttributeSet attrs, String attributeName, boolean hasAttribute) {
        this(context, attrs);
        mAttributeName = attributeName;
        mHasAttribute = hasAttribute;
        initializeView();
    }

    private String mAttributeName;
    private boolean mHasAttribute;

    private void initializeView() {
        setText(String.valueOf(mAttributeName));
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
        setPadding(getPixelFromDp(4), getPixelFromDp(2), getPixelFromDp(4), getPixelFromDp(2));
        if (mHasAttribute) {
            setTextColor(getResources().getColor(R.color.colorPinkA400));
            setBackgroundResource(R.drawable.widget_oval_rectangle_shop_attribute_true);
        } else {
            setTextColor(getResources().getColor(R.color.colorGray400));
            setBackgroundResource(R.drawable.widget_oval_rectangle_shop_attribute_false);
        }
    }

    private int getPixelFromDp(int dp) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
