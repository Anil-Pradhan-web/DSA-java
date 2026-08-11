import java.util.HashSet;
import java.util.Set;

public class q7 {
    /*
     * Pattern: Hashing / HashSet
     * Company Names: Amazon, Google, Meta, Uber
     * Difficulty: Easy
     *
     * LeetCode #202: Happy Number
     *
     * Problem samajh lo:
     * Ek number happy hai agar:
     * 1. Number ke digits ka square sum nikalte raho
     * 2. Agar kabhi 1 aa jaye, to happy number hai
     * 3. Agar cycle me phas jao (same number dobara aaye), to happy nahi hai
     *
     * Example:
     * n = 19
     * Step 1: 1^2 + 9^2 = 82
     * Step 2: 8^2 + 2^2 = 68
     * Step 3: 6^2 + 8^2 = 100
     * Step 4: 1^2 + 0^2 + 0^2 = 1
     * Answer = true (1 aa gaya)
     *
     * n = 2
     * 2 -> 4 -> 16 -> 37 -> 58 -> 89 -> 145 -> 42 -> 20 -> 4 (cycle!)
     * Answer = false
     *
     * Best idea:
     * HashSet use karo jo dekhe gaye numbers ko track kare.
     * Har step me naya number calculate karo.
     * Agar 1 mil gaya, to true.
     * Agar number pehle se set me hai, to cycle hai — false.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(log n)
     */
    public static void main(String[] args) {
        int n = 19;
        System.out.println("Is happy number = " + isHappy(n));
    }

    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = sumOfSquares(n);
        }

        return n == 1;
    }

    private static int sumOfSquares(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }
}