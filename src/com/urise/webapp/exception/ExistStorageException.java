package com.urise.webapp.exception;

public class ExistStorageException extends StorageException {

    public ExistStorageException(String uuid) {
        super("ERROR: the resume " + uuid + " is already exist!", uuid);
    }
}
