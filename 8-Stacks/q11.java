import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class q11 {
    /*
     * Pattern: Stack / Simulation
     * Company Names: Amazon, Bloomberg
     * Difficulty: Medium
     *
     * LeetCode #735: Asteroid Collision
     *
     * Problem samajh lo:
     * Positive asteroid right move karta hai,
     * negative left move karta hai.
     * Collisions resolve karni hain.
     *
     * Stack current surviving asteroids ko maintain karti hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            boolean alive = true;

            while (alive && asteroid < 0 && !stack.isEmpty() && stack.peek() > 0) {
                if (stack.peek() < -asteroid) {
                    stack.pop();
                } else if (stack.peek() == -asteroid) {
                    stack.pop();
                    alive = false;
                } else {
                    alive = false;
                }
            }

            if (alive) {
                stack.push(asteroid);
            }
        }

        int[] answer = new int[stack.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}
