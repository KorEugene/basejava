package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void deleteResume(int keyUuid) {
        storage[keyUuid] = storage[size - 1];
    }

    @Override
    protected void addNewResume(Resume r, int keyUuid) {
        storage[size] = r;
    }

    @Override
    protected Object getKeyByUuid(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
