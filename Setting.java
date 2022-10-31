package com.example.codelearn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Setting extends Activity {
	
	TextView logout;
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.seting);
	        
	        logout=(TextView) findViewById(R.id.tvlogout);
	        
	        logout.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent i=new Intent(Setting.this,Login.class);
					startActivity(i);
				}
			});
	        
	 }
}
	 
