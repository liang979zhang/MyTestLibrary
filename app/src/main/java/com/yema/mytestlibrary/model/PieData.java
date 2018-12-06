package com.yema.mytestlibrary.model;

import org.jetbrains.annotations.NotNull;

public  class PieData {

    public   int color;
    public  float angle;
    @NotNull
    public  float percentage;

    public PieData() {
    }

    public PieData(int color, float angle, @NotNull float percentage) {
        this.color = color;
        this.angle = angle;
        this.percentage = percentage;
    }
}
