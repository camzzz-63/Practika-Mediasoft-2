import java.util.Scanner;

public class DealershipApp {
    public static void main(String[] args) {
        CarDealership dealership = new CarDealership();
        Scanner scanner = new Scanner(System.in);

        // Предзаполнение
        dealership.addCar(new TypedCar("VIN1", "Model X", "Tesla", 2023, 10000, 80000, CarType.ELECTRIC));
        dealership.addCar(new TypedCar("VIN2", "RAV4", "Toyota", 2018, 50000, 25000, CarType.SUV));

        while (true) {
            System.out.println("""
                \nМеню:
                1. Добавить машину
                2. Найти по производителю
                3. Средняя цена по типу
                4. Сортировка по году
                5. Статистика
                0. Выход
                """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("VIN: ");
                    String vin = scanner.nextLine();
                    System.out.print("Модель: ");
                    String model = scanner.nextLine();
                    System.out.print("Производитель: ");
                    String manufacturer = scanner.nextLine();
                    System.out.print("Год: ");
                    int year = scanner.nextInt();
                    System.out.print("Пробег: ");
                    int mileage = scanner.nextInt();
                    System.out.print("Цена: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Тип (SEDAN/SUV/ELECTRIC/HATCHBACK): ");
                    CarType type = CarType.valueOf(scanner.nextLine().toUpperCase());

                    boolean added = dealership.addCar(new TypedCar(vin, model, manufacturer, year, mileage, price, type));
                    System.out.println(added ? "Машина добавлена." : "Ошибка: VIN уже существует.");
                }
                case 2 -> {
                    System.out.print("Производитель: ");
                    String m = scanner.nextLine();
                    dealership.findByManufacturer(m).forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("Тип: ");
                    CarType t = CarType.valueOf(scanner.nextLine().toUpperCase());
                    System.out.printf("Средняя цена: %.2f%n", dealership.averagePriceByType(t));
                }
                case 4 -> dealership.getSortedByYear().forEach(System.out::println);
                case 5 -> {
                    System.out.println("Количество по типам:");
                    dealership.countByType().forEach((k, v) -> System.out.println(k + ": " + v));
                    System.out.println("Самая старая машина: " + dealership.getOldest().orElse(null));
                    System.out.println("Самая новая машина: " + dealership.getNewest().orElse(null));
                }
                case 0 -> System.exit(0);
                default -> System.out.println("Неверный ввод");
            }
        }
    }
}