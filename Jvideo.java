package com.example.codelearn;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Jvideo extends Activity {
    String n;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jvideo);
        n =getIntent().getExtras().getString("name");

        findViewById(R.id.jtxt12).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                cliked_btn("https://www.youtube.com/watch?v=ygivEeptFZo&feature=youtu.be");
            }
        });
        findViewById(R.id.jtxt13).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                cliked_btn("https://www.youtube.com/watch?v=cVGK_oO-n1A&feature=youtu.be");
            }
        });

        findViewById(R.id.jtxt14).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                cliked_btn("https://www.youtube.com/watch?v=UcsoLgBaGmg");
            }
        });
        findViewById(R.id.jtxt15).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                cliked_btn("https://www.youtube.com/watch?v=TmM9XAIKa-Y&feature=youtu.be");
            }
        });
        findViewById(R.id.jtxt16).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                cliked_btn("https://www.youtube.com/watch?v=TR25f1wEH8I&feature=youtu.be");
            }
        });
        findViewById(R.id.jtxt17).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                cliked_btn("https://www.youtube.com/watch?v=g7UUJy4eCM8&feature=youtu.be");
            }
        });
        findViewById(R.id.jtxt18).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                cliked_btn("https://www.youtube.com/watch?v=r59xYe3Vyks&feature=youtu.be");
            }
        });

        findViewById(R.id.jtxt19).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                cliked_btn("https://www.youtube.com/watch?v=Keok13el9Ag&feature=youtu.be");
            }
        });

        findViewById(R.id.jtxt20).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                cliked_btn("https://www.youtube.com/watch?v=iOpNgJCEFog&feature=youtu.be");
            }
        });


    }

    public void cliked_btn(String url)

    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);

    }
    public void goHome(View v){
        Intent i = new Intent(Jvideo.this, Learn.class);
        i.putExtra("name",n);
        startActivity(i);
    }
}


