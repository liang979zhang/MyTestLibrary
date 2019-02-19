package com.yema.recypro;

import com.yema.recypro.test.CommentData;
import com.yema.recypro.test.ReplayMultipleItem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    public void aaa() {
        List<ReplayMultipleItem> strings = new ArrayList();
        List<CommentData> testList = new ArrayList();

        for (int y = 0; y < 12; y++) {
            if (y % 2 == 0) {
                strings.add(new ReplayMultipleItem(1, "asdasd" + y, "我" + y, "他" + y));

            } else {
                strings.add(new ReplayMultipleItem(2, "asdasd$y", "我$y", "他$y"));
            }
        }

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                testList.add(new CommentData("asdasd", strings.subList(0, 8)));

            } else {
                testList.add(new CommentData("asdasd", strings));

            }
        }



        strings.add(new ReplayMultipleItem(2, "asdadas", "asdas", "asdasdsa"));
        testList.add(2,new CommentData("asdasd", strings.subList(0, 1)));

    }
}