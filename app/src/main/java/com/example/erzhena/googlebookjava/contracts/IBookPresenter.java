package com.example.erzhena.googlebookjava.contracts;

public interface IBookPresenter {
    void getDefaultBooksData(boolean isUpdate);

    void getSearchBookData(boolean isUpdate, String keyWord);
}
