package com.urise.webapp.exception;

public class NotExistStorageException extends StorageException {

    public NotExistStorageException(String uuid) {
        super("ERROR: the resume " + uuid + " doesn't exist!", uuid);
    }
}
