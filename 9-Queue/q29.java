import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * Pattern: Monotonic Stack/Deque Boundary Calculation
 * Company Names: Amazon
 * Difficulty: Medium
 *
 * Problem: Maximum of Minimum for Every Window Size
 * Platform: GFG
 *
 * Hinglish Explanation:
 * Har window size ke liye us window ka minimum nikalna hai, phir un minimums
 * mein maximum answer hota hai.
 *
 * Brute force O(n^2) ya O(n^3) ja sakta hai.
 *
 * Optimized idea:
 * Har element ko minimum maan ke dekho. Ye element kitni badi window tak
 * minimum reh sakta hai?
 *
 * Uske liye:
 * - Previous smaller element ka index nikalo.
 * - Next smaller element ka index nikalo.
 * - Window length = nextSmaller - prevSmaller - 1.
 *
 * arr[i] us length ki window ka possible minimum hai.
 * answer[length] = max(answer[length], arr[i])
 *
 * Last mein suffix maximum fill karo, kyunki choti windows ke answer bade
 * windows se at least improve ho sakte hain.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class q29 {
    public static int[] maxOfMin(int[] arr) {
        int n = arr.length;
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            prevSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextSmaller[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int[] answer = new int[n];
        Arrays.fill(answer, Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            int windowLength = nextSmaller[i] - prevSmaller[i] - 1;
            answer[windowLength - 1] = Math.max(answer[windowLength - 1], arr[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            answer[i] = Math.max(answer[i], answer[i + 1]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 50, 10, 70, 30};
        System.out.println(Arrays.toString(maxOfMin(arr)));
    }
}
