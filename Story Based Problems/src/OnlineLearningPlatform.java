// Base class Course
class Course {

    protected int courseId;
    protected String courseName;
    protected double price;

    // Static field for platform name
    static String platformName = "EduPlatform";

    // Constructor
    Course(int courseId, String courseName, double price) {
        this.courseId = courseId;
        this.courseName = toTitleCase(courseName);
        this.price = price;
    }

    // Method to get final price (can be overridden)
    double getFinalPrice() {
        return price;
    }

    // Convert string to Title Case
    protected String toTitleCase(String input) {
        String[] words = input.split(" ");
        StringBuilder titleCase = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                titleCase.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return titleCase.toString().trim();
    }

    @Override
    public String toString() {
        return "Course{ID=" + courseId + ", Name='" + courseName + "', Price=₹" + price + "}";
    }
}

// RecordedCourse → 10% discount
class RecordedCourse extends Course {

    private static final double DISCOUNT_RATE = 0.10;

    RecordedCourse(int courseId, String courseName, double price) {
        super(courseId, courseName, price);
    }

    @Override
    double getFinalPrice() {
        return price * (1 - DISCOUNT_RATE);
    }

    @Override
    public String toString() {
        return "RecordedCourse{ID=" + courseId + ", Name='" + courseName + "', Original Price=₹" + price +
                ", Final Price=₹" + getFinalPrice() + "}";
    }
}

// LiveCourse → 5% discount
class LiveCourse extends Course {

    private static final double DISCOUNT_RATE = 0.05;

    LiveCourse(int courseId, String courseName, double price) {
        super(courseId, courseName, price);
    }

    @Override
    double getFinalPrice() {
        return price * (1 - DISCOUNT_RATE);
    }

    @Override
    public String toString() {
        return "LiveCourse{ID=" + courseId + ", Name='" + courseName + "', Original Price=₹" + price +
                ", Final Price=₹" + getFinalPrice() + "}";
    }
}

// Main class
public class OnlineLearningPlatform {

    public static void main(String[] args) {

        System.out.println("Platform: " + Course.platformName + "\n");

        // Polymorphic references
        Course c1 = new RecordedCourse(101, "java programming basics", 2000.0);
        Course c2 = new LiveCourse(102, "advanced python course", 3000.0);

        // Display details
        System.out.println(c1);
        System.out.println(c2);
    }
}