package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {

    private static final int STORAGE_LIMIT = 10000;

    public static int getStorageLimit() {
        return STORAGE_LIMIT;
    }

    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    protected int size = 0;

    public int size() {
        return size;
    }

    public void updateResume(Resume r) {
        storage[getPositionNumber(r.getUuid())] = r;
    }

    public void saveResume(Resume r) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("ERROR: storage is overflow!", r.getUuid());
        } else {
            addNewResume(r, getPositionNumber(r.getUuid()));
            size++;
        }
    }

    public void deleteResume(String uuid) {
        deleteResume(getPositionNumber(uuid));
        storage[size - 1] = null;
        size--;
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

    public Resume getResume(String uuid) {
        return storage[getPositionNumber(uuid)];
    }

    protected abstract void deleteResume(int positionNumber);

    protected abstract void addNewResume(Resume r, int positionNumber);

}
