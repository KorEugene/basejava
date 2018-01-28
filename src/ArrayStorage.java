/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    private static int ELEMENTS_COUNTER = 0;

    void clear() {
        storage = new Resume[10000];
        ELEMENTS_COUNTER = 0;
    }

    void save(Resume r) {
        storage[ELEMENTS_COUNTER] = r;
        ELEMENTS_COUNTER++;
    }

    Resume get(String uuid) {
        Resume searchResult = new Resume();
        searchResult.uuid = "There is no matches!";
        for (Resume elementOfArray : storage) {
            if (elementOfArray == null) {
                break;
            } else if (elementOfArray.uuid.equals(uuid)) {
                searchResult = elementOfArray;
                break;
            }
        }
        return searchResult;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(uuid)) {
                System.arraycopy(storage, i + 1, storage, i, storage.length - 1 - i);
                ELEMENTS_COUNTER--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] currentStorage = new Resume[ELEMENTS_COUNTER];
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                break;
            } else {
                currentStorage[i] = storage[i];
            }
        }
        return currentStorage;
    }

    int size() {
        return ELEMENTS_COUNTER;
    }
}
