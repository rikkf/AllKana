package com.codanimex.android.allkana.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codanimex.android.allkana.R;
import com.codanimex.android.allkana.learn.HiraganaTab;

/**
 * Created by Riccardo on 01/09/2017.
 */

public class HiraganaFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.hiragana_layout, container, false);
    }

}
