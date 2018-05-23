package com.urise.webapp.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ListSection extends Section {

    private static final long serialVersionUID = 1L;

    private List<String> elementsOfSection;

    public ListSection() {
    }

    public ListSection(String... elementsOfSection) {
        this(Arrays.asList(elementsOfSection));
    }

    public ListSection(List<String> elementsOfSection) {
        Objects.requireNonNull(elementsOfSection, "elementsOfSection must not be null");
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
