package com.android.twowhy.shoptracker.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.android.twowhy.shoptracker.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yoon on 2017. 6. 30..
 */

public class ShopAttributeLayout extends LinearLayout {

    public ShopAttributeLayout(Context context) {
        super(context);
    }

    public ShopAttributeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ShopAttributeLayout(Context context, AttributeSet attrs, ArrayList<Boolean> shopAttributes) {
        this(context, attrs);
        mShopAttributes = shopAttributes;
        initializeView(context);
    }

    private ArrayList<Boolean> mShopAttributes;
    private ArrayList<String> mShopAttributeNames;

    private void initializeView(Context context) {
        if (mShopAttributeNames == null) {
            mShopAttributeNames = initializeAttributes();
        }

        int childViewSize = Math.min(mShopAttributes.size(), mShopAttributeNames.size());
        for (int i = 0; i < childViewSize; i++) {
            ShopAttributeView shopAttributeView = new ShopAttributeView(context, null,
                    mShopAttributeNames.get(i), mShopAttributes.get(i));
            addView(shopAttributeView);
            if (i != childViewSize - 1) {
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) shopAttributeView.getLayoutParams();
                params.setMargins(0, 0, getPixelFromDp(6), 0);
                shopAttributeView.setLayoutParams(params);
            }
        }
    }

    public ArrayList<String> getShopAttributeNames() {
        return mShopAttributeNames;
    }

    public void setShopAttributeNames(ArrayList<String> shopAttributeNames) {
        mShopAttributeNames = shopAttributeNames;
    }

    private ArrayList<String> initializeAttributes() {
        String[] shopAttributes = getResources().getStringArray(R.array.shop_attributes);
        return new ArrayList<>(Arrays.asList(shopAttributes));
    }

    private int getPixelFromDp(int dp) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
