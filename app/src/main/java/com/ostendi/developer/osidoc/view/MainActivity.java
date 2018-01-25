package com.ostendi.developer.osidoc.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ostendi.developer.osidoc.R;
import com.ostendi.developer.osidoc.model.LineModel;
import com.ostendi.developer.osidoc.model.LineModelDataSource;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    public RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("ee", "MainActivity called " );
        ButterKnife.bind(this);
        LineModelDataSource lineModelDataSource = new LineModelDataSource();

        List<LineModel> newLine = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            LineModel listofLine = new LineModel("Line " + i);
            newLine.add(listofLine);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(false);


        PageViewAdapter pageViewAdapter = new PageViewAdapter(newLine);
        recyclerView.setAdapter(pageViewAdapter);
    }
}
