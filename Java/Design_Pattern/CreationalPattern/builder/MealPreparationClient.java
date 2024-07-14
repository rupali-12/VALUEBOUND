// Builder Interface: MealBuilder
interface MealBuilder {
    void addAppetizer(String appetizer);

    void addMainCourse(String mainCourse);

    void addDessert(String dessert);
    // Other methods for adding components as needed
}

// Concrete Builder: VegetarianMealBuilder
class VegetarianMealBuilder implements MealBuilder {
    private String appetizer;
    private String mainCourse;
    private String dessert;

    @Override
    public void addAppetizer(String appetizer) {
        this.appetizer = appetizer;
    }

    @Override
    public void addMainCourse(String mainCourse) {
        this.mainCourse = mainCourse;
    }

    @Override
    public void addDessert(String dessert) {
        this.dessert = dessert;
    }

    // Other methods specific to Vegetarian meal construction
    public String getResult() {
        return "Vegetarian Meal: " + appetizer + ", " + mainCourse + ", " + dessert;
    }
}

// Concrete Builder: NonVegetarianMealBuilder
class NonVegetarianMealBuilder implements MealBuilder {
    private String appetizer;
    private String mainCourse;
    private String dessert;

    @Override
    public void addAppetizer(String appetizer) {
        this.appetizer = appetizer;
    }

    @Override
    public void addMainCourse(String mainCourse) {
        this.mainCourse = mainCourse;
    }

    @Override
    public void addDessert(String dessert) {
        this.dessert = dessert;
    }

    // Other methods specific to Non-vegetarian meal construction
    public String getResult() {
        return "Non-Vegetarian Meal: " + appetizer + ", " + mainCourse + ", " + dessert;
    }
}

// Director (optional): MealDirector
// Manages the order of steps to construct a meal

// Client Code
public class MealPreparationClient {
    public static void main(String[] args) {
        // Create a vegetarian meal using VegetarianMealBuilder
        VegetarianMealBuilder vegetarianBuilder = new VegetarianMealBuilder();
        constructMeal(vegetarianBuilder); // Director or client manages construction steps
        String vegetarianMeal = vegetarianBuilder.getResult();
        System.out.println("Generated Vegetarian Meal:\n" + vegetarianMeal);

        System.out.println();

        // Create a non-vegetarian meal using NonVegetarianMealBuilder
        NonVegetarianMealBuilder nonVegetarianBuilder = new NonVegetarianMealBuilder();
        constructMeal(nonVegetarianBuilder); // Director or client manages construction steps
        String nonVegetarianMeal = nonVegetarianBuilder.getResult();
        System.out.println("Generated Non-Vegetarian Meal:\n" + nonVegetarianMeal);
    }

    public static void constructMeal(MealBuilder builder) {
        builder.addAppetizer("Salad");
        builder.addMainCourse("Grilled Chicken");
        builder.addDessert("Chocolate Cake");
        // Other construction steps as needed
    }
}
