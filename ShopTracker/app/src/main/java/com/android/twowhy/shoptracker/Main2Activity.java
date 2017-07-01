package com.android.twowhy.shoptracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.android.twowhy.shoptracker.view.custom.ShopAttributeLayout;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mLinearLayout = (LinearLayout) findViewById(R.id.activity_main2);
//        ShopAttributeView shopAttributeView1 = new ShopAttributeView(getApplicationContext(), null,
//                "test1", false);
//        ShopAttributeView shopAttributeView2 = new ShopAttributeView(getApplicationContext(), null,
//                "test2", true);
//
//        mLinearLayout.addView(shopAttributeView1);
//        mLinearLayout.addView(shopAttributeView2);


        ArrayList<Boolean> attributes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            attributes.add(i % 2 == 0);
        }
        ShopAttributeLayout shopAttributeLayout =
                new ShopAttributeLayout(getApplicationContext(), null, attributes);
        mLinearLayout.addView(shopAttributeLayout);
    }
}
