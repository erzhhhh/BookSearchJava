package com.example.erzhena.googlebookjava.contracts;

import com.example.erzhena.googlebookjava.model.entity.BookData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface IBookService {
    @GET("?q=android")
    Observable<BookData> getDefaultBooksData();

    @GET("?maxResults=30")
    Observable<BookData> getSearchBooksData(@Query("q") String searchQuery);

}
