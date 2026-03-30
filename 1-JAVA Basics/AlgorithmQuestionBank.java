import java.util.Arrays;

public class AlgorithmQuestionBank {
    public static void main(String[] args) {
        q1ConstantTimeAccess();
        q2LinearLoopComplexity();
        q3SeparateLoops();
        q4NestedLoops();
        q5DependentInnerLoop();
        q6DoublingLoop();
        q7HalvingLoop();
        q8SimpleRecursion();
        q9RecursiveSum();
        q10NaiveFibonacci();
        q11LinearSearchCases();
        q12BinarySearch();
        q13AuxiliarySpaceConstant();
        q14AuxiliarySpaceLinear();
        q15BigOIgnoreConstants();
        q16DominatingTerm();
        q17SelectionSortStylePattern();
        q18PrefixSumIdea();
        q19CountDigitsLogN();
        q20ThetaOmegaBigO();
    }

    private static void printHeading(int number, String question) {
        System.out.println();
        System.out.println("Q" + number + ": " + question);
    }

    // Q1: Array ka first element access karne ki complexity kya hoti hai?
    // Answer: O(1), kyunki index access constant time hota hai.
    private static void q1ConstantTimeAccess() {
        printHeading(1, "Access the first element of an array");
        int[] arr = {11, 22, 33, 44};
        System.out.println("First element = " + arr[0]);
        System.out.println("Time Complexity = O(1)");
    }

    // Q2: Single loop ki time complexity kaise identify karte hain?
    // Answer: Loop n times chale to usually O(n).
    private static void q2LinearLoopComplexity() {
        printHeading(2, "Run a single loop from 0 to n - 1");
        int n = 5;

        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Time Complexity = O(n)");
    }

