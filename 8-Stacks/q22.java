import java.util.Arrays;

public class q22 {
    /*
     * Pattern: Sorting + Stack-like Greedy
     * Company Names: Google, Amazon
     * Difficulty: Medium
     *
     * LeetCode #853: Car Fleet
     *
     * Problem samajh lo:
     * Cars target ki taraf move kar rahi hain.
     * Faster car slow car ko overtake nahi karegi; wo us fleet ka part ban jayegi.
     *
     * Idea:
     * Cars ko position ke basis par sort karo.
     * Right se left aao aur arrival time compare karo.
     * Agar current time previous fleet time se bada hai, new fleet banti hai.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        System.out.println(carFleet(target, position, speed));
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (first, second) -> Integer.compare(first[0], second[0]));

        int fleets = 0;
        double lastTime = 0;

        for (int i = n - 1; i >= 0; i--) {
            double time = (double) (target - cars[i][0]) / cars[i][1];

            if (time > lastTime) {
                fleets++;
                lastTime = time;
            }
        }

        return fleets;
    }
}
