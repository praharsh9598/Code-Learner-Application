package com.example.codelearn;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class testdel extends Activity {
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.registration);
	    
	    Mysqlhelper helper=new Mysqlhelper(testdel.this);
	 	final SQLiteDatabase db=helper.getWritableDatabase();
	 	String dq="delete from registration where name='rahul'";
		db.execSQL(dq);
	}
}
