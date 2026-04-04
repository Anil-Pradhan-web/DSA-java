# String Theory Notes

## 1. String kya hota hai?

String characters ka ordered sequence hota hai. Simple words me, ye text ko represent karta hai. Har character ki ek position hoti hai jise index kehte hain. Java me indexing `0` se start hoti hai.

Example understanding:
- `"hello"` ek string hai
- `"java"` ek string hai
- `"12345"` bhi string ho sakti hai, chahe usme digits hi kyon na hon

## 2. Java me string ka importance

Strings DSA aur interviews me bahut common hote hain because:
- text processing
- searching and matching
- parsing input
- validation problems
- palindrome and anagram type questions
- sliding window based substring problems
- hashing and frequency problems

## 3. Java me `String` ka nature

Java me `String` immutable hota hai.

Immutable ka matlab:
- string create hone ke baad uska content change nahi hota
- agar tum string modify karne jaisa kuch karte ho, to actually naya string object banta hai

Is property ka impact:
- strings safe hote hain
- reuse ho sakta hai
- string pool possible hota hai
- loop me repeated concatenation costly ho sakta hai

## 4. String, character aur text representation

String ek sequence hota hai characters ka. Har character internally Unicode system par based hota hai.

Important understanding:
- ek character single symbol hota hai
- string multiple characters ka group hota hai
- har character ko index se access kiya ja sakta hai

## 5. `String` vs `char[]`

### `String`

- immutable hota hai
- easy to use hota hai
- built-in methods milti hain
- interview aur real code dono me common hai

### `char[]`

- mutable hota hai
- in-place modifications ke liye useful hota hai
- reverse, swap, ya manual editing me kaam aata hai

Kab kya use karna:
- read-only ya general text handling me `String`
- direct modifications ya low-level operations me `char[]`

## 6. `String` vs `StringBuilder` vs `StringBuffer`

## 6.1 `String`

- immutable
- small fixed text ke liye convenient
- repeated modifications ke liye inefficient ho sakta hai

## 6.2 `StringBuilder`

- mutable
- fast modifications ke liye useful
- append, insert, reverse jaisi operations me commonly use hota hai
- single-threaded scenarios me preferred hota hai

## 6.3 `StringBuffer`

- mutable
- synchronized hota hai
- thread-safe hota hai
- usually `StringBuilder` se thoda slower hota hai

Quick memory:
- `String` = immutable
- `StringBuilder` = mutable and fast
- `StringBuffer` = mutable and thread-safe

## 7. String pool kya hota hai?

Java string literals ko optimize karne ke liye string pool use karta hai.

Simple idea:
- same literal baar-baar likhne par Java usse pool me reuse kar sakta hai
- isse memory bachta hai

Important distinction:
- literal strings pool me ho sakti hain
- `new String(...)` alag object bana sakta hai

Ye concept mainly `==` aur `equals()` ke difference ko samajhne me help karta hai.

## 8. `==` aur `equals()` me difference

Ye Java strings ka sabse important concept hai.

### `==`

Reference compare karta hai.
Matlab dono variables same object ko point kar rahe hain ya nahi.

### `equals()`

Content compare karta hai.
Matlab dono strings me same characters same order me hain ya nahi.

Interview rule:
- strings compare karne ke liye generally `equals()` use karo
- `==` reference check ke liye hota hai

## 9. Lexicographical order kya hota hai?

Lexicographical order dictionary order jaisa hota hai.

Use cases:
- sorting strings
- compareTo logic
- prefix based problems
- smallest/largest string type questions

Important:
- comparison character by character hota hai
- case sensitivity matter karti hai
- shorter string kabhi-kabhi pehle aa sakta hai if prefix same ho

## 10. Case sensitivity

Java strings case-sensitive hoti hain.

Matlab:
- `"abc"` aur `"ABC"` alag hain
- `'A'` aur `'a'` alag characters hain

String problems me hamesha dekhna chahiye:
- case-sensitive compare chahiye?
- case-insensitive compare chahiye?

## 11. Common string operations ka theory

### Length

String ki total character count.

### Character access

Kisi specific position ka character dekhna.

### Substring

String ka continuous part nikalna.

Important:
- substring me starting boundary aur ending boundary carefully samajhni hoti hai
- off-by-one errors bahut common hain

### Concatenation

Do ya zyada strings ko jodna.

### Search

Check karna ki koi character ya substring string ke andar exist karti hai ya nahi.

### Replacement

String ke kuch part ko dusre part se replace karna.

