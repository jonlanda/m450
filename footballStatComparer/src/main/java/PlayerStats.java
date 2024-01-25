public class PlayerStats {
    private int goals;
    private int assists;
    private int minutesPlayed;
    private int yellowCards;
    private int redCards;
    private int chancesCreated;
    private int shots;

    public PlayerStats(int goals, int assists, int minutesPlayed, int yellowCards, int redCards, int chancesCreated, int shots) {
        this.goals = goals;
        this.assists = assists;
        this.minutesPlayed = minutesPlayed;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.chancesCreated = chancesCreated;
        this.shots = shots;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }

    public int getMinutesPlayed() {
        return minutesPlayed;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public int getRedCards() {
        return redCards;
    }

    public int getChancesCreated() {
        return chancesCreated;
    }

    public int getShots() {
        return shots;
    }
}
