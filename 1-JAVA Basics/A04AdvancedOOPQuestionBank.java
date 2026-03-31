public class A04AdvancedOOPQuestionBank {
    public static void main(String[] args) {
        q1ConstructorBasics();
        q2ThisKeyword();
        q3ConstructorOverloading();
        q4AccessModifiers();
        q5Encapsulation();
        q6AbstractClass();
        q7InterfaceExample();
        q8AbstractVsInterface();
        q9StaticVariable();
        q10StaticMethod();
        q11FinalVariable();
        q12FinalMethodAndClass();
        q13ReferenceVsContentComparison();
        q14WrapperClasses();
        q15AutoboxingAndUnboxing();
        q16PackageAndImportIdea();
        q17MainMethodArguments();
        q18SwitchBreakContinue();
        q19ForEachLoop();
        q20StringBuilder();
    }

    private static void printHeading(int number, String question) {
        System.out.println();
        System.out.println("Q" + number + ": " + question);
    }

    // Q1: Constructor kya hota hai?
    // Answer: Special member hota hai jo object creation ke time automatically call hota hai.
    private static void q1ConstructorBasics() {
        printHeading(1, "Create object using a constructor");
        Student student = new Student("Anil", 21);
        System.out.println(student);
    }

    // Q2: this keyword ka use kyon hota hai?
    // Answer: Current object ke instance variable ko refer karne ke liye.
    private static void q2ThisKeyword() {
        printHeading(2, "Use this keyword to resolve variable shadowing");
        CarInfo car = new CarInfo("Honda");
        System.out.println("Brand = " + car.brand);
    }

    // Q3: Constructor overloading kya hota hai?
    // Answer: Ek hi class me multiple constructors with different parameter lists.
    private static void q3ConstructorOverloading() {
        printHeading(3, "Demonstrate constructor overloading");
        Box defaultBox = new Box();
        Box customBox = new Box(10, 20);

        System.out.println("Default box area = " + defaultBox.area());
        System.out.println("Custom box area = " + customBox.area());
    }

    // Q4: Access modifiers kya control karte hain?
    // Answer: Members ki visibility aur accessibility control karte hain.
    private static void q4AccessModifiers() {
        printHeading(4, "Show access modifier summary");
        System.out.println("public -> everywhere");
        System.out.println("private -> same class only");
        System.out.println("protected -> package + inheritance");
        System.out.println("default -> same package");
    }

    // Q5: Encapsulation ka simple example do.
    // Answer: Data ko private rakho aur public getter/setter se access do.
    private static void q5Encapsulation() {
        printHeading(5, "Protect data using encapsulation");
        BankAccount account = new BankAccount();
        account.setBalance(5000.0);
        System.out.println("Balance = " + account.getBalance());
    }

    // Q6: Abstract class kab use karte hain?
    // Answer: Jab kuch common implementation ho aur kuch methods subclasses complete karein.
    private static void q6AbstractClass() {
        printHeading(6, "Use an abstract class");
        AnimalBase animal = new DogBase();
        animal.sleep();
        animal.sound();
    }

    // Q7: Interface ka example kya hai?
    // Answer: Interface contract define karta hai jo class implement karti hai.
    private static void q7InterfaceExample() {
        printHeading(7, "Implement an interface");
        Flyable bird = new Bird();
        bird.fly();
    }

    // Q8: Abstract class aur interface me key difference kya hai?
    // Answer: Abstract class state rakh sakti hai; interface behavior contract pe focus karta hai.
    private static void q8AbstractVsInterface() {
        printHeading(8, "Compare abstract class and interface");
        System.out.println("Abstract class -> partial implementation possible");
        System.out.println("Interface -> contract oriented");
        System.out.println("Class can extend one abstract class but implement many interfaces");
    }

    // Q9: Static variable ka use kya hota hai?
    // Answer: Shared class-level state maintain karne ke liye.
    private static void q9StaticVariable() {
        printHeading(9, "Count objects using static variable");
        new Counter();
        new Counter();
        new Counter();
        System.out.println("Object count = " + Counter.count);
    }

    // Q10: Static method ko object ke bina kaise call karte hain?
    // Answer: Class name ke through directly call karte hain.
    private static void q10StaticMethod() {
        printHeading(10, "Call a static method");
        System.out.println("Square of 5 = " + MathUtils.square(5));
    }

    // Q11: final variable ka behavior kya hota hai?
    // Answer: Once assign ho gaya to usko reassign nahi kar sakte.
    private static void q11FinalVariable() {
        printHeading(11, "Use a final variable");
        final int x = 10;
        System.out.println("Final x = " + x);
    }

    // Q12: final method aur final class ka matlab kya hota hai?
    // Answer: final method override nahi hota, final class inherit nahi hoti.
    private static void q12FinalMethodAndClass() {
        printHeading(12, "Show final method and final class idea");
        SecurePrinter printer = new SecurePrinter();
        printer.printMessage();
        FinalNote note = new FinalNote();
        note.show();
    }

    // Q13: == aur equals() me difference kya hai?
    // Answer: == references compare karta hai, equals() content compare karta hai.
    private static void q13ReferenceVsContentComparison() {
        printHeading(13, "Compare == and equals()");
        String a = new String("Java");
        String b = new String("Java");

        System.out.println("a == b -> " + (a == b));
        System.out.println("a.equals(b) -> " + a.equals(b));
    }

    // Q14: Wrapper classes kya hoti hain?
    // Answer: Primitive types ke object versions hoti hain.
    private static void q14WrapperClasses() {
        printHeading(14, "Use wrapper classes");
        Integer intObj = Integer.valueOf(10);
        Double doubleObj = Double.valueOf(9.5);
        Character charObj = Character.valueOf('K');

        System.out.println("Integer = " + intObj);
        System.out.println("Double = " + doubleObj);
        System.out.println("Character = " + charObj);
    }

    // Q15: Autoboxing aur unboxing kaise kaam karte hain?
    // Answer: Primitive auto-box hokar wrapper banta hai, wrapper auto-unbox hokar primitive.
    private static void q15AutoboxingAndUnboxing() {
        printHeading(15, "Show autoboxing and unboxing");
        Integer wrapped = 20; // autoboxing
        int primitive = wrapped; // unboxing

        System.out.println("Wrapped = " + wrapped);
        System.out.println("Primitive = " + primitive);
    }

    // Q16: package aur import ka role kya hota hai?
    // Answer: package organization ke liye aur import dusri classes ko use karne ke liye.
    private static void q16PackageAndImportIdea() {
        printHeading(16, "Explain package and import concept");
        System.out.println("Example package statement -> package mypackage;");
        System.out.println("Example import statement -> import java.util.Scanner;");
    }

    // Q17: main method me String[] args ka kya use hota hai?
    // Answer: Command line arguments receive karne ke liye.
    private static void q17MainMethodArguments() {
        printHeading(17, "Read command line arguments");
        String[] sampleArgs = {"hello", "java"};

        for (String arg : sampleArgs) {
            System.out.println("Arg = " + arg);
        }
    }

    // Q18: switch, break aur continue ko kaise use karte hain?
    // Answer: switch multi-way branching ke liye; break stop karta hai; continue current iteration skip karta hai.
    private static void q18SwitchBreakContinue() {
        printHeading(18, "Use switch, break and continue");
        int day = 2;

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            default:
                System.out.println("Invalid");
        }

        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue;
            }
            if (i == 5) {
                break;
            }
            System.out.println("Loop value = " + i);
        }
    }

    // Q19: For-each loop kab useful hota hai?
    // Answer: Jab array ya collection ko sequentially traverse karna ho.
    private static void q19ForEachLoop() {
        printHeading(19, "Traverse array using for-each loop");
        int[] arr = {1, 2, 3};

        for (int value : arr) {
            System.out.println(value);
        }
    }

    // Q20: StringBuilder kyon use karte hain?
    // Answer: Repeated string modification ke liye StringBuilder efficient hota hai.
    private static void q20StringBuilder() {
        printHeading(20, "Build string using StringBuilder");
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" Java");
        sb.append(" Learner");
        System.out.println(sb.toString());
    }
}

class Student {
    private final String name;
    private final int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

class CarInfo {
    String brand;

    CarInfo(String brand) {
        this.brand = brand;
    }
}

class Box {
    int length;
    int width;

    Box() {
        this(1, 1);
    }

    Box(int length, int width) {
        this.length = length;
        this.width = width;
    }

    int area() {
        return length * width;
    }
}

class BankAccount {
    private double balance;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}

abstract class AnimalBase {
    abstract void sound();

    void sleep() {
        System.out.println("Sleeping...");
    }
}

class DogBase extends AnimalBase {
    @Override
    void sound() {
        System.out.println("Bark");
    }
}

interface Flyable {
    void fly();
}

class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Counter {
    static int count = 0;

    Counter() {
        count++;
    }
}

class MathUtils {
    static int square(int x) {
        return x * x;
    }
}

class Printer {
    final void printMessage() {
        System.out.println("This final method cannot be overridden");
    }
}

class SecurePrinter extends Printer {
}

final class FinalNote {
    void show() {
        System.out.println("Final class cannot be inherited");
    }
}
