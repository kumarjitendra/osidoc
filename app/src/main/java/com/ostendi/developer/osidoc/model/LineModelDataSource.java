package com.ostendi.developer.osidoc.model;

import android.os.AsyncTask;
import android.renderscript.Sampler;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jitendra on 24/01/2018.
 */

public class LineModelDataSource {
    private String TAG = LineModelDataSource.class.getSimpleName();
    private final static int ITEMS_PER_PAGE = 50;

    private List<LineModel> mLines;
    public LineModelDataSource() {

        mLines = new ArrayList<>();
        new getInformations().execute();
    }

    public LineModel get(int position) {
        return mLines.get(position);
    }

    private void getItems(int page) {
        // TODO

    }

    private class getInformations extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Add progress dialog here
            Log.e(TAG, "Page loading.. " );

        }

        @Override
        protected Void doInBackground(Void... voids) {
            HttpHandler httpHandler = new HttpHandler();
            String url = "https://vast-fjord-16773.herokuapp.com/getItems/2/10";
            // Making a request to url and getting response
            String jsonStr = httpHandler.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONArray jsonarray = new JSONArray(jsonStr);
                    for (int i = 0; i < jsonarray.length(); i++) {
                        JSONObject jsonobject = jsonarray.getJSONObject(i);
                        String label = jsonobject.getString("label");
                        Log.e(TAG, "jsonObj " +label);
                    }


                } catch (JSONException e) {
                    Log.e(TAG, "jsonException " );
                    e.printStackTrace();
                }

            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);


        }
    }



}