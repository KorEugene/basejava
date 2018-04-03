package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void deleteResume(int positionNumber) {
        storage[positionNumber] = storage[size - 1];
    }

    @Override
    protected void addNewResume(Resume r, int positionNumber) {
        storage[size] = r;
    }

    @Override
    protected Object getPositionNumber(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
