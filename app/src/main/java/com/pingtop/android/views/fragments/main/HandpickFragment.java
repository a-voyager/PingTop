package com.pingtop.android.views.fragments.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pingtop.android.R;
import com.pingtop.android.adapter.list.HandPickListAdapter;
import com.pingtop.android.entities.response.GudienceResponse;
import com.pingtop.android.manager.DataManager;
import com.pingtop.android.manager.HttpHelper;
import com.pingtop.android.utils.SnackBarUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;

/**
 * A simple {@link Fragment} subclass.
 */
public class HandpickFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.rv_hand_picks)
    RecyclerView mRvHandPicks;
    @BindView(R.id.refresh_hand_picks)
    SwipeRefreshLayout mRefreshHandPicks;
    private HttpHelper mHttpHelper;
    private long mLastTime;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_handpick, container, false);
        ButterKnife.bind(this, view);
        mRefreshHandPicks.setOnRefreshListener(this);
        mRvHandPicks.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvHandPicks.setAdapter(new HandPickListAdapter(getContext()));
//        SwipeRefreshLayout indicator does not appear when the setRefreshing(true) is called before the SwipeRefreshLayout.onMeasure()
//        http://stackoverflow.com/questions/26858692/swiperefreshlayout-setrefreshing-not-showing-indicator-initially
        mRefreshHandPicks.postDelayed(() -> {
            mRefreshHandPicks.setRefreshing(true);
            onRefresh();
        }, 500);
        return view;
    }


    @Override
    public void onRefresh() {
        if (mHttpHelper == null)
            mHttpHelper = DataManager.getHttpHelper();
        String token = DataManager.getPreferenceHelper(getContext()).getToken();
        long nowTime = System.currentTimeMillis();
        mHttpHelper.getHandPicks(token, mLastTime, nowTime, new Subscriber<List<GudienceResponse>>() {
            @Override
            public void onCompleted() {
                mRefreshHandPicks.setRefreshing(false);
                mLastTime = System.currentTimeMillis();
                SnackBarUtils.show(getActivity(), getActivity().getString(R.string.hand_pick_refresh_complete));
            }

            @Override
            public void onError(Throwable e) {
                mRefreshHandPicks.setRefreshing(false);
                SnackBarUtils.show(getActivity(), getActivity().getString(R.string.hand_pick_refresh_error));
                e.printStackTrace();
            }

            @Override
            public void onNext(List<GudienceResponse> gudienceResponses) {
                SnackBarUtils.show(getActivity(), gudienceResponses.toString());
                // TODO: 2016/8/1 插入新数据
            }
        });
    }
}
