public class Student {
    private String name;
    private int age;
    private String address;

    public Student() {};

    public Student(String name, int Student_age, String address) {
        this.name = name;
        age = Student_age;
        this.address = address;
    }

    public void set_name(String student_name) {
        this.name = student_name;
    }

    public void set_age(int Student_age) {
        age = Student_age;
    }

    public void set_addreess(String student_address) {
        this.address = student_address;
    }

    public String get_name() {
        return name;
    }

    public int get_age() {
        return age;
    }
    
    public String get_address() {
        return address;
    }
    
}