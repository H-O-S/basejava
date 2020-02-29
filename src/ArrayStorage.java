/**
 * Array based storage for Resumes
 */

/*
        Реализуйте класс ArrayStorage, организовав хранение резюме на основе массива с методами
        save, get, delete, size, clear, getAll
        Храните все резюме в начале storage (без дырок в виде null), чтобы не перебирать каждый раз все 10000 элементов.
                Схема хранения резюме в массиве storage (в элементах от 0 до size-1 отсутствуют null):
                r1, r2, r3,..., rn, null, null,..., null
                <----- size ----->
                <------- storage.length (10000) ------->
        Протестируйте вашу реализацию с помощью классов MainArray.main() и MainTestArrayStorage.main()
        Все резюме в хранилище имеют уникальный uuid, что исключает повторы. Cортировка по uuid не требуется.
        При реализации метода delete() не используйте сортировку резюме.
        В методе clear() обнуление массива предполагает именно обнуление (null), а не создание нового

*/

import java.util.Arrays;

public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, 0, size(), null);
    }

    void save(Resume r) {
        storage[size()] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[size() - 1];
                storage[size() - 1] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                return i;
            }
        }
        return storage.length;
    }
}
