public class App {
    public static void main(String[] args) {

        // car demo code for working with class
        System.out.println("Car class demo");

        Car car = new Car("mini", 100, 25.50);
        System.out.println(car.get_model());
        System.out.println(car.get_fuelin_tank());
        System.out.println(car.get_tank_size());

        System.out.println("amount of vaules");
        System.out.println(car.estimate_distance());

        // loop examples

        Loop loop = new Loop();

        // they dont return anything tho
        loop.for_loop("java");
        loop.while_loop("java");
        loop.do_while_loop("java");

        Student student = new Student("michael" , 20, "mendip way 128");

        // read from students
        System.out.println(student.get_name() + " " + student.get_age() + " " + student.get_address());

        // bro idk what this gonna be used for 

        


    }
}
