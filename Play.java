package com.example.codelearn;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Play extends Activity {
	
	Button crchallenge,vwchallenge,challengeres;
	String n;
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.play);
	        
	        n =getIntent().getExtras().getString("name");
	        
	        
	        Mysqlhelper helper=new Mysqlhelper(Play.this);
	    	
	    	final SQLiteDatabase db=helper.getWritableDatabase();
	        
	        crchallenge=(Button) findViewById(R.id.btnchallenge);
	        vwchallenge=(Button) findViewById(R.id.btnviewchallenge);
	        challengeres=(Button) findViewById(R.id.btnchallengeresponse);
	        
	        
	        crchallenge.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent i=new Intent(Play.this,Createchallenge.class);
					i.putExtra("name",n);
					startActivity(i);
					
				}
			});
	        
	        	vwchallenge.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent i=new Intent(Play.this,Viewchallenge.class);
					i.putExtra("name",n);
					startActivity(i);
					
				}
			});
	        	
	        	challengeres.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
						Intent i=new Intent(Play.this,Response.class);
						i.putExtra("name",n);
						startActivity(i);
						
					}
				});
	        
	 }

}
