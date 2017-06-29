package com.android.twowhy.shoptracker;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private CoordinatorLayout mCoordinatorLayout;
    private ArrayList<ShopInfo> mShopInfos;
    private RecyclerView mShopRecommendRecyclerView;
    private ShopRecommendAdapter mShopRecommendAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        mCoordinatorLayout.setOnClickListener(this);
        mShopInfos = new ArrayList<>();
        mShopRecommendRecyclerView = (RecyclerView) findViewById(R.id.shop_recommend_recycler_view);
        mShopRecommendRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        updateUI();
        setShops();
    }

    private void setShops() {
        for (int i = 0; i < 20; i++) {
            ShopInfo shopInfo = new ShopInfo();
            shopInfo.setId(i);
            shopInfo.setName("name " + i);
            mShopInfos.add(shopInfo);
        }
        updateUI();
    }

    private void updateUI() {
        if (mShopRecommendAdapter == null) {
            mShopRecommendAdapter = new ShopRecommendAdapter(mShopInfos);
            mShopRecommendRecyclerView.setAdapter(mShopRecommendAdapter);
        } else {
            mShopRecommendAdapter.notifyDataSetChanged();
        }
    }

    private class ShopRecommendAdapter extends RecyclerView.Adapter<TrackerRecommendViewHolder> {

        private ArrayList<ShopInfo> mShopInfos;

        public ShopRecommendAdapter(ArrayList<ShopInfo> shopInfos) {
            mShopInfos = shopInfos;
        }

        @Override
        public TrackerRecommendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.list_item_shop_recommend, parent, false);
            return new TrackerRecommendViewHolder(view);
        }

        @Override
        public void onBindViewHolder(TrackerRecommendViewHolder holder, int position) {
            holder.bindTrackerRecommend(mShopInfos.get(position));
        }

        @Override
        public int getItemCount() {
            return mShopInfos.size();
        }
    }

    private class TrackerRecommendViewHolder extends RecyclerView.ViewHolder {

        private ShopInfo mShopInfo;

        private TextView mShopRecommendShopNameTextView;

        public TrackerRecommendViewHolder(View itemView) {
            super(itemView);
            mShopRecommendShopNameTextView =
                    (TextView) itemView.findViewById(R.id.list_item_shop_recommend_name);
        }

        public void bindTrackerRecommend(ShopInfo shopInfo) {
            mShopInfo = shopInfo;
            mShopRecommendShopNameTextView.setText(String.valueOf(mShopInfo.getName()));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.coordinator_layout:
                break;
        }
    }
}
