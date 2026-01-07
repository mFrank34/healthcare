package Repository;

import FileHandlers.Handler;
import Utilities.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * A base framework for handling objects creation and destruction
 * Mostly data handler for the different importing data sets
 * @param <T> temp value for class object such as Appointment or Patients models
 */
public abstract class BaseRepository<T> implements Repository<T> {
    protected HashMap<String, T> items = new HashMap<>();
    protected String fileName;

    /**
     * base contractor for handler to get a file name to read
     * @param fileName to set the value of file that being read
     */
    public BaseRepository(String fileName) {
        this.fileName = fileName;
    }

    /**
     * the handler that handle loading data from file
     * and skips first line of all file to skip header
     * and place them in hashmap
     */
    @Override
    public void load() {
        items.clear();
        ArrayList<String> lines = Handler.readLines(fileName);
        boolean skipHeader = true;

        for (String line : lines) {
            if (skipHeader) {
                skipHeader = false;
                continue;
            }
            String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // Regex for fixing "something, something"
            for (int i = 0; i < parts.length; i++) {
                parts[i] = parts[i].replaceAll("^\"|\"$", "");
            }

            T obj = parse(parts);
            items.put(getId(obj), obj);
        }
    }

    /**
     * rewrites the file with header and all the class object data
     */
    @Override
    public void save() {
        var lines = new ArrayList<String>();
        lines.add(getHeader());
        for (T obj : items.values()) lines.add(toCSV(obj));
        Handler.writeLines(fileName, lines);
    }

    /**
     * get all data returned as collection course you can NOT naturally convert hashmap to vector
     * @return the data that stored within item, and converts it to Collection
     */
    @Override
    public Collection<T> getAll() {
        return items.values();
    }

    /**
     * function to get id value of item inside the hashmap
     * @param id the instance that you want to select in hashmap
     * @return return the target that your looking for
     */
    @Override
    public T getById(String id) {
        return items.get(id);
    }

    /**
     * adds new instance of model that class is configured with
     * @param item give it any model and add it to items hashmap
     */
    @Override
    public void add(T item) {
        items.put(getId(item), item);
        save();
    }

    /**
     * helper function to make and return a model fast
     * @param data data directly from a form
     * @return return that object that was created so it stored within the model
     */
    public T CreateAndAdd(List<String> data) {
        String[] parts = data.toArray(new String[0]);
        T obj = parse(parts);
        add(obj);
        return obj;
    }

    /**
     * remove item from hashmap
     * @param id with id value that links them
     */
    @Override
    public void remove(String id) {
        items.remove(id);
        save();
    }

    /**
     * conversation to table output to string in
     * @return returns the data that stored in items to strings and for easy use for table handling
     */
    public Object[][] toTableData() {
        Object[][] data = new Object[items.size()][];
        int i = 0;
        for (T item : items.values()) {
            data[i++] = toTableRow(item);
        }
        return data;
    }

    /**
     * the parse that allows for different models to pass into object
     * @param data the string data from file
     * @return returns an object depending on the T Model
     */
    protected abstract T parse(String[] data);

    /**
     * coverts Objects to Strings for use within adding them to cvs files
     * @param obj selected object to covert
     * @return return string of data that is object values
     */
    protected abstract String toCSV(T obj);

    /**
     * Converts items into columns and rows to easier add to table
     * @param item selected object that need to be converted
     * @return return list of objects values
     */
    protected abstract Object[] toTableRow(T item);

    /**
     * header to the cvs file as string
     * @return string of cvs header
     */
    protected abstract String getHeader();

    /**
     * get id grabbing the id from an object
     * @param obj selected object for id value
     * @return return sting of id it's found
     */
    protected abstract String getId(T obj);
}
