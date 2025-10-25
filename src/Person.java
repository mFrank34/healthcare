public class Person {
    private String first_name;
    private String last_name;
    private int age;

    public Person() {
    }

    // overloaded constructor
    public Person(String first_name, String last_name, int age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }

    public String get_first() {
        return first_name;
    }

    public String get_last() {
        return last_name;
    }

    public int get_age() {
        return age;
    }

    public String toString() {
        String place_holder = "Name: %s %s  Age: %";
        String output = String.format(place_holder, first_name, last_name, age);
        return output;
    }

}
