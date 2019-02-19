package com.yema.recypro;

import android.os.Bundle;

import com.yema.recypro.test.AAdapter;
import com.yema.recypro.test.CommentData;
import com.yema.recypro.test.ItemInPutClick;
import com.yema.recypro.test.ReplayMultipleItem;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {


    private RecyclerView rl_list;
    private List<ReplayMultipleItem> strings = new ArrayList();
    private List<CommentData> testList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rl_list = findViewById(R.id.rl_list);


        for (int y = 0; y < 12; y++) {
            if (y % 2 == 0) {
                strings.add(new ReplayMultipleItem(1, "asdasd" + y, "我" + y, "他" + y));

            } else {
                strings.add(new ReplayMultipleItem(2, "asdasd$y", "我$y", "他$y"));
            }
        }

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                testList.add(new CommentData("asdasd", strings.subList(0,8)));

            } else {
                testList.add(new CommentData("asdasd", strings));

            }
        }

        final AAdapter aAdapter = new AAdapter(this);
        rl_list.setLayoutManager(new LinearLayoutManager(this));
        aAdapter.setHasStableIds(true);
        rl_list.setAdapter(aAdapter);
        aAdapter.setNewData(testList);
        aAdapter.setListtener(new ItemInPutClick() {
            @Override
            public void itemClick2(int po) {
                strings.add(new ReplayMultipleItem(2, "asdadas", "asdas", "asdasdsa"));
                aAdapter.updata(po,new CommentData("asdasd", strings.subList(0,1)));
            }
        });


    }
}
