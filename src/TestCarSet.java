import java.util.*;

public class TestCarSet {
    public static void main(String[] args) {
        Set<Car> cars = new HashSet<>();
        cars.add(new Car("VIN123", "BMW X5", "BMW", 2020, 30000, 30000));
        cars.add(new Car("VIN123", "BMW X5", "BMW", 2020, 30000, 30000)); // дубликат
        cars.add(new Car("VIN456", "Toyota Camry", "Toyota", 2019, 50000, 25000));

        for (Car car : cars) {
            System.out.println(car);
        }
    }
}