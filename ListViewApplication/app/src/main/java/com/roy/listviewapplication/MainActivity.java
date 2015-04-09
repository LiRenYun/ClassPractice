package com.roy.listviewapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity{
    ListView listView;
    ListAdapter listAdapter;
    private final Integer[] fruitPictures = {
            R.drawable.bulbasaur,R.drawable.ivysaur,R.drawable.venusaur,
            R.drawable.charmander,R.drawable.charmeleon,R.drawable.charizard,
            R.drawable.squirtle,   R.drawable.wartortle , R.drawable.blastoise
    };
    final String[] fruits = {
            "妙蛙種子", "妙蛙草", "妙蛙花", "小火龍", "火恐龍",
            "噴火龍","傑尼龜", "卡咪龜", "水箭龜" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById (R.id.listView);
        listAdapter = new ListAdapter(this,fruitPictures,fruits);
        listView.setAdapter(listAdapter);


        /*ListView listView = (ListView) findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, fruits);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);*/

    }
    /*@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this.getApplicationContext(),"Click : "+position+" item",Toast.LENGTH_SHORT).show();

    }*/


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
}
