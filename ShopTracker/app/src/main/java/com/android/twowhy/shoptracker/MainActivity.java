package com.android.twowhy.shoptracker;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements View.OnTouchListener, View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private CoordinatorLayout mCoordinatorLayout;
    private ArrayList<Shop> mShops;
    private RecyclerView mTrackerRecommendRecyclerView;
    private TrackerRecommendAdapter mTrackerRecommendAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        mCoordinatorLayout.setOnTouchListener(this);
        mCoordinatorLayout.setOnClickListener(this);
        mShops = new ArrayList<>();
        setShops();
        mTrackerRecommendRecyclerView = (RecyclerView)
                findViewById(R.id.tracker_recommend_recycler_view);

        mTrackerRecommendRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        updateUI();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }

    private void setShops() {
        for (int i = 0; i < 20; i++) {
            Shop shop = new Shop();
            shop.setId(i);
            shop.setName("name " + i);
            mShops.add(shop);
        }
    }

    private void updateUI() {
        if (mTrackerRecommendAdapter == null) {
            mTrackerRecommendAdapter = new TrackerRecommendAdapter(mShops);
            mTrackerRecommendRecyclerView.setAdapter(mTrackerRecommendAdapter);
        } else {
            mTrackerRecommendAdapter.notifyDataSetChanged();
        }
    }

    private class TrackerRecommendAdapter extends RecyclerView.Adapter<TrackerRecommendViewHolder> {

        private ArrayList<Shop> mShops;

        public TrackerRecommendAdapter(ArrayList<Shop> shops) {
            mShops = shops;
        }

        @Override
        public TrackerRecommendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.list_item_tracker_recommend, parent, false);
            return new TrackerRecommendViewHolder(view);
        }

        @Override
        public void onBindViewHolder(TrackerRecommendViewHolder holder, int position) {
            holder.bindTrackerRecommend(mShops.get(position));
        }

        @Override
        public int getItemCount() {
            return mShops.size();
        }
    }

    private class TrackerRecommendViewHolder extends RecyclerView.ViewHolder {

        private Shop mShop;

        private TextView mTrackerRecommendShopNameTextView;

        public TrackerRecommendViewHolder(View itemView) {
            super(itemView);
            mTrackerRecommendShopNameTextView =
                    (TextView) itemView.findViewById(R.id.list_item_tracker_recommend_name);
        }

        public void bindTrackerRecommend(Shop shop) {
            mShop = shop;
            mTrackerRecommendShopNameTextView.setText(String.valueOf(mShop.getName()));
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TAG, "dispatchTouchEvent MotionEvent: getX(): " + ev.getX());
        Log.i(TAG, "dispatchTouchEvent MotionEvent: getY(): " + ev.getY());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.coordinator_layout:
                Log.i(TAG, "onTouch MotionEvent: getX(): " + event.getX());
                Log.i(TAG, "onTouch MotionEvent: getY(): " + event.getY());
                break;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.coordinator_layout:
                break;
        }
    }
}
