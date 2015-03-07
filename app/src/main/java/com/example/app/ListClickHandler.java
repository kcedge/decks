package com.example.app;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;


    public class ListClickHandler implements Button.OnClickListener {

    int count;
    TextView textView;

    public ListClickHandler(TextView view){
        textView = view;
        count = 0;
    }
    @Override
    public void onClick(View view) {
        //String text = listText.getText().toString();
        count++;
        textView.setText(Integer.toString(count));
    }

}
