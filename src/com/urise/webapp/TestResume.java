package com.urise.webapp;

import com.urise.webapp.model.ContactType;
import com.urise.webapp.model.HyperLink;
import com.urise.webapp.model.ListSection;
import com.urise.webapp.model.Organization;
import com.urise.webapp.model.OrganizationSection;
import com.urise.webapp.model.Resume;
import com.urise.webapp.model.SectionType;
import com.urise.webapp.model.StringSection;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import static java.lang.System.out;

public class TestResume {

    public static void main(String[] args) {

        Resume testResume = new Resume("uuid", "Joshua Bloch");

        out.println(testResume.toString());
        out.println("\n");
        out.println("Uuid: " + testResume.getUuid());
        out.println("FullName: " + testResume.getFullName());
        out.println("Contacts: " + Arrays.toString(ContactType.values()));
        out.println("Sections: " + Arrays.toString(SectionType.values()));

        out.println("\n");
        testResume.getContacts().put(ContactType.PHONE_NUMBER, "+79993332211");

        StringSection strSec = new StringSection("Clever");
        testResume.getSections().put(SectionType.PERSONAL, new StringSection("Smart"));

        String[] testStrArr = new String[]{"Money", "Work", "Education"};
        testResume.getSections().put(SectionType.OBJECTIVE, new ListSection(Arrays.asList(testStrArr)));

        Organization testOrg1 = new Organization(new HyperLink("HomePage", "https://homepage.com"), "OAO", LocalDate.of(2016, Month.NOVEMBER, 30), LocalDate.of(2017, Month.DECEMBER, 30), "Good");
        Organization testOrg2 = new Organization(new HyperLink("HomePage", null), "OOO", LocalDate.of(2015, Month.OCTOBER, 29), LocalDate.of(2016, Month.NOVEMBER, 29), "Bad");
        Organization[] testOrgArr = new Organization[]{testOrg1, testOrg2};
        testResume.getSections().put(SectionType.EXPERIENCE, new OrganizationSection(Arrays.asList(testOrgArr)));

        out.println("\n");
        out.println("PHONE_NUMBER: " + testResume.getContact(ContactType.PHONE_NUMBER));
        out.println("PERSONAL: " + testResume.getSection(SectionType.PERSONAL));
        out.println("OBJECTIVE: " + testResume.getSection(SectionType.OBJECTIVE));
        out.println("EDUCATION: " + testResume.getSection(SectionType.EXPERIENCE));
        out.println("String content: " + strSec.getContent());

    }
}

