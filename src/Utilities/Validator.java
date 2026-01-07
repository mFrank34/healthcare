package Utilities;

import java.util.List;

/**
 * system to validate items entering a form field
 */
public interface Validator {
    /**
     * validate with list of strings that was given
     * @param data list of data to check
     * @return returns list of items that validated
     */
    List<String> validate(List<String> data);

    /**
     * blank section check
     * @param data data from forms
     * @param index index of form data given
     * @return returns true || false depending on state
     */
    default boolean isBlank(List<String> data, int index) {
        return data.get(index).trim().isEmpty();
    }
}
