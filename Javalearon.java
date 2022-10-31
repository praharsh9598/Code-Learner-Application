package com.example.codelearn;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Javalearon  extends Activity {

    //TextView change;
    ImageView jbasic, jloop, jarray, jvideo;
    //int no=1;
    //int flag=0;
    String n;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.javalearnon);

        n = getIntent().getExtras().getString("name");


        Mysqlhelper helper = new Mysqlhelper(Javalearon.this);

        final SQLiteDatabase db = helper.getWritableDatabase();

        jbasic = (ImageView) findViewById(R.id.jimagebasic);
        jloop = (ImageView) findViewById(R.id.jimageloop);
        jarray = (ImageView) findViewById(R.id.jimagearray);
        jvideo = (ImageView) findViewById(R.id.jimageView12);
        //  change=(TextView) findViewById(R.id.txtchange);

        jbasic.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(Javalearon.this, Jbasic.class);
                i.putExtra("topic", "9");
                i.putExtra("name", n);
                startActivity(i);
                finish();
            }
        });

        jloop.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(Javalearon.this, Jloop.class);
                i.putExtra("topic", "13");
                i.putExtra("name", n);
                startActivity(i);
                finish();
            }
        });

        jarray.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(Javalearon.this, Jarray.class);
                i.putExtra("topic", "14");
                i.putExtra("name", n);
                startActivity(i);
                finish();
            }
        });
        jvideo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(Javalearon.this, Jvideo.class);
               /* i.putExtra("topic", "7");*/
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


