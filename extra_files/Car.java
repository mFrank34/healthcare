public class Car {
    private String model;
    private int tank_size;
    private Double fuelin_tank;

    public Car() {};

    public Car(String model, int size, Double fuelin) {
        this.model = model;
        tank_size = size;
        fuelin_tank = fuelin;
    }

    public String get_model(){
        return model;
    }

    public int get_tank_size() {
        return tank_size;
    }

    public Double get_fuelin_tank() { 
        return fuelin_tank;
    }

    public void set_model(String model) {
        this.model = model;
    }

    public void set_tank_size(int size) {
        tank_size = size;
    }

    public void set_fuelin_tank(Double fuelin) {
        fuelin_tank = fuelin;
    }

    public Double estimate_distance() {
        return tank_size * fuelin_tank * 0.22;
    }
};