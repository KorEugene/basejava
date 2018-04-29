package com.urise.webapp.model;

import java.util.Date;

public class Organization {

    private final String nameOfOrganization;

    private final Date start;

    private final Date end;

    private final String content;

    public Organization(String nameOfOrganization, Date start, Date end, String content) {
        this.nameOfOrganization = nameOfOrganization;
        this.start = start;
        this.end = end;
        this.content = content;
    }

    public String getNameOfOrganization() {
        return nameOfOrganization;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public String getContent() {
        return content;
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
