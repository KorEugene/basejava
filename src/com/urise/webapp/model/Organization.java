package com.urise.webapp.model;

import java.time.LocalDate;

public class Organization {

    private final String nameOfOrganization;

    private final LocalDate start;

    private final LocalDate end;

    private final String content;

    public Organization(String nameOfOrganization, LocalDate start, LocalDate end, String content) {
        this.nameOfOrganization = nameOfOrganization;
        this.start = start;
        this.end = end;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Organization that = (Organization) o;

            if (!nameOfOrganization.equals(that.nameOfOrganization)) return false;
            if (!start.equals(that.start)) return false;
            if (!end.equals(that.end)) return false;
            return content.equals(that.content);
    }

    @Override
    public int hashCode() {
        int result = nameOfOrganization.hashCode();
        result = 31 * result + start.hashCode();
        result = 31 * result + end.hashCode();
        result = 31 * result + content.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "nameOfOrganization='" + nameOfOrganization + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", content='" + content + '\'' +
                '}';
    }
}
