import java.util.*;

// Interface
interface MealPlan {
    void showMeal();
}

// Subtypes
class VegetarianMeal implements MealPlan {
    public void showMeal() {
        System.out.println("Vegetarian Meal: Salad, Paneer, Fruits");
    }
}

class VeganMeal implements MealPlan {
    public void showMeal() {
        System.out.println("Vegan Meal: Tofu, Veggies, Nuts");
    }
}

class KetoMeal implements MealPlan {
    public void showMeal() {
        System.out.println("Keto Meal: Eggs, Avocado, Chicken");
    }
}

class HighProteinMeal implements MealPlan {
    public void showMeal() {
        System.out.println("High Protein Meal: Chicken, Lentils, Eggs");
    }
}

// Generic Class
class Meal<T extends MealPlan> {
    private T meal;

    public void setMeal(T meal) {
        this.meal = meal;
    }

    public void displayMeal() {
        meal.showMeal();
    }
}

public class MealPlanDemo {

    // Generic Method to generate meal
    public static <T extends MealPlan> void generateMealPlan(T meal) {
        System.out.println("Your Personalized Meal Plan:");
        meal.showMeal();
    }

    public static void main(String[] args) {

        // Vegetarian Meal
        Meal<VegetarianMeal> vegMeal = new Meal<>();
        vegMeal.setMeal(new VegetarianMeal());
        vegMeal.displayMeal();

        // Vegan Meal
        Meal<VeganMeal> veganMeal = new Meal<>();
        veganMeal.setMeal(new VeganMeal());
        veganMeal.displayMeal();

        // Using Generic Method
        System.out.println("\nUsing Generator Method:");
        generateMealPlan(new KetoMeal());
        generateMealPlan(new HighProteinMeal());

        // ❌ Not allowed
        // Meal<String> wrongMeal = new Meal<>();
    }
}