package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];

    private int size = 0;

    public void clear() {
        storage = new Resume[10000];
        size = 0;
    }

    public void update(Resume r) {
        int positionNumber = getIndex(r.getUuid());
        if (positionNumber == -1) {
            System.out.println("\n" + "ERROR: the resume doesn't exist!" + "\n");
        } else {
            storage[positionNumber] = r;
        }
    }

    public void save(Resume r) {
        if (getIndex(r.getUuid()) != -1) {
            System.out.println("\n" + "ERROR: the resume is already exist!" + "\n");
        } else if (size == storage.length) {
            System.out.println("\n" + "ERROR: storage is overflow!" + "\n");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        int positionNumber = getIndex(uuid);
        if (positionNumber == -1) {
            System.out.println("\n" + "ERROR: the resume doesn't exist!" + "\n");
            return null;
        }
        return storage[positionNumber];
    }

    public void delete(String uuid) {
        int positionNumber = getIndex(uuid);
        if (positionNumber == -1) {
            System.out.println("\n" + "ERROR: the resume doesn't exist!" + "\n");
        } else {
            storage[positionNumber] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] currentStorage = new Resume[size];
        System.arraycopy(storage, 0, currentStorage, 0, size);
        return currentStorage;
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
