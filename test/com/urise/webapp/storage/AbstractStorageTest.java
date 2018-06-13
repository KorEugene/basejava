package com.urise.webapp.storage;

import com.urise.webapp.Config;
import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.ContactType;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.urise.webapp.TestData.*;
import static org.junit.Assert.assertEquals;

public class AbstractStorageTest {

    protected static final File STORAGE_DIR = Config.getInstance().getStorageDir();

    protected Storage storage;


    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void save() {
        storage.save(R4);
        assertEquals(4, storage.size());
        assertEquals(R4, storage.get(UUID_4));
    }

    @Test(expected = ExistStorageException.class)
    public void saveAlreadyExist() {
        storage.save(R3);
    }

    @Test
    public void update() {
        Resume r = new Resume(UUID_1, "Employee");
        R1.addContact(ContactType.E_MAIL, "mail@google.com");
        R1.addContact(ContactType.SKYPE, "NewSkype");
        R1.addContact(ContactType.PHONE_NUMBER, "+7 921 222-22-22");
        storage.update(r);
        assertEquals(r, storage.get(UUID_1));
        assertEquals(3, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void updateIsNotExist() {
        Resume magicR = new Resume("magic_uuid", "magic_employee");
        storage.update(magicR);
    }

    @Test
    public void delete() {
        storage.delete(UUID_3);
        assertEquals(2, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteIsNotExist() {
        storage.delete("uuid4");
    }

    @Test
    public void getAllSorted() {
        List<Resume> list = storage.getAllSorted();
        assertEquals(3, list.size());
        List<Resume> sortedResumes = Arrays.asList(R1, R2, R3);
        Collections.sort(sortedResumes);
        assertEquals(sortedResumes, list);
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void get() {
        assertEquals(R1, storage.get(R1.getUuid()));
        assertEquals(R2, storage.get(R2.getUuid()));
        assertEquals(R3, storage.get(R3.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void getIsNotExist() {
        storage.get("uuid4");
    }
}
