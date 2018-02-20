package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void clear() {
        Arrays.fill(storage, 0, size, null);
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
        } else if (size == STORAGE_LIMIT) {
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
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
