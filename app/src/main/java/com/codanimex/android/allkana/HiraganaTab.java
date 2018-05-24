package com.codanimex.android.allkana;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codanimex.android.allkana.database.Hiragana;
import com.codanimex.android.allkana.recyclerview_adapters.HiraganaAdapter;

import java.util.List;


/**
 * Created by Riccardo on 04/09/2017.
 */

public class HiraganaTab extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiragana_tab);
        getIntent();
        mRecyclerView = findViewById(R.id.hiraganaRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this, 5);
        mRecyclerView.setLayoutManager(mLayoutManager);
        List<Hiragana> hiragana = Hiragana.listAll(Hiragana.class);
        mAdapter = new HiraganaAdapter(hiragana);
        mRecyclerView.setAdapter(mAdapter);
    }

}
