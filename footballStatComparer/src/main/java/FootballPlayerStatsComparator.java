import java.util.Scanner;

public class FootballPlayerStatsComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter statistics for Player 1:");
        PlayerStats player1 = getPlayerStats();
        System.out.println("\nEnter statistics for Player 2:");
        PlayerStats player2 = getPlayerStats();

        PlayerStatsCalculatorService calculator = new PlayerStatsCalculatorService();

        double points1 = calculator.calculatePoints(player1);
        double points2 = calculator.calculatePoints(player2);

        System.out.println("\nPlayer 1 points: " + points1);
        System.out.println("Player 2 points: " + points2);

        if (points1 > points2) {
            System.out.println("\nPlayer 1 wins!");
        } else if (points2 > points1) {
            System.out.println("\nPlayer 2 wins!");
        } else {
            System.out.println("\nIt's a tie!");
        }

        scanner.close();
    }

    private static PlayerStats getPlayerStats() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Goals scored: ");
        int goals = scanner.nextInt();
        System.out.print("Assists: ");
        int assists = scanner.nextInt();
        System.out.print("Minutes played: ");
        int minutesPlayed = scanner.nextInt();
        System.out.print("Yellow cards: ");
        int yellowCards = scanner.nextInt();
        System.out.print("Red cards: ");
        int redCards = scanner.nextInt();
        System.out.print("Chances created: ");
        int chancesCreated = scanner.nextInt();
        System.out.print("Shots: ");
        int shots = scanner.nextInt();

        return new PlayerStats(goals, assists, minutesPlayed, yellowCards, redCards, chancesCreated, shots);
    }
}
