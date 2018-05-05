package com.urise.webapp.model;

import java.time.LocalDate;

public class Organization {

    private final HyperLink webPage;

    private final String nameOfOrganization;

    private final LocalDate start;

    private final LocalDate end;

    private final String content;

    public Organization(HyperLink webPage, String nameOfOrganization, LocalDate start, LocalDate end, String content) {
        this.webPage = webPage;
        this.nameOfOrganization = nameOfOrganization;
        this.start = start;
        this.end = end;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "webPage=" + webPage +
                ", nameOfOrganization='" + nameOfOrganization + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!webPage.equals(that.webPage)) return false;
        if (!nameOfOrganization.equals(that.nameOfOrganization)) return false;
        if (!start.equals(that.start)) return false;
        if (!end.equals(that.end)) return false;
        return content != null ? content.equals(that.content) : that.content == null;
    }

    @Override
    public int hashCode() {
        int result = webPage.hashCode();
        result = 31 * result + nameOfOrganization.hashCode();
        result = 31 * result + start.hashCode();
        result = 31 * result + end.hashCode();
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