### Splitting

Ek string ko delimiter ke basis par parts me todna.

### Trimming

Start aur end ke unnecessary spaces remove karna.

## 12. String immutability ka practical impact

Immutability ka real effect:
- concatenation ke har step par naya object ban sakta hai
- loop me repeated `+` performance ko slow kar sakta hai
- heavy building tasks me `StringBuilder` better hota hai

Isliye:
- small expressions me normal `String`
- repeated updates me `StringBuilder`

## 13. String traversal

String problems ka base traversal hota hai.

Traversal styles:
- left to right
- right to left
- both ends se
- window based traversal
- nested traversal for substring checks

## 14. Substring aur subsequence me difference

Ye bohot important concept hai.

### Substring

Continuous part hota hai.
Beech me gap allowed nahi hota.

### Subsequence

Characters ka order same rehta hai, but beech ke characters skip kiye ja sakte hain.

Interview me ye distinction bahut important hota hai:
- longest common subsequence alag concept hai
- longest common substring alag concept hai

## 15. Palindrome concept

Palindrome wo string hoti hai jo left se aur right se same read ho.

String palindrome problems me common ideas:
- two pointers
- center expansion
- cleanup of spaces/symbols if needed

Important variations:
- exact palindrome
- alphanumeric-only palindrome
- case-insensitive palindrome
- one deletion allowed palindrome

## 16. Anagram concept

Do strings anagram hoti hain agar unme same characters same frequencies ke saath present hon, order chahe alag ho.

Anagram solve karne ke common thought patterns:
- frequency count
- sorting compare
- hashing

Important:
- length same honi chahiye
- case sensitivity aur spaces ka rule clear hona chahiye

## 17. Frequency count concept

String problems me frequency count bahut powerful tool hai.

Use when:
- character occurrences count karne ho
- anagram check karna ho
- duplicate characters dhoondhne ho
- unique character identify karna ho
- sliding window me counts maintain karne ho

Frequency structure kya ho sakta hai:
- array, jab character range fixed ho
- `HashMap`, jab character set generic ho

## 18. Character set samajhna kyu zaroori hai?

String problem dekhte hi ye sochna chahiye:
- sirf lowercase letters hain?
- uppercase bhi hain?
- digits bhi hain?
- spaces aur punctuation bhi hain?
- Unicode text bhi ho sakta hai?

Ye decide karta hai:
- frequency array chalega ya nahi
- normalization chahiye ya nahi
- parsing ka approach kya hoga

## 19. Prefix aur suffix in strings

### Prefix

String ka starting part.

### Suffix

String ka ending part.

Prefix-suffix ideas useful hote hain:
- longest common prefix
- KMP LPS array
- string matching
- border concepts

## 20. Longest Common Prefix concept

Ye common interview topic hai.

Idea:
- multiple strings me common starting sequence dhoondhna
- shortest string ya incremental mismatch thinking useful hoti hai

Typical approaches:
- vertical scanning
- horizontal reduction
- sorting based approach
- trie based approach in advanced setting

## 21. Pattern matching kya hota hai?

Pattern matching ka matlab hota hai:
- given text me pattern find karna
- pattern kis index par milta hai dekhna
- pattern kitni baar aata hai count karna

Iske do levels hote hain:
- simple substring search
- advanced efficient pattern matching

## 22. Naive pattern searching

Naive pattern search me hum text ke har possible start index par pattern ko compare karte hain.

Pros:
- simple hota hai
- samajhne me easy

Cons:
- repeated comparisons waste ho sakti hain
- worst case me slow ho sakta hai

Naive search ka theory samajhna important hai kyunki wahi se optimized algorithms ka motivation aata hai.

## 23. KMP algorithm ka theory

KMP ka full form hai:
- Knuth-Morris-Pratt

KMP pattern matching ko optimize karta hai.

Main idea:
- mismatch hone par humein text pointer ko unnecessary peeche ya baar-baar restart nahi karna chahiye
- pattern ke andar hi information stored hoti hai ki next kahan se resume karna hai

Ye information `LPS` se aati hai.

## 24. LPS array kya hota hai?

LPS ka matlab:
- Longest Proper Prefix which is also Suffix

Simple meaning:
- kisi prefix part ke andar aisa longest part jo prefix bhi ho aur suffix bhi ho

KMP me LPS help karta hai:
- mismatch ke baad next valid comparison point dhoondhne me
- repeated work bachane me

## 25. Rabin-Karp basic theory

