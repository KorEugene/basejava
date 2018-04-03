package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List<Resume> storageList = new ArrayList<>();

    @Override
    protected void deleteElement(Object positionNumber) {
        storageList.remove(positionNumber);
    }

    @Override
    protected void saveElement(Resume r, Object positionNumber) {
        storageList.add(r);
    }

    @Override
    protected void updateElement(Resume r, Object positionNumber) {
        storageList.set((Integer) positionNumber, r);
    }

    @Override
    protected Resume getElement(Object positionNumber) {
        return storageList.get((Integer) positionNumber);
    }

    @Override
    protected Object getPositionNumber(Object o) {
        for (int i = 0; i < storageList.size(); i++) {
            if (storageList.get(i).getUuid().equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        storageList.clear();
    }

    @Override
    public Resume[] getAll() {
        return storageList.toArray(new Resume[storageList.size()]);
    }

    @Override
    public int size() {
        return storageList.size();
    }
}
