public interface Shape {
    void draw();
}

// Concrete Products
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

// Creator class with Factory Method
public abstract class ShapeFactory {
    public abstract Shape createShape();
}

// Concrete Creator extending Factory
public class CircleFactory extends ShapeFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
}

public class SquareFactory extends ShapeFactory {
    @Override
    public Shape createShape() {
        return new Square();
    }
}

// Client code
public class FactoryMethod {
    public static void main(String[] args) {
        ShapeFactory factory1 = new CircleFactory();
        Shape circle = factory1.createShape();
        circle.draw(); // Output: Drawing Circle

        ShapeFactory factory2 = new SquareFactory();
        Shape square = factory2.createShape();
        square.draw(); // Output: Drawing Square
    }
}
