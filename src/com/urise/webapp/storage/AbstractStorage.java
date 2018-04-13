package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume r) {
        Object keyUuid = getKeyByUuid(r.getUuid());
        if (!isExist(keyUuid)) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            updateElement(r, keyUuid);
        }
    }

    public void save(Resume r) {
        Object keyUuid = getKeyByUuid(r.getUuid());
        if (isExist(keyUuid)) {
            throw new ExistStorageException(r.getUuid());
        } else {
            saveElement(r, keyUuid);
        }
    }

    public void delete(String uuid) {
        Object keyUuid = getKeyByUuid(uuid);
        if (!isExist(keyUuid)) {
            throw new NotExistStorageException(uuid);
        } else {
            deleteElement(keyUuid);
        }
    }

    public Resume get(String uuid) {
        Object keyUuid = getKeyByUuid(uuid);
        if (!isExist(keyUuid)) {
            throw new NotExistStorageException(uuid);
        }
        return getElement(keyUuid);
    }

    protected abstract boolean isExist(Object keyUuid);

    protected abstract void deleteElement(Object keyUuid);

    protected abstract void saveElement(Resume r, Object keyUuid);

    protected abstract void updateElement(Resume r, Object keyUuid);

    protected abstract Resume getElement(Object keyUuid);

    protected abstract Object getKeyByUuid(String uuid);
}
