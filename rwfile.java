package com.example.codelearn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class rwfile extends Activity {
	EditText text;
	Button read,write;
	TextView tv;
	
	public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.rwfile);
	        
	        text=(EditText) findViewById(R.id.edttext);
	        tv=(TextView) findViewById(R.id.tvtext);
	        read=(Button) findViewById(R.id.btnread);
	        write=(Button) findViewById(R.id.btnwrite);
	        
	        write.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					writeToFile(text.getText().toString(), rwfile.this);
					
					
				}
			});
	        
	        read.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					readFromFile(rwfile.this);
					
				}
			});
	        
	}
	        
	        //write file
	        
	        private void writeToFile(String data,Context context) {
	            try {
	                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
	                outputStreamWriter.write(data);
	                outputStreamWriter.close();
	                Toast.makeText(rwfile.this, "store", Toast.LENGTH_SHORT).show();
	            }
	            catch (IOException e) {
	                Log.e("Exception", "File write failed: " + e.toString());
	            } 
	        }
	        
	        //read file
	        
	        private String readFromFile(Context context) {

	            String ret = "";

	            try {
	                InputStream inputStream = context.openFileInput("anis.txt");

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
	                    tv.setText(ret);
	                    Toast.makeText(rwfile.this, ret, Toast.LENGTH_SHORT).show();
	                }
	            }
	            catch (FileNotFoundException e) {
	                Log.e("login activity", "File not found: " + e.toString());
	            } catch (IOException e) {
	                Log.e("login activity", "Can not read file: " + e.toString());
	            }

	            return ret;
	        }
	        
	 }
	        


