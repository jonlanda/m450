import java.text.DecimalFormat;

public class PlayerStatsCalculatorService {
    public double calculatePoints(PlayerStats player) {
        double points = 0.0;

        points += 5.0 * player.getGoals();
        points += 3.0 * player.getAssists();
        points += 0.1 * player.getMinutesPlayed();

        if (player.getMinutesPlayed() > 0) {
            double goalsPerMinute = (double) player.getGoals() / player.getMinutesPlayed();
            points += 10.0 * goalsPerMinute;
        } else {
            points = 0.0;
            return points;
        }

        points -= 2.0 * player.getYellowCards();
        points -= 4.0 * player.getRedCards();
        points += player.getChancesCreated();
        points += player.getShots();

        if (player.getGoals() > 0) {
            double shotsPerGoal = (double) player.getShots() / player.getGoals();
            if (shotsPerGoal > 0) {
                points += 1.0 / shotsPerGoal; // Use 1.0 instead of 5.0 here
            } else {
                points += 0.0;
            }
        }

        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(points));
    }
}

