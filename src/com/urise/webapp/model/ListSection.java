package com.urise.webapp.model;

import java.util.List;

public class ListSection extends Section {

    private final List<String> elementsOfSection;

    public ListSection(List<String> elementsOfSection) {
        this.elementsOfSection = elementsOfSection;
    }

    public List<String> getElementsOfSection() {
        return elementsOfSection;
    }

    @Override
    public String toString() {
        return elementsOfSection.toString();
    }
}
