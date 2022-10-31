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
import android.widget.TextView;

public class Anschallenge extends Activity {
	TextView tv;
	EditText ed;
	Button submit;
	String n,chall_name;
	String contact_no;
	String cid;
	
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anschallnge);
        
        n =getIntent().getExtras().getString("name");
        chall_name =getIntent().getExtras().getString("chall_name");
        cid = getIntent().getExtras().getString("cid");
        
        Mysqlhelper helper=new Mysqlhelper(Anschallenge.this);
    	
    	final SQLiteDatabase db=helper.getWritableDatabase();
    	// TODO Auto-generated method stub
    	String question="";
		String q1="select * from challenge where cid='"+cid+"'";
        Cursor c=db.rawQuery(q1, null);
        c.moveToFirst();
//        if(c!=null && c.moveToFirst())
//        {
//       // question;
//
//
//
//		do{
//			question=c.getString(2);
//			cid=c.getString(0);
//		}while(c.moveToNext());
//
//        }
        
       String q2="select contact_no from registration where name='"+n+"'";
        	Cursor c1=db.rawQuery(q2, null);
         	
        	if(c1!=null && c1.moveToFirst())
         	{

		
		do{
			contact_no=c1.getString(0);
		}while(c1.moveToNext());	
		
        }
		
    	tv=(TextView) findViewById(R.id.tvanswerchallenge);
    	tv.setText(question);
    	ed=(EditText) findViewById(R.id.edtanswerchallenge);
    	submit=(Button) findViewById(R.id.btnans);
       submit.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//answer id
			int ch_id=0;
			/*
			String q1="select * from answer ORDER BY aid DESC limit 1";
	        Cursor c2=db.rawQuery(q1, null);
	        
	        if(c2!=null)
	        {
	        String ch_no;
			c2.moveToFirst();
			
			do{
				ch_no=c2.getString(0);
			}while(c2.moveToNext());	
			 ch_id=Integer.parseInt(ch_no);
			 
			
	        }
	        */
	        ch_id++;
			String q="insert into answer (aid,name,answer,cid) values ("+ch_id+",'"+n+"','"+ed.getText().toString()+"',"+cid+")";
			db.execSQL(q);
			
			Intent i=new Intent(Anschallenge.this,Activityfeed.class);
			i.putExtra("contactno",contact_no);
			startActivity(i);
		}
	}); 
	}


}
