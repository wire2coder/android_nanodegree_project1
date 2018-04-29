package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static Sandwich sandwich;

    private static List<String> alsoKnownAsList = new ArrayList<>();
    private static List<String> ingredientsList = new ArrayList<>();

    public static Sandwich parseSandwichJson(String json) {

        // TODO: https://jsonformatter.curiousconcept.com/
        // lesson 2, 21. quiz: parse JSON

        try {

            JSONObject sandwichRoot = new JSONObject(json);

            JSONObject nameInJson = sandwichRoot.getJSONObject("name");
            String mainName = nameInJson.getString("mainName");
//                Log.i(">>> name: ", name);

            JSONArray alsoKnownAs = nameInJson.getJSONArray("alsoKnownAs");

            makeListString(alsoKnownAs, alsoKnownAsList);
//                Log.i(">>> alsoKnownAs: ", alsoKnownAsList.toString() );

            String placeOfOrigin = sandwichRoot.getString("placeOfOrigin");
//                Log.i(">>> placeOfOrigin: ", placeOfOrigin);

            String description = sandwichRoot.getString("description");
//                Log.i(">>> description: ", description);

            String image = sandwichRoot.getString("image");
//                Log.i(">>> image: ", image);

            JSONArray ingredients = sandwichRoot.getJSONArray("ingredients");

            makeListString(ingredients, ingredientsList);
            Log.i(">>> ingredients: ", ingredientsList.toString());

            sandwich = new Sandwich(mainName, alsoKnownAsList,
                    placeOfOrigin, description, image, ingredientsList);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;

    } // parseSandwichJson

    // this class method is converting JSONArray into STRING LIST
    private static void makeListString(JSONArray jsonArray, List<String> list) {

        for (int i = 0; i < jsonArray.length(); i++) {
            list.add(jsonArray.optString(i));
        }

    }

} // class
