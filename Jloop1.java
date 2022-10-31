package com.example.codelearn;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Jloop1 extends Activity implements RadioGroup.OnCheckedChangeListener {

    TextView jtopic,jque;
    RadioGroup jrg;
    RadioButton mc1,mc2,mc3,mc4;
    Button jnxt;
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
        setContentView(R.layout.jloop1);

        n =getIntent().getExtras().getString("name");


        Mysqlhelper helper=new Mysqlhelper(Jloop1.this);
        final SQLiteDatabase db=helper.getWritableDatabase();

        //topic=(TextView) findViewById(R.id.lptv1);
        no=Integer.parseInt(getIntent().getStringExtra("topic"));
        jque=(TextView) findViewById(R.id.jlpmctv1);
        jrg=(RadioGroup) findViewById(R.id.jrgloop2);
        mc1=(RadioButton) findViewById(R.id.jlmcq1);
        mc2=(RadioButton) findViewById(R.id.jlmcq2);
        mc3=(RadioButton) findViewById(R.id.jlmcq3);
        mc4=(RadioButton) findViewById(R.id.jlmcq4);
        jnxt=(Button) findViewById(R.id.jbtnlnxt1);
        TextView arr1 = (TextView)findViewById(R.id.mcqnum);
        arr1.setText("MCQ: "+Integer.toString(no-12)+"/1");
        jrg.setOnCheckedChangeListener(this);


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


        jque.setText(question);
        mc1.setText(optionA);
        mc2.setText(optionB);
        mc3.setText(optionC);
        mc4.setText(optionD);






        jnxt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(flag==1)
                {
                    no++;
                    Intent i;
                    if(no>13) {
                        i = new Intent(Jloop1.this, Javalearon.class);
                        Toast.makeText(Jloop1.this, "Loop Section Completed", Toast.LENGTH_SHORT).show();
                    }
                    else
                        i=new Intent(Jloop1.this,Jloop.class);
                    flag=0;
                    String num=String.valueOf(no);
                    i.putExtra("topic", num);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(Jloop1.this,"Wrong answer", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId==R.id.jlmcq1)
        {
            //Toast.makeText(Basic1.this,answer, Toast.LENGTH_SHORT).show();
            if(mc1.getText().toString().equals(answer))
            {
                flag=1;

            }
        }
        if(checkedId==R.id.jlmcq2)
        {
            if(mc2.getText().toString().equals(answer))
            {
                flag=1;
            }

        }
        if(checkedId==R.id.jlmcq3)
        {
            if(mc3.getText().toString().equals(answer))
            {
                flag=1;
            }
        }
        if(checkedId==R.id.jlmcq4)
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
        Intent i = new Intent(Jloop1.this, Learn.class);
        i.putExtra("name",n);
        startActivity(i);
    }





}

