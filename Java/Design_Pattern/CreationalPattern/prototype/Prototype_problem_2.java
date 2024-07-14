package prototype;

// Prototype interface
interface Entity extends Cloneable {
    void draw(); // Example method for simulation entities

    Entity clone();
}

// Concrete Prototype: Vehicle
class Vehicle implements Entity {
    private String type;

    public Vehicle(String type) {
        this.type = type;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Vehicle of type: " + type);
    }

    @Override
    public Entity clone() {
        return new Vehicle(this.type);
    }
}

// Concrete Prototype: Building
class Building implements Entity {
    private String name;

    public Building(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Building: " + name);
    }

    @Override
    public Entity clone() {
        return new Building(this.name);
    }
}

public class Prototype_problem_2 {
    public static void main(String[] args) {
        // Create original entities
        Entity originalVehicle = new Vehicle("Car");
        Entity originalBuilding = new Building("Skyscraper");

        // Clone entities
        Entity clonedVehicle = originalVehicle.clone();
        Entity clonedBuilding = originalBuilding.clone();

        // Draw original and cloned entities
        originalVehicle.draw(); // Output: Drawing Vehicle of type: Car
        clonedVehicle.draw(); // Output: Drawing Vehicle of type: Car

        originalBuilding.draw(); // Output: Drawing Building: Skyscraper
        clonedBuilding.draw(); // Output: Drawing Building: Skyscraper
    }
}
