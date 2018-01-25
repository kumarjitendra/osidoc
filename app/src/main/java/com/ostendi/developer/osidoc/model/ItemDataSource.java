package com.ostendi.developer.osidoc.model;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jitendra on 24/01/2018.
 */

public class ItemDataSource {
    private String TAG = ItemDataSource.class.getSimpleName();

    private final static int ITEMS_PER_PAGE = 50;
    private List<Item> resultItem = new ArrayList<>();

    public ItemDataSource() {
        new getInformationsFromServer().execute();
    }

    public void setResultItem(List<Item> resultItem) {
        Log.e(TAG, "setResultItem is : " + resultItem);
        //Log details till here is correct
        // setResultItem is  [Line 200, Line 201, Line 202, Line 203, Line 204, Line 205, Line 206,...]
        resultItem.addAll(resultItem);
    }

    public List<Item> getresultItem() {
        Log.e(TAG, "getresultItem " + resultItem);
        // Here log : [] (empty array). I have used this method in MainActivity class to pass the parameter in ItemViewAdapter to display on UI
        return resultItem;
    }

    //start thread to retrieve page from server
    private class getInformationsFromServer extends AsyncTask<Void, Void, List<Item>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Add progress dialog here
            Log.e(TAG, "Page loading.. ");

        }

        @Override
        protected List<Item> doInBackground(Void... Void) {
            HttpHandler httpHandler = new HttpHandler();
            String url = "https://vast-fjord-16773.herokuapp.com/getItems/5/50";
            // Making a request to url and getting response
            String jsonStr = httpHandler.makeServiceCall(url);
            Log.e(TAG, "Response from url: " + jsonStr);

            List<Item> listForReceivedItemFromServer = new ArrayList<>();
            if (jsonStr != null) {
                try {
                    JSONArray jsonarray = new JSONArray(jsonStr);
                    for (int i = 0; i < jsonarray.length(); i++) {
                        JSONObject jsonobject = jsonarray.getJSONObject(i);
                        String receivedLabelFromServer = jsonobject.getString("label");
                        Log.e(TAG, "jsonObj " + receivedLabelFromServer);
                        Item item = new Item(receivedLabelFromServer);
                        listForReceivedItemFromServer.add(item);
                    }

                } catch (JSONException e) {
                    Log.e(TAG, "jsonException ");
                    e.printStackTrace();
                }

            }
            return listForReceivedItemFromServer;
        }

        @Override
        protected void onPostExecute(List<Item> result) {
            super.onPostExecute(result);
            Log.e(TAG, "onPostExecute " + result);
            setResultItem(result);

        }
    }

    /**
     * public Item get(int position) {
     return null;
     }
     private void getItems(int page) {
     // TODO
     }
     */
}