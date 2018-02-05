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
        int positionNumber = resumeIsPresent(r.getUuid());
        if (positionNumber >= 0) {
            storage[positionNumber] = r;
        } else {
            System.out.println("\n" + "ERROR: the resume doesn't exist!" + "\n");
        }
    }

    public void save(Resume r) {
        int positionNumber = resumeIsPresent(r.getUuid());
        if (positionNumber >= 0) {
            System.out.println("\n" + "ERROR: the resume is already exist!" + "\n");
        } else {
            if (size <= storage.length) {
                storage[size] = r;
                size++;
            } else {
                System.out.println("\n" + "ERROR: storage is overflow!" + "\n");
            }
        }
    }

    public Resume get(String uuid) {
        Resume result = null;
        int positionNumber = resumeIsPresent(uuid);
        if (positionNumber >= 0) {
            result = storage[positionNumber];
        } else {
            System.out.println("\n" + "ERROR: the resume doesn't exist!" + "\n");
        }
        return result;
    }

    public void delete(String uuid) {
        int positionNumber = resumeIsPresent(uuid);
        if (positionNumber >= 0) {
            storage[positionNumber] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("\n" + "ERROR: the resume doesn't exist!" + "\n");
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

    private int resumeIsPresent(String uuid) {
        int resumePosition = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                resumePosition = i;
            }
        }
        return resumePosition;
    }
}
