# Strings in Java for DSA

## 1. String kya hota hai?

String characters ka ordered sequence hota hai.

Examples:

- `"hello"`
- `"java"`
- `"aabbcc"`

Java me string ka type `String` hota hai.

```java
String s = "hello";
```

Har character ka ek index hota hai.

```text
String: J A V A
Index : 0 1 2 3
```

## 2. Java me String important kyu hai?

DSA aur interviews me strings bohot common hote hain because:

- text processing
- pattern matching
- palindrome problems
- substring problems
- hashing and sliding window
- parsing and validation

## 3. `String`, `StringBuilder`, `StringBuffer`

## 3.1 `String`

- immutable hota hai
- once create ho gaya, direct modify nahi hota
- interview aur daily Java dono me sabse common

```java
String s = "cat";
s = "bat";
```

Yahan original string change nahi hui, naya string assign hua.

## 3.2 `StringBuilder`

- mutable hota hai
- fast string modification ke liye useful hai
- generally single-threaded use me preferred hota hai

```java
StringBuilder sb = new StringBuilder("code");
sb.append("123");
System.out.println(sb); // code123
```

## 3.3 `StringBuffer`

- mutable hota hai
- `StringBuilder` jaisa hai
- synchronized hota hai, isliye thread-safe hota hai
- usually `StringBuilder` se slower ho sakta hai due to synchronization

```java
StringBuffer sb = new StringBuffer("java");
sb.append("core");
System.out.println(sb); // javacore
```

### Simple difference

- `String` -> immutable
- `StringBuilder` -> mutable, faster, non-synchronized
- `StringBuffer` -> mutable, synchronized, thread-safe

## 4. Character array vs String

### `String`

- easy to use
- built-in methods milte hain
- immutable hota hai

### `char[]`

- mutable hota hai
- in-place modification ke liye useful hai
- kuch DSA problems me direct char swap karna easy hota hai

Example:

```java
String s = "code";
char[] arr = {'c', 'o', 'd', 'e'};
```

## 5. Basic string operations in Java

## 5.1 Concatenation

```java
String a = "hello";
String b = "world";
String c = a + b;
System.out.println(c); // helloworld
```

Better in loops:

```java
StringBuilder sb = new StringBuilder();
sb.append("hello");
sb.append("world");
String ans = sb.toString();
```

## 5.2 Substring

```java
String s = "programming";
System.out.println(s.substring(3));    // gramming
System.out.println(s.substring(3, 7)); // gram
```

Important:

- `beginIndex` included hota hai
- `endIndex` excluded hota hai

## 5.3 Comparison

### `equals()`

Content compare karta hai.

```java
String a = "abc";
String b = "abc";
System.out.println(a.equals(b)); // true
```

### `==`

Reference compare karta hai.

```java
String a = new String("abc");
String b = new String("abc");
System.out.println(a == b);      // false
System.out.println(a.equals(b)); // true
```

### `compareTo()`

Lexicographical comparison ke liye.

```java
System.out.println("abc".compareTo("abd"));
```

## 6. Important Java String methods

### `length()`

```java
String s = "hello";
System.out.println(s.length()); // 5
```

### `charAt(index)`

```java
String s = "world";
System.out.println(s.charAt(0)); // w
```

### `indexOf()`

```java
String s = "banana";
System.out.println(s.indexOf('a'));   // 1
System.out.println(s.indexOf("na")); // 2
```

### `contains()`

```java
String s = "datastructure";
System.out.println(s.contains("data")); // true
```

### `toCharArray()`

```java
String s = "hello";
char[] arr = s.toCharArray();
```

## 7. String pool basic idea

Java string literals pool me store ho sakte hain.

```java
String a = "java";
String b = "java";
System.out.println(a == b); // true
```

Lekin:

```java
String a = new String("java");
String b = new String("java");
System.out.println(a == b); // false
```

## 8. Naive pattern searching

Question:

- given text and pattern
- pattern kis index par start hota hai find karo

Naive approach me hum text ke har possible start index par pattern compare karte hain.

Example:

```text
text = "ababcabc"
pattern = "abc"
```

### Java code

```java
public static int naiveSearch(String text, String pattern) {
    int n = text.length();
    int m = pattern.length();

    for (int i = 0; i <= n - m; i++) {
        int j = 0;

        while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
            j++;
        }

        if (j == m) {
            return i;
        }
    }

    return -1;
}
```

### Complexity

- worst case = `O(n * m)`

## 9. KMP Algorithm basic idea

KMP ka full form hai:

- Knuth-Morris-Pratt

KMP pattern searching ko optimize karta hai.

### Basic idea

Normal naive search me mismatch ke baad hum next position se dubara compare karte hain.

KMP me hum pattern ka ek helper array banate hain jise `LPS` kehte hain.

LPS means:

- Longest Proper Prefix which is also Suffix

Isse fayda:

- mismatch hone par unnecessary repeated comparison bach jata hai

### Example intuition

Agar pattern me pehle se kuch prefix part match ho chuka hai, to KMP use karta hai ki next comparison kahan se continue karna chahiye.

### LPS build code

```java
public static int[] buildLPS(String pattern) {
    int[] lps = new int[pattern.length()];
    int len = 0;
    int i = 1;

    while (i < pattern.length()) {
        if (pattern.charAt(i) == pattern.charAt(len)) {
            len++;
            lps[i] = len;
            i++;
        } else {
            if (len != 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
    }

    return lps;
}
```

### KMP search code

