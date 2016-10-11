package com.cornez.shadesii;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class AnimalActivity extends Activity {
    ArrayList<Drawable> drawables;
    public static final String EXTRA_URL = "url";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Need to check if Activity has been switched to landscape mode
        // If yes, finished and go back to the start Activity
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        setContentView(R.layout.animal_fragment);

        //SHOW THE UP BUTTON IN THE ACTION BAR
        getActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String AnimalValue = intent.getStringExtra("Animal");


        ImageView AnimalImage0 = (ImageView) findViewById(R.id.AnimalImage0);
        getDrawables();
        Log.i("Log",AnimalValue);
        if (AnimalValue.equals("11")){
            AnimalImage0.setImageDrawable(drawables.get(0));
        }else if (AnimalValue.equals("12")){
            AnimalImage0.setImageDrawable(drawables.get(1));
        }else if (AnimalValue.equals("13")){
            AnimalImage0.setImageDrawable(drawables.get(2));
        }
    }

    public void getDrawables() {
        Field[] drawablesFields = com.cornez.shadesii.R.drawable.class.getFields();
        drawables = new ArrayList<>();

        String fieldName;
        for (Field field : drawablesFields) {
            try {
                fieldName = field.getName();
                Log.i("LOG_TAG", "com.cornez.shadesii.R.drawable." + fieldName);
                drawables.add(getResources().getDrawable(field.getInt(null)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
