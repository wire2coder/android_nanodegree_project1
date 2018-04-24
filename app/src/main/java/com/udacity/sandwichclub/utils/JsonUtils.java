package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        // TODO: 'implement' parseSandwichJson(String json)
        // lesson 2, 21. quiz: parse JSON
        // you have STRING coming in
        // 1. Convert STRING to JSON
        // 2. PARSE the JSON into different 'parts'

//        Log.i(">>> parseSandwichJson", json );

        try {
            JSONObject sandwichData = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

//        Log.i(">>> parseSandwichJson", sandwichData );
        // TODO: HERE 4/24

        return null;
    }

}
