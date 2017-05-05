package com.example.x220.rslogger;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.rslogger.MESSAGE";

    int stresscount;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //don't touch
        super.onCreate(savedInstanceState); //don't touch
        setContentView(R.layout.activity_main); //don't touch
    }

    //tell program that there will be buttons in the appbar
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //create button in the appbar
    public boolean onOptionsItemSelected(MenuItem item) {
        //noinspection SimplifiableIfStatement
        int id = item.getItemId();
        if (id == R.id.action_help) {
            Intent help = new Intent(this, help.class); //reference activity
            startActivity(help); //start activity
        }
        return super.onOptionsItemSelected(item);
    }

    //what happens when you press the 'Add New' button
    public void addNew (View view) { //initialize
        Intent startAddNew = new Intent(this, addNewActivity.class); //reference activity
        startActivity(startAddNew); //start activity
    }

    //what happens when you press the 'Stats' button
    public void viewStats (View view) { //initialize
        String.valueOf(stresscount);
        Intent startStats = new Intent(this, statsView.class); //reference activity

        startActivity(startStats);
    }

    //what happens when you press the 'Stressed!' button
        public void stress(View view) { //initialize
            stresscount++; //add one to the amount of stress counted

            Context context = getApplicationContext(); //do it when button is pressed
            CharSequence text = "Stress logged "+stresscount+" times"; //message and show stresscount
            int duration = Toast.LENGTH_SHORT; //showtime of toast

            Toast toast = Toast.makeText(context, text, duration); //collect data
            toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0); //position
            toast.show(); //display
        }
    }