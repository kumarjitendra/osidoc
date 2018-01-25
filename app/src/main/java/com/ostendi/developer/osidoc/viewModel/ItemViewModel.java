package com.ostendi.developer.osidoc.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.ostendi.developer.osidoc.model.Item;
import com.ostendi.developer.osidoc.model.ItemDataSource;

import java.util.List;

public class ItemViewModel extends ViewModel {
    //LiveData:Data holder class that keeps a value(here Item) and allows this value to be observed
    public LiveData<List<Item>> liveListOfItem;
    private ItemDataSource itemDataSource;

    public ItemViewModel() {
        observeLivedata();
    }

    private void observeLivedata() {
        liveListOfItem = null; // need to add observed livedata from ItemDataSource .now application crash because it is null
    }

    //Expose data to observe by Activity and display on UI
    public LiveData<List<Item>> getLiveData() {
        return liveListOfItem;
    }
}
