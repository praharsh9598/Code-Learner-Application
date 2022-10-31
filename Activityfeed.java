package com.example.codelearn;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class Activityfeed extends Activity {
	
	ImageView setting,user,home,book,play;
	TextView tv;
	String n="";
	String cont_no;
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activityfeed);
	        
	        setting=(ImageView) findViewById(R.id.imageseting);
	        user=(ImageView) findViewById(R.id.imageuser);
	        home=(ImageView) findViewById(R.id.imagehome);
	        book=(ImageView) findViewById(R.id.imagebook);
	        play=(ImageView) findViewById(R.id.imageplay);
	        
	        tv=(TextView) findViewById(R.id.txtusername);
		 SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
		 cont_no =pref.getString("contactno",null);
	    //cont_no =getIntent().getExtras().getString("contactno");
	        
	        
	        Mysqlhelper helper=new Mysqlhelper(Activityfeed.this);
	    	
	    	final SQLiteDatabase db=helper.getWritableDatabase();
	        
	    	String q1="select name from registration where contact_no='"+cont_no+"'";
	        Cursor c=db.rawQuery(q1, null);
	        if(c!=null)
	        {
			int index_name=c.getColumnIndex("name");
			c.moveToFirst();
			
			do{
				n=c.getString(index_name);
			}while(c.moveToNext());	
			
			tv.setText(n);
	        }
	        setting.setOnClickListener(new OnClickListener() {	
			public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent i=new Intent(Activityfeed.this,Setting.class);
					startActivity(i);
				}
			});
	        
	        user.setOnClickListener(new OnClickListener() {	
			public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent i=new Intent(Activityfeed.this,Activityfeed.class);
					//i.putExtra("name",n);
					startActivity(i);
				}
			});  
	        
	       /* home.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent i=new Intent(Activityfeed.this,Activityfeed.class);
					startActivity(i);
				}
			});*/ 
	        
	        	book.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent i=new Intent(Activityfeed.this,Learn.class);
					i.putExtra("name",n);

					startActivity(i);
				}
			}); 
	        
	        
	        	play.setOnClickListener(new OnClickListener() {	
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent i=new Intent(Activityfeed.this,Play.class);
					i.putExtra("name",n);
					startActivity(i);
				}
			}); 
}
}