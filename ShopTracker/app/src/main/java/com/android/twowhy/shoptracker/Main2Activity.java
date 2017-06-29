package com.android.twowhy.shoptracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.android.twowhy.shoptracker.view.custom.ShopAttributeView;

public class Main2Activity extends AppCompatActivity {

    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mLinearLayout = (LinearLayout) findViewById(R.id.activity_main2);
        ShopAttributeView shopAttributeView1 = new ShopAttributeView(getApplicationContext(), null,
                "test1", false);
        ShopAttributeView shopAttributeView2 = new ShopAttributeView(getApplicationContext(), null,
                "test2", true);

        mLinearLayout.addView(shopAttributeView1);
        mLinearLayout.addView(shopAttributeView2);
    }
}
