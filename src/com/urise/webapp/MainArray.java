package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.ArrayStorage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Test com.urise.webapp.storage.ArrayStorage
 */
public class MainArray {
    private static ArrayStorage arrayStorage = new ArrayStorage();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Resume r;
        while (true) {
            System.out.print("Введите одну из команд - (list | save uuid | delete uuid | get uuid | clear | exit): ");
            String[] params = reader.readLine().trim().toLowerCase().split(" ");
            if (params.length < 1 || params.length > 2) {
                System.out.println("Неверная команда.");
                continue;
            }
            String uuid = null;
            if (params.length == 2) {
                uuid = params[1].intern();
            }
            switch (params[0]) {
                case "list":
                    printAll();
                    break;
                case "size":
                    System.out.println(arrayStorage.size());
                    break;
                case "save":
                    r = new Resume();
                    r.setUuid(uuid);
                    arrayStorage.save(r);
                    printAll();
                    break;
                case "delete":
                    arrayStorage.delete(uuid);
                    printAll();
                    break;
                case "get":
                    System.out.println(arrayStorage.get(uuid));
                    break;
                case "clear":
                    arrayStorage.clear();
                    printAll();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Неверная команда.");
                    break;
            }
        }
    }

    private static void printAll() {
        Resume[] all = arrayStorage.getAll();
        System.out.println("----------------------------");
        if (all.length == 0) {
            System.out.println("Empty");
        } else {
            for (Resume r : all) {
                System.out.println(r);
            }
        }
        System.out.println("----------------------------");
    }
}