Rabin-Karp hashing based pattern matching approach hai.

Idea:
- pattern aur text windows ka hash compare karo
- hash match hone par actual verification karo

Useful when:
- multiple pattern matching
- rolling hash ideas
- repeated substring detection

## 26. Z algorithm basic idea

Z algorithm string matching aur prefix related questions me use hota hai.

Idea:
- har index se start hone wale longest prefix match ka length store karta hai

Useful for:
- pattern matching
- repeated prefix detection
- string structure analysis

## 27. Sliding window in strings

Sliding window strings me sabse important patterns me se ek hai.

Use cases:
- longest substring without repeating characters
- minimum window substring
- permutation in string
- fixed-size substring frequency problems

Types:
- fixed window
- variable window

Important:
- window state maintain karne ke liye frequency structure chahiye hota hai

## 28. Two pointers in strings

Two pointers strings me useful hota hai:
- palindrome
- reverse
- compare from both ends
- trimming like behavior
- merge style comparisons

## 29. Hashing in strings

Hashing ka use fast lookup ke liye hota hai.

String problems me hashing use hota hai:
- repeated substring detection
- anagram grouping
- character frequency
- substring state tracking
- rolling hash based comparisons

## 30. String parsing kya hota hai?

Parsing ka matlab hota hai string se meaningful information extract karna.

Examples:
- integer parse karna
- words split karna
- tokens identify karna
- expressions ya input format decode karna

Parsing problems me ye important hota hai:
- spaces
- signs
- invalid characters
- leading zeroes
- separators

## 31. Tokenization and split concept

Kabhi ek string ko multiple parts me todna hota hai.

Examples:
- sentence into words
- CSV-like data
- paths
- custom delimiters

Important caution:
- multiple spaces
- empty tokens
- regex-based splitting behavior

## 32. Whitespace handling

Strings me whitespace problems common hoti hain.

Possible cases:
- leading spaces
- trailing spaces
- multiple spaces between words
- tabs and newline characters

String questions me whitespace ignore karna hai ya preserve, ye pehle clear hona chahiye.

## 33. String normalization

Normalization ka matlab hota hai processing se pehle string ko standard form me lana.

Examples:
- lowercase karna
- spaces trim karna
- special chars hataana
- unwanted formatting remove karna

Ye especially useful hota hai:
- palindrome checks
- anagram
- search
- validation

## 34. String reversal concepts

Reverse string problem basic lagta hai but important hai.

Reverse se related variations:
- poori string reverse
- words reverse
- word order reverse
- vowels only reverse
- substring reverse

Approaches:
- char array
- `StringBuilder`
- stack type thinking

## 35. Duplicate characters and uniqueness

Common questions:
- duplicate characters find karo
- first non-repeating character
- all unique characters?
- repeated blocks count karo

Typical tools:
- frequency count
- set
- map

## 36. Compression and run-length style problems

Kuch string problems consecutive same characters ko compress karne par based hote hain.

Examples:
- count and say
- string compression
- grouped character processing

Important skill:
- run boundaries detect karna
- consecutive count maintain karna

## 37. Word-based string problems

Sab string questions character-based nahi hote. Bohot questions word-level par hote hain.

Examples:
- reverse words
- length of last word
- reorder sentence parts
- word pattern matching

Isme usually:
- trimming
- splitting
- scanning
- delimiter handling

important hota hai.

## 38. String to number and number to string thinking

Parsing questions me conversion important hoti hai.

Examples:
- string to integer
- integer to Roman
- Roman to integer
- expression parsing

Main risks:
- overflow
- invalid input
- leading/trailing spaces
- sign handling

## 39. String comparison problems

Comparison always simple equality nahi hota.

Possible comparison types:
- exact equality
- case-insensitive equality
- lexicographical order
- prefix match
- suffix match
- pattern-based match

## 40. Edit distance type thinking

Advanced string questions me operations allowed hote hain:
- insert
- delete
- replace

Phir poocha jata hai:
- minimum operations kitne?
- one edit away hai ya nahi?

Ye DP oriented string category me aata hai but theory level par samajhna useful hai.

## 41. Substring search related common patterns

Substring based questions me pehle clear karo:
- first occurrence chahiye?
- count chahiye?
- longest valid substring chahiye?
- all distinct substrings ki baat hai?
- repeated substring detect karna hai?

Pattern identify karte hi approach clear hone lagta hai.

## 42. Common string problem patterns

## 42.1 Frequency Array / HashMap

