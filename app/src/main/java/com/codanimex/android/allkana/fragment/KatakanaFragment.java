package com.codanimex.android.allkana.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codanimex.android.allkana.R;

/**
 * Created by Riccardo on 01/09/2017.
 */

public class KatakanaFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.katakana_layout, container, false);
    }
}
