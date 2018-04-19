package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import static java.lang.System.arraycopy;
import static java.util.Arrays.binarySearch;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void deleteResume(int keyUuid) {
        int numMoved = size - keyUuid - 1;
        if (numMoved > 0) {
            arraycopy(storage, keyUuid + 1, storage, keyUuid, numMoved);
        }
    }

    @Override
    protected void addNewResume(Resume r, int keyUuid) {
        keyUuid = (keyUuid + 1) * -1;
        // because by default storage is empty i have to use storage.length instead of size or outOfBoundException
        arraycopy(storage, keyUuid, storage, keyUuid + 1, storage.length - keyUuid - 1);
        storage[keyUuid] = r;
    }

    @Override
    protected Integer getKeyByUuid(String uuid) {
        Resume searchKey = new Resume(uuid, "Employee");
        return binarySearch(storage, 0, size, searchKey);
    }
}
