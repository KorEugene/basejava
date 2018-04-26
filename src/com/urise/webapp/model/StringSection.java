package com.urise.webapp.model;

public class StringSection extends Section {

    private final String content;

    public StringSection(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }
}
