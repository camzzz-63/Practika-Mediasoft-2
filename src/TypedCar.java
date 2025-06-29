public class TypedCar extends Car {
    private CarType type;

    public TypedCar(String vin, String model, String manufacturer, int year, int mileage, double price, CarType type) {
        super(vin, model, manufacturer, year, mileage, price);
        this.type = type;
    }

    public CarType getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString() + " [" + type + "]";
    }
}