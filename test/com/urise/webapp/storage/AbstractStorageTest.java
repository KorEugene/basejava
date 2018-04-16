package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AbstractStorageTest {

    private static final String UUID_1 = "uuid1";
    private static final String NAME_1 = "name1";
    private static final Resume R1 = new Resume(UUID_1, NAME_1);

    private static final String UUID_2 = "uuid2";
    private static final String NAME_2 = "name2";
    private static final Resume R2 = new Resume(UUID_2, NAME_2);

    private static final String UUID_3 = "uuid3";
    private static final String NAME_3 = "name3";
    private static final Resume R3 = new Resume(UUID_3, NAME_3);

    private static final String UUID_4 = "uuid4";
    private static final String NAME_4 = "name4";
    private static final Resume R4 = new Resume(UUID_4, NAME_4);

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
        Resume r = new Resume("uuid1", "Employee");
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
        storage.delete("uuid3");
        assertEquals(2, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteIsNotExist() {
        storage.delete("uuid4");
    }

    @Test
    public void getAllSorted() {
        List<Resume> testArray = storage.getAllSorted();
        assertEquals(3, testArray.size());
        assertEquals(R1, testArray.get(0));
        assertEquals(R2, testArray.get(1));
        assertEquals(R3, testArray.get(2));
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void get() {
        assertEquals("uuid1 name1", storage.get("uuid1").toString());
        assertEquals(3, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void getIsNotExist() {
        storage.get("uuid4");
    }
}
