package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
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
    }
}