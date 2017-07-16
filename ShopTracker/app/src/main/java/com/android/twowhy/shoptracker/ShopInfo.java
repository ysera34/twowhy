package com.android.twowhy.shoptracker;

import android.util.SparseArray;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by yoon on 2017. 6. 3..
 */

public class ShopInfo {

    private int mId;
    private String mName;
    private String mAddress;
    private String mDistrictName1;
    private String mDistrictName2;
    private String mDistrictName3;
    private SparseArray<String> mAddresses;
    private float mRatingValue;
    private int mLikeValue;
    private ArrayList<Boolean> mAttributes;

    public ShopInfo() {

        mAddresses = new SparseArray<>();

        Random random = new Random();
        mAttributes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            mAttributes.add(random.nextInt(10) % 2 == 0);
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

    public String getAddress() {
        return mAddresses.get(0, mAddress);
//        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
        mAddresses.put(0, mAddress);
    }

    public String getDistrictName1() {
        return mAddresses.get(1, mDistrictName1);
//        return mDistrictName1;
    }

    public void setDistrictName1(String districtName1) {
        mDistrictName1 = districtName1;
        mAddresses.put(1, mDistrictName1);
    }

    public String getDistrictName2() {
        return mAddresses.get(2, mDistrictName2);
//        return mDistrictName2;
    }

    public void setDistrictName2(String districtName2) {
        mDistrictName2 = districtName2;
        mAddresses.put(2, mDistrictName2);
    }

    public String getDistrictName3() {
        return mAddresses.get(3, mDistrictName3);
//        return mDistrictName3;
    }

    public void setDistrictName3(String districtName3) {
        mDistrictName3 = districtName3;
        mAddresses.put(3, mDistrictName3);
    }

    public SparseArray<String> getAddresses() {
        return mAddresses;
    }

    public void setAddresses(SparseArray<String> addresses) {
        mAddresses = addresses;
    }

    public float getRatingValue() {
        return mRatingValue;
    }

    public void setRatingValue(float ratingValue) {
        mRatingValue = ratingValue;
    }

    public int getLikeValue() {
        return mLikeValue;
    }

    public void setLikeValue(int likeValue) {
        mLikeValue = likeValue;
    }

    public ArrayList<Boolean> getAttributes() {
        return mAttributes;
    }

    public void setAttributes(ArrayList<Boolean> attributes) {
        mAttributes = attributes;
    }
}
