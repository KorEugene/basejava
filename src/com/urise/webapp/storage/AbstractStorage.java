package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume r) {
        String keyUuid = r.getUuid();
        if ((Integer) getPositionNumber(keyUuid) < 0) {
            throw new NotExistStorageException(keyUuid);
        } else {
            updateElement(r, getPositionNumber(keyUuid));
        }
    }

    public void save(Resume r) {
        String keyUuid = r.getUuid();
        if ((Integer) getPositionNumber(keyUuid) > 0) {
            throw new ExistStorageException(keyUuid);
        } else {
            saveElement(r, getPositionNumber(keyUuid));
        }
    }

    public void delete(String uuid) {
        if ((Integer) getPositionNumber(uuid) < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            deleteElement(getPositionNumber(uuid));
        }
    }

    public Resume get(String uuid) {
        if ((Integer) getPositionNumber(uuid) < 0) {
            throw new NotExistStorageException(uuid);
        }
        return getElement(getPositionNumber(uuid));
    }

//    private boolean isExist(Object o) {
//        return getPositionNumber(o) >= 0;
//    }

    protected abstract void deleteElement(Object positionNumber);

    protected abstract void saveElement(Resume r, Object positionNumber);

    protected abstract void updateElement(Resume r, Object positionNumber);

    protected abstract Resume getElement(Object positionNumber);

    protected abstract Object getPositionNumber(Object o);
}
