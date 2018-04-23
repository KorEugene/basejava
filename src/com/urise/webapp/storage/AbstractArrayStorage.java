package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {

    private static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    protected int size = 0;

    protected abstract void deleteResume(int keyUuid);

    protected abstract void addNewResume(Resume r, int keyUuid);

    public static int getStorageLimit() {
        return STORAGE_LIMIT;
    }

    @Override
    public void updateElement(Resume r, Integer keyUuid) {
        storage[keyUuid] = r;
    }

    @Override
    public void saveElement(Resume r, Integer keyUuid) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("ERROR: storage is overflow!", r.getUuid());
        } else {
            addNewResume(r, keyUuid);
            size++;
        }
    }

    @Override
    public void deleteElement(Integer keyUuid) {
        deleteResume(keyUuid);
        storage[size - 1] = null;
        size--;
    }

    @Override
    public Resume getElement(Integer keyUuid) {
        return storage[keyUuid];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<Resume> copyElements() {
        Resume[] copyOfArray = Arrays.copyOfRange(storage, 0, size);
        return Arrays.asList(copyOfArray);
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected boolean isExist(Integer keyUuid) {
        return keyUuid >= 0;
    }
}
