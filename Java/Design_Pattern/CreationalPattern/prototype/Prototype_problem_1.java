package prototype;

// Prototype interface
interface Shape extends Cloneable {
    void draw();

    Shape clone();
}

class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle with radius: " + radius);
    }

    @Override
    public Shape clone() {
        return new Circle(this.radius);
    }
}

// Concrete Prototype: Rectangle
class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle with width: " + width + " and height: " + height);
    }

    @Override
    public Shape clone() {
        return new Rectangle(this.width, this.height);
    }
}

public class Prototype_problem_1 {
    public static void main(String[] args) {
        // Create original shapes
        Shape originalCircle = new Circle(10);
        Shape originalRectangle = new Rectangle(20, 30);

        // Clone shapes
        Shape clonedCircle = originalCircle.clone();
        Shape clonedRectangle = originalRectangle.clone();

        // Draw original and cloned shapes
        originalCircle.draw(); // Output: Drawing Circle with radius: 10
        clonedCircle.draw(); // Output: Drawing Circle with radius: 10

        originalRectangle.draw(); // Output: Drawing Rectangle with width: 20 and height: 30
        clonedRectangle.draw(); // Output: Drawing Rectangle with width: 20 and height: 30
    }
}