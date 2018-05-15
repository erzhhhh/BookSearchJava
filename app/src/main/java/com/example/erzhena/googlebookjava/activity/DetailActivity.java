package com.example.erzhena.googlebookjava.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.erzhena.googlebookjava.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private TextView detail_URL;
    String tURL;
    private TextView detail_author;
    String tAuthor;
    private TextView detail_title;
    String tTitle;
    private TextView detail_desc;
    String tDesc;
    private TextView detail_date;
    String tDate;
    private ImageView detail_image;
    String tThumb;
    private Uri mCurrentNewsUri;
    String prevActivity;
    String tSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();

        mCurrentNewsUri = intent.getData();

        String dTitle = intent.getStringExtra("CURRENT_TITLE");
        String dDesc = intent.getStringExtra("CURRENT_DESC");
        String dDate = intent.getStringExtra("CURRENT_DATE");
        String dThumb = intent.getStringExtra("CURRENT_THUMB");
        String dURL = intent.getStringExtra("CURRENT_URL");
        String dAuthor = intent.getStringExtra("CURRENT_AUTHOR");
        String dSource = intent.getStringExtra("CURRENT_SOURCE");

        tAuthor = dAuthor;
        tTitle = dTitle;
        tDesc = dDesc;
        tDate = dDate;
        tThumb = dThumb;
        tURL = dURL;
        tSource = dSource;

        detail_date = (TextView) findViewById(R.id.detail_date);
        detail_date.setText(dDate);

        detail_author = (TextView) findViewById(R.id.detail_author);
        detail_author.setText(dAuthor);

        detail_title = (TextView) findViewById(R.id.detail_title);
        detail_title.setText(dTitle);

        detail_desc = (TextView) findViewById(R.id.detail_text);
        detail_desc.setText(dDesc);

        detail_URL = (TextView) findViewById(R.id.detail_link);
        detail_URL.setText(dURL);

        detail_image = (ImageView) findViewById(R.id.detail_image);
        Picasso.get().load(dThumb).into(detail_image);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    public void onBackPressed(){
        finish();
    }
}
