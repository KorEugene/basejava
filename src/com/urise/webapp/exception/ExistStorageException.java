package com.urise.webapp.exception;

public class ExistStorageException extends StorageException {

    public ExistStorageException(String uuid) {
        super("\"\\n\" + \"ERROR: the resume " + uuid + " is already exist!\" + \"\\n\"", uuid);
    }
}
