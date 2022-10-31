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

public class Jbasic extends Activity{

    Button jnxt;
    TextView jtopic;
    int no;
    String n;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jbasic);

        n =getIntent().getExtras().getString("name");

        Mysqlhelper helper=new Mysqlhelper(Jbasic.this);

        final SQLiteDatabase db=helper.getWritableDatabase();

        jnxt=(Button) findViewById(R.id.jbtnnxt);
        jtopic=(TextView) findViewById(R.id.jbstv);
        no=Integer.parseInt(getIntent().getStringExtra("topic"));
        readFromFile(Jbasic.this);

        jnxt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i=new Intent(Jbasic.this,Jbasic1.class);
                String num=String.valueOf(no);
                i.putExtra("topic", num);
                i.putExtra("name",n);
                startActivity(i);
                //finish();

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
        Intent i = new Intent(Jbasic.this, Learn.class);
        i.putExtra("name",n);
        startActivity(i);
    }

}


