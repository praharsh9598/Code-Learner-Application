package com.example.codelearn;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Mysqlhelper extends SQLiteOpenHelper {

	public Mysqlhelper(Context context) {
		super(context,"codelearn.db", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		
		String q="create table registration(name varchar(100),contact_no varchar(20),email varchar(100),password varchar(100),conformpassword varchar(100))";
		db.execSQL(q);
		
		String qry="create table topicmcq(topicid varchar(10),topictype varchar(100),description text(3200),question varchar(1000),optionA varchar(1000),optionB varchar(1000),optionC varchar(1000),optionD varchar(1000),answer varchar(1000),sid varchar(100))";
		db.execSQL(qry);
		
		String query="create table subject(sid varchar(10),sname varchar(100))";
		db.execSQL(query);
		
		String query1="CREATE TABLE challenge(cid INT,name VARCHAR( 100 ),question VARCHAR( 100 ))";
		db.execSQL(query1);
		
		String query2="create table answer(aid INT,name varchar(100),answer varchar(100),cid INT)";
		db.execSQL(query2);
		
		String querym="create table mcq(mcqid varchar(10),question varchar(1000),optionA varchar(1000),optionB varchar(1000),optionC varchar(1000),optionD varchar(1000),answer varchar(1000),sid varchar(10))";
		db.execSQL(querym);
		
		String t1="insert into topicmcq(topicid,topictype,question,optionA,optionB,optionC,optionD,answer,sid) values('1','basic','PHP is a...','website','home page','server side programming language','markup language','server side programming language','1')";
		db.execSQL(t1);
		
		String s="insert into subject(sid,sname)values('1','php')";
		db.execSQL(s);
		
		String t2="insert into topicmcq(topicid,topictype,question,optionA,optionB,optionC,optionD,answer,sid) values('2','basic','Can you run PHP in Linux ?','No','Yes','Maybe','None of these','Yes','1')";
		db.execSQL(t2);
		
		String t3="insert into topicmcq(topicid,topictype,question,optionA,optionB,optionC,optionD,answer,sid) values('3','basic','Variable start with ____ ?','@','$','&','!','$','1')";
		db.execSQL(t3);
		
		String t4="insert into topicmcq(topicid,topictype,question,optionA,optionB,optionC,optionD,answer,sid) values('4','basic','Which of the following characters indicates comments in PHP ?','***','//','<!---','\\','//','1')";
		db.execSQL(t4);
		
		String l1="insert into topicmcq(topicid,topictype,question,optionA,optionB,optionC,optionD,answer,sid) values('5','loop','Syntax of while loop ?','(while)condition','condition(while)','while(condition)','(condition)while','while(condition)','1')";
		db.execSQL(l1);
		
		String l2="insert into topicmcq(topicid,topictype,question,optionA,optionB,optionC,optionD,answer,sid) values('6','loop','Syntax of foreach loop ?','($array as $value)foreach','foreach($array as $value)','Both a and b','None of these','foreach($array as $value)','1')";
		db.execSQL(l2);
	
		String a1="insert into topicmcq(topicid,topictype,question,optionA,optionB,optionC,optionD,answer,sid) values('7','array','Which function is used to create array ?','while','for','array','do while','array','1')";
		db.execSQL(a1);
		
		String a2="insert into topicmcq(topicid,topictype,question,optionA,optionB,optionC,optionD,answer,sid) values('8','array','Get the length of array using which function','array','count','for','while','count','1')";
		db.execSQL(a2);

		a2="insert into topicmcq(topicid,topictype,question,optionA,optionB,optionC,optionD,answer,sid) values('9','array','Get the length of array using which function','array','count','for','while','count','1')";
		db.execSQL(a2);
		
	}
	
	

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		
	}

}
