package com.example.erzhena.googlebookjava;

import android.content.Context;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.erzhena.googlebookjava.model.entity.Item;

import java.text.SimpleDateFormat;
import java.util.Date;
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

        TextView locationPlaceTextView = (TextView) convertView.findViewById(R.id.primary_location);

        String description = item.getVolumeInfo().getDescription();
        locationPlaceTextView.setText(description);

        return convertView;
    }
}