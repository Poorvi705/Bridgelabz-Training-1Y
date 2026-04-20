public class SpaceNormalizer {

    public static void main(String[] args) {

        String input = "This   is   an   example   with   multiple   spaces.";

        // 🔹 Replace multiple spaces with single space
        String result = input.replaceAll("\\s+", " ");

        System.out.println("Output:");
        System.out.println(result);
    }
}