Useful for:
- anagram
- duplicates
- frequency count
- distinct character count

## 42.2 Two Pointers

Useful for:
- palindrome
- reverse
- compare both ends

## 42.3 Sliding Window

Useful for:
- longest unique substring
- minimum covering substring
- fixed-size substring conditions

## 42.4 Sorting

Useful for:
- anagram grouping
- canonical ordering
- lexicographical reasoning

## 42.5 Prefix/Suffix Logic

Useful for:
- longest common prefix
- KMP
- border problems

## 42.6 Stack-Based Thinking

Useful for:
- remove adjacent duplicates
- bracket validation
- decoding style problems

## 42.7 Dynamic Programming

Useful for:
- longest palindromic subsequence
- edit distance
- longest common subsequence
- word break

## 43. Common mistakes in string problems

- `==` use kar dena instead of `equals()`
- immutability bhool jana
- loop me repeated concatenation karna
- substring boundaries galat lena
- case sensitivity ignore karna
- empty string case bhool jana
- single-character case ignore karna
- spaces and punctuation handle na karna
- Unicode or character range assumption galat lena
- sliding window me frequency update galat karna

## 44. Empty string aur edge cases

String questions me ye edge cases hamesha sochne chahiye:
- empty string
- single character
- all same characters
- all distinct characters
- uppercase/lowercase mix
- spaces only
- special characters present
- pattern longer than text

## 45. Off-by-one errors in strings

Bahut common hote hain because:
- indexing `0` se start hoti hai
- substring me end index exclusive hota hai
- `left <= right` aur `left < right` ka confusion hota hai
- window size calculation me galti hoti hai

## 46. Time complexity intuition for strings

General rules:
- traversal = `O(n)`
- compare = `O(n)` worst case
- reverse = `O(n)`
- frequency count = `O(n)`
- naive pattern search = `O(n * m)`
- KMP = `O(n + m)`
- sorting characters = `O(n log n)`
- substring extraction ka cost implementation dependent ho sakta hai, but usually usse free assume nahi karna chahiye

## 47. Interview approach for string questions

String question dekhte hi ye sochna useful hota hai:

1. Character-based problem hai ya word-based?
2. Case-sensitive hai ya nahi?
3. Spaces/special characters important hain ya ignore?
4. Substring chahiye ya subsequence?
5. Frequency useful hogi?
6. Sliding window lag sakta hai?
7. Two pointers se ho sakta hai?
8. Prefix/suffix ya pattern matching ka angle hai?
9. Parsing problem hai?
10. Immutability ke wajah se `StringBuilder` chahiye?

## 48. Brute force, better, optimal mindset

Strings me bhi approach ladder important hota hai:

### Brute Force

Sab substrings ya all comparisons check karna.

### Better

Frequency count, sorting, hashing, window, ya prefix logic use karna.

### Optimal

Pattern ko identify karke exact efficient approach lagana, jaise:
- sliding window
- KMP
- rolling hash
- DP

## 49. Java-specific string interview essentials

Ye topics bahut strong hone chahiye:
- `String` immutable hota hai
- `StringBuilder` कब use karna hai
- `equals()` vs `==`
- `compareTo()` ka idea
- substring boundary understanding
- string pool ka basic concept
- char traversal
- case conversion and normalization

## 50. Quick revision sheet

- String characters ka ordered sequence hota hai.
- Java me `String` immutable hota hai.
- `StringBuilder` repeated modifications ke liye better hota hai.
- `==` reference compare karta hai, `equals()` content compare karta hai.
- Substring continuous hota hai, subsequence me skipping allowed hoti hai.
- Palindrome me two pointers common hain.
- Anagram me frequency ya sorting useful hota hai.
- Sliding window substring problems ka core pattern hai.
- KMP aur LPS advanced but important concepts hain.
- Spaces, case sensitivity, aur boundaries ko ignore nahi karna chahiye.

## 51. Final takeaway

String mastery ka matlab sirf methods ya syntax yaad karna nahi hai. Real mastery tab hoti hai jab tum problem dekhkar turant samajh pao ki:

- simple traversal enough hai
- two pointers chahiye
- sliding window lagega
- frequency count kaam karega
- prefix/suffix logic useful hai
- pattern matching algorithm chahiye
- parsing carefully karni padegi
- ya `StringBuilder` performance ke liye zaroori hai

Strings strong ho gaye to parsing, hashing, sliding window, pattern matching aur kaafi interview categories naturally easy lagne lagti hain.
