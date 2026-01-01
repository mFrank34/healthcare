package Repository;

import FileHandlers.Handler;
import Utilities.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public abstract class BaseRepository<T> implements Repository<T> {
    protected HashMap<String, T> items = new HashMap<>();
    protected String fileName;

    public BaseRepository(String fileName) {
        this.fileName = fileName;
    }

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

    @Override
    public void save() {
        var lines = new ArrayList<String>();
        lines.add(getHeader());
        for (T obj : items.values()) lines.add(toCSV(obj));
        Handler.writeLines(fileName, lines);
    }

    @Override
    public Collection<T> getAll() {
        return items.values();
    }

    @Override
    public T getById(String id) {
        return items.get(id);
    }

    @Override
    public void add(T item) {
        items.put(getId(item), item);
        save();
    }

    @Override
    public void remove(String id) {
        items.remove(id);
        save();
    }

    // abstract requirements
    protected abstract T parse(String[] data);
    protected abstract String toCSV(T obj);
    protected abstract String getHeader();
    protected abstract String getId(T obj);
}
