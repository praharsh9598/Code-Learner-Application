package com.example.codelearn;



import android.R.integer;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
//import android.view.Menu;
import android.database.sqlite.SQLiteDatabase;

public class Login extends Activity {
	
	
	EditText contact,pass;
	Button login,signup;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        Mysqlhelper helper=new Mysqlhelper(Login.this);
    	
    	final SQLiteDatabase db=helper.getWritableDatabase();
    	
    	contact=(EditText) findViewById(R.id.edtno);
    	pass=(EditText) findViewById(R.id.edtpassword);
    	
    	login=(Button) findViewById(R.id.btnlogin);
    	signup=(Button) findViewById(R.id.btnsignup);
    	
     
    	login.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				int flag=0;
				
				if(contact.getText().toString().length()!=10)
				{
					contact.setError("contact must be 10 digit");
					flag=1;
				}
				if(pass.getText().toString().length()==0)
				{
					pass.setError("Field must be filled");
					flag=1;
				}
				
				if(flag==0)
				{
				
				String phone=contact.getText().toString();
				if(phone.equals("1111111111") && pass.getText().toString().equals("1111111111"))
				{
					Intent i=new Intent(Login.this,Adminhome.class);
					startActivity(i);
				//	Toast.makeText(Login.this, "login", Toast.LENGTH_LONG).show();
				}
				
				else
						{
				String q="select password from registration where contact_no="+phone;
				Cursor c=db.rawQuery(q, null);
				String password="";
				if(c!=null)
				{
					int index_pass=c.getColumnIndex("password");
				
					c.moveToFirst();
				
				
					do{
					password=c.getString(index_pass);
					}while(c.moveToNext());
				}
			if(pass.getText().toString().equals(password))
			{
				Intent i=new Intent(Login.this,Activityfeed.class);
				SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
				SharedPreferences.Editor editor = pref.edit();
				editor.putString("contactno",contact.getText().toString());
				editor.commit();
				i.putExtra("contactno",contact.getText().toString());
				startActivity(i);
				finish();
			}
			else
			{
				Toast t=Toast.makeText(Login.this,"invalid contact/password",Toast.LENGTH_SHORT);
				t.setGravity(Gravity.CENTER,0,0);
				t.show();
			}
						}
			}
			}
		});
    	
    	signup.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				Intent i=new Intent(Login.this,Registration.class);
			
				startActivity(i);
				
			}
		});
    	
    }

    
	
	//String q="insert into registration values('"+n+"')";
	
	//db.execSQL(q);
	
	//Toast.makeText(Test_Activity.this,"data inserted", Toast.LENGTH_SHORT).show();
	
}
