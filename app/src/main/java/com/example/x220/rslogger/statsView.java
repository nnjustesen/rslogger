package com.example.x220.rslogger;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import static com.example.x220.rslogger.R.integer.stresscount;

public class statsView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_view);

        TextView displayCount = (TextView)findViewById(R.id.counter);
        displayCount.setText(stresscount+"");

// draw graph
        GraphView graph = (GraphView) findViewById(R.id.graph);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 60),
                new DataPoint(1, 30),
                new DataPoint(2, 100),
                new DataPoint(3, 90),
                new DataPoint(4, 60),
                new DataPoint(5, 30),
                new DataPoint(6, 100),
                new DataPoint(7, 90),
                new DataPoint(8, 120)
        });
        graph.addSeries(series);

// styling
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/9, (int) Math.abs(data.getY()*255/12), 100);
            }
        });

        series.setSpacing(5);

// draw values on top
        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.RED);
//series.setValuesOnTopSize(50);
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
            Intent help = new Intent(this, statsViewHelp5.class); //reference activity
            startActivity(help); //start activity
        }
        return super.onOptionsItemSelected(item);
    }

}
