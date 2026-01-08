package utilities;

import java.util.List;

public interface Validator {

    List<String> validate(List<String> data);

    /**
     * Checking text fields are empty
     * @param data data of the list
     * @param index index of items selected
     * @return true or false depending on selected target
     */
    default boolean isBlank(List<String> data, int index) {
        return data.get(index).trim().isEmpty();
    }

    /**
     * regex for testing the corrected date
     * @param value targe to be checked
     * @return return the state
     */
    default boolean isValidDate(String value) {
        return !value.matches("\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])");
    }

    /**
     * checking the email though regex's
     * @param value selected target
     * @return return the state
     */
    default boolean isValidEmail(String value) {
        return !value.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    /**
     * checking if they had valid phone number
     * @param value target to be checked
     * @return return the state
     */
    default boolean isValidPhone(String value) {
        return !value.matches("\\+?[0-9\\- ]{7,20}");
    }

    /**
     * checking if the target is number
     * @param value target to get checked
     * @return return the state
     */
    default boolean isNumeric(String value) {
        return !value.matches("\\d+");
    }

    /**
     * checking the zip code though the regex's
     * @param value target to get checked
     * @return returns the state
     */
    default boolean isValidPostcode(String value) {
        return !value.matches("^[A-Za-z]{1,2}\\d[A-Za-z\\d]? ?\\d[A-Za-z]{2}$");
    }
}
