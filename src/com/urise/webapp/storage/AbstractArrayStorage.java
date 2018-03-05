package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
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
        int positionNumber = getIndex(r.getUuid());
        if (positionNumber != -1) {
            System.out.println("\n" + "ERROR: the resume is already exist!" + "\n");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("\n" + "ERROR: storage is overflow!" + "\n");
        } else {
            addNewResume(r, positionNumber);
            size++;
        }
    }

    public void delete(String uuid) {
        int positionNumber = getIndex(uuid);
        if (positionNumber == -1) {
            System.out.println("\n" + "ERROR: the resume doesn't exist!" + "\n");
        } else {
            deleteResume(positionNumber);
            storage[size - 1] = null;
            size--;
        }
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

    public Resume get(String uuid) {
        int positionNumber = getIndex(uuid);
        if (positionNumber == -1) {
            System.out.println("\n" + "ERROR: the resume doesn't exist!" + "\n");
            return null;
        }
        return storage[positionNumber];
    }

    protected abstract void deleteResume(int positionNumber);

    protected abstract void addNewResume(Resume r, int positionNumber);

    protected abstract int getIndex(String uuid);
}
