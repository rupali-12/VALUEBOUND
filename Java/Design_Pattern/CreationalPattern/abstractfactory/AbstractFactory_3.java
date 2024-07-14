// Abstract Product: Button
interface Button {
    void render();
}

// Concrete Product: LightButton
class LightButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Light Button");
    }
}

// Concrete Product: DarkButton
class DarkButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Dark Button");
    }
}

// Abstract Factory Interface: ThemeFactory
interface ThemeFactory {
    Button createButton();
    // Add more factory methods for other UI components like Checkbox, TextBox, etc.
}

// Concrete Factory: LightThemeFactory
class LightThemeFactory implements ThemeFactory {
    @Override
    public Button createButton() {
        return new LightButton();
    }
    // Implement other factory methods for LightTheme UI components
}

// Concrete Factory: DarkThemeFactory
class DarkThemeFactory implements ThemeFactory {
    @Override
    public Button createButton() {
        return new DarkButton();
    }
    // Implement other factory methods for DarkTheme UI components
}

// Client Code
public class AbstractFactory_3 {
    public static void main(String[] args) {
        // Use LightThemeFactory to create UI components
        ThemeFactory lightFactory = new LightThemeFactory();
        Button lightButton = lightFactory.createButton();
        lightButton.render();

        System.out.println();

        // Use DarkThemeFactory to create UI components
        ThemeFactory darkFactory = new DarkThemeFactory();
        Button darkButton = darkFactory.createButton();
        darkButton.render();
    }
}
