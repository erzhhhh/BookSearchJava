package com.example.erzhena.googlebookjava;

import com.example.erzhena.googlebookjava.api.GoogleBookApi;
import com.example.erzhena.googlebookjava.contracts.IBookPresenter;
import com.example.erzhena.googlebookjava.contracts.IBookView;
import com.example.erzhena.googlebookjava.model.entity.BookData;
import com.example.erzhena.googlebookjava.model.entity.Item;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BookPresenter implements IBookPresenter {
    private final GoogleBookApi bookApi;
    private final IBookView bookView;

    public BookPresenter(IBookView view) {
        bookApi = new GoogleBookApi();
        bookView = view;
    }

    @Override
    public void getDefaultBooksData(boolean isUpdate) {
        Observable<BookData> dataObservable = bookApi.getDefaultBooks();

        dataObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bookData ->
                {
                    List<Item> items = new ArrayList<>();
                    items.addAll(bookData.getItems());

                    bookView.hideLoadingIndicator();

                    if (items.isEmpty()) bookView.setEmptyResponseText("There is no books");
                    else if (isUpdate) bookView.updateBooksListView(items);
                    else bookView.setBooksListViewData(items);
                });
    }

    @Override
    public void getSearchBookData(boolean isUpdate, String keyWord) {
        Observable<BookData> dataObservable = bookApi.getDefaultBooks1(keyWord);

        dataObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bookData ->
                {
                    List<Item> items = new ArrayList<>();
                    items.addAll(bookData.getItems());

                    bookView.hideLoadingIndicator();

                    if (items.isEmpty()) bookView.setEmptyResponseText("There is no books");
                    else if (isUpdate) bookView.updateBooksListView(items);
                    else bookView.setBooksListViewData(items);
                });

    }
}
