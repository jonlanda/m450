import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PlayerStatsCalculatorServiceTest {

    private PlayerStatsCalculatorService calculator;

    @BeforeAll
    public void setUp() {
        calculator = new PlayerStatsCalculatorService();
    }

    @Test
    public void testCalculatePoints() {
        PlayerStats playerStats = new PlayerStats(5, 3, 90, 2, 0, 8, 15);
        double expectedPoints = 62.89;
        double actualPoints = calculator.calculatePoints(playerStats);
        assertEquals(expectedPoints, actualPoints);
    }

    @Test
    public void testCalculatePointsWithZeroMinutesPlayed() {
        PlayerStats playerStats = new PlayerStats(3, 2, 0, 1, 0, 5, 10);
        int expectedPoints = 0;
        double actualPoints = calculator.calculatePoints(playerStats);
        assertEquals(expectedPoints, actualPoints);
    }

    @Test
    public void testCalculatePointsWithZeroStats() {
        PlayerStats playerStats = new PlayerStats(0, 0, 90, 0, 0, 0, 0);
        int expectedPoints = 9;
        double actualPoints = calculator.calculatePoints(playerStats);
        assertEquals(expectedPoints, actualPoints);
    }

    @Test
    public void testCalculatePointsWithShotsPerGoal() {
        PlayerStats playerStats = new PlayerStats(4, 2, 120, 1, 0, 5, 20);
        double expectedPoints = 61.53;
        double actualPoints = calculator.calculatePoints(playerStats);
        assertEquals(expectedPoints, actualPoints);
    }

    @Test
    public void testCalculatePointsForOneGoal() {
        PlayerStats playerStats = new PlayerStats(1, 0, 90, 0, 0, 0, 1);
        double expectedPoints = 16.11;
        double actualPoints = calculator.calculatePoints(playerStats);
        assertEquals(expectedPoints, actualPoints);
    }

    @Test
    public void testComparePlayersAndDetermineWinner() {
        PlayerStats player1 = new PlayerStats(3, 2, 90, 1, 0, 5, 15);
        PlayerStats player2 = new PlayerStats(2, 3, 90, 0, 0, 7, 10);

        double points1 = calculator.calculatePoints(player1);
        double points2 = calculator.calculatePoints(player2);

        assertEquals(48.53, points1);
        assertEquals(45.42, points2);
        assertTrue(points1 > points2);
    }
}
