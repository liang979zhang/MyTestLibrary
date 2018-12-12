package com.yema.mytestlibrary;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {


    private TextView tv1, tv2, tv3;

    private List<TextView> textViews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        textViews.add(tv1);
        textViews.add(tv2);
        textViews.add(tv3);


    }

    public void click(View view) {

        for (int i = 0; i < textViews.size(); i++) {
            if (i == 1) {
                textViews.get(i).setText("我是第二个");
            } else {
                textViews.get(i).setText("我是第n个");
            }

        }
    }
}
