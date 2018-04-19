package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {

    private static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    protected int size = 0;

    public static int getStorageLimit() {
        return STORAGE_LIMIT;
    }

    @Override
    public void updateElement(Resume r, Object keyUuid) {
        storage[(Integer) keyUuid] = r;
    }

    @Override
    public void saveElement(Resume r, Object keyUuid) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("ERROR: storage is overflow!", r.getUuid());
        } else {
            addNewResume(r, (Integer) keyUuid);
            size++;
        }
    }

    @Override
    public void deleteElement(Object keyUuid) {
        deleteResume((Integer) keyUuid);
        storage[size - 1] = null;
        size--;
    }

    @Override
    public Resume getElement(Object keyUuid) {
        return storage[(Integer) keyUuid];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<Resume> sortElements() {
        Resume[] copyOfArray = Arrays.copyOfRange(storage, 0, size);
        return Arrays.asList(copyOfArray);
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected boolean isExist(Object keyUuid) {
        return (Integer) keyUuid >= 0;
    }

    protected abstract void deleteResume(int keyUuid);

    protected abstract void addNewResume(Resume r, int keyUuid);
}
