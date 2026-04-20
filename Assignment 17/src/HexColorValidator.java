public class HexColorValidator {

    public static void main(String[] args) {

        String[] colors = {
                "#1A2B3C", "#abc123", "#FFF", "123456", "#12G45Z"
        };

        String regex = "^#[0-9A-Fa-f]{6}$";

        for (String color : colors) {
            if (color.matches(regex)) {
                System.out.println(color + " → Valid");
            } else {
                System.out.println(color + " → Invalid");
            }
        }
    }
}