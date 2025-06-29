import java.util.Random;
import java.time.Year;

public class CarYears {
    public static void main(String[] args) {
        int[] years = new int[50];
        Random random = new Random();

        for (int i = 0; i < years.length; i++) {
            years[i] = 2000 + random.nextInt(26);
        }

        System.out.println("Машины после 2015 года:");
        int sumAge = 0;
        int currentYear = Year.now().getValue();

        for (int year : years) {
            if (year > 2015) {
                System.out.print(year + " ");
            }
            sumAge += currentYear - year;
        }

        double avgAge = (double) sumAge / years.length;
        System.out.printf("%nСредний возраст авто: %.2f лет%n", avgAge);
    }
}