package com.example.codelearn;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class video extends Activity {
    String n;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);
        n =getIntent().getExtras().getString("name");

        findViewById(R.id.txt12).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                cliked_btn("https://www.youtube.com/watch?v=1jBLkSuy1cQ&feature=youtu.be");
            }
        });
        findViewById(R.id.txt13).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                cliked_btn("https://www.youtube.com/watch?v=jPhpsM8oSRs&feature=youtu.be");
            }
        });

        findViewById(R.id.txt14).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                cliked_btn("https://www.youtube.com/watch?v=3f0efM27ajg&feature=youtu.be");
            }
        });
        findViewById(R.id.txt15).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                cliked_btn("https://www.youtube.com/watch?v=b-AZsyofrlM&feature=youtu.be");
            }
        });
        findViewById(R.id.txt16).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                cliked_btn("https://www.youtube.com/watch?v=Ek539mj6IEE&feature=youtu.be");
            }
        });
        findViewById(R.id.txt17).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                cliked_btn("https://www.youtube.com/watch?v=dJfjVK56Bmk&feature=youtu.bee");
            }
        });
        findViewById(R.id.txt18).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                cliked_btn("https://www.youtube.com/watch?v=yMclPkD4sQg&feature=youtu.be");
            }
        });

        findViewById(R.id.txt19).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                cliked_btn("https://www.youtube.com/watch?v=3lfWcIWrHtc&feature=youtu.be");
            }
        });

        findViewById(R.id.txt20).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                cliked_btn("https://www.youtube.com/watch?v=JCLlVu_0OiA&feature=youtu.bee");
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
        Intent i = new Intent(video.this, Learn.class);
        i.putExtra("name",n);
        startActivity(i);
    }
    }



