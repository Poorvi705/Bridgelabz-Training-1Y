import java.util.*;
import java.util.stream.*;

// Movie Class
class Movie {
    String name;
    double rating;
    int year;

    public Movie(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    @Override
    public String toString() {
        return name + " | Rating: " + rating + " | Year: " + year;
    }
}

// Main Class
public class MovieDemo {

    public static void main(String[] args) {

        List<Movie> movies = Arrays.asList(
                new Movie("Movie A", 8.5, 2023),
                new Movie("Movie B", 9.0, 2024),
                new Movie("Movie C", 8.8, 2022),
                new Movie("Movie D", 9.2, 2024),
                new Movie("Movie E", 7.9, 2021),
                new Movie("Movie F", 8.7, 2023),
                new Movie("Movie G", 9.1, 2025)
        );

        System.out.println("Top 5 Trending Movies:");

        movies.stream()

                // 🔹 Optional filter (example: rating > 8)
                .filter(m -> m.rating > 8)

                // 🔹 Sort by rating DESC, then year DESC
                .sorted((m1, m2) -> {
                    if (m2.rating != m1.rating) {
                        return Double.compare(m2.rating, m1.rating);
                    } else {
                        return Integer.compare(m2.year, m1.year);
                    }
                })

                // 🔹 Limit to top 5
                .limit(5)

                // 🔹 Print
                .forEach(System.out::println);
    }
}