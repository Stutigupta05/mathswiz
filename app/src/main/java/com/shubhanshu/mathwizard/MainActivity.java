package com.shubhanshu.mathwizard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btneasy,btnmedium,btnhard,btnexpert,btnhighscore;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btneasy=(Button)findViewById(R.id.easy);
        btnmedium=(Button)findViewById(R.id.medium);
        btnhard=(Button)findViewById(R.id.hard);
        btnexpert=(Button)findViewById(R.id.expert);
        btnhighscore=(Button)findViewById(R.id.highscore);
        btneasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                intent.putExtra("min",1);
                intent.putExtra("max",9);
                startActivity(intent);

            }
        });
        btnmedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),GameActivity.class);
                intent.putExtra("min",10);
                intent.putExtra("max",19);
                startActivity(intent);

            }
        });
        btnhard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),GameActivity.class);
                intent.putExtra("min",20);
                intent.putExtra("max",30);
                startActivity(intent);

            }
        });
        btnexpert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),GameActivity.class);
                intent.putExtra("min",31);
                intent.putExtra("max",99);
                startActivity(intent);

            }
        });
        btnhighscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),HSActivity.class);
                startActivity(intent);
            }
        });
    }
}
