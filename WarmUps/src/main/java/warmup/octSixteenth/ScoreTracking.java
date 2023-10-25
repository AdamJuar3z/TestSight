package warmup.octSixteenth;

public class ScoreTracking {

    private String lions;
    private int matchGoals;
    private int pointScored;

    public ScoreTracking(String lions, int matchGoals, int pointScored) {
        this.lions = lions;
        this.matchGoals = matchGoals;
        this.pointScored = pointScored;
    }

    public String getLions() {
        return lions;
    }

    public void setLions(String lions) {
        this.lions = lions;
    }

    public int getMatchGoals() {
        return matchGoals;
    }

    public void setMatchGoals(int matchGoals) {
        this.matchGoals = matchGoals;
    }

    public int getPointScored() {
        return pointScored;
    }

    public void setPointScored(int pointScored) {
        this.pointScored = pointScored;
    }
}
