package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {

    private static final String UUID_1 = "uuid1";
    private static final Resume R1 = new Resume(UUID_1);

    private static final String UUID_2 = "uuid2";
    private static final Resume R2 = new Resume(UUID_2);

    private static final String UUID_3 = "uuid3";
    private static final Resume R3 = new Resume(UUID_3);

    private static final String UUID_4 = "uuid4";
    private static final Resume R4 = new Resume(UUID_4);

    private Storage storage;

    protected AbstractArrayStorageTest(Storage storage) {
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
        assertEquals(3, storage.size());
        assertEquals(R3, storage.get(UUID_3));
    }

    @Test(expected = StorageException.class)
    public void storageIsOverflow() {
        int limit = AbstractArrayStorage.getStorageLimit();
        try {
            for (int i = 3; i < limit; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            fail("ERROR: storage is overflow!");
        }
        storage.save(new Resume());
        assertEquals(AbstractArrayStorage.getStorageLimit(), storage.size());
    }

    @Test
    public void update() {
        Resume r = new Resume("uuid1");
        storage.update(r);
        assertEquals(r, storage.get(UUID_1));
        assertEquals(3, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void updateIsNotExist() {
        Resume magicR = new Resume("magic_uuid");
        storage.update(magicR);
        assertEquals(3, storage.size());
    }

    @Test
    public void delete() {
        storage.delete("uuid3");
        assertEquals(2, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteIsNotExist() {
        storage.delete("uuid4");
        assertEquals(3, storage.size());
    }

    @Test
    public void getAll() {
        Resume[] testArray = storage.getAll();
        assertEquals(3, testArray.length);
        assertEquals(R1, testArray[0]);
        assertEquals(R2, testArray[1]);
        assertEquals(R3, testArray[2]);
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void get() {
        assertEquals("uuid1", storage.get("uuid1").toString());
        assertEquals(3, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void getIsNotExist() {
        storage.get("uuid4");
        assertEquals(3, storage.size());
    }
}