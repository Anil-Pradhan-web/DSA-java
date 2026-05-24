public class q3 {
    /*
     * Pattern: Circular Queue Design
     * Company Names: Wipro, Cognizant
     * Difficulty: Medium
     *
     * LeetCode #622: Design Circular Queue
     *
     * Problem samajh lo:
     * Fixed-size queue design karni hai jo circular array use kare.
     *
     * Circular queue me modulo use hota hai:
     * next index = (index + 1) % capacity
     *
     * Time Complexity: O(1) per operation
     * Space Complexity: O(k)
     */
    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
        System.out.println(queue.enQueue(1));
        System.out.println(queue.enQueue(2));
        System.out.println(queue.Front());
        System.out.println(queue.Rear());
    }

    static class MyCircularQueue {
        private final int[] data;
        private int front;
        private int rear;
        private int size;

        MyCircularQueue(int k) {
            data = new int[k];
            front = 0;
            rear = -1;
            size = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }

            rear = (rear + 1) % data.length;
            data[rear] = value;
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }

            front = (front + 1) % data.length;
            size--;
            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : data[front];
        }

        public int Rear() {
            return isEmpty() ? -1 : data[rear];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == data.length;
        }
    }
}
