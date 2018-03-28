package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List<Resume> storageList = new ArrayList<>();

    @Override
    protected void deleteElement(int positionNumber) {

    }

    @Override
    protected void saveElement(Resume r, int positionNumber) {

    }

    @Override
    protected void updateElement(Resume r, int positionNumber) {

    }

    @Override
    protected Resume getElement(int positionNumber) {
        return storageList.get(positionNumber);
    }

    @Override
    protected int getPositionNumber(String uuid) {
        for (int i = 0; i < storageList.size(); i++) {
            if (storageList.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }
}
