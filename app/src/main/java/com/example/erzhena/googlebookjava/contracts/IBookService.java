package com.example.erzhena.googlebookjava.contracts;

import com.example.erzhena.googlebookjava.model.entity.BookData;

import retrofit2.http.GET;
import rx.Observable;

public interface IBookService {
    @GET("?q=flowers")
    Observable<BookData> getBooksData();
}
