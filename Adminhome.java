package com.example.codelearn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Adminhome extends Activity {
	
	Button b1,b2,b3,b4,b5;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminhome);
        
        //b1=(Button) findViewById(R.id.addsub);
     //   b2=(Button) findViewById(R.id.addtopicmcq);
        b3=(Button) findViewById(R.id.adminviewchallenge);
        b4=(Button) findViewById(R.id.viewuser);
        b5=(Button) findViewById(R.id.adminlogout);
      
	/*b1.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i=new Intent(Adminhome.this,Addsub.class);
			startActivity(i);
		}
	});
	
	b2.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i=new Intent(Adminhome.this,Topicmcq.class);
			startActivity(i);
		}
	});*/
	
	b3.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i=new Intent(Adminhome.this,Adviewch.class);
			startActivity(i);
		}
	});
	
	b4.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i=new Intent(Adminhome.this,Viewuser.class);
			startActivity(i);
		}
	});
	
	b5.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i=new Intent(Adminhome.this,Login.class);
			startActivity(i);
		}
	});
	
	}
}
