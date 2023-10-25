package warmup.octSixteenth;

public class Main {
    public static void main(String[] args) {
        //created the int [array] with
        int[] matchGoals = {2, 3, 1, 4, 2, 0, 2, 1, 3, 2};
        // 0 foals{2,3,1,4,2,0,2,1,3,2} = 20
        int totalPoints = 0;
        for (int touchdowns : matchGoals) {
            totalPoints += touchdowns;
        }

        double averageGoals = (double) totalPoints / matchGoals.length;

        System.out.println("Total number of goals scored: " + totalPoints);
        System.out.println("Average number of goals per match: " + averageGoals);
    }
}


