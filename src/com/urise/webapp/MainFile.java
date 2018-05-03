package com.urise.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static java.lang.System.out;

public class MainFile {

    public static void main(String[] args) {

        String filePath = ".\\.gitignore";

        File file = new File("C:\\Users\\Master\\basejava\\.gitignore");
        File file2 = new File(filePath);
        try {
            out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }
        try {
            out.println(file2.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File dir = new File("./src/com/urise/webapp");
        out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : list) {
                out.println(name);
            }
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            out.println("\n" + fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
