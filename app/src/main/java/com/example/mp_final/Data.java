package com.example.mp_final;

import java.io.Serializable;

public class Data implements Serializable {
    String name;
    Integer row;
    Integer col;
    Integer height;
    Integer color;

    public Data(String name, Integer row, Integer col, Integer height, Integer color){
        this.name = name;
        this.row = row;
        this.col = col;
        this.height = height;
        this.color = color;
    }
}
