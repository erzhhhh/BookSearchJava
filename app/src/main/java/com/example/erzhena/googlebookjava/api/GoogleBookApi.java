package com.example.erzhena.googlebookjava.api;

import com.example.erzhena.googlebookjava.contracts.IBookService;
import com.example.erzhena.googlebookjava.model.entity.BookData;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class GoogleBookApi {

    public Observable<BookData> getBooks() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.googleapis.com/books/v1/volumes/")
                .build();

        IBookService bookService = retrofit.create(IBookService.class);

        return bookService.getBooksData();
    }
}