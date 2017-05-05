package com.example.x220.rslogger;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class addNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
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
            Intent help = new Intent(this, addNewHelp2.class); //reference activity
            startActivity(help); //start activity
        }
        return super.onOptionsItemSelected(item);
    }

    //what happens when you press the 'ADD' button
    public void saveActivity(View view) { //initialize
        Intent homeScreen = new Intent(this, MainActivity.class); //reference activity
        startActivity(homeScreen); //start activity
        Context context = getApplicationContext(); //do it when button is pressed
        CharSequence text = "Activity added!"; //message
        int duration = Toast.LENGTH_SHORT; //showtime of toast

        Toast toast = Toast.makeText(context, text, duration); //collect data for the sandwich
        toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0); //position
        toast.show(); //display sandwich
    }

    //what happens when you press the 'Select activity' button
    public void selectActivity(View view) { //initialize
        Intent selectActivity = new Intent(this, selectActivity.class); //reference activity
        startActivity(selectActivity); //start activity
    }

    //what happens when you press the 'duration' button
    public void addDuration(View view) { //initialize
        Intent addDuration = new Intent(this, addDuration.class); //reference activity
        startActivity(addDuration); //start activity
    }
}
