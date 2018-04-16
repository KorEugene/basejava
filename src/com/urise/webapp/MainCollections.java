package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainCollections {

    private static final String UUID_1 = "uuid1";
    private static final Resume R1 = new Resume(UUID_1);

    private static final String UUID_2 = "uuid2";
    private static final Resume R2 = new Resume(UUID_2);

    private static final String UUID_3 = "uuid3";
    private static final Resume R3 = new Resume(UUID_3);

    public static void main(String[] args) {

        Collection<Resume> collection = new ArrayList<>();
        collection.add(R1);
        collection.add(R2);
        collection.add(R3);
        Iterator<Resume> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Resume r = iterator.next();
            System.out.println(r);
            if (Objects.equals(r.getUuid(), UUID_1)) {
                iterator.remove();
            }
        }
        System.out.println(collection.toString());
        Map<String, Resume> map = new HashMap<>();
        map.put(UUID_1, R1);
        map.put(UUID_2, R2);
        map.put(UUID_3, R3);
        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

}
