public class Vehicle {
    private String registrationNumber;
    private String model;
    private String manufacturer;

    public Vehicle(String registrationNumber, String model, String manufacturer) {
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.manufacturer = manufacturer;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
