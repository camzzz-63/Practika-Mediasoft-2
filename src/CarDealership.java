import java.util.*;
import java.util.stream.Collectors;

public class CarDealership {
    private List<Car> cars = new ArrayList<>();

    public boolean addCar(Car car) {
        return cars.stream().noneMatch(c -> c.getVin().equals(car.getVin())) && cars.add(car);
    }

    public List<Car> findByManufacturer(String manufacturer) {
        return cars.stream()
                .filter(c -> c.getManufacturer().equalsIgnoreCase(manufacturer))
                .collect(Collectors.toList());
    }

    public double averagePriceByType(CarType type) {
        return cars.stream()
                .filter(c -> c instanceof TypedCar && ((TypedCar) c).getType() == type)
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
    }

    public List<Car> getSortedByYear() {
        return cars.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public Map<CarType, Long> countByType() {
        return cars.stream()
                .filter(c -> c instanceof TypedCar)
                .map(c -> ((TypedCar) c).getType())
                .collect(Collectors.groupingBy(t -> t, Collectors.counting()));
    }

    public Optional<Car> getOldest() {
        return cars.stream().min(Comparator.comparingInt(Car::getYear));
    }

    public Optional<Car> getNewest() {
        return cars.stream().max(Comparator.comparingInt(Car::getYear));
    }
}