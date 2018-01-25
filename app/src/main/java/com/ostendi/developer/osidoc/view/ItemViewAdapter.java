package com.ostendi.developer.osidoc.view;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.ostendi.developer.osidoc.R;
import com.ostendi.developer.osidoc.model.Item;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jitendra on 24/01/2018.
 */

public class ItemViewAdapter extends RecyclerView.Adapter<ItemViewAdapter.ViewHolder> {
    private final List<Item> itemList;
    private String TAG = ItemViewAdapter.class.getSimpleName();

    private int counterOnCreateViewHolder = 0; //just for Test
    private int counterOnBindViewHolder = 0; //just for Test
    private ViewHolder viewholder;

    public ItemViewAdapter(List<Item> resultItem) {
        Log.e(TAG, "itemList : " + resultItem);
        this.itemList = resultItem;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e(TAG, "onCreateViewHolder called : " + ++counterOnCreateViewHolder);
        // Create a new View
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.line_view, parent, false);
        viewholder = new ViewHolder(layoutView);

        //in some cases, it will prevent unwanted situations
        viewholder.checkBox.setOnCheckedChangeListener(null);
        /**
         To reduce the unnecessary burden on onBindviewHolder( which may effect efficiency of scrolling ) we must use click listener on onCreateViewHolder
         setOnCheckedChangeListener():Register a callback to be invoked when the checked state of this button changes.
         compoundButton:A button with two states, checked and unchecked. When the button is pressed or clicked, the state changes automatically.
         */

        viewholder.checkBox.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (compoundButton.isChecked()) {
                viewholder.checkBox.setChecked(isChecked);
            }
        });
        return viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.e(TAG, "onBindViewHolder called " + ++counterOnBindViewHolder);
        holder.textView.setText(String.valueOf(itemList.get(position)));
    }

    @Override
    public int getItemCount() {
//         itemList.size();
        return 0;
    }

    //Live observed item list is set here which will be used to bind by the adapter to display on Ui
    public void setList(List<Item> list) {
        // this.itemList = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private int counterOnViewHolder = 0; //just for Test
        @BindView(R.id.line)
        TextView textView;

        @BindView(R.id.checkbox)
        CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            Log.e("TAG", "ViewHolder called" + ++counterOnViewHolder);
        }
    }

}
