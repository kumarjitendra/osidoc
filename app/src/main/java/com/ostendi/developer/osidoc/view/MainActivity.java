package com.ostendi.developer.osidoc.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.ostendi.developer.osidoc.R;
import com.ostendi.developer.osidoc.model.Item;
import com.ostendi.developer.osidoc.model.ItemDataSource;
import com.ostendi.developer.osidoc.viewModel.ItemViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    public RecyclerView recyclerView;
    private ItemViewModel itemViewModel;
    private ItemViewAdapter itemViewAdapter;
    private ItemDataSource itemDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(false);
        recyclerView.setAdapter(itemViewAdapter);

        itemDataSource = new ItemDataSource(); // this is just to test the datasource functionality
        List<Item> listitem = itemDataSource.getresultItem();
        Log.e("", "listitem : " + listitem);
        itemViewAdapter = new ItemViewAdapter(listitem);


        // Below commentedcode is for Live Data

        // itemViewModel = new ItemViewModel();
        /**
         * itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
         //Live item is observed here by the instance of itemViewModel
         itemViewModel.getLiveData().observe(this, new Observer<List<Item>>() {
        @Override public void onChanged(@Nullable List<Item> itemModels) {
        itemViewAdapter.setList(itemModels);
        }
        });
         */

    }
}
