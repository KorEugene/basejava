package com.urise.webapp.storage.serializer;

import com.urise.webapp.model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface StreamSerializer {

    void writeElement(Resume r, OutputStream os) throws IOException;

    Resume readElement(InputStream is) throws IOException;

}
