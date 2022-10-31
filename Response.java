package com.example.codelearn;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class Response extends Activity {
	
	String  n;
	TextView tv;
	String question;
    String ch_id;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.response);
        tv=(TextView)findViewById(R.id.ques_ans);
        n =getIntent().getExtras().getString("name");
        
        
        Mysqlhelper helper=new Mysqlhelper(Response.this);
    	
    	final SQLiteDatabase db=helper.getWritableDatabase();
    	String str="";
    	String q1="select * from challenge where name='"+n+"'";
        Cursor c=db.rawQuery(q1, null);
        if(c!=null)
        {
        c.moveToFirst();
		
		do{
			question=c.getString(2);
			ch_id=c.getString(0);
			q1="select * from answer where cid='"+ch_id+"'";
	        Cursor c1=db.rawQuery(q1, null);
	         if(c1!=null && c1.moveToFirst())
	         {
	        str+="Question :"+question+" \nAnswer :\n";
	        String answer;

			
			do{
				answer=c1.getString(2);
				str+=answer+" by "+c1.getString(1)+"  \n";
				
			}while(c1.moveToNext());
			str+="\n\n";
	         }
		}while(c.moveToNext());
		tv.setText(str);
        }
		
		
         
	}

}
