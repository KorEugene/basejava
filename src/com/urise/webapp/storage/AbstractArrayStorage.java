package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

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
    public void updateElement(Resume r, int positionNumber) {
        storage[positionNumber] = r;
    }

    @Override
    public void saveElement(Resume r, int positionNumber) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("ERROR: storage is overflow!", r.getUuid());
        } else {
            addNewResume(r, positionNumber);
            size++;
        }
    }

    @Override
    public void deleteElement(int positionNumber) {
        deleteResume(positionNumber);
        storage[size - 1] = null;
        size--;
    }

    @Override
    public Resume getElement(int positionNumber) {
        return storage[positionNumber];
    }

    public int size() {
        return size;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    protected abstract void deleteResume(int positionNumber);

    protected abstract void addNewResume(Resume r, int positionNumber);

}
