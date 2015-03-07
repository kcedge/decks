package com.example.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Toast;

/**
 * Created by Casey on 2/9/14.
 */
public class listItem {
    private int id;
    private String name;
    private double price;
    private String urlToMedia;
    public int count;
    public listItem(){
        super();
    }

    public listItem(int id, String name, double price,String urlToMedia){
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.urlToMedia = urlToMedia;
        this.count = 0;
    }

    @Override
    public String toString(){
        return this.id + " " + this.name + " " +this.count;
    }



}
