package com.example.bogusz.eartraining.database;

/**
 * Created by bogusz on 09.09.17.
 */

public class CardQuest {

    private int id;
    private String title;
    private String content;
    private String button;

    public CardQuest(int id, String title, String content, String button) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.button = button;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }
}
