public class q11 {
    /*
     * Pattern: Prefix Sum / HashMap
     * Company Names: Amazon, Microsoft
     *
     * LeetCode #287: Find Duplicate Number
     *
     * Problem samajh lo:
     * Array me numbers 1 se n range ke hote hain,
     * aur size n + 1 hota hai, isliye ek number duplicate hona guaranteed hai.
     * Humein wahi duplicate return karna hai.
     *
     * Example:
     * nums = [1, 3, 4, 2, 2]
     * Answer = 2
     *
     * Best idea:
     * Is problem ko linked list cycle jaisa treat karte hain.
     * Har index ek node hai aur nums[index] next pointer jaisa behave karta hai.
     * Duplicate hone ki wajah se cycle ban jaati hai.
     *
     * Floyd's Cycle Detection:
     * 1. Slow pointer ek step chalega
     * 2. Fast pointer do step chalega
     * 3. Dono cycle ke andar milenge
     *
     * Phir:
     * Slow ko start par reset karo
     * Ab slow aur fast dono ek-ek step chalayenge
     * Jahan milenge wahi duplicate number hoga
     *
     * Yeh approach smart hai kyunki:
     * 1. Array modify nahi hota
     * 2. Extra space nahi lagti
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println("Duplicate = " + findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
