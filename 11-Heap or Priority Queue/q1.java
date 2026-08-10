import java.util.PriorityQueue;

public class q1 {
    /*
     * Pattern: Heap / Max Heap
     * Company Names: Amazon, Google, Bloomberg
     * Difficulty: Easy
     *
     * LeetCode #1046: Last Stone Weight
     *
     * Problem samajh lo:
     * Humein stones ki weights di gayi hain.
     * Har step me sabse bade do stones ko todna hai:
     * - Agar dono ka weight equal hai, to dono destroy ho jate hain.
     * - Agar unequal hain, to bade stone me se chhote wale ka weight subtract karke
     *   bacha hua weight wapas stones me add hota hai.
     *
     * Is process ko tab tak repeat karna hai jab tak 0 ya 1 stone bache.
     *
     * Example:
     * stones = [2, 7, 4, 1, 8, 1]
     * Step 1: 8 aur 7 -> 1 bacha
     * Step 2: 4 aur 2 -> 2 bacha
     * Step 3: 2 aur 1 -> 1 bacha
     * Step 4: 1 aur 1 -> 0
     * Answer = 0
     *
     * Best idea:
     * Max heap use karo taaki har baar sabse bade do stones O(1) me top par mil jayein.
     * Har iteration me do baar poll karo, difference nikaalo, aur agar > 0 hai to wapas add karo.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println("Last stone weight = " + lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int largest = maxHeap.poll();
            int secondLargest = maxHeap.poll();

            int diff = largest - secondLargest;
            if (diff > 0) {
                maxHeap.add(diff);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}