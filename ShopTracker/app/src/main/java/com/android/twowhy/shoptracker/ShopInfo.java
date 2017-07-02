package com.android.twowhy.shoptracker;

import java.util.ArrayList;

/**
 * Created by yoon on 2017. 6. 3..
 */

public class ShopInfo {

    private int mId;
    private String mName;
    private ArrayList<Boolean> mAttributes;

    public ShopInfo() {
        mAttributes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            mAttributes.add(i % 2 == 0);
        }
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public ArrayList<Boolean> getAttributes() {
        return mAttributes;
    }

    public void setAttributes(ArrayList<Boolean> attributes) {
        mAttributes = attributes;
    }
}
