package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import org.w3c.dom.Text;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    // class variables
    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;


    private ImageView image_iv;

    private TextView origin_label_tv;
    private TextView origin_tv;

    private TextView also_know_label_tv;
    private TextView also_known_tv;
    private TextView ingredients_tv;
    private TextView description_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView ingredientsIv = findViewById(R.id.image_iv);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);

        String json = sandwiches[position];

//        Log.i(">>> TTT DetailActivity", String.valueOf(position) );
//        Log.i(">>> TTT DetailActivity", json );
//        Log.i(">>> TTT DetailActivity", json.getClass().getName() );

        // getting data from JsonUtils.java
        Sandwich sandwich = JsonUtils.parseSandwichJson(json);

        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        populateUI(sandwich);

        Picasso.with(this)
                .load(sandwich.getImage())
                .into(ingredientsIv);

        setTitle(sandwich.getMainName());

    } // onCreate

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI(Sandwich sandwich) {
        // COMPLETED: put code that will add Strings to activity_detail.xml

        image_iv = findViewById(R.id.image_iv);

        origin_tv = findViewById(R.id.origin_tv);
        origin_label_tv = findViewById(R.id.origin_label_tv);

        description_tv = findViewById(R.id.description_tv);
        ingredients_tv = findViewById(R.id.ingredients_tv);
        also_known_tv = findViewById(R.id.also_known_tv);

        if (sandwich.getPlaceOfOrigin().isEmpty()) {
//            origin_tv.setVisibility(View.INVISIBLE);
            origin_tv.setText("N/A");
        } else {
            origin_tv.setText(sandwich.getPlaceOfOrigin());
        }


        if (sandwich.getAlsoKnownAs().isEmpty()) {
            also_known_tv.setText("N/A");
        } else {
            List<String> alsoList = sandwich.getAlsoKnownAs();
            String alsoKnownAs = TextUtils.join(", ", alsoList);
            also_known_tv.setText(alsoKnownAs);
        }

        List<String> ingredientsList = sandwich.getIngredients();
        String ingredients = TextUtils.join(", ", ingredientsList);
        ingredients_tv.setText(ingredients);

        description_tv.setText(sandwich.getDescription());

    } // populateUI()

} // class
