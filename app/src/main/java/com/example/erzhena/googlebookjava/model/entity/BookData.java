package com.example.erzhena.googlebookjava.model.entity;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookData {
        @SerializedName("kind")
        @Expose
        private String kind;

        @SerializedName("totalItems")
        @Expose
        private Integer totalItems;

        @SerializedName("items")
        @Expose
        private List<Item> items = new ArrayList<>();

        public String getKind() {return kind;}

        public int getTotalItems() {return totalItems;}

        public List<Item> getItems() {
            return items;
        }

        public void setFeatures(List<Item> items) {
            this.items = items;
        }

}

