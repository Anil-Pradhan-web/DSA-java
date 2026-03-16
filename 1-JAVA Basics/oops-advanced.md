# Advanced OOP in Java - Hinglish Notes

## 1. Constructors kya hote hain?

Constructor ek special method hota hai jo object create hote hi automatically call hota hai.

Rules:

- constructor ka naam class ke naam jaisa hota hai
- iska koi return type nahi hota

### Example

```java
class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

## 2. `this` keyword

`this` current object ko refer karta hai.

Use cases:

- instance variables aur parameters me difference dikhana
- current object ko refer karna
- constructor chaining

### Example

```java
class Car {
    String brand;

    Car(String brand) {
        this.brand = brand;
    }
}
```

## 3. Constructor overloading

Ek class me multiple constructors ho sakte hain with different parameters.

```java
class Box {
    int length;
    int width;

    Box() {
        length = 1;
        width = 1;
    }

    Box(int length, int width) {
        this.length = length;
        this.width = width;
    }
}
```

## 4. Access modifiers

Java me access control ke liye modifiers use hote hain.

- `public`
- `private`
- `protected`
- default

### Short idea

- `public` -> sab jagah accessible
- `private` -> sirf same class ke andar
- `protected` -> package + inheritance
- default -> same package

## 5. Encapsulation

Data aur methods ko ek class me bind karna aur direct access restrict karna encapsulation kehlata hai.

Usually:

- variables `private`
- access through getters/setters

### Example

```java
class BankAccount {
    private double balance;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
```

## 6. Abstraction

Implementation details hide karke sirf essential behavior dikhana abstraction hota hai.

Java me abstraction 2 ways se aata hai:

- abstract class
- interface

## 7. Abstract class

Abstract class ka object directly nahi banta.

Ye incomplete blueprint jaisa hota hai.

```java
abstract class Animal {
    abstract void sound();

    void sleep() {
        System.out.println("Sleeping...");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Bark");
    }
}
```

## 8. Interface

Interface pure contract jaisa hota hai.

Java me class multiple interfaces implement kar sakti hai.

```java
interface Flyable {
    void fly();
}

class Bird implements Flyable {
    public void fly() {
        System.out.println("Bird is flying");
    }
}
```

## 9. Abstract class vs Interface

### Abstract class

- methods with body ho sakte hain
- state/instance variables ho sakte hain
- inheritance ke liye use hoti hai

### Interface

- behavior contract define karta hai
- multiple interfaces implement kar sakte ho
- loose coupling ke liye useful hai

## 10. Static keyword

`static` member class level ka hota hai, object level ka nahi.

### Example

```java
class Counter {
    static int count = 0;

    Counter() {
        count++;
    }
}
```

### Static method

```java
class MathUtils {
    static int square(int x) {
        return x * x;
    }
}
```

Call:

```java
System.out.println(MathUtils.square(5));
```

## 11. Final keyword

`final` ka meaning usually fixed hota hai.

### final variable

```java
final int x = 10;
```

Reassign nahi kar sakte.

### final method

Override nahi kar sakte.

### final class

Inherit nahi kar sakte.

## 12. `==` vs `equals()`

### `==`

- primitive values compare karta hai
- objects me reference compare karta hai

### `equals()`

- object content compare karne ke liye use hota hai

```java
String a = new String("Java");
String b = new String("Java");

System.out.println(a == b);      // false
System.out.println(a.equals(b)); // true
```

## 13. Wrapper classes

Primitive types ke object versions hote hain.

Examples:

- `int` -> `Integer`
- `char` -> `Character`
- `double` -> `Double`
- `boolean` -> `Boolean`

## 14. Autoboxing and unboxing

### Autoboxing

Primitive automatically wrapper me convert hota hai.

```java
Integer x = 10;
```

### Unboxing

Wrapper automatically primitive me convert hota hai.

```java
Integer y = 20;
int z = y;
```

## 15. Packages and import

Package classes ko organize karne ke liye use hota hai.

```java
package mypackage;
```

Import dusre package ki classes use karne ke liye:

```java
import java.util.Scanner;
import java.util.ArrayList;
```

## 16. Main method structure

Java program execution usually `main` method se start hota hai.

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Java");
    }
}
```

### `String[] args`

Command line arguments receive karta hai.

## 17. `switch`, `break`, `continue`

### switch

```java
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
```

### break

Loop ya switch ko turant stop karta hai.

### continue

Current iteration skip karta hai.

## 18. For-each loop

Collection ya array traverse karne ke liye useful.

```java
int[] arr = {1, 2, 3};
for (int x : arr) {
    System.out.println(x);
}
```

## 19. StringBuilder basic intro

Repeated string modification ke liye `StringBuilder` useful hota hai.

```java
StringBuilder sb = new StringBuilder();
sb.append("Hello");
sb.append(" Java");
System.out.println(sb.toString());
```

## 20. Quick revision summary

- constructor object initialization ke liye hota hai
- `this` current object ko refer karta hai
- encapsulation = private data + public methods
- abstraction = implementation hide karna
- abstract class aur interface dono important hain
- `static` class-level hota hai
- `final` fixed behavior ke liye hota hai
- wrapper classes collections me bohot useful hoti hain
- `==` aur `equals()` ka difference bohot important hai
