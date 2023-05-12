package com.framfresh.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductViewActivity extends AppCompatActivity {

    TextView tv_title,tv_des;
    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);


        String title = getIntent().getStringExtra("title");
        int img = getIntent().getIntExtra("img",000);
        String des = getIntent().getStringExtra("des");

        im = findViewById(R.id.im);

        tv_des = findViewById(R.id.des);
        tv_title = findViewById(R.id.title);

        tv_des.setText(des);
        tv_title.setText(title);
        im.setImageResource(img);

    }
}