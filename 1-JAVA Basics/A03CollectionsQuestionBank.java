import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

public class A03CollectionsQuestionBank {
    public static void main(String[] args) {
        q1ArrayListBasics();
        q2ArrayListMethods();
        q3ArrayListContains();
        q4LinkedListFrontBack();
        q5HashSetUniqueness();
        q6LinkedHashSetOrder();
        q7TreeSetSorting();
        q8HashMapPutGet();
        q9LinkedHashMapOrder();
        q10TreeMapSortedKeys();
        q11QueueOperations();
        q12DequeOperations();
        q13PriorityQueueMinHeap();
        q14ForEachIteration();
        q15MapIteration();
        q16CollectionsUtilityMethods();
        q17ArraysUtilityMethods();
        q18PrimitiveVsWrapper();
        q19WhenToUseWhichCollection();
    }

    private static void printHeading(int number, String question) {
        System.out.println();
        System.out.println("Q" + number + ": " + question);
    }

    // Q1: ArrayList kya hota hai?
    // Answer: Dynamic array hota hai jo size ko automatically manage karta hai.
    private static void q1ArrayListBasics() {
        printHeading(1, "Create an ArrayList and add elements");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("List = " + list);
    }

    // Q2: ArrayList ke common methods kaise use karte hain?
    // Answer: add, get, set, remove aur size frequently use hote hain.
    private static void q2ArrayListMethods() {
        printHeading(2, "Use common ArrayList methods");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(1, 15);
        list.set(0, 5);
        list.remove(2);

        System.out.println("List = " + list);
        System.out.println("First element = " + list.get(0));
        System.out.println("Size = " + list.size());
    }

    // Q3: ArrayList me search ka simple example kya hai?
    // Answer: contains method se check kar sakte hain ki value present hai ya nahi.
    private static void q3ArrayListContains() {
        printHeading(3, "Check whether ArrayList contains an element");
        ArrayList<String> names = new ArrayList<>();
        names.add("Anil");
        names.add("Rahul");

        System.out.println("Contains Rahul? " + names.contains("Rahul"));
        System.out.println("Contains Mohan? " + names.contains("Mohan"));
    }

    // Q4: LinkedList front aur back operations me useful kyon hota hai?
    // Answer: addFirst, addLast, removeFirst jaise operations easily milte hain.
    private static void q4LinkedListFrontBack() {
        printHeading(4, "Use LinkedList as a double-ended structure");
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.addFirst(5);
        list.addLast(20);
        System.out.println("Removed first = " + list.removeFirst());
        System.out.println("Remaining list = " + list);
    }

    // Q5: HashSet duplicate elements ko kaise handle karta hai?
    // Answer: Duplicate store hi nahi karta.
    private static void q5HashSetUniqueness() {
        printHeading(5, "Store unique elements using HashSet");
        HashSet<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(10);
        System.out.println("Set = " + set);
    }

    // Q6: LinkedHashSet ki khas baat kya hai?
    // Answer: Unique elements ke saath insertion order bhi maintain karta hai.
    private static void q6LinkedHashSetOrder() {
        printHeading(6, "Preserve insertion order using LinkedHashSet");
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.add(20);
        set.add(10);
        set.add(30);
        System.out.println("LinkedHashSet = " + set);
    }

    // Q7: TreeSet ka main use kya hai?
    // Answer: Elements sorted order me store hote hain.
    private static void q7TreeSetSorting() {
        printHeading(7, "Store sorted elements using TreeSet");
        TreeSet<Integer> set = new TreeSet<>();
        set.add(30);
        set.add(10);
        set.add(20);
        System.out.println("TreeSet = " + set);
    }

    // Q8: HashMap key-value pairs ko kaise store karta hai?
    // Answer: put se insert aur get se retrieve karte hain.
    private static void q8HashMapPutGet() {
        printHeading(8, "Use HashMap for key-value pairs");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Anil", 90);
        map.put("Rahul", 85);
        System.out.println("Anil marks = " + map.get("Anil"));
        System.out.println("Map = " + map);
    }

    // Q9: LinkedHashMap aur HashMap me difference kya hai?
    // Answer: LinkedHashMap insertion order maintain karta hai.
    private static void q9LinkedHashMapOrder() {
        printHeading(9, "Maintain insertion order using LinkedHashMap");
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(2, "B");
        map.put(1, "A");
        map.put(3, "C");
        System.out.println("LinkedHashMap = " + map);
    }

