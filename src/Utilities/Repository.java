package Utilities;

import java.util.Collection;

/**
 * interface for repository's
 * to help with conversion of object to and from files
 * @param <T> class model that needing to be used
 */
public interface Repository<T> {
    /**
     * load function for the class
     */
    void load();

    /**
     * save function for the class
     */
    void save();

    /**
     * return the all the data within class
     * @return collection of vaules
     */
    Collection<T> getAll();    // ✔️ generic

    /**
     * get by id gets item object from id value
     */
    T getById(String id);      // ✔️ lookup by ID

    /**
     * add models to hashmap of items
     * @param item object model to be added to hashmap
     */
    void add(T item);

    /**
     * remove object from items using id value
     * @param id value relation to id string
     */
    void remove(String id);

}
