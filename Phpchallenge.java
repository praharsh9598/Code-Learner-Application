package com.example.codelearn;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Phpchallenge extends Activity {
	
	String n;
	EditText ed;
	Button submit;
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.phpchallenge);
	        
	        n =getIntent().getExtras().getString("name");
	        ed=(EditText) findViewById(R.id.edtinschallenge);
	        submit=(Button) findViewById(R.id.btnsubmitchallenge);
	        
	        Mysqlhelper helper=new Mysqlhelper(Phpchallenge.this);
	    	
	    	final SQLiteDatabase db=helper.getWritableDatabase();
	    	
	        submit.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String contact_no="";
					String q1="select contact_no from registration where name='"+n+"'";
			        Cursor c=db.rawQuery(q1, null);
			        if(c!=null)
			        {
			        
					c.moveToFirst();
					
					do{
						contact_no=c.getString(0);
					}while(c.moveToNext());	
			        }
					//change id
			        int ch_id=0;
			       String	q2="select * from challenge ORDER BY cid DESC limit 1";
			        Cursor c1=db.rawQuery(q2, null);
			        
			        if(c1!=null && c1.moveToFirst())
			        {
			        String ch_no;

					do{
						ch_no=c1.getString(0);
					}while(c1.moveToNext());	
					
					ch_id=Integer.parseInt(ch_no);
			        }
					ch_id++;
			        
					String q="insert into challenge (cid,name,question) values ("+ch_id+",'"+n+"','"+ed.getText().toString()+"')";
					db.execSQL(q);
					
					
					Intent i=new Intent(Phpchallenge.this,Activityfeed.class);
					i.putExtra("contactno",contact_no);
					startActivity(i);
				}
			});
	 }

}
