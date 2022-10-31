package com.example.codelearn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Jloop extends Activity {

    TextView jtopic;
    //RadioGroup rg;
    Button jnxt;
    //RadioButton mc1,mc2,mc3,mc4;
    int no;
    String n;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jloop);

        n =getIntent().getExtras().getString("name");


        Mysqlhelper helper=new Mysqlhelper(Jloop.this);
        final SQLiteDatabase db=helper.getWritableDatabase();

        jtopic=(TextView) findViewById(R.id.jltv);
        jnxt=(Button) findViewById(R.id.jbtnlnxt);

        no=Integer.parseInt(getIntent().getStringExtra("topic"));
        readFromFile(Jloop.this);

        jnxt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent i= new Intent(Jloop.this,Jloop1.class);
                String num=String.valueOf(no);
                i.putExtra("topic", num);
                i.putExtra("name",n);
                startActivity(i);

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
                jtopic.setText(ret);
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
        Intent i = new Intent(Jloop.this, Learn.class);
        i.putExtra("name",n);
        startActivity(i);
    }


}


