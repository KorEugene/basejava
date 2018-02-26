package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import static java.lang.System.arraycopy;
import static java.util.Arrays.binarySearch;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume r) {
        int positionNumber = getIndex(r.getUuid());
        if (positionNumber > 0) {
            System.out.println("\n" + "ERROR: the resume is already exist!" + "\n");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("\n" + "ERROR: storage is overflow!" + "\n");
        } else {
            positionNumber = (positionNumber + 1) * -1;
            // because by default storage is empty i have to use storage.length instead of size or outOfBoundException
            arraycopy(storage, positionNumber, storage, positionNumber + 1, storage.length - positionNumber - 1);
            storage[positionNumber] = r;
            size++;
        }
    }

    @Override
    public void delete(String uuid) {
        int positionNumber = getIndex(uuid);
        if (positionNumber < 0) {
            System.out.println("\n" + "ERROR: the resume doesn't exist!" + "\n");
        } else {
            arraycopy(storage, positionNumber + 1, storage, positionNumber, size - positionNumber - 1);
            size--;
        }
    }


    @Override
    public int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return binarySearch(storage, 0, size, searchKey);
    }
}
