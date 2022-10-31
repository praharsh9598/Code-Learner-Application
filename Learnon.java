package com.example.codelearn;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class Learnon extends Activity {
	
	//TextView change;
	ImageView basic,loop,array,video;
	//int no=1;
	//int flag=0;
	String  n;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learnon);
        
        n =getIntent().getExtras().getString("name");
        
        
        Mysqlhelper helper=new Mysqlhelper(Learnon.this);
    	
    	final SQLiteDatabase db=helper.getWritableDatabase();
        
        basic=(ImageView) findViewById(R.id.imagebasic);
        loop=(ImageView) findViewById(R.id.imageloop);
        array=(ImageView) findViewById(R.id.imagearray);
        video=(ImageView)findViewById(R.id.imageView12);
      //  change=(TextView) findViewById(R.id.txtchange);

		   basic.setOnClickListener(new OnClickListener() {

			   public void onClick(View v) {
				   // TODO Auto-generated method stub
				   Intent i = new Intent(Learnon.this, Basic.class);
				   i.putExtra("topic", "1");
				   i.putExtra("name", n);
				   startActivity(i);
				   finish();
			   }
		   });

		   loop.setOnClickListener(new OnClickListener() {

			   public void onClick(View v) {
				   // TODO Auto-generated method stub
				   Intent i = new Intent(Learnon.this, Loop.class);
				   i.putExtra("topic", "5");
				   i.putExtra("name", n);
				   startActivity(i);
				   finish();
			   }
		   });

		   array.setOnClickListener(new OnClickListener() {

			   public void onClick(View v) {
				   // TODO Auto-generated method stub
				   Intent i = new Intent(Learnon.this, Array.class);
				   i.putExtra("topic", "7");
				   i.putExtra("name", n);
				   startActivity(i);
				   finish();
			   }
		   });
		   video.setOnClickListener(new OnClickListener() {

			   public void onClick(View v) {
				   // TODO Auto-generated method stub
				   Intent i = new Intent(Learnon.this, video.class);
				   /*i.putExtra("topic", "7");*/
				   i.putExtra("name", n);
				   startActivity(i);
				   finish();

			   }
		   });

	   }


      /*  change.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Learnon.this,Learn.class);
				startActivity(i);
				//finish();
				
			}
		});*/
        
	}
	


