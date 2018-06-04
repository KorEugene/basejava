package com.urise.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class HyperLink implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;

    private String url;

    public HyperLink() {
    }

    public HyperLink(String title, String url) {
        Objects.requireNonNull(title, "title must not be null");
        this.title = title;
        this.url = url == null ? "" : url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "HyperLink{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HyperLink hyperLink = (HyperLink) o;

        if (!title.equals(hyperLink.title)) return false;
        return url != null ? url.equals(hyperLink.url) : hyperLink.url == null;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
