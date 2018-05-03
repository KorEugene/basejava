package com.urise.webapp;

import com.urise.webapp.model.ContactType;
import com.urise.webapp.model.Resume;
import com.urise.webapp.model.SectionType;

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
        out.println(testResume.getContact(ContactType.PHONE_NUMBER));
        out.println(testResume.getSections(SectionType.PERSONAL));

    }
}

