package com.pingtop.android.views.fragments.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.pingtop.android.R;
import com.pingtop.android.adapter.list.ZoneListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZoneFragment extends Fragment {
    // TODO: 修改为需要传递进来的参数键
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @OnClick(R.id.ll_me)
    void onClick(View view) {
        mListener.clickZoneAvatar(view);
    }

    @BindView(R.id.lv_zone)
    ListView mLvZone;

    // TODO: 重命名为传进来的参数成员变量
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ZoneFragment() {
        // Required empty public constructor
    }

    // TODO: 重命名参数
    public static ZoneFragment newInstance(String param1, String param2) {
        ZoneFragment fragment = new ZoneFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zone, container, false);
        ButterKnife.bind(this, view);
        initViews();
        return view;
    }

    private void initViews() {
        mLvZone.setAdapter(new ZoneListAdapter(getActivity()));
        mLvZone.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        mListener.clickZoneFavorite();
                        break;
                    case 1:
                        mListener.clickZoneRoute();
                        break;
                    case 2:
                        mListener.clickZoneMessage();
                        break;
                }
            }
        });
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * 与Activity交互的接口
     */
    public interface OnFragmentInteractionListener {
        void clickZoneAvatar(View v);

        void clickZoneFavorite();

        void clickZoneRoute();

        void clickZoneMessage();
    }
}
