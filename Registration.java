package com.example.codelearn;



import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends Activity {
	
	EditText name,contact,email,password,compass;
	Button reg;
	
	
		public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.registration);
	    
	    Mysqlhelper helper=new Mysqlhelper(Registration.this);
	 	final SQLiteDatabase db=helper.getWritableDatabase();
	
	name=(EditText) findViewById(R.id.edtname);
	contact=(EditText) findViewById(R.id.edtphone);
	email=(EditText) findViewById(R.id.edtmail);
	password=(EditText) findViewById(R.id.edtpass);
	compass=(EditText) findViewById(R.id.edtconformpass);
	
	
	
	reg=(Button) findViewById(R.id.btnreg);
	
	reg.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			int flag=0;
			if(name.getText().toString().length()==0)
			{
				name.setError("Field must be filled");
				flag=1;
			}
			if(contact.getText().toString().length()!=10)
			{
				contact.setError("contact must be 10 digit");
				flag=1;
			}
			if(email.getText().toString().length()==0)
			{
				email.setError("Field must be filled");
				flag=1;
			}
			if(password.getText().toString().length()==0)
			{
				password.setError("Field must be filled");
				flag=1;
			}
			/*if(compass.getText().toString().length()==password.getText().toString().length())
			{
				compass.setError("not match");
				flag=1;
			}*/
			
			
			if(flag==0)
			{
			 
			String phone=contact.getText().toString();
			String q="insert into registration(name,contact_no,email,password,conformpassword) values ('"+name.getText().toString()+"',"+phone+",'"+email.getText().toString()+"','"+password.getText().toString()+"','"+compass.getText().toString()+"')";
			//String q="insert into registration(name,contact_no,email,password,conformpassword) values('"+name.getText().toString()+"',"+phone+",'"+email.getText().toString()+"','"+password.getText().toString()+"','"+compass.getText().toString()+"')";
			db.execSQL(q);
			
			Toast.makeText(Registration.this,"data inserted", Toast.LENGTH_SHORT).show();
			Intent i=new Intent(Registration.this,Login.class);
			startActivity(i);
			}
		}
	});
	
	
	

	}
}
