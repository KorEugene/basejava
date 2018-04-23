package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {

    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected abstract boolean isExist(SK keyUuid);

    protected abstract void deleteElement(SK keyUuid);

    protected abstract void saveElement(Resume r, SK keyUuid);

    protected abstract void updateElement(Resume r, SK keyUuid);

    protected abstract Resume getElement(SK keyUuid);

    protected abstract SK getKeyByUuid(String uuid);

    protected abstract List<Resume> copyElements();

    public void update(Resume r) {
        LOG.info("Update " + r);
        SK keyUuid = getKeyByUuid(r.getUuid());
        if (!isExist(keyUuid)) {
            LOG.warning("ERROR: the resume " + r + " doesn't exist!");
            throw new NotExistStorageException(r.getUuid());
        } else {
            updateElement(r, keyUuid);
        }
    }

    public void save(Resume r) {
        LOG.info("Save " + r);
        SK keyUuid = getKeyByUuid(r.getUuid());
        if (isExist(keyUuid)) {
            LOG.warning("ERROR: the resume " + r + " is already exist!");
            throw new ExistStorageException(r.getUuid());
        } else {
            saveElement(r, keyUuid);
        }
    }

    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        SK keyUuid = getKeyByUuid(uuid);
        if (!isExist(keyUuid)) {
            LOG.warning("ERROR: the resume " + uuid + " doesn't exist!");
            throw new NotExistStorageException(uuid);
        } else {
            deleteElement(keyUuid);
        }
    }

    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        SK keyUuid = getKeyByUuid(uuid);
        if (!isExist(keyUuid)) {
            LOG.warning("ERROR: the resume " + uuid + " doesn't exist!");
            throw new NotExistStorageException(uuid);
        }
        return getElement(keyUuid);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public List<Resume> getAllSorted() {
        LOG.info("getAllSorted");
        List<Resume> sortedList = copyElements();
        Collections.sort(sortedList);
        return sortedList;
    }
}
