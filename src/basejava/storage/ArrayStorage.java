/**
 * Array based basejava.storage for Resumes
 */

package basejava.storage;

import basejava.model.Resume;

import java.util.Arrays;

public class ArrayStorage {
    private Resume[] storage = new Resume[1000];
    private int size = 0;

    public void update(Resume resume) {
        if (size == 0) {
            System.out.println("    !!!ERROR!!!\n Incorrect data entered.\n Repeat entry.");
        }
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(resume.getUuid())) {
                storage[i] = resume;
                System.out.println("Object Resume with UUID \"" + resume.getUuid() + "\" was updated successfully");
                break;
            } else if (i == (size - 1)) {
                System.out.println("    !!!ERROR!!!\n Incorrect data entered.\n Repeat entry.");
            }
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (size < storage.length) {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(resume.getUuid())) {
                    System.out.println("    !!!ERROR!!!\n Incorrect data entered.\n Repeat entry.");
                    break;
                } else if (i == (size - 1)) {
                    storage[size] = resume;
                    size++;
                    break;
                }
            }
            if (size == 0) {
                storage[size] = resume;
                size++;
            }
        } else {
            System.out.println("    !!!ERROR!!!\n Incorrect data entered.\n Repeat entry.");
            System.out.println("Object \"Resume\" with uuid \"" + resume.getUuid() +
                    "\" was not saved because the storage is full\n");

        }
    }

    public Resume get(String uuid) {
        if (size == 0) {
            System.out.println("    !!!ERROR!!!\n Incorrect data entered.\n Repeat entry.");
        }

        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            } else if (i == (size - 1)) {
                System.out.println("    !!!ERROR!!!\n Incorrect data entered.\n Repeat entry.");
            }
        }
        return null;
    }

    public void delete(String uuid) {
        if (size == 0) {
            System.out.println("    !!!ERROR!!!\n Incorrect data entered.\n Repeat entry.");
        }

        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                break;
            } else if (i == (size - 1)) {
                System.out.println("    !!!ERROR!!!\n Incorrect data entered.\n Repeat entry.");
            }
        }
    }

    /**
     * @return array, contains only Resumes in basejava.storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}
