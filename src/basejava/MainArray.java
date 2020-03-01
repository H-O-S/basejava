package basejava;
/**
 * Interactive test for basejava.ArrayStorage implementation
 * (just run, no need to understand)
 */

import basejava.model.Resume;
import basejava.storage.ArrayStorage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainArray {
    private final static ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Resume r;
        while (true) {
            System.out.print("Введите одну из команд - " +
                    "(list | size | update uuid | save uuid | delete uuid | get uuid | clear | exit): ");
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
                    System.out.println(ARRAY_STORAGE.size());
                    break;
                case "update":
                    r = new Resume();
                    r.setUuid(uuid);
                    ARRAY_STORAGE.update(r);
                    printAll();
                    break;
                case "save":
                    r = new Resume();
                    r.setUuid(uuid);
                    ARRAY_STORAGE.save(r);
                    printAll();
                    break;
                case "delete":
                    ARRAY_STORAGE.delete(uuid);
                    printAll();
                    break;
                case "get":
                    System.out.println(ARRAY_STORAGE.get(uuid));
                    break;
                case "clear":
                    ARRAY_STORAGE.clear();
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

    static void printAll() {
        Resume[] all = ARRAY_STORAGE.getAll();
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

/*
HW02
        +1). Поместите классы в пакеты, как это показано в уроке
        +2). Реализуйте и протестируйте ArrayStorage.update(Resume resume)
            Сделайте проверки:
        +3). в update/delete/get - резюме есть в basejava.storage?
        +4). в save- резюме нет в basejava.storage?
        +5). сделайте в save проверку на переполнение
        +6). выведите соответствующие предупреждения для всех, указанных выше проверок - System.out.println("Resume ...")
        -7). Избавьтесь от дублирования в коде ArrayStorage
        -8). Посмотрите на методы класса java.util.Arrays.
        Некоторые из них помогут упростить реализацию ваших методов clear() и getAll()

HW01
        Реализуйте класс basejava.ArrayStorage, организовав хранение резюме на основе массива с методами
        save, get, delete, size, clear, getAll
        Храните все резюме в начале basejava.storage (без дырок в виде null), чтобы не перебирать каждый раз все 10000 элементов.
                Схема хранения резюме в массиве basejava.storage (в элементах от 0 до size-1 отсутствуют null):
                r1, r2, r3,..., rn, null, null,..., null
                <----- size ----->
                <------- basejava.storage.length (10000) ------->
        Протестируйте вашу реализацию с помощью классов basejava.MainArray.main() и basejava.MainTestArrayStorage.main()
        Все резюме в хранилище имеют уникальный uuid, что исключает повторы. Cортировка по uuid не требуется.
        При реализации метода delete() не используйте сортировку резюме.
        В методе clear() обнуление массива предполагает именно обнуление (null), а не создание нового

*/