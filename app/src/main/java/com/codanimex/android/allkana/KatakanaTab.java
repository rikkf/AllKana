package com.codanimex.android.allkana;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codanimex.android.allkana.database.Katakana;
import com.codanimex.android.allkana.recyclerview_adapters.KatakanaAdapter;

import java.util.List;

/**
 * Created by Riccardo on 04/09/2017.
 */

public class KatakanaTab extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katakana_tab);
        getIntent();
        mRecyclerView = findViewById(R.id.katakanaRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this, 5);
        mRecyclerView.setLayoutManager(mLayoutManager);
        List<Katakana> katakana = Katakana.listAll(Katakana.class);
        mAdapter = new KatakanaAdapter(katakana);
        mRecyclerView.setAdapter(mAdapter);
    }
}