    // Q10: TreeMap ka behavior kya hota hai?
    // Answer: Keys sorted order me rehti hain.
    private static void q10TreeMapSortedKeys() {
        printHeading(10, "Store sorted keys using TreeMap");
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(3, "C");
        map.put(1, "A");
        map.put(2, "B");
        System.out.println("TreeMap = " + map);
    }

    // Q11: Queue me FIFO ka example do.
    // Answer: Jo element pehle aata hai, wahi pehle nikalta hai.
    private static void q11QueueOperations() {
        printHeading(11, "Use Queue with FIFO operations");
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println("Removed = " + queue.poll());
        System.out.println("Front now = " + queue.peek());
        System.out.println("Queue = " + queue);
    }

    // Q12: Deque kya hota hai?
    // Answer: Double-ended queue jisme front aur rear dono se operations possible hain.
    private static void q12DequeOperations() {
        printHeading(12, "Use Deque from both ends");
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(10);
        deque.addLast(20);
        deque.addFirst(5);

        System.out.println("Removed first = " + deque.removeFirst());
        System.out.println("Removed last = " + deque.removeLast());
        System.out.println("Deque = " + deque);
    }

    // Q13: PriorityQueue default me kya behave karta hai?
    // Answer: Min-heap, so smallest element first nikalta hai.
    private static void q13PriorityQueueMinHeap() {
        printHeading(13, "Use PriorityQueue as min-heap");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(30);
        pq.offer(10);
        pq.offer(20);

        System.out.println("First poll = " + pq.poll());
        System.out.println("Second poll = " + pq.poll());
    }

    // Q14: Collection ko for-each se kaise iterate karte hain?
    // Answer: for-each loop clean traversal ke liye useful hai.
    private static void q14ForEachIteration() {
        printHeading(14, "Iterate a collection using for-each loop");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        for (int value : list) {
            System.out.println(value);
        }
    }

    // Q15: Map iteration ka sahi tarika kya hai?
    // Answer: entrySet ke through key aur value dono access karte hain.
    private static void q15MapIteration() {
        printHeading(15, "Iterate over a map using entrySet");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Math", 95);
        map.put("Science", 88);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Q16: Collections utility class me kaunse useful methods hote hain?
    // Answer: sort, reverse, max aur min common helpers hain.
    private static void q16CollectionsUtilityMethods() {
        printHeading(16, "Use methods from Collections utility class");
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, 1, 3, 2));
        Collections.sort(list);
        System.out.println("Sorted = " + list);
        Collections.reverse(list);
        System.out.println("Reversed = " + list);
        System.out.println("Max = " + Collections.max(list));
        System.out.println("Min = " + Collections.min(list));
    }

    // Q17: Arrays utility class ka use kab karte hain?
    // Answer: Arrays.sort aur Arrays.toString primitive arrays par useful hote hain.
    private static void q17ArraysUtilityMethods() {
        printHeading(17, "Use Arrays utility methods");
        int[] arr = {3, 1, 2};
        Arrays.sort(arr);
        System.out.println("Sorted array = " + Arrays.toString(arr));
    }

    // Q18: Collections me primitive types directly kyon nahi use hote?
    // Answer: Collections generic types ke saath objects use karti hain, isliye wrapper classes chahiye.
    private static void q18PrimitiveVsWrapper() {
        printHeading(18, "Store primitive-like values using wrapper classes");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10); // int auto-box hokar Integer ban gaya.
        list.add(20);
        int sum = 0;

        for (int value : list) {
            sum += value; // Integer auto-unbox hokar int ban gaya.
        }

        System.out.println("List = " + list);
        System.out.println("Sum = " + sum);
    }

    // Q19: Different collections ko kab choose karna chahiye?
    // Answer: Need ke hisab se choose karte hain: random access, uniqueness, sorting ya FIFO.
    private static void q19WhenToUseWhichCollection() {
        printHeading(19, "Compare collection use cases");
        System.out.println("ArrayList -> random access");
        System.out.println("LinkedList -> front/back operations");
        System.out.println("HashSet -> unique elements");
        System.out.println("HashMap -> key-value lookup");
        System.out.println("TreeSet/TreeMap -> sorted data");
        System.out.println("Queue -> FIFO problems");
        System.out.println("Deque -> both stack and queue style");
        System.out.println("PriorityQueue -> min/max priority");
    }
}
