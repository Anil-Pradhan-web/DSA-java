import java.util.PriorityQueue;

public class q11 {
    /*
     * Pattern: Heap / Two Heaps
     * Company Names: Amazon, Google, Meta, Microsoft, Goldman Sachs
     * Difficulty: Hard
     *
     * LeetCode #295: Find Median from Data Stream
     *
     * Problem samajh lo:
     * Ek data stream me numbers aate rehte hain. Humein har baar
     * current stream ka median nikalna hai.
     *
     * Median kya hota hai?
     * Even count: do middle elements ka average
     * Odd count: middle element
     *
     * Example:
     * addNum(1) -> median = 1
     * addNum(2) -> median = 1.5
     * addNum(3) -> median = 2
     *
     * Best idea:
     * Do heaps use karo:
     * - Max heap (left half): stream ke chhote half elements
     * - Min heap (right half): stream ke bade half elements
     *
     * Invariant:
     * - maxHeap.size() >= minHeap.size() (at most 1 difference)
     * - maxHeap ka top = left ka sabse bada
     * - minHeap ka top = right ka sabse chhota
     *
     * Median:
     * - Odd size: maxHeap.peek()
     * - Even size: (maxHeap.peek() + minHeap.peek()) / 2.0
     *
     * Time Complexity: addNum O(log n), findMedian O(1)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("Median = " + medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println("Median = " + medianFinder.findMedian());
    }

    static class MedianFinder {
        // Max heap for smaller half
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // Min heap for larger half
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        public void addNum(int num) {
            // Pehle max heap me daalo
            maxHeap.add(num);

            // Balance karo: maxHeap ka top hamesha minHeap ke top se chhota hona chahiye
            if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                minHeap.add(maxHeap.poll());
            }

            // Size balance karo
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            }
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            }
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}