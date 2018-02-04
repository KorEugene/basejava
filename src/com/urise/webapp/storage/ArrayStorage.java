package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];

    private int size = 0;

    private int resumePosition = -1;

    public void clear() {
        storage = new Resume[10000];
        size = 0;
    }

    public void update(Resume r) {
        if (resumeIsPresent(r)) {
            storage[resumePosition] = r;
            // or change some other field in Resume, like
            // storage[resumePosition].setUuid(r.getUuid());
        } else {
            System.out.println("\n" + "ERROR: the resume doesn't exist!" + "\n");
        }
    }

    public void save(Resume r) {
        if (resumeIsPresent(r)) {
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
        if (resumeIsPresent(uuid)) {
            result = storage[resumePosition];
        } else {
            System.out.println("\n" + "ERROR: the resume doesn't exist!" + "\n");
        }
        return result;
    }

    public void delete(String uuid) {
        if (resumeIsPresent(uuid)) {
            storage[resumePosition] = storage[size - 1];
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

    private boolean resumeIsPresent(Resume r) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(r.getUuid())) {
                resumePosition = i;
                return true;
            }
        }
        return false;
    }

    private boolean resumeIsPresent(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                resumePosition = i;
                return true;
            }
        }
        return false;
    }
}
