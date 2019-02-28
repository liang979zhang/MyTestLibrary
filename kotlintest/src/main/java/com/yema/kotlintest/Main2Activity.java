package com.yema.kotlintest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.github.florent37.inlineactivityresult.InlineActivityResult;
import com.github.florent37.inlineactivityresult.Result;
import com.github.florent37.inlineactivityresult.callbacks.ActivityResultListener;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tv_back = findViewById(R.id.tv_back);
        TextView tv_jump = findViewById(R.id.tv_jump);
        tv_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new InlineActivityResult(Main2Activity.this).startForResult(new Intent(Main2Activity.this, MainActivity.class), new ActivityResultListener() {
                    @Override
                    public void onSuccess(Result result) {
                        Log.e("tag", "");
                    }

                    @Override
                    public void onFailed(Result result) {
                        Log.e("tag", "");
                    }
                });
            }
        });


        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("aa", "asdasda");
                intent.putExtra("aa2", "asdasda");
                setResult(-1,intent);
                finish();
            }
        });
    }


}
