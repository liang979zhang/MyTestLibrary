package com.yema.recypro.test;


import java.util.List;

public class CommentData {

    public String content;
    public List<ReplayMultipleItem> strings;
    public boolean isshow = false;  //是否展开

    public CommentData(String content, List<ReplayMultipleItem> strings) {
        this.content = content;
        this.strings = strings;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<ReplayMultipleItem> getStrings() {
        return strings;
    }

    public void setStrings(List<ReplayMultipleItem> strings) {
        this.strings = strings;
    }

    public boolean isIsshow() {
        return isshow;
    }

    public void setIsshow(boolean isshow) {
        this.isshow = isshow;
    }
}
