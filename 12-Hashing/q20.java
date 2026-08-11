import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class q20 {
    /*
     * Pattern: Hashing / HashMap + ArrayList
     * Company Names: Amazon, Google, Meta, Microsoft, Apple
     * Difficulty: Medium
     *
     * LeetCode #380: Insert Delete GetRandom O(1)
     *
     * Problem samajh lo:
     * Humein ek data structure design karna hai jisme:
     * - insert(val): value add karo (false agar already hai)
     * - remove(val): value delete karo (false agar nahi hai)
     * - getRandom(): random value return karo
     * Sab operations O(1) me hone chahiye.
     *
     * Example:
     * insert(1) -> true
     * insert(2) -> true
     * getRandom() -> 1 ya 2
     * remove(1) -> true
     * getRandom() -> 2
     *
     * Best idea:
     * HashMap + ArrayList use karo.
     * - ArrayList: values store karta hai (random access ke liye)
     * - HashMap: value -> index (O(1) lookup ke liye)
     *
     * Remove ka trick:
     * Element ko last element se swap karo, phir last remove karo.
     * Isse O(1) me remove hota hai bina shift kiye.
     *
     * Time Complexity: O(1) for all operations
     * Space Complexity: O(n)
     */
    static class RandomizedSet {
        private Map<Integer, Integer> map; // value -> index
        private List<Integer> list; // values
        private Random random;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }

            map.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }

            int index = map.get(val);
            int lastElement = list.get(list.size() - 1);

            // Last element ko current index par swap karo
            list.set(index, lastElement);
            map.put(lastElement, index);

            // Last remove karo
            list.remove(list.size() - 1);
            map.remove(val);

            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        System.out.println("insert(1) = " + set.insert(1));
        System.out.println("insert(2) = " + set.insert(2));
        System.out.println("insert(1) again = " + set.insert(1)); // false
        System.out.println("remove(1) = " + set.remove(1));
        System.out.println("getRandom() = " + set.getRandom());
    }
}