package com.codanimex.android.allkana.recyclerview_adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.codanimex.android.allkana.KatakanaViewActivity;
import com.codanimex.android.allkana.R;
import com.codanimex.android.allkana.database.Katakana;

import java.util.List;

public class KatakanaAdapter extends RecyclerView.Adapter<KatakanaAdapter.ViewHolder> {

    private List<Katakana> katakanaDataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public KatakanaAdapter(List<Katakana> myDataset) {
        katakanaDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public KatakanaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        Button katakanaButton = (Button) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_katakana_item, parent, false);
        ViewHolder vh = new ViewHolder(katakanaButton);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Long katakanaID = katakanaDataset.get(position).getId();
        holder.katakanaButton.setText(katakanaDataset.get(position).katakana);
        holder.katakanaButton.setContentDescription(String.valueOf(katakanaDataset.get(position).getId()));
        holder.katakanaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent katakanaViewIntent = new Intent(v.getContext(), KatakanaViewActivity.class);
                katakanaViewIntent.putExtra("katakana_id", katakanaID);
                v.getContext().startActivity(katakanaViewIntent);
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return katakanaDataset.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public Button katakanaButton;

        public ViewHolder(Button katakanaButton) {
            super(katakanaButton);
            this.katakanaButton = katakanaButton;
        }
    }
}