import java.util.*;

public class CarModels {
    public static void main(String[] args) {
        List<String> models = new ArrayList<>(Arrays.asList(
                "Toyota Camry", "BMW X5", "Audi A4", "Tesla Model 3", "BMW X5", "Tesla Model S", "Lada Granta"
        ));

        Set<String> uniqueModels = new TreeSet<>(Collections.reverseOrder());
        for (String model : models) {
            if (model.contains("Tesla")) {
                uniqueModels.add("ELECTRO_CAR");
            } else {
                uniqueModels.add(model);
            }
        }

        System.out.println("Отсортированные модели без дубликатов:");
        for (String model : uniqueModels) {
            System.out.println(model);
        }
    }
}