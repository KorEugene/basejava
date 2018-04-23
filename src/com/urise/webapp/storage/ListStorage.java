package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {

    private List<Resume> storageList = new ArrayList<>();

    @Override
    protected void deleteElement(Integer keyUuid) {
        storageList.remove(keyUuid.intValue());
    }

    @Override
    protected void saveElement(Resume r, Integer keyUuid) {
        storageList.add(r);
    }

    @Override
    protected void updateElement(Resume r, Integer keyUuid) {
        storageList.set(keyUuid, r);
    }

    @Override
    protected Resume getElement(Integer keyUuid) {
        return storageList.get(keyUuid);
    }

    @Override
    protected Integer getKeyByUuid(String uuid) {
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
    public List<Resume> copyElements() {
        return new ArrayList<>(storageList);
    }

    @Override
    public int size() {
        return storageList.size();
    }

    @Override
    protected boolean isExist(Integer keyUuid) {
        return keyUuid != -1;
    }
}
