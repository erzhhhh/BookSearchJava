package com.example.erzhena.googlebookjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.erzhena.googlebookjava.model.entity.Item;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class BooksListAdapter extends ArrayAdapter<Item> {

    public BooksListAdapter(Context context, List<Item> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Item item = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.book_item, parent, false);
        }

        TextView titlTextView = (TextView) convertView.findViewById(R.id.book_title);
        String title = item.getVolumeInfo().getTitle();
        titlTextView.setText(title);

        TextView authorTextView = (TextView) convertView.findViewById(R.id.authors);
        Object[] authors = item.getVolumeInfo().getAuthors().toArray();
        authorTextView.setText(Arrays.toString(authors).replaceAll("\\[|\\]", ""));

        TextView descTextView = (TextView) convertView.findViewById(R.id.book_desc);
        String desc = item.getVolumeInfo().getDescription();
        descTextView.setText(desc);

        TextView dateTextView = (TextView) convertView.findViewById(R.id.date);
        String date = item.getVolumeInfo().getPublishedDate();
        dateTextView.setText(date);

        ImageView picture = (ImageView) convertView.findViewById(R.id.thumbnail);
        try {
            String thumbnail = item.getVolumeInfo().getImageLinks().getSmallThumbnail();
            Picasso.get().load(thumbnail).into(picture);
        } catch (NullPointerException e) {
        }

        return convertView;
    }
}