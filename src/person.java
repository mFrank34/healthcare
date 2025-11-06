public class person {
    private String id;
    private String first;
    private String last;
    private String phone;
    private String email;

    public person() {

    }

    public person(String id, String first, String last, String phone, String email) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.phone = phone;
        this.email = email;
    }

    // setters
    public void set_id(String id) {
        this.id = id;
    }

    public void set_first(String first) {
        this.first = first;
    }

    public void set_last(String last) {
        this.last = last;
    }

    public void set_phone(String phone) {
        this.phone = phone;
    }

    public void set_email(String email) {
        this.email = email;
    }

    // getters
    public String get_id() {
        return id;
    }

    public String get_first(){
        return first;
    }

    public String get_last() {
        return last;
    }

    public String get_fullname() {
        return first + " " + last;
    }

    public String get_phone() {
        return phone;
    }

    public String get_email() {
        return email;
    }
}
