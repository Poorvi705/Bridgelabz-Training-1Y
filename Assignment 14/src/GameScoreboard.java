public class GameScoreboard {
    public static void main(String[] args) {

        // Scores (null = player hasn't played)
        Integer[] scores = {100, null, 250, 300, null, 150};

        int notPlayedCount = 0;
        int totalScore = 0;

        for (Integer score : scores) {
            if (score == null) {
                notPlayedCount++;
            } else {
                // Auto-unboxing (Integer → int)
                totalScore += score;
            }
        }

        // Output
        System.out.println("Players not played: " + notPlayedCount);
        System.out.println("Total Score: " + totalScore);
    }
}