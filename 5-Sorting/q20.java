import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q20 {
    /*
     * Pattern: Sorting / Intervals Merge
     * Company Names: Google, Uber
     * Difficulty: Hard
     *
     * LeetCode #759: Employee Free Time
     *
     * Problem samajh lo:
     * Har employee ka busy schedule diya hota hai.
     * Humein sab employees ka common free time nikalna hai.
     *
     * Idea:
     * Saare intervals ko ek list me flatten karo.
     * Start time ke basis par sort karo.
     * Phir merge karte hue gaps nikaalo.
     * Do merged busy intervals ke beech ka gap hi common free time hota hai.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        List<List<Interval>> schedule = new ArrayList<>();
        schedule.add(Arrays.asList(new Interval(1, 2), new Interval(5, 6)));
        schedule.add(Arrays.asList(new Interval(1, 3)));
        schedule.add(Arrays.asList(new Interval(4, 10)));

        System.out.println(employeeFreeTime(schedule));
    }

    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> all = new ArrayList<>();

        for (List<Interval> employee : schedule) {
            all.addAll(employee);
        }

        all.sort((first, second) -> Integer.compare(first.start, second.start));

        List<Interval> answer = new ArrayList<>();
        Interval current = all.get(0);

        for (int i = 1; i < all.size(); i++) {
            Interval next = all.get(i);

            if (next.start > current.end) {
                answer.add(new Interval(current.end, next.start));
                current = next;
            } else {
                current.end = Math.max(current.end, next.end);
            }
        }

        return answer;
    }

    private static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }
}
