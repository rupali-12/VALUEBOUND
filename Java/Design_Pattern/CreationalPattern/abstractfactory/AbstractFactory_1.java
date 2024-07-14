// Abstract Factory Interfaces
interface ButtonFactory {
    Button createButton();
}

interface CheckboxFactory {
    Checkbox createCheckbox();
}

// Abstract Product Types
interface Button {
    void render();
}

interface Checkbox {
    void render();
}

// Concrete Products: Windows Button and Checkbox
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Windows style button");
    }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a Windows style checkbox");
    }
}

// Concrete Products: MacOS Button and Checkbox
class MacOSButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a MacOS style button");
    }
}

class MacOSCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a MacOS style checkbox");
    }
}

// Concrete Factories: Windows and MacOS Factories
class WindowsUIFactory implements ButtonFactory, CheckboxFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacOSUIFactory implements ButtonFactory, CheckboxFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

// Client Code
public class AbstractFactory_1 {
    public static void main(String[] args) {
        // Depending on the OS or configuration, select the appropriate factory
        ButtonFactory buttonFactory = new WindowsUIFactory(); // or MacOSUIFactory()
        CheckboxFactory checkboxFactory = new WindowsUIFactory(); // or MacOSUIFactory()

        // Use the factory to create UI components
        Button button = buttonFactory.createButton();
        Checkbox checkbox = checkboxFactory.createCheckbox();

        // Render UI components
        button.render(); // Rendering a Windows style button
        checkbox.render(); // Rendering a Windows style checkbox
    }
}
