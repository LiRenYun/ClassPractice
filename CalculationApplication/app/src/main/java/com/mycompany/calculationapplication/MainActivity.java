package com.mycompany.calculationapplication;

import android.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calculation(View v){
        AlertDialog message = new AlertDialog.Builder(this).create();
        message.setTitle("錯誤");
        message.setMessage("有一數字為空的");

        EditText n1 = (EditText) findViewById(R.id.number1);
        EditText n2 = (EditText) findViewById(R.id.number2);
        TextView result = (TextView) findViewById(R.id.resultuse);
        String n1s = n1.getText().toString();
        String n2s = n2.getText().toString();
        if(v.getId() == R.id.clearuse){
            n1.setText("");
            n2.setText("");
            result.setText("Result:");
        }
        else if(v.getId() == R.id.closeuse){
            System.exit(0);
        }
        else if(n1s.equals("") == true || n2s.equals("") == true){
            message.show();
        }
        else if(isNumber(n1s) ==false || isNumber(n2s) == false){
            message.setMessage("輸入錯誤數字");
            message.show();
        }
        else if(v.getId() == R.id.add){
            double answer = Double.valueOf(n1s)+Double.valueOf(n2s);
            result.setText("Result:"+answer);
        }
        else if(v.getId() == R.id.reduce){
                double answer = Double.valueOf(n1s)-Double.valueOf(n2s);
                result.setText("Result:"+answer);
        }
        else if(v.getId() == R.id.multiply){
            double answer = Double.valueOf(n1s)*Double.valueOf(n2s);
            result.setText("Result:"+answer);
        }
        else if(v.getId() == R.id.division){
            if(n2s.equals("0") == true){
                message.setMessage("不可除以0!");
                message.show();
            }
            else{
                double answer = Double.valueOf(n1s)/Double.valueOf(n2s);
                result.setText("Result:"+answer);
            }
        }
    }
    public boolean isNumber(String numberStr){
        String NUMBER_PATTERN = "^[0-9]*$";
        Pattern pattern = Pattern.compile(NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(numberStr);
        return matcher.matches();
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
}
