package com.urise.webapp;

import java.io.File;

import static java.lang.System.out;

public class Recursion {

    public static void main(String[] args) {

        String baseDirectory = "C:\\Users\\Master\\basejava";
        getCatalog(baseDirectory);
    }

    private static void getCatalog(String baseDirectory) {

        File dir = new File(baseDirectory);
        File[] list = dir.listFiles();
        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].isDirectory()) {
                    out.println("\n" + list[i].getName());
                    getCatalog(list[i].getAbsolutePath());
//                    out.println(list[i].getName());
                } else {
//                    out.println("\n" + list[i].getName());
//                    getCatalog(list[i].getAbsolutePath());
                    out.println(list[i].getName());
                }
            }
        }
    }
}
