package com.codanimex.android.allkana.recyclerview_adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.codanimex.android.allkana.HiraganaViewActivity;
import com.codanimex.android.allkana.R;
import com.codanimex.android.allkana.database.Hiragana;

import java.util.List;

public class HiraganaAdapter extends RecyclerView.Adapter<HiraganaAdapter.ViewHolder> {
    private List<Hiragana> hiraganaDataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public HiraganaAdapter(List<Hiragana> myDataset) {
        hiraganaDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public HiraganaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        Button hiraganaButton = (Button) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_hiragana_item, parent, false);
        ViewHolder vh = new ViewHolder(hiraganaButton);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Long hiraganaID = hiraganaDataset.get(position).getId();
        holder.hiraganaButton.setText(hiraganaDataset.get(position).hiragana);
        holder.hiraganaButton.setContentDescription(String.valueOf(hiraganaDataset.get(position).getId()));
        holder.hiraganaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hiraganaViewIntent = new Intent(v.getContext(), HiraganaViewActivity.class);
                hiraganaViewIntent.putExtra("hiragana_id", hiraganaID);
                v.getContext().startActivity(hiraganaViewIntent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return hiraganaDataset.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public Button hiraganaButton;

        public ViewHolder(Button hiraganaButton) {
            super(hiraganaButton);
            this.hiraganaButton = hiraganaButton;
        }
    }
}