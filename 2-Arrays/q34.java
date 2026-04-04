public class q34 {
    /*
     * Pattern: Additional Important Array Problems
     * Company Names: Not specified in your list
     *
     * Problem: Gas Station
     *
     * Problem samajh lo:
     * Circular route par gas aur cost arrays diye hote hain.
     * Humein starting station ka index batana hai jahan se poora circle complete ho sake.
     * Agar possible na ho to -1 return karna hai.
     *
     * Example:
     * gas = [1, 2, 3, 4, 5]
     * cost = [3, 4, 5, 1, 2]
     * Answer = 3
     *
     * Greedy intuition:
     * Agar total gas total cost se kam hai, answer impossible hai.
     * Agar total enough hai, to ek valid start zaroor exist karta hai.
     *
     * Running tank maintain karo.
     * Agar kisi point par tank negative ho jaye,
     * to current start se yahan tak koi bhi station valid start nahi ho sakta.
     * Isliye next station ko new start bana do.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println("Start index = " + canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;

            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return total >= 0 ? start : -1;
    }
}
