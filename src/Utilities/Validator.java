package Utilities;

import java.util.List;

/**
 * system to validate items entering a form field
 * @param <T> type of model that getting validated
 */
public interface Validator<T> {
    /**
     * validate with list of strings that was given
     * @param Model the current model to covert to
     * @return returns list of items that validated
     */
    List<String> validate(T Model);
}
