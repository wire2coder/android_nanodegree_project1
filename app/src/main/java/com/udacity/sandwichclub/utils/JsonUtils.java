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

    public static Sandwich parseSandwichJson(String json) {

        // TODO: https://jsonformatter.curiousconcept.com/
        // lesson 2, 21. quiz: parse JSON

        try {

            JSONObject sandwichRoot = new JSONObject(json);

            JSONObject nameInJson = sandwichRoot.getJSONObject("name");
            String mainName = nameInJson.getString("mainName");
//                Log.i(">>> name: ", name);

            JSONArray alsoKnownAs = nameInJson.getJSONArray("alsoKnownAs");

            List<String> alsoKnownAsList = new ArrayList<>();
            for (int i = 0; i < alsoKnownAs.length(); i++) {
                alsoKnownAsList.add(alsoKnownAs.optString(i));
//                Log.i(">>> alsoKnownAs: ", alsoKnownAs.optString(i) );
            }
//                Log.i(">>> alsoKnownAs: ", alsoKnownAsList.toString() );

            String placeOfOrigin = sandwichRoot.getString("placeOfOrigin");
//                Log.i(">>> placeOfOrigin: ", placeOfOrigin);

            String description = sandwichRoot.getString("description");
//                Log.i(">>> description: ", description);

            String image = sandwichRoot.getString("image");
//                Log.i(">>> image: ", image);

            JSONArray ingredients = sandwichRoot.getJSONArray("ingredients");

            List<String> ingredientsList = new ArrayList<>();

            for (int i = 0; i < ingredients.length(); i++) {

//                Log.i(">>> ingredients: ", ingredients.optString(i) );
                ingredientsList.add(ingredients.optString(i));

            }
//                Log.i(">>> ingredients: ", ingredientsList.toString() );


            sandwich = new Sandwich(mainName, alsoKnownAsList,
                    placeOfOrigin, description, image, ingredientsList);

//            Log.i(">>> Sandwich: ", sandwich.getMainName() );
//            Log.i(">>> Sandwich: ", sandWich.getAlsoKnownAs() );
//            Log.i(">>> Sandwich: ", sandwich.getPlaceOfOrigin() );
//            Log.i(">>> Sandwich: ", sandwich.getDescription() );
//            Log.i(">>> Sandwich: ", sandwich.getImage() );
//            Log.i(">>> Sandwich: ", sandWich.getIngredients() );


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;
    }

}
