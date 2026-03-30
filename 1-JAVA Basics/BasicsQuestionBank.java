public class BasicsQuestionBank {
    public static void main(String[] args) {
        q1VariablesAndTypes();
        q2ArithmeticOperators();
        q3RelationalAndLogicalOperators();
        q4EvenOddWithIfElse();
        q5ElseIfLadder();
        q6ForLoopSum();
        q7WhileLoopCountdown();
        q8DoWhileRunsOnce();
        q9OneDimensionalArray();
        q10LargestInArray();
        q11TwoDimensionalArray();
        q12MethodWithoutParameters();
        q13MethodWithParameters();
        q14PassByValue();
        q15RecursiveFactorial();
        q16RecursiveCountdown();
        q17ClassAndObject();
        q18InheritanceExample();
        q19MethodOverriding();
        q20TryCatchFinally();
    }

    private static void printHeading(int number, String question) {
        System.out.println();
        System.out.println("Q" + number + ": " + question);
    }

    // Q1: Different data types ka use kaise karte hain?
    // Answer: int, double, char, boolean aur String apne-apne type ka data store karte hain.
    private static void q1VariablesAndTypes() {
        printHeading(1, "Declare and print different basic data types");
        int age = 21;
        double price = 99.99;
        char grade = 'A';
        boolean isJavaFun = true;
        String name = "Anil";

        System.out.println("Age = " + age);
        System.out.println("Price = " + price);
        System.out.println("Grade = " + grade);
        System.out.println("isJavaFun = " + isJavaFun);
        System.out.println("Name = " + name);
    }

    // Q2: Arithmetic operators kya kaam karte hain?
    // Answer: +, -, *, / aur % basic mathematical operations perform karte hain.
    private static void q2ArithmeticOperators() {
        printHeading(2, "Use arithmetic operators");
        int a = 10;
        int b = 3;

        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));
    }

    // Q3: Relational aur logical operators ka combined use ka example do.
    // Answer: Comparison se true/false milta hai, phir logical operators conditions ko combine karte hain.
    private static void q3RelationalAndLogicalOperators() {
        printHeading(3, "Check relational and logical conditions");
        int x = 5;
        int y = 8;
        boolean hasID = true;

        System.out.println("x < y = " + (x < y));
        System.out.println("x == y = " + (x == y));
        System.out.println("(y > x) && hasID = " + ((y > x) && hasID));
        System.out.println("(x > y) || hasID = " + ((x > y) || hasID));
    }

    // Q4: if-else se even ya odd kaise check karte hain?
    // Answer: Number ko 2 se divide karke remainder 0 ho to even, warna odd.
    private static void q4EvenOddWithIfElse() {
        printHeading(4, "Find whether a number is even or odd");
        int number = 14;

        if (number % 2 == 0) {
            System.out.println(number + " is even");
        } else {
            System.out.println(number + " is odd");
        }
    }

    // Q5: else-if ladder ka practical use kya hai?
    // Answer: Multiple ranges ya conditions ko top-down order me check karne ke liye.
    private static void q5ElseIfLadder() {
        printHeading(5, "Assign grade using else-if ladder");
        int marks = 85;

        if (marks >= 90) {
            System.out.println("Grade A+");
        } else if (marks >= 75) {
            System.out.println("Grade A");
        } else if (marks >= 40) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    // Q6: for loop ka use karke 1 se 5 tak sum nikalo.
    // Answer: Fixed number of iterations ho to for loop best hota hai.
    private static void q6ForLoopSum() {
        printHeading(6, "Sum numbers from 1 to 5 using for loop");
        int sum = 0;

        for (int i = 1; i <= 5; i++) {
            sum += i;
        }

        System.out.println("Sum = " + sum);
    }

    // Q7: while loop kab use karna chahiye?
    // Answer: Jab loop condition-based ho aur iteration count pehle se fixed na ho.
    private static void q7WhileLoopCountdown() {
        printHeading(7, "Print countdown using while loop");
        int i = 5;

        while (i >= 1) {
            System.out.println(i);
            i--;
        }
    }

    // Q8: do-while ki khas baat kya hoti hai?
    // Answer: Condition false ho tab bhi block kam se kam ek baar run hota hai.
    private static void q8DoWhileRunsOnce() {
        printHeading(8, "Show that do-while executes at least once");
        int i = 10;

        do {
            System.out.println("This prints once even though condition is false.");
            i++;
        } while (i < 10);
    }

    // Q9: 1D array ko kaise traverse karte hain?
    // Answer: Index-based loop ya for-each loop dono se elements access kar sakte hain.
    private static void q9OneDimensionalArray() {
        printHeading(9, "Traverse a one-dimensional array");
        int[] numbers = {10, 20, 30, 40};

        for (int value : numbers) {
            System.out.println(value);
        }
    }

    // Q10: Array ka largest element kaise nikalte hain?
    // Answer: Pehle element ko max maan kar baaki sab se compare karte hain.
    private static void q10LargestInArray() {
        printHeading(10, "Find the largest element in an array");
        int[] numbers = {12, 45, 7, 89, 32};
        int max = numbers[0];

        for (int value : numbers) {
            if (value > max) {
                max = value;
            }
        }

        System.out.println("Largest = " + max);
    }

    // Q11: 2D array ko matrix ki tarah kaise print karte hain?
    // Answer: Nested loops row aur column dono ko traverse karte hain.
    private static void q11TwoDimensionalArray() {
        printHeading(11, "Print a two-dimensional array");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    // Q12: Method bina parameters ke kya karta hai?
    // Answer: Reusable block hota hai jo fixed kaam perform karta hai.
    private static void q12MethodWithoutParameters() {
        printHeading(12, "Call a method without parameters");
        greet();
    }

    private static void greet() {
        System.out.println("Hello, Java!");
    }

    // Q13: Method with parameters ka example do.
    // Answer: Parameters method ko dynamic input dete hain.
    private static void q13MethodWithParameters() {
        printHeading(13, "Add two numbers using a method");
        int result = add(5, 7);
        System.out.println("Result = " + result);
    }

    private static int add(int a, int b) {
        return a + b;
    }

    // Q14: Java me pass by value ka matlab kya hota hai?
    // Answer: Primitive value ki copy pass hoti hai, original variable unchanged rehta hai.
    private static void q14PassByValue() {
        printHeading(14, "Show pass by value with primitive type");
        int num = 10;
        changeValue(num);
        System.out.println("Original num = " + num);
    }

    private static void changeValue(int x) {
        x = 100;
        System.out.println("Changed copy inside method = " + x);
    }

    // Q15: Recursion se factorial kaise nikalte hain?
    // Answer: n * factorial(n - 1) until base case 0 or 1.
    private static void q15RecursiveFactorial() {
        printHeading(15, "Find factorial using recursion");
        int n = 5;
        System.out.println("Factorial of " + n + " = " + factorial(n));
    }

    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // Q16: Recursion me base case kyon zaroori hai?
    // Answer: Base case infinite recursive calls ko rokta hai.
    private static void q16RecursiveCountdown() {
        printHeading(16, "Print numbers recursively");
        printNumbers(5);
    }

    private static void printNumbers(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printNumbers(n - 1);
    }

    // Q17: Class aur object ka simple example do.
    // Answer: Class blueprint hoti hai aur object us blueprint ka instance hota hai.
    private static void q17ClassAndObject() {
        printHeading(17, "Create object from a class");
        Car car = new Car();
        car.brand = "Toyota";
        car.speed = 120;
        car.display();
    }

    // Q18: Inheritance ka fayda kya hai?
    // Answer: Child class parent class ke common members reuse kar sakti hai.
    private static void q18InheritanceExample() {
        printHeading(18, "Use inheritance in Java");
        Dog dog = new Dog();
        dog.sound();
        dog.bark();
    }

    // Q19: Method overriding kya hota hai?
    // Answer: Child class parent ke method ko apne behavior ke saath redefine karti hai.
    private static void q19MethodOverriding() {
        printHeading(19, "Demonstrate runtime polymorphism");
        Animal animal = new Puppy();
        animal.sound();
    }

    // Q20: try-catch-finally ka use kyon karte hain?
    // Answer: Runtime exceptions ko handle karne aur cleanup code chalane ke liye.
    private static void q20TryCatchFinally() {
        printHeading(20, "Handle exception using try-catch-finally");

        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Zero se divide nahi kar sakte");
        } finally {
            System.out.println("Finally block always runs");
        }
    }
}

class Car {
    String brand;
    int speed;

    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed);
    }
}

class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

class Puppy extends Animal {
    @Override
    void sound() {
        System.out.println("Bark");
    }
}
