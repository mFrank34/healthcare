package Utilities;

import java.util.Collection;

public interface Repository<T> {
    void load();
    void save();

    Collection<T> getAll();    // ✔️ generic
    T getById(String id);      // ✔️ lookup by ID

    void add(T item);
    void remove(String id);
}
