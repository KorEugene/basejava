package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected void deleteElement(Object keyUuid) {
        map.remove(keyUuid);
    }

    @Override
    protected void saveElement(Resume r, Object keyUuid) {
        map.put((String) keyUuid, r);
    }

    @Override
    protected void updateElement(Resume r, Object keyUuid) {
        map.replace((String) keyUuid, r);
    }

    @Override
    protected Resume getElement(Object keyUuid) {
        return map.get(keyUuid);
    }

    @Override
    protected String getKeyByUuid(String uuid) {
        return uuid;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> sortElements() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    protected boolean isExist(Object keyUuid) {
        return map.containsKey(keyUuid);
    }
}
