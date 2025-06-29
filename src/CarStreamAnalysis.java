import java.util.*;
import java.util.stream.Collectors;

public class CarStreamAnalysis {
    public static void main(String[] args) {
        List<Car> cars = List.of(
                new Car("1", "Model A", "Toyota", 2018, 20000, 20000),
                new Car("2", "Model B", "BMW", 2022, 60000, 50000),
                new Car("3", "Model C", "Tesla", 2021, 10000, 80000),
                new Car("4", "Model D", "BMW", 2023, 40000, 75000),
                new Car("5", "Model E", "Toyota", 2020, 30000, 30000)
        );

        System.out.println("Машины с пробегом < 50000:");
        cars.stream().filter(c -> c.getMileage() < 50_000).forEach(System.out::println);

        System.out.println("\nТоп-3 дорогих машин:");
        cars.stream().sorted(Comparator.comparingDouble(Car::getPrice).reversed()).limit(3).forEach(System.out::println);

        double avgMileage = cars.stream().mapToInt(Car::getMileage).average().orElse(0);
        System.out.printf("%nСредний пробег: %.2f км%n", avgMileage);

        Map<String, List<Car>> byManufacturer = cars.stream()
                .collect(Collectors.groupingBy(Car::getManufacturer));

        System.out.println("\nГруппировка по производителю:");
        byManufacturer.forEach((k, v) -> System.out.println(k + " → " + v.size() + " машин"));
    }
}