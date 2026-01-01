package Interface;

import java.util.ArrayList;

public interface Repository<T> {
    void load();
    void save();

    ArrayList<T> getAll();
    T getById(String id);

    void add(T item);
    void remove(String id);
}
