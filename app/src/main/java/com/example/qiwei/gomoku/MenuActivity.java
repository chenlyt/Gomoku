package com.example.qiwei.gomoku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        init();
    }
    private void init(){
        findViewById(R.id.start).setOnClickListener(this);
        findViewById(R.id.help).setOnClickListener(this);
         findViewById(R.id.about).setOnClickListener(this);
        findViewById(R.id.exit).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.start:
                Intent intent = new Intent(this,GameActivity.class);
                startActivity(intent);
                break;
            case R.id.help:
                break;
            case R.id.about:
                break;
            case R.id.exit:
                break;
        }
    }
}
