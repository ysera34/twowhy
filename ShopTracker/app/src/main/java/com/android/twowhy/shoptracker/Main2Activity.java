package com.android.twowhy.shoptracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.android.twowhy.shoptracker.view.custom.ShopAttributeLayout;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private LinearLayout mLinearLayout;
    private RecyclerView mShopVicinityRecyclerView;
    private ShopVicinityAdapter mShopVicinityAdapter;
    private ArrayList<ShopInfo> mShopInfos;

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


        mShopVicinityRecyclerView = (RecyclerView) findViewById(R.id.shop_vicinity_recycler_view);
        mShopVicinityRecyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));

        setShopInfos();

        updateRecyclerView();
    }

    private void setShopInfos() {
        mShopInfos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ShopInfo shopInfo = new ShopInfo();
            mShopInfos.add(shopInfo);
        }
    }

    private void updateRecyclerView() {
        if (mShopVicinityAdapter == null) {
            mShopVicinityAdapter = new ShopVicinityAdapter(mShopInfos);
            mShopVicinityRecyclerView.setAdapter(mShopVicinityAdapter);
        } else {
            mShopVicinityAdapter.notifyDataSetChanged();
        }
    }

    private class ShopVicinityAdapter extends RecyclerView.Adapter<ShopVicinityHolder> {

        private ArrayList<ShopInfo> mShopInfos;

        public ShopVicinityAdapter(ArrayList<ShopInfo> shopInfos) {
            mShopInfos = shopInfos;
        }

        @Override
        public ShopVicinityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
            View view = layoutInflater.inflate(R.layout.list_item_shop_vicinity, parent, false);
            return new ShopVicinityHolder(view);
        }

        @Override
        public void onBindViewHolder(ShopVicinityHolder holder, int position) {
            holder.bindShopVicinity(mShopInfos.get(position));
        }

        @Override
        public int getItemCount() {
            return mShopInfos.size();
        }
    }

    private class ShopVicinityHolder extends RecyclerView.ViewHolder {

        private ShopInfo mShopInfo;
        private ShopAttributeLayout mShopAttributeLayout;

        public ShopVicinityHolder(View itemView) {
            super(itemView);
        }

        public void bindShopVicinity(ShopInfo shopInfo) {
            mShopInfo = shopInfo;
            mShopAttributeLayout = new ShopAttributeLayout(
                    getApplicationContext(), null, mShopInfo.getAttributes());
        }
    }
}
