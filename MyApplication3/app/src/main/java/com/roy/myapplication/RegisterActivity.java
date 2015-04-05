package com.roy.myapplication;

import android.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegisterActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void Buttoncall(View v)
    {
        if(v.getId() == R.id.clearButton){
            EditText t1 = (EditText) findViewById(R.id.email);
            EditText t2 = (EditText) findViewById(R.id.username);
            EditText t3 = (EditText) findViewById(R.id.code);
            EditText t4 = (EditText) findViewById(R.id.code2);
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
        }
        else if(v.getId() == R.id.okButton){
            String titleStr = "";
            String Message = "";
            EditText t1 = (EditText) findViewById(R.id.email);
            EditText t2 = (EditText) findViewById(R.id.username);
            EditText t3 = (EditText) findViewById(R.id.code);
            EditText t4 = (EditText) findViewById(R.id.code2);
            String c1 = t3.getText().toString();
            String c2 = t4.getText().toString();
            String emailstr = t1.getText().toString();
            if(isValidEmail(emailstr) ==false){
                titleStr = "Error!";
                Message ="Email is not legitimate";
            }
            else if(c1.equals(c2) == false){
                titleStr = "Error!";
                Message = "The repeat code is not current!";
            }
            else{
                titleStr = "Succed!";
                Message = "Welcome :"+t2.getText().toString() +"!";
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
            }
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setMessage(Message);
            alertDialog.setTitle(titleStr);
            alertDialog.show();
        }

    }
    public boolean isValidEmail(String emailStr){
        String EMAIL_PATTERN = "^[_A-Za-z0-9\\+]+(\\.[A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(emailStr);

        return matcher.matches();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
