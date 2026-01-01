package Repositories;

import Utilities.Repository;
import FileHandlers.Handler;

import java.util.ArrayList;

public abstract class BaseRepository<T> implements Repository<T> {
    protected ArrayList<T> items = new ArrayList<>();
    protected String fileName;

    public BaseRepository(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void load() {
        items.clear();
        ArrayList<String> lines = Handler.readLines(fileName);

        boolean skip = true;
        for (String line : lines) {
            if (skip) {
                skip = false;
                continue;
            }
            String[] parts = line.split(",");
            items.add(parse(parts));
        }
    }

    @Override
    public void save() {
        ArrayList<String> lines = new ArrayList<>();
        lines.add(getHeader());

        for (T obj : items) {
            lines.add(toCSV(obj));
        }
        Handler.writeLines(fileName, lines);
    }

    @Override
    public ArrayList<T> getAll() {
        return items;
    }

    @Override
    public T getById(String id) {
        for (T obj : items) {
            if (matchesId(obj, id)) return obj;
        }
        return null;
    }

    @Override
    public void add(T item) {
        items.add(item);
        save();
    }

    @Override
    public void remove(String id) {
        items.removeIf(obj -> matchesId(obj, id));
        save();
    }

    // making my life easier you know
    protected abstract T parse(String[] data);
    protected abstract String toCSV(T obj);
    protected abstract String getHeader();
    protected abstract boolean matchesId(T obj, String id);
}
