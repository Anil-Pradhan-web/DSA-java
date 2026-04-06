public class q27 {
    /*
     * Pattern: Binary Search on Answer
     * Company Names: Amazon, Flipkart
     *
     * Problem: Allocate Books
     *
     * Problem samajh lo:
     * Books ko students me contiguous order me allocate karna hai.
     * Maximum pages assigned to a student minimum honi chahiye.
     *
     * Ye exact binary search on answer pattern ka classic question hai.
     * Candidate answer = allowed maximum pages per student
     *
     * Time Complexity: O(n log(sum))
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] books = {12, 34, 67, 90};
        int students = 2;
        System.out.println(allocateBooks(books, students));
    }

    public static int allocateBooks(int[] books, int students) {
        if (students > books.length) {
            return -1;
        }

        int low = 0;
        int high = 0;

        for (int pages : books) {
            low = Math.max(low, pages);
            high += pages;
        }

        int answer = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canAllocate(books, students, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    private static boolean canAllocate(int[] books, int students, int maxPages) {
        int usedStudents = 1;
        int currentPages = 0;

        for (int pages : books) {
            if (currentPages + pages > maxPages) {
                usedStudents++;
                currentPages = pages;
            } else {
                currentPages += pages;
            }
        }

        return usedStudents <= students;
    }
}
