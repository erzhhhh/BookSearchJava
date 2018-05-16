package com.example.erzhena.googlebookjava.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.erzhena.googlebookjava.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private TextView detailURL;
    String tURL;
    private TextView detailAuthorTextView;
    ArrayList<String> tAuthor;
    private TextView detailTitleTextView;
    String tTitle;
    private TextView detailDesc;
    String tDesc;
    private TextView detailDateTextView;
    String tDate;
    private ImageView detailImage;
    String tThumb;
    private Uri mCurrentNewsUri;
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
        String dSource = intent.getStringExtra("CURRENT_SOURCE");
        ArrayList<String> authors = getIntent().getStringArrayListExtra("CURRENT_AUTHOR");

        tAuthor = authors;
        tTitle = dTitle;
        tDesc = dDesc;
        tDate = dDate;
        tThumb = dThumb;
        tURL = dURL;
        tSource = dSource;

        detailDateTextView = (TextView) findViewById(R.id.detail_date);
        detailDateTextView.setText(dDate);

        detailAuthorTextView = (TextView) findViewById(R.id.detail_author);
        detailAuthorTextView.setText("");
        for (int j = 0; j < authors.size(); j++) {
            detailAuthorTextView.append(authors.get(j) + ", ");
        }

        detailTitleTextView = (TextView) findViewById(R.id.detail_title);
        detailTitleTextView.setText(dTitle);

        detailDesc = (TextView) findViewById(R.id.detail_text);
        detailDesc.setText(dDesc);

        detailURL = (TextView) findViewById(R.id.detail_link);
        detailURL.setText(dURL);

        detailImage = (ImageView) findViewById(R.id.detail_image);
        Picasso.get().load(dThumb).into(detailImage);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
