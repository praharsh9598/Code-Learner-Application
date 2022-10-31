package com.example.codelearn;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class Adviewch extends Activity {
	TextView challange;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adviewch);
        challange=(TextView) findViewById(R.id.tchallangead);
        
        Mysqlhelper helper=new Mysqlhelper(Adviewch.this);
    	
    	final SQLiteDatabase db=helper.getWritableDatabase();
	
    	String q="select * from challenge";
		Cursor c=db.rawQuery(q, null);
		String result="";
		String cid="";
		String name="";
		String question="";
		if(c!=null)
		{
			int index_cid=c.getColumnIndex("cid");
			int index_name=c.getColumnIndex("name");
			int index_question=c.getColumnIndex("question");
			
			c.moveToFirst();
			do{
			//password=c.getString(index_pass);
				name=c.getString(index_name);
				cid=c.getString(index_cid);
				question=c.getString(index_question);
				result=result+cid+"\t\t\tchallange by\t"+name+"\nQuestion:-\n"+question+"\n\n";
				}while(c.moveToNext());
			challange.setText(result);
		}
	} 
	}