    // Q3: Do alag linear loops ka total complexity kya hogi?
    // Answer: O(n) + O(n) = O(n), because constants are ignored.
    private static void q3SeparateLoops() {
        printHeading(3, "Check complexity of two separate loops");
        int n = 4;

        for (int i = 0; i < n; i++) {
            System.out.print("A" + i + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print("B" + i + " ");
        }
        System.out.println();
        System.out.println("Overall Complexity = O(n)");
    }

    // Q4: Nested loops ki complexity kaise aati hai?
    // Answer: Outer n aur inner n ho to total O(n^2).
    private static void q4NestedLoops() {
        printHeading(4, "Run nested loops");
        int n = 3;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("(" + i + "," + j + ") ");
            }
            System.out.println();
        }
        System.out.println("Time Complexity = O(n^2)");
    }

    // Q5: Dependent inner loop ki complexity kya hoti hai?
    // Answer: 1 + 2 + ... + n pattern hota hai, isliye O(n^2).
    private static void q5DependentInnerLoop() {
        printHeading(5, "Use a dependent inner loop");
        int n = 4;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                count++;
            }
        }

        System.out.println("Total inner operations = " + count);
        System.out.println("Time Complexity = O(n^2)");
    }

    // Q6: i *= 2 wali loop ki complexity kya hoti hai?
    // Answer: Har step me value double hoti hai, so O(log n).
    private static void q6DoublingLoop() {
        printHeading(6, "Run a loop with doubling");
        int n = 32;

        for (int i = 1; i < n; i *= 2) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Time Complexity = O(log n)");
    }

    // Q7: i /= 2 wali loop ka pattern kya batata hai?
    // Answer: Har step me problem half hoti hai, so O(log n).
    private static void q7HalvingLoop() {
        printHeading(7, "Run a loop with halving");
        int n = 40;

        for (int i = n; i >= 1; i /= 2) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Time Complexity = O(log n)");
    }

    // Q8: fun(n - 1) type recursion ki complexity kya hoti hai?
    // Answer: Total n calls, so time O(n) and stack space O(n).
    private static void q8SimpleRecursion() {
        printHeading(8, "Demonstrate simple recursion");
        simpleRecursion(4);
        System.out.println("Time = O(n), Auxiliary Space = O(n)");
    }

    private static void simpleRecursion(int n) {
        if (n == 0) {
            return;
        }
        System.out.println("Call with n = " + n);
        simpleRecursion(n - 1);
    }

    // Q9: Recursion se 1 se n tak sum kaise nikalte hain?
    // Answer: sum(n) = n + sum(n - 1), base case at 0.
    private static void q9RecursiveSum() {
        printHeading(9, "Find recursive sum from 1 to n");
        int n = 5;
        System.out.println("Sum = " + recursiveSum(n));
        System.out.println("Time Complexity = O(n)");
    }

    private static int recursiveSum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + recursiveSum(n - 1);
    }

    // Q10: Naive Fibonacci recursion slow kyon hoti hai?
    // Answer: Har call do aur calls karti hai, approx O(2^n).
    private static void q10NaiveFibonacci() {
        printHeading(10, "Compute Fibonacci using naive recursion");
        int n = 6;
        System.out.println("fib(" + n + ") = " + fib(n));
        System.out.println("Time Complexity approx = O(2^n)");
    }

    private static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // Q11: Linear search ka best aur worst case kya hota hai?
    // Answer: Best O(1), worst O(n).
    private static void q11LinearSearchCases() {
        printHeading(11, "Perform linear search");
        int[] arr = {4, 9, 1, 7, 5};
        int foundIndex = linearSearch(arr, 7);
        int notFoundIndex = linearSearch(arr, 99);

        System.out.println("Index of 7 = " + foundIndex);
        System.out.println("Index of 99 = " + notFoundIndex);
        System.out.println("Best Case = O(1), Worst Case = O(n)");
    }

    private static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    // Q12: Binary search kab use hota hai?
    // Answer: Sorted array par, aur iski worst-case complexity O(log n) hoti hai.
    private static void q12BinarySearch() {
        printHeading(12, "Perform binary search on sorted array");
        int[] arr = {2, 4, 6, 8, 10, 12, 14};
        int key = 10;
        int index = binarySearch(arr, key);

        System.out.println("Array = " + Arrays.toString(arr));
        System.out.println("Index of " + key + " = " + index);
        System.out.println("Worst Case Complexity = O(log n)");
    }

    private static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    // Q13: Extra variables ke saath array sum karne me auxiliary space kitni hoti hai?
    // Answer: O(1), kyunki sirf fixed number of variables use ho rahe hain.
    private static void q13AuxiliarySpaceConstant() {
        printHeading(13, "Find sum with constant extra space");
        int[] arr = {3, 6, 9};
        int sum = 0;

        for (int value : arr) {
            sum += value;
        }

        System.out.println("Sum = " + sum);
        System.out.println("Auxiliary Space = O(1)");
    }

    // Q14: Extra copy array banane se auxiliary space kya hoti hai?
    // Answer: O(n), kyunki input ke alawa n size ka extra array use hua.
    private static void q14AuxiliarySpaceLinear() {
        printHeading(14, "Copy one array into another array");
        int[] original = {1, 2, 3, 4};
        int[] copy = new int[original.length];

        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }

        System.out.println("Copied array = " + Arrays.toString(copy));
        System.out.println("Auxiliary Space = O(n)");
    }

    // Q15: O(2n) ko simplify kaise karte hain?
    // Answer: Constants ignore karte hain, so result O(n).
    private static void q15BigOIgnoreConstants() {
        printHeading(15, "Understand why constants are ignored in Big O");
        int n = 5;
        int operations = 0;

        for (int i = 0; i < n; i++) {
            operations++;
        }
        for (int i = 0; i < n; i++) {
            operations++;
        }

        System.out.println("Operations counted = " + operations);
        System.out.println("Complexity simplified from O(2n) to O(n)");
    }

    // Q16: O(n^2 + n + 100) me dominating term kya hoti hai?
    // Answer: n^2, because largest growth term dominate karta hai.
    private static void q16DominatingTerm() {
        printHeading(16, "Find dominating term in a complexity expression");
        System.out.println("Expression = O(n^2 + n + 100)");
        System.out.println("Simplified Answer = O(n^2)");
    }

    // Q17: Selection-sort style double loop ka pattern kya hota hai?
    // Answer: Usually O(n^2), because comparisons nested pattern me hote hain.
    private static void q17SelectionSortStylePattern() {
        printHeading(17, "Count comparisons in selection-sort style pattern");
        int[] arr = {5, 2, 4, 1};
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                comparisons++;
            }
        }

        System.out.println("Comparisons = " + comparisons);
        System.out.println("Time Complexity = O(n^2)");
    }

    // Q18: Prefix sum ka basic fayda kya hota hai?
    // Answer: Range sum queries fast ho jati hain after preprocessing.
    private static void q18PrefixSumIdea() {
        printHeading(18, "Build a prefix sum array");
        int[] arr = {2, 4, 6, 8};
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        System.out.println("Prefix = " + Arrays.toString(prefix));
        System.out.println("Range sum (1 to 3) = " + (prefix[3] - prefix[0]));
    }

    // Q19: Kisi number ke digits count karne me O(log n) ka intuition kya hai?
    // Answer: Har division by 10 se number chhota hota hai, so steps digits ke equal hote hain.
    private static void q19CountDigitsLogN() {
        printHeading(19, "Count digits of a number");
        int number = 987654;
        int count = 0;
        int temp = number;

        while (temp > 0) {
            count++;
            temp /= 10;
        }

        System.out.println("Digits in " + number + " = " + count);
        System.out.println("Time Complexity = O(log n)");
    }

    // Q20: Big O, Omega aur Theta me difference kya hai?
    // Answer: Big O upper bound, Omega lower bound, Theta tight bound.
    private static void q20ThetaOmegaBigO() {
        printHeading(20, "Compare Big O, Omega and Theta");
        System.out.println("For a loop that always runs n times:");
        System.out.println("Big O = O(n)");
        System.out.println("Omega = Omega(n)");
        System.out.println("Theta = Theta(n)");
    }
}
