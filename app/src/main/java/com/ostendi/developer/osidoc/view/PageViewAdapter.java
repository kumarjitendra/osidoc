package com.ostendi.developer.osidoc.view;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.ostendi.developer.osidoc.R;
import com.ostendi.developer.osidoc.model.LineModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jitendra on 24/01/2018.
 */

public class PageViewAdapter extends RecyclerView.Adapter<PageViewAdapter.ViewHolder> {
    private String TAG = PageViewAdapter.class.getSimpleName();
    List<LineModel> lineModelList;
    ViewHolder viewholder;

    public PageViewAdapter(List<LineModel> newLine) {
       this.lineModelList=newLine;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e(TAG, "onCreateViewHolder called : ");
        // Create a new View
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.line_view, parent, false);
        viewholder = new ViewHolder(layoutView);
         //in some cases, it will prevent unwanted situations
        viewholder.checkBox.setOnCheckedChangeListener(null);

        //setOnCheckedChangeListener():Register a callback to be invoked when the checked state of this button changes.
        //compoundButton:A button with two states, checked and unchecked. When the button is pressed or clicked, the state changes automatically.
        viewholder.checkBox.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (compoundButton.isChecked()) {
                viewholder.checkBox.setChecked(isChecked);
            }

        });

        return viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.e(TAG, "onBindViewHolder called ");
        holder.textView.setText( String.valueOf(lineModelList.get(position)));
    }

    @Override
    public int getItemCount() {
        return lineModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.line)
        TextView textView;

        @BindView(R.id.checkbox)
        CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            Log.e("fd", "ViewHolder called");
        }
    }

}
