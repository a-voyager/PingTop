package com.pingtop.android.views.fragments.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pingtop.android.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HandpickFragment extends Fragment {


    public HandpickFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_handpick, container, false);
    }

}
