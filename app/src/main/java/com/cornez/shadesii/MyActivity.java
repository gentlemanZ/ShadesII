package com.cornez.shadesii;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MyActivity extends Activity implements
        MyListFragment.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

    }

    @Override
    public void onColorItemSelected(String link) {

        // Need to check if Activity has been switched to landscape mode
        // If yes, finished and go back to the start Activity
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            InformationFragment infoFragment = new InformationFragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
        /*
        //A TWO PANE CONFIGURATION
        if (fragment2 != null && fragment2.isInLayout()) {
            fragment2.setText(link);
        }
        //A SINGLE-PANE CONFIGURATION -
        //  IF FRAGMENT 2 DOES NOT EXIST IN THIS LAYOUT, THEN ACTIVATE THE NEXT ACTIVITY
        else {
            Intent intent = new Intent (this, InformationActivity.class);
            intent.putExtra("Information", link);
            startActivity (intent);
        }*/

            transaction.replace(R.id.ReservedSlot,infoFragment);
            transaction.commit();
            fm.executePendingTransactions();
            infoFragment.setText(link);
        }else{
            Intent intent = new Intent (this, InformationActivity.class);
            intent.putExtra("Information", link);
            startActivity (intent);
        }


    }

    public void onAnimalItemSelected(String link){

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            AnimalFragment Animal = new AnimalFragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
        /*
        //CHECK IF FRAGMENT2 EXISTS IN THIS LAYOUT
        InformationFragment fragment2 = (InformationFragment) getFragmentManager()
                .findFragmentById(R.id.fragment2);

        //A TWO PANE CONFIGURATION
        if (fragment2 != null && fragment2.isInLayout()) {
            fragment2.setText(link);
        }
        //A SINGLE-PANE CONFIGURATION -
        //  IF FRAGMENT 2 DOES NOT EXIST IN THIS LAYOUT, THEN ACTIVATE THE NEXT ACTIVITY
        else {
            Intent intent = new Intent (this, InformationActivity.class);
            intent.putExtra("Information", link);
            startActivity (intent);
        }
        */
            transaction.replace(R.id.ReservedSlot,Animal);
            transaction.commit();
            fm.executePendingTransactions();
            Animal.setPictures(link);


        }else{
            Intent intent = new Intent (this, AnimalActivity.class);
            intent.putExtra("Animal", link);
            startActivity (intent);
        }

    }

}
