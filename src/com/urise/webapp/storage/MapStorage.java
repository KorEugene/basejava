package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    Map<String, Resume> map = new HashMap<>();

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
        return null;
    }

    @Override
    protected int getPositionNumber(String uuid) {
        return 0;
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
