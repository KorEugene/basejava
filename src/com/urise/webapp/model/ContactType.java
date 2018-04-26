package com.urise.webapp.model;

public enum ContactType {
    PHONE_NUMBER("Телефон"),
    SKYPE("Skype"),
    E_MAIL("Электронная почта"),
    LINKEDIN("Профиль LinkedIn"),
    GITHUB("Профиль GitHub"),
    STACKOVERFLOW("Профиль StackOverFlow"),
    HOME_PAGE("Домашняя станица");

    private final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