```java
public static int kmpSearch(String text, String pattern) {
    if (pattern.length() == 0) {
        return 0;
    }

    int[] lps = buildLPS(pattern);
    int i = 0;
    int j = 0;

    while (i < text.length()) {
        if (text.charAt(i) == pattern.charAt(j)) {
            i++;
            j++;
        }

        if (j == pattern.length()) {
            return i - j;
        } else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
            if (j != 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
    }

    return -1;
}
```

### Complexity

- time = `O(n + m)`
- space = `O(m)`

## 10. Common string problem patterns

### Frequency count

```java
String s = "banana";
int[] freq = new int[26];

for (int i = 0; i < s.length(); i++) {
    freq[s.charAt(i) - 'a']++;
}
```

### Two pointers

Use for:

- palindrome
- reverse string
- compare from both ends

### Sliding window

Use for:

- longest substring without repeating characters
- fixed-size substring problems

## 11. Practice Problems

## 11.1 Reverse a string

Using `StringBuilder`:

```java
public static String reverseString(String s) {
    return new StringBuilder(s).reverse().toString();
}
```

Using char array:

```java
public static String reverseStringUsingArray(String s) {
    char[] arr = s.toCharArray();
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
    }

    return new String(arr);
}
```

## 11.2 Check palindrome

```java
public static boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }

    return true;
}
```

## 11.3 Valid anagram

```java
public static boolean isAnagram(String a, String b) {
    if (a.length() != b.length()) {
        return false;
    }

    int[] freq = new int[26];

    for (int i = 0; i < a.length(); i++) {
        freq[a.charAt(i) - 'a']++;
        freq[b.charAt(i) - 'a']--;
    }

    for (int x : freq) {
        if (x != 0) {
            return false;
        }
    }

    return true;
}
```

## 11.4 Longest common prefix

```java
public static String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
        return "";
    }

    String prefix = strs[0];

    for (int i = 1; i < strs.length; i++) {
        while (!strs[i].startsWith(prefix)) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) {
                return "";
            }
        }
    }

    return prefix;
}
```

## 11.5 Count vowels and consonants

```java
public static void countVowelsConsonants(String s) {
    int vowels = 0;
    int consonants = 0;

    s = s.toLowerCase();

    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);

        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else {
                consonants++;
            }
        }
    }

    System.out.println("Vowels = " + vowels);
    System.out.println("Consonants = " + consonants);
}
```

## 11.6 Remove duplicates from string

Question yeh ho sakta hai ki duplicate characters hatao aur first occurrence preserve karo.

```java
public static String removeDuplicates(String s) {
    boolean[] seen = new boolean[256];
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if (!seen[ch]) {
            seen[ch] = true;
            sb.append(ch);
        }
    }

    return sb.toString();
}
```

## 11.7 Implement `strStr()`

`strStr()` ka matlab usually first occurrence of substring find karna hota hai.

### Simple Java implementation

```java
public static int strStr(String haystack, String needle) {
    if (needle.length() == 0) {
        return 0;
    }

    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
        int j = 0;

        while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
            j++;
        }

        if (j == needle.length()) {
            return i;
        }
    }

    return -1;
}
```

## 11.8 Count and Say

Count and Say sequence:

- `1`
- `11`
- `21`
- `1211`
- `111221`

Idea:

- previous string ko read karo
- consecutive digits count karo
- next string build karo

### Java code

```java
public static String countAndSay(int n) {
    String result = "1";

    for (int i = 2; i <= n; i++) {
        StringBuilder current = new StringBuilder();
        int count = 1;

        for (int j = 1; j < result.length(); j++) {
            if (result.charAt(j) == result.charAt(j - 1)) {
                count++;
            } else {
                current.append(count).append(result.charAt(j - 1));
                count = 1;
            }
        }

        current.append(count).append(result.charAt(result.length() - 1));
        result = current.toString();
    }

    return result;
}
```

## 12. Common mistakes in Java strings

### `==` use kar dena instead of `equals()`

Ye very common mistake hai.

### Loop me repeated string concatenation

`StringBuilder` use karo.

### `substring()` me end index exclude hota hai

```java
String s = "abcdef";
System.out.println(s.substring(1, 4)); // bcd
```

### Empty string handle na karna

```java
String s = "";
```

### Case sensitivity ignore karna

`'A'` aur `'a'` alag hain.

## 13. Time complexity cheat sheet

For string length `n`:

- traversal = `O(n)`
- reverse = `O(n)`
- compare strings = `O(n)` worst case
- naive pattern search = `O(n * m)`
- KMP = `O(n + m)`
- frequency count = `O(n)`
- substring extraction = often `O(k)`

## 14. Quick revision summary

- Java me `String` immutable hota hai.
- `StringBuilder` mutable hota hai aur loops me better hota hai.
- `StringBuffer` synchronized hota hai aur thread-safe hota hai.
- `equals()` content compare karta hai, `==` reference compare karta hai.
- Pattern searching ke liye naive approach aur KMP dono important hain.
- Anagram me frequency count useful hota hai.
- Palindrome me two pointers useful hote hain.
- `strStr()`, longest common prefix, remove duplicates, count and say common interview questions hain.

## 15. Final takeaway

Strings Java interviews ka bohot important topic hain kyunki ye basics se lekar advanced pattern matching tak sab cover karte hain.

Java interview ke liye most important practical points:

- `String` vs `StringBuilder` vs `StringBuffer`
- `substring()`, `charAt()`, `indexOf()`, `equals()`
- naive pattern searching
- KMP ka basic idea
- palindrome and anagram logic
- common problems like `strStr()` and count and say

Agar strings strong ho gayi, to pattern matching, hashing, sliding window aur parsing problems kaafi easy lagne lagti hain.
