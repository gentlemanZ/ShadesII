package com.cornez.shadesii;


import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.lang.reflect.Field;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalFragment extends Fragment {

    ArrayList<Drawable> drawables;
    private ImageView AnimalImage0;

    public AnimalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Resources resources = getResources();
        View view = inflater.inflate(R.layout.animal_fragment, container, false);
        AnimalImage0 = (ImageView) view.findViewById(R.id.AnimalImage0);
        return view;
    }

    public void setPictures(String item){
        getDrawables();
        if (item.equals("11")){
            AnimalImage0.setImageDrawable(drawables.get(0));
        }else if (item.equals("12")){
            AnimalImage0.setImageDrawable(drawables.get(1));
        }else if (item.equals("13")){
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
