package com.android.twowhy.shoptracker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by yoon on 2017. 6. 5..
 */

public class HomeActivity extends AppCompatActivity {

    private TextView mHomeContentTextView;
    private RelativeLayout mHomeActionButtonLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mHomeContentTextView = (TextView) findViewById(R.id.home_content_text_view);
        mHomeActionButtonLayout = (RelativeLayout) findViewById(R.id.home_action_button_layout);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 70; i++) {
            sb.append("home_content_text_view");
        }
        mHomeContentTextView.setText(sb.toString());
    }


}
