package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    Map<String, Resume> map = new HashMap<>();

    @Override
    protected void deleteElement(Object keyUuid) {

    }

    @Override
    protected void saveElement(Resume r, Object keyUuid) {

    }

    @Override
    protected void updateElement(Resume r, Object keyUuid) {

    }

    @Override
    protected Resume getElement(Object keyUuid) {
        return null;
    }

    @Override
    protected Object getKeyByUuid(String uuid) {
        return null;
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

    @Override
    protected boolean isExist(Object keyUuid) {
        return false;
    }
}
