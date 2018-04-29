package com.urise.webapp.model;

import java.util.List;

public class OrganizationSection extends Section {

    private final List<Organization> organizations;

    public OrganizationSection(List<Organization> organizations) {
        this.organizations = organizations;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    @Override
    public String toString() {
        return organizations.toString();
    }
}
