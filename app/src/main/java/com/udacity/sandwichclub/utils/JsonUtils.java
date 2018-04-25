package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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
//            Log.i(">>> ::: ", sandwichData.toString() );

            JSONObject nameInJson = sandwichData.getJSONObject("name");

            String name = nameInJson.getString("mainName");
//            Log.i(">>> ___ ", name);

            ArrayList<String> ls1 = new ArrayList<>();
            ls1.add("a");
            ls1.add("b");
            ls1.add("c");

//        Log.i(">>> ___ ", ls1.toString() );

            // TODO: HERE 4/25 make a Sandwich objects
            Sandwich sandWich = new Sandwich(name, ls1, "origin", "des", "imag", ls1);
            Log.i(">>> ___ ", sandWich.getMainName() );


        } catch (JSONException e) {
            e.printStackTrace();
        }

        /*
        public Sandwich(
                String mainName,
                List<String> alsoKnownAs,
                String placeOfOrigin,
                String description,
                String image,
                List<String> ingredients)
        */




        return null;
    }

}
