package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import static java.lang.System.arraycopy;
import static java.util.Arrays.binarySearch;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void deleteResume(int positionNumber) {
        int numMoved = size - positionNumber - 1;
        if (numMoved > 0) {
            arraycopy(storage, positionNumber + 1, storage, positionNumber, numMoved);
        }
    }

    @Override
    protected void addNewResume(Resume r, int positionNumber) {
        positionNumber = (positionNumber + 1) * -1;
        // because by default storage is empty i have to use storage.length instead of size or outOfBoundException
        arraycopy(storage, positionNumber, storage, positionNumber + 1, storage.length - positionNumber - 1);
        storage[positionNumber] = r;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return binarySearch(storage, 0, size, searchKey);
    }
}
