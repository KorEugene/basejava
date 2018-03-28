package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume r) {
        if (!isExist(r.getUuid())) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            updateResume(r);
        }
    }

    public void save(Resume r) {
        if (isExist(r.getUuid())) {
            throw new ExistStorageException(r.getUuid());
        } else {
            saveResume(r);
        }
    }

    public void delete(String uuid) {
        if (!isExist(uuid)) {
            throw new NotExistStorageException(uuid);
        } else {
            deleteResume(uuid);
        }
    }

    public Resume get(String uuid) {
        if (!isExist(uuid)) {
            throw new NotExistStorageException(uuid);
        }
        return getResume(uuid);
    }

    protected boolean isExist(String uuid) {
        return getPositionNumber(uuid) > 0;
    }

    protected abstract void deleteResume(String uuid);

    protected abstract void saveResume(Resume r);

    protected abstract void updateResume(Resume r);

    protected abstract Resume getResume(String uuid);

    protected abstract int getPositionNumber(String uuid);
}
