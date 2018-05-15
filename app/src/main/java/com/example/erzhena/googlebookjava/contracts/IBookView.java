package com.example.erzhena.googlebookjava.contracts;

import com.example.erzhena.googlebookjava.model.entity.Item;
import java.util.List;

public interface IBookView {
    void setBooksListViewData(List<Item> items);
    void updateBooksListView(List<Item> items);
    void setEmptyResponseText(String text);
    void hideLoadingIndicator();
    void showNoConnectionMessage();
}
