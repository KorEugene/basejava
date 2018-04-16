package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List<Resume> storageList = new ArrayList<>();

    @Override
    protected void deleteElement(Object keyUuid) {
        storageList.remove(((Integer) (keyUuid)).intValue());
    }

    @Override
    protected void saveElement(Resume r, Object keyUuid) {
        storageList.add(r);
    }

    @Override
    protected void updateElement(Resume r, Object keyUuid) {
        storageList.set((Integer) keyUuid, r);
    }

    @Override
    protected Resume getElement(Object keyUuid) {
        return storageList.get((Integer) keyUuid);
    }

    @Override
    protected Object getKeyByUuid(String uuid) {
        for (int i = 0; i < storageList.size(); i++) {
            if (storageList.get(i).getUuid().equals(uuid)) {
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
    public List<Resume> getAllSorted() {
        List<Resume> sortedList = new ArrayList<>(storageList);
        Collections.sort(sortedList);
        return sortedList;
    }

    @Override
    public int size() {
        return storageList.size();
    }

    @Override
    protected boolean isExist(Object keyUuid) {
        return (Integer) keyUuid != -1;
    }
}
