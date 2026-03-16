# Java Basics in Hinglish

Ye file Java ke core basics ko simple Hinglish me explain karti hai. Har topic ke saath short example diya gaya hai taki concept jaldi clear ho.

---

## 1. Variables, Data Types, Operators

### Variable kya hota hai?
Variable ek container hota hai jisme hum data store karte hain.

Example:

```java
int age = 21;
double price = 99.99;
char grade = 'A';
boolean isJavaFun = true;
String name = "Anil";
```

### Common Data Types

| Data Type | Use | Example |
|---|---|---|
| `int` | poore number | `int x = 10;` |
| `double` | decimal number | `double pi = 3.14;` |
| `char` | single character | `char ch = 'K';` |
| `boolean` | true/false | `boolean flag = true;` |
| `String` | text | `String city = "Delhi";` |

### Operators

#### 1. Arithmetic Operators
Maths wale operations ke liye use hote hain.

```java
int a = 10;
int b = 3;

System.out.println(a + b); // 13
System.out.println(a - b); // 7
System.out.println(a * b); // 30
System.out.println(a / b); // 3
System.out.println(a % b); // 1
```

#### 2. Relational Operators
Comparison ke liye use hote hain.

```java
int x = 5;
int y = 8;

System.out.println(x < y);  // true
System.out.println(x > y);  // false
System.out.println(x == y); // false
System.out.println(x != y); // true
```

#### 3. Logical Operators
Conditions combine karne ke liye use hote hain.

```java
int age = 20;
boolean hasID = true;

System.out.println(age >= 18 && hasID); // true
System.out.println(age < 18 || hasID);  // true
System.out.println(!hasID);             // false
```

---

## 2. Control Statements

Control statements decide karte hain ki code ka flow kaise chalega.

### if-else
Jab condition true ho tab ek block chalega, warna dusra.

```java
int marks = 75;

if (marks >= 40) {
    System.out.println("Pass");
} else {
    System.out.println("Fail");
}
```

### else-if ladder
Multiple conditions check karni ho to use hota hai.

```java
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
```

### for loop
Jab number of iterations pehle se pata ho.

```java
for (int i = 1; i <= 5; i++) {
    System.out.println("Count: " + i);
}
```

### while loop
Jab tak condition true hai tab tak loop chalta rahega.

```java
int i = 1;

while (i <= 5) {
    System.out.println(i);
    i++;
}
```

### do-while loop
Isme block kam se kam ek baar zaroor chalega.

```java
int i = 1;

do {
    System.out.println(i);
    i++;
} while (i <= 5);
```

---

## 3. Arrays (1D and 2D)

Array same type ke multiple values ko ek saath store karta hai.

### 1D Array

```java
int[] numbers = {10, 20, 30, 40};

System.out.println(numbers[0]); // 10
System.out.println(numbers[2]); // 30
```

Loop ke saath:

```java
int[] numbers = {10, 20, 30, 40};

for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

### 2D Array
2D array ko matrix ya table jaisa samajh sakte ho.

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};

System.out.println(matrix[0][1]); // 2
System.out.println(matrix[1][2]); // 6
```

Nested loop ke saath:

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};

for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
```

---

## 4. Functions / Methods

Java me function ko generally `method` bolte hain.

Method ka kaam hota hai code ko reusable banana.

### Simple Method

```java
public class Main {
    static void greet() {
        System.out.println("Hello, Java!");
    }

    public static void main(String[] args) {
        greet();
    }
}
```

### Method with Parameters

```java
public class Main {
    static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int result = add(5, 7);
        System.out.println(result); // 12
    }
}
```

### Pass by Value
Java me arguments ka copy pass hota hai. Matlab original primitive variable directly change nahi hota.

```java
public class Main {
    static void changeValue(int x) {
        x = 100;
    }

    public static void main(String[] args) {
        int num = 10;
        changeValue(num);
        System.out.println(num); // 10
    }
}
```

Yahan `num` change nahi hua, kyunki method ko sirf uski copy mili thi.

### Recursion Basics
Jab koi method khud ko hi call karta hai, use recursion bolte hain.

```java
public class Main {
    static void printNumbers(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printNumbers(n - 1);
    }

    public static void main(String[] args) {
        printNumbers(5);
    }
}
```

Important: Recursion me base case hona bahut zaroori hai, warna method infinite baar call hota rahega.

---

## 5. OOP Basics

OOP ka full form hai Object-Oriented Programming.

Isme code ko real-world objects ke basis par design kiya jata hai.

### Class and Object

- `Class` ek blueprint hoti hai
- `Object` us class ka actual instance hota hai

```java
class Car {
    String brand;
    int speed;

    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed);
    }
}

public class Main {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.brand = "Toyota";
        c1.speed = 120;
        c1.display();
    }
}
```

### Inheritance
Ek class dusri class ke features ko inherit kar sakti hai.

```java
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

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.sound();
        d.bark();
    }
}
```

### Polymorphism
Same method name, different behavior.

#### Method Overriding

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Bark");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.sound(); // Bark
    }
}
```

Yahan reference `Animal` ka hai, but object `Dog` ka hai. Isliye `Dog` wala `sound()` call hua.

---

## 6. Exception Handling

Exception ka matlab hai runtime pe aane wali error jise hum handle kar sakte hain.

### try-catch

```java
public class Main {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Zero se divide nahi kar sakte");
        }
    }
}
```

### finally
`finally` block almost hamesha execute hota hai, chahe exception aaye ya na aaye.

```java
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Try block");
        } catch (Exception e) {
            System.out.println("Catch block");
        } finally {
            System.out.println("Finally block");
        }
    }
}
```

---

## 7. Input / Output

### Scanner
User se input lene ka easy tarika.

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);

        sc.close();
    }
}
```

### BufferedReader
Thoda traditional aur fast input method mana jata hai.

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter your city: ");
        String city = br.readLine();

        System.out.println("City: " + city);
    }
}
```

Note:

- `Scanner` beginner-friendly hota hai
- `BufferedReader` fast hota hai aur competitive programming me kaafi use hota hai

---

## 8. Quick Summary

- Variable data store karta hai
- Data type batata hai kis type ka data store hoga
- Operators calculations aur comparisons ke liye use hote hain
- `if-else` aur loops program ka flow control karte hain
- Arrays multiple values ko store karte hain
- Methods code reuse karne me help karte hain
- Java me primitive arguments pass by value hote hain
- Recursion me function khud ko call karta hai
- OOP me class, object, inheritance, polymorphism important hote hain
- Exception handling runtime errors ko manage karti hai
- `Scanner` aur `BufferedReader` input lene ke common tareeke hain

---

## 9. Mini Practice Ideas

1. Ek program banao jo 2 numbers ka sum, difference aur product print kare.
2. Ek program banao jo check kare number even hai ya odd.
3. Array ka largest element find karo.
4. Ek recursive function banao jo factorial nikaale.
5. `Student` class banao jisme name aur marks ho.
6. `try-catch` ka use karke division error handle karo.

Ye topics agar achhe se clear ho gaye, to Java ka strong base ready ho jayega.
