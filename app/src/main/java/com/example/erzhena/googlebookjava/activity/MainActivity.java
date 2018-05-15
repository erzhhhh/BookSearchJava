package com.example.erzhena.googlebookjava.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.erzhena.googlebookjava.BookPresenter;
import com.example.erzhena.googlebookjava.BooksListAdapter;
import com.example.erzhena.googlebookjava.R;
import com.example.erzhena.googlebookjava.contracts.IBookPresenter;
import com.example.erzhena.googlebookjava.contracts.IBookView;
import com.example.erzhena.googlebookjava.model.entity.Item;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IBookView {
    private IBookPresenter presenter;

    private List<Item> books;

    private ListView booksListView;
    private TextView oopsTextView;
    private BooksListAdapter adapter;
    private ProgressBar loadingIndicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        booksListView = (ListView) findViewById(R.id.books_list_view);

        oopsTextView = (TextView) findViewById(R.id.oopsTextView);
        booksListView.setEmptyView(oopsTextView);

        loadingIndicator = (ProgressBar) findViewById(R.id.loading_spinner);
        loadingIndicator.getIndeterminateDrawable().setColorFilter(ContextCompat
                .getColor(this, R.color.colorPrimaryDark), PorterDuff.Mode.MULTIPLY);

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            if (presenter == null) presenter = new BookPresenter(this);

            presenter.getBooksData(false);

            booksListView.setOnItemClickListener((adapterView, view, i, l) -> {
                String url = books.get(i).getVolumeInfo().getInfoLink();
                Intent browseIntent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url));
                startActivity(browseIntent);
            });
        } else {
            showNoConnectionMessage();
        }


    }

    @Override
    public void setBooksListViewData(List<Item> items) {
        books = items;
        adapter = new BooksListAdapter(getApplicationContext(), books);
        booksListView.setAdapter(adapter);
    }

    @Override
    public void updateBooksListView(List<Item> items) {
        books = items;
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setEmptyResponseText(String text) {
        oopsTextView.setText(text);
    }

    @Override
    public void hideLoadingIndicator() {
        loadingIndicator.setVisibility(View.GONE);
    }

    @Override
    public void showNoConnectionMessage() {
        loadingIndicator.setVisibility(View.GONE);
        oopsTextView.setText("Подключите интернет");
    }
}
