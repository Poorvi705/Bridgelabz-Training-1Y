import java.io.*;

public class FileReaderExample {
    public static void main(String[] args) {

        try {
            // Try to open file
            FileReader file = new FileReader("data.txt");
            BufferedReader reader = new BufferedReader(file);

            String line;

            // Read file line by line
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            // Handle checked exception
            System.out.println("File not found");
        }
    }
}