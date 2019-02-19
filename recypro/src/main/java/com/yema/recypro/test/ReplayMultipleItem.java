package com.yema.recypro.test;

public class ReplayMultipleItem {



    public static int NORME = 1;
    public static int TOMMAIN = 1;

    private int itemType;
    private String content;

    private String responde;

    private String replied;


    public ReplayMultipleItem(int itemType, String content, String responde, String replied) {
        this.itemType = itemType;
        this.content = content;
        this.responde = responde;
        this.replied = replied;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getResponde() {
        return responde;
    }

    public void setResponde(String responde) {
        this.responde = responde;
    }

    public String getReplied() {
        return replied;
    }

    public void setReplied(String replied) {
        this.replied = replied;
    }
}
