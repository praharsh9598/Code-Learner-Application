package com.example.codelearn;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class Viewuser extends Activity {
	TextView user;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewuser);
	
        user=(TextView) findViewById(R.id.vusertv);
        
        Mysqlhelper helper=new Mysqlhelper(Viewuser.this);
    	
    	final SQLiteDatabase db=helper.getWritableDatabase();
	
    	String q="select * from registration";
		Cursor c=db.rawQuery(q, null);
		String result="Name\t\t\tContact No\t\tEmail\n";
		String name="";
		String email="";
		String no="";
		if(c!=null)
		{
			int index_name=c.getColumnIndex("name");
			int index_no=c.getColumnIndex("contact_no");
			int index_email=c.getColumnIndex("email");
			
			c.moveToFirst();
			do{
			//password=c.getString(index_pass);
				name=c.getString(index_name);
				email=c.getString(index_email);
				no=c.getString(index_no);
				result=result+name+"\t\t\t"+no+"\t"+email+"\n";
				}while(c.moveToNext());
			user.setText(result);
		}
	}
}
