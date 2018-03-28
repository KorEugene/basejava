package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume r) {
        String keyUuid = r.getUuid();
        if (!isExist(keyUuid)) {
            throw new NotExistStorageException(keyUuid);
        } else {
            updateElement(r, getPositionNumber(keyUuid));
        }
    }

    public void save(Resume r) {
        String keyUuid = r.getUuid();
        if (isExist(keyUuid)) {
            throw new ExistStorageException(keyUuid);
        } else {
            saveElement(r, getPositionNumber(keyUuid));
        }
    }

    public void delete(String uuid) {
        if (!isExist(uuid)) {
            throw new NotExistStorageException(uuid);
        } else {
            deleteElement(getPositionNumber(uuid));
        }
    }

    public Resume get(String uuid) {
        if (!isExist(uuid)) {
            throw new NotExistStorageException(uuid);
        }
        return getElement(getPositionNumber(uuid));
    }

    private boolean isExist(String uuid) {
        return getPositionNumber(uuid) >= 0;
    }

    protected abstract void deleteElement(int positionNumber);

    protected abstract void saveElement(Resume r, int positionNumber);

    protected abstract void updateElement(Resume r, int positionNumber);

    protected abstract Resume getElement(int positionNumber);

    protected abstract int getPositionNumber(String uuid);
}
