package com.example.codelearn;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class Array2 extends Activity implements OnCheckedChangeListener{
	
	TextView topic,que;
	RadioGroup rg;
	RadioButton mc1,mc2,mc3,mc4;
	Button nxt;
	int flag=0;
	String question="";
	String optionA="";
	String optionB="";
	String optionC="";
	String optionD="";
	String answer="";
	String n;
	int no;
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.array1);
        
        n =getIntent().getExtras().getString("name");

        
        Mysqlhelper helper=new Mysqlhelper(Array2.this);
    	final SQLiteDatabase db=helper.getWritableDatabase();
        
        //topic=(TextView) findViewById(R.id.lptv1);
    	no=Integer.parseInt(getIntent().getStringExtra("topic"));
        que=(TextView) findViewById(R.id.tvarrayque);
        rg=(RadioGroup) findViewById(R.id.arrayradioGroup1);
        mc1=(RadioButton) findViewById(R.id.arraymcq1);
        mc2=(RadioButton) findViewById(R.id.arraymcq2);
        mc3=(RadioButton) findViewById(R.id.arraymcq3);
        mc4=(RadioButton) findViewById(R.id.arraymcq4);
        nxt=(Button) findViewById(R.id.arraybtnnxt);
        TextView arr1 = (TextView)findViewById(R.id.mcqnum);
        arr1.setText("MCQ: "+Integer.toString(no-6)+"/2");
        rg.setOnCheckedChangeListener((OnCheckedChangeListener) this);
        
        
        String q1="select * from topicmcq where topicid="+no;
        Cursor c=db.rawQuery(q1, null);
        
       
 		
		int index_que=c.getColumnIndex("question");
		int index_mcq1=c.getColumnIndex("optionA");
		int index_mcq2=c.getColumnIndex("optionB");
		int index_mcq3=c.getColumnIndex("optionC");
		int index_mcq4=c.getColumnIndex("optionD");
		int index_ans=c.getColumnIndex("answer");
		//Toast.makeText(Basic1.this,"in="+index_ans, Toast.LENGTH_SHORT).show();
		
		c.moveToFirst();
		
		
		
		
			do{
				question=c.getString(index_que);
				optionA=c.getString(index_mcq1);
				optionB=c.getString(index_mcq2);
				optionC=c.getString(index_mcq3);
				optionD=c.getString(index_mcq4);
				answer=c.getString(index_ans);
				//Toast.makeText(Basic1.this,"ans="+answer, Toast.LENGTH_SHORT).show();
			}while(c.moveToNext());		
			
		
			que.setText(question);
			mc1.setText(optionA);
			mc2.setText(optionB);
			mc3.setText(optionC);
			mc4.setText(optionD);
			
			
			
        
       
	
	nxt.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(flag==1)
			{
				no++;
				Intent i;
				 if(no>8){
					 i=new Intent(Array2.this,Learnon.class);
					 Toast.makeText(Array2.this, "Array Section Completed", Toast.LENGTH_SHORT).show();

				 }
				 else
					 i=new Intent(Array2.this,Array.class);
				flag=0;
			    String num=String.valueOf(no);
				i.putExtra("topic", num);
				startActivity(i);
				finish();
			}
			else
			{
				Toast.makeText(Array2.this,"Wrong answer", Toast.LENGTH_SHORT).show();
			}
		}
	});
      
   	}
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if(checkedId==R.id.arraymcq1)
		{
			//Toast.makeText(Basic1.this,answer, Toast.LENGTH_SHORT).show();
			if(mc1.getText().toString().equals(answer))
			{
				flag=1;
				
			}
		}
		if(checkedId==R.id.arraymcq2)
		{
			if(mc2.getText().toString().equals(answer))
			{
				flag=1;
			}
			
		}
		if(checkedId==R.id.arraymcq3)
		{
			if(mc3.getText().toString().equals(answer))
			{
				flag=1;
			}
		}
		if(checkedId==R.id.arraymcq4)
		{
			if(mc4.getText().toString().equals(answer))
			{
				flag=1;
			}
		}

		
	}



/*
public void onCheckedChanged(RadioGroup group, int checkedId) {
	// TODO Auto-generated method stub
	
}

*/

	public void goHome(View v){
		Intent i = new Intent(Array2.this, Learn.class);
		i.putExtra("name",n);
		startActivity(i);
	}


        
	

}



