package Utilities;

import java.util.List;

public interface Validator<T> {
    List<String> validate(T Model);
}
