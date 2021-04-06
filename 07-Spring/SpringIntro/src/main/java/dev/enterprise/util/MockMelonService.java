package dev.enterprise.util;

public class MockMelonService {

    private String typeOfMelon;
    private double circumference;
    private double price;

    public MockMelonService(String typeOfMelon, double circumference, double price) {
        this.typeOfMelon = typeOfMelon;
        this.circumference = circumference;
        this.price = price;
    }

    @Override
    public String toString() {
        return "MockMelonService{" +
                "typeOfMelon='" + typeOfMelon + '\'' +
                ", circumference=" + circumference +
                ", price=" + price +
                '}';
    }
}
