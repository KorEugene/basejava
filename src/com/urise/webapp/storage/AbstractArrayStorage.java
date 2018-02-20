package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int positionNumber = getIndex(uuid);
        if (positionNumber == -1) {
            System.out.println("\n" + "ERROR: the resume doesn't exist!" + "\n");
            return null;
        }
        return storage[positionNumber];
    }

    protected abstract int getIndex(String uuid);
}
