// Abstract Factory Interfaces
interface EngineFactory {
    Engine createEngine();
}

interface BodyFactory {
    Body createBody();
}

// Abstract Product Types
interface Engine {
    void design();
}

interface Body {
    void manufacture();
}

// Concrete Products: Sedan Engine and Body
class SedanEngine implements Engine {
    @Override
    public void design() {
        System.out.println("Designing Sedan Engine");
    }
}

class SedanBody implements Body {
    @Override
    public void manufacture() {
        System.out.println("Manufacturing Sedan Body");
    }
}

// Concrete Products: SUV Engine and Body
class SuvEngine implements Engine {
    @Override
    public void design() {
        System.out.println("Designing SUV Engine");
    }
}

class SuvBody implements Body {
    @Override
    public void manufacture() {
        System.out.println("Manufacturing SUV Body");
    }
}

// Concrete Factories: Sedan and SUV Factories
class SedanFactory implements EngineFactory, BodyFactory {
    @Override
    public Engine createEngine() {
        return new SedanEngine();
    }

    @Override
    public Body createBody() {
        return new SedanBody();
    }
}

class SuvFactory implements EngineFactory, BodyFactory {
    @Override
    public Engine createEngine() {
        return new SuvEngine();
    }

    @Override
    public Body createBody() {
        return new SuvBody();
    }
}

// Client Code
public class AbstractFactory_2 {
    public static void assembleCar(EngineFactory engineFactory, BodyFactory bodyFactory) {
        // Use the factory to create car parts
        Engine engine = engineFactory.createEngine();
        Body body = bodyFactory.createBody();

        // Assemble the car
        System.out.println("Assembling car parts...");
        engine.design();
        body.manufacture();
    }

    public static void main(String[] args) {
        // Assemble a Sedan
        System.out.println("Manufacturing Sedan:");
        assembleCar(new SedanFactory(), new SedanFactory());

        System.out.println();

        // Assemble an SUV
        System.out.println("Manufacturing SUV:");
        assembleCar(new SuvFactory(), new SuvFactory());
    }
}
