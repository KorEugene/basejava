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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListSection that = (ListSection) o;

        return elementsOfSection.equals(that.elementsOfSection);
    }

    @Override
    public int hashCode() {
        return elementsOfSection.hashCode();
    }
}
