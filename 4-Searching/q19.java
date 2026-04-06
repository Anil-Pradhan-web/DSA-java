import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q19 {
    /*
     * Pattern: Binary Search on Stored Values
     * Company Names: Google, Amazon
     * Difficulty: Medium
     *
     * LeetCode #981: Time Based Key-Value Store
     *
     * Problem samajh lo:
     * Humein key ke against different timestamps par values store karni hain.
     * Get operation me diya gaya timestamp ya usse chhota nearest timestamp ki value return karni hai.
     *
     * Important observation:
     * Har key ke timestamps increasing order me store kiye ja sakte hain.
     * Isliye get operation me last valid timestamp dhoondhne ke liye binary search lagti hai.
     *
     * Time Complexity:
     * set = O(1) amortized
     * get = O(log n)
     * Space Complexity: O(total entries)
     */
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1));
        System.out.println(timeMap.get("foo", 3));
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4));
        System.out.println(timeMap.get("foo", 5));
    }
}

class TimeMap {
    private final Map<String, List<Entry>> data = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        data.putIfAbsent(key, new ArrayList<>());
        data.get(key).add(new Entry(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Entry> entries = data.get(key);

        if (entries == null) {
            return "";
        }

        int left = 0;
        int right = entries.size() - 1;
        String answer = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (entries.get(mid).timestamp <= timestamp) {
                answer = entries.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private static class Entry {
        int timestamp;
        String value;

        Entry(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
