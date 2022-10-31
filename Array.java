package com.example.codelearn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Array extends Activity {
	
	TextView topic,que;
	RadioGroup  rg;
	Button nxt;
	int no;
	String n;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.array);
        
        n =getIntent().getExtras().getString("name");

        
        Mysqlhelper helper=new Mysqlhelper(Array.this);
    	
    	final SQLiteDatabase db=helper.getWritableDatabase();
        
        topic=(TextView) findViewById(R.id.tva);
        nxt=(Button) findViewById(R.id.btnanxt);
       // que=(TextView) findViewById(R.id.tvaq);
       // rg=(RadioGroup) findViewById(R.id.arg1);
        
        no=Integer.parseInt(getIntent().getStringExtra("topic"));
        readFromFile(Array.this);
        //no=1;
			nxt.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
				Intent i=new Intent(Array.this,Array2.class);
				String num=String.valueOf(no);
				i.putExtra("topic", num);
				i.putExtra("name",n);
				startActivity(i);
				finish();
				
				}
			});
	    
  	}
	
	 //read file
    
    private String readFromFile(Context context) {

        String ret = "";

        try {
        	
            InputStream inputStream = context.openFileInput("topic"+no+".txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
                topic.setText(ret);
            //    Toast.makeText(Basic.this, ret, Toast.LENGTH_SHORT).show();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }


    public void goHome(View v){
        Intent i = new Intent(Array.this, Learn.class);
        i.putExtra("name",n);
        startActivity(i);
    }

}

