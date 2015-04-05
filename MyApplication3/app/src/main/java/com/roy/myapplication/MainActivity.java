package com.roy.myapplication;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button) findViewById(R.id.okButton);
        b1.setOnTouchListener(this);
        Button b2 = (Button) findViewById(R.id.button2);
        b2.setOnTouchListener(this);
    }
    public void buttonClick(View v)
    {
        if(v.getId() == R.id.okButton) {
            //AlertDialog message = new AlertDialog.Builder(this).create();
            //message.setTitle("Hellow World!");
            //message.setMessage("Nice to meet you");
            //message.show();
            //Button button = (Button) v;
            //v.setBackgroundColor(Color.RED);
            //button.setText("I am clicked.");
        }
        else if(v.getId() == R.id.button2){
            //v.setBackgroundColor(Color.BLUE);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(v.getId() == R.id.okButton){
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    v.setBackgroundColor(Color.BLUE);
                    break;
                case MotionEvent.ACTION_UP:
                    v.setBackgroundColor(Color.RED);
            }
        }
        else if(v.getId() == R.id.button2)
        {
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    v.setBackgroundColor(Color.BLACK);
                    break;
                case MotionEvent.ACTION_UP:
                    v.setBackgroundColor(Color.RED);
                    break;
            }

        }
        return false;
    }
}
