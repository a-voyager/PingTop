package com.pingtop.android.views.fragments.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pingtop.android.R;
import com.pingtop.android.views.activities.WriteMessageActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityFragment extends Fragment implements View.OnClickListener {


    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.rv_community)
    RecyclerView mRvCommunity;

    public CommunityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_community, container, false);
        ButterKnife.bind(this, view);
        mFab.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:
                Intent intent = new Intent(getActivity(), WriteMessageActivity.class);
                getActivity().startActivity(intent);
                break;
        }
    }
}
