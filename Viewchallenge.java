package com.example.codelearn;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Viewchallenge extends Activity {

	String n;
	Button chphp, chmalay, chrahul;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewchallenge);

		n = getIntent().getExtras().getString("name");


		Mysqlhelper helper = new Mysqlhelper(Viewchallenge.this);

		final SQLiteDatabase db = helper.getWritableDatabase();

		int num = 0;
		String q2 = "select * from challenge";
		final Cursor c1 = db.rawQuery(q2, null);
		if (c1 != null && c1.moveToFirst()) {
			String ch_no;

			do {
				num += 1;
			} while (c1.moveToNext());
		}

		c1.moveToFirst();

		LinearLayout btns = (LinearLayout)findViewById(R.id.buttons);
		Button x[] = new Button[num];
		for (int i = 0; i < num; i++) {
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
			lp.setMargins(0,0,0,26);
			x[i] = new Button(this);
			x[i].setLayoutParams(lp);
			final String cid = c1.getString(0);
			final String name = c1.getString(1);
			final String chall_name = c1.getString(2);
			x[i].setText(c1.getString(2));
			btns.addView(x[i]);

			x[i].setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Viewchallenge.this,Anschallenge.class);
				i.putExtra("name",name);
				i.putExtra("chall_name", chall_name);
				i.putExtra("cid", cid);
				startActivity(i);
			}
		});
			c1.moveToNext();



		}


//		chphp=(Button) findViewById(R.id.btnchphp);
//    	chmalay=(Button) findViewById(R.id.btnchajava);
//    	chrahul=(Button) findViewById(R.id.btnchCplus);
//
//    	chphp.setOnClickListener(new OnClickListener() {
//
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Intent i=new Intent(Viewchallenge.this,Anschallenge.class);
//				i.putExtra("name",n);
//				i.putExtra("chall_name", "anis");
//				startActivity(i);
//			}
//		});
////chphp=(Button) findViewById(R.id.btnchphp);
//
//    	chmalay.setOnClickListener(new OnClickListener() {
//
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Intent i=new Intent(Viewchallenge.this,Anschallenge.class);
//				i.putExtra("name",n);
//				i.putExtra("chall_name", "malay");
//				startActivity(i);
//			}
//		});
////chphp=(Button) findViewById(R.id.btnchphp);
//
//    	chrahul.setOnClickListener(new OnClickListener() {
//
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Intent i=new Intent(Viewchallenge.this,Anschallenge.class);
//				i.putExtra("name",n);
//				i.putExtra("chall_name", "rushi");
//				startActivity(i);
//			}
//		});

	}
}
