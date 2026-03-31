# Array Theory Notes

## 1. Array kya hota hai?

Array ek linear data structure hota hai jisme same type ke multiple elements ko ek sequence me store kiya jaata hai. Har element ka ek fixed position hota hai jise index kehte hain. Java me indexing `0` se start hoti hai.

Simple words me:
- array ek fixed-size container hota hai
- isme similar type ka data store hota hai
- har value ko direct index se access kiya ja sakta hai

## 2. Array ki sabse important properties

- Array ka size fixed hota hai.
- Elements contiguous logical order me arranged hote hain.
- Random access fast hota hai.
- Har element ka index hota hai.
- Same data type ka rule follow hota hai.
- Java me array object hota hai.
- Array ka length banne ke baad change nahi hota.

## 3. Java me array ka behavior

Java me array reference type hota hai, chahe uske andar primitive values hi kyon na ho. Matlab array khud ek object ki tarah treat hota hai.

Important points:
- `arr.length` property hoti hai, method nahi
- default values milti hain jab array `new` se banta hai
- primitive arrays aur object arrays ka default behavior alag hota hai

Default values:
- `int` array me default `0`
- `double` array me default `0.0`
- `boolean` array me default `false`
- object array me default `null`

## 4. Array kyun important hai?

DSA ki bohot saari techniques arrays se hi start hoti hain. Array strong ho gaya to bahut saare topics automatically easy lagne lagte hain.

Array important hai kyunki:
- indexing fast hoti hai
- searching, sorting aur traversal ka base yahi hai
- sliding window, prefix sum, two pointers jaisi patterns arrays par hi most common hoti hain
- strings ko bhi aksar character array logic se samjha ja sakta hai
- matrix problems bhi 2D array ka extension hote hain

## 5. Array aur memory intuition

Array ka main fayda hota hai direct access. Agar index pata hai to element tak instantly pahunch sakte ho. Isi wajah se array access theoretical level par `O(1)` hota hai.

Lekin fixed-size hone ki wajah se:
- beech me insert karna costly hota hai
- beech se delete karna bhi costly hota hai
- resize karne ke liye naya structure banana pad sakta hai

## 6. Array operations ka theory

### Access

Index se element dekhna sabse fast operation hai. Isme scanning nahi karni padti.

### Update

Kisi index par nayi value rakhna bhi fast hota hai kyunki direct position mil jaati hai.

### Traversal

Poore array ko left to right ya right to left dekhna traversal kehlata hai. Maximum basic array problems traversal par hi depend karti hain.

### Search

Agar array unsorted hai to linear search use hota hai. Agar sorted hai to binary search use kiya ja sakta hai.

### Insertion

Fixed-size array me insertion ka matlab usually shift operation hota hai. End me jagah ho to easy hota hai, middle me costly.

### Deletion

Delete karne ke baad gap fill karne ke liye elements ko shift karna padta hai.

## 7. Time complexity intuition

- index access = `O(1)`
- index update = `O(1)`
- traversal = `O(n)`
- linear search = `O(n)`
- insertion at end with free space = `O(1)`
- insertion in middle = `O(n)`
- deletion in middle = `O(n)`
- binary search on sorted array = `O(log n)`

## 8. Array ke advantages

- direct index access fast hota hai
- simple structure hai
- memory overhead kam hota hai
- primitives ko efficiently handle karta hai
- sorting aur searching algorithms ka natural base hai
- interview problems me bohot common hai

## 9. Array ke disadvantages

- size fixed hota hai
- insertion aur deletion expensive ho sakte hain
- same type restriction hota hai
- dynamic resizing naturally supported nahi hoti
- middle operations ke liye best structure nahi hai

## 10. Array vs ArrayList

### Array

- fixed size
- primitive values directly store kar sakta hai
- lightweight hota hai
- low-level DSA understanding ke liye best hota hai

### ArrayList

- dynamic size
- built-in methods zyada convenient hoti hain
- primitive values ke liye wrapper types lagte hain
- practical app code me convenient hota hai

Interview point:
ArrayList use karna alag cheez hai, lekin array logic samajhna core cheez hai.

## 11. 1D array aur 2D array

### 1D Array

Ek straight sequence hota hai jisme sirf ek index se element access hota hai.

### 2D Array

Rows aur columns ka structure hota hai. Matrix, board, grid, game state, path problems me use hota hai.

2D arrays samajhte waqt:
- row count
- column count
- boundary handling
- nested loops

bahut important hote hain.

## 12. Array traversal ke thought patterns

Traversal sirf ek loop chalana nahi hota. Problem ke hisaab se alag direction aur style use hoti hai:

- left to right
- right to left
- two-end traversal
- partial traversal
- nested traversal
- layer-wise traversal in matrix

## 13. Array problems solve karte waqt basic questions

Har problem me pehle ye sochna chahiye:

- array sorted hai ya unsorted?
- duplicates allowed hain ya nahi?
- negative values ho sakti hain ya nahi?
- fixed length subarray chahiye ya variable length?
- answer index me chahiye, value me chahiye, ya count me?
- in-place solution chahiye ya extra space allowed hai?
- contiguous subarray ki baat ho rahi hai ya subset ki?

Ye questions pattern identify karne me help karte hain.

## 14. Common array patterns

## 14.1 Two Pointers

Jab do positions ko saath me track karna hota hai tab two pointers useful hota hai.

Typical use:
- reverse array
- sorted array me pair search
- remove duplicates
- move zeros
- container type problems

Idea:
- ek pointer start par
- ek pointer end par ya ek fast aur ek slow

## 14.2 Sliding Window

Jab contiguous subarray ya substring ke upar kaam ho, sliding window bahut useful hoti hai.

Do types:
- fixed-size window
- variable-size window

Typical use:
- max sum of size `k`
- longest/shortest valid subarray
- stock, streak, and range-based problems

## 14.3 Prefix Sum

Prefix sum tab powerful hota hai jab repeated range sum ya subarray sum se related questions aate hain.

Idea:
- har position tak ka cumulative sum maintain karo
- range queries fast ho jaati hain

Typical use:
- range sum
- subarray sum equals k
- cumulative frequency style reasoning

## 14.4 Hashing with Array Problems

Jab fast lookup chahiye hota hai tab `HashMap` ya `HashSet` array ke saath combine kiye jaate hain.

Typical use:
- two sum
- duplicate detection
- prefix sum frequency
- longest subarray conditions

## 14.5 Sorting Based Approach

Kayi problems me original array ko sort karke problem easy ho jaati hai.

Sorting helpful hoti hai jab:
- intervals merge karne ho
- duplicates group karne ho
- kth element sochna ho
- binary search apply karna ho

Tradeoff:
- order change ho sakta hai
- time `O(n log n)` lag sakta hai

## 14.6 Binary Search on Array

Binary search sirf simple sorted search ke liye nahi hoti. Ye answer-space search me bhi use hoti hai.

Binary search useful hoti hai jab:
- array sorted ho
- monotonic condition ho
- rotated sorted array ho
- minimum/maximum feasible answer dhoondhna ho

## 14.7 Greedy on Array

Kabhi-kabhi best local decision se overall answer mil jaata hai.

Typical use:
- jump game
- stock profit
- interval scheduling variants

## 14.8 Matrix / 2D Array

2D arrays me boundary control sabse important hota hai.

Typical concepts:
- row-column traversal
- transpose
- rotation
- spiral traversal
- zero-marking
- neighbor-based simulation

## 15. Contiguous subarray vs subset

Ye confusion bahut common hota hai.

### Contiguous Subarray

Elements continuous honge. Beech me gap allowed nahi hota.

### Subset / Subsequence type thinking

Elements skip kiye ja sakte hain.

Array problems me jab "subarray" likha ho to contiguous hi maana jaata hai.

## 16. Sorted array aur unsorted array difference

### Sorted array me kya extra power milti hai?

- binary search
- two pointers
- duplicate compression
- interval-like merge logic

### Unsorted array me kya hota hai?

- usually hashing ya full traversal chahiye hota hai
- binary search directly apply nahi hoti
- order ka importance zyada hota hai

## 17. In-place operation ka matlab

In-place ka matlab hota hai ki problem ko same array me solve karna, minimal extra space ke saath.

In-place operations examples:
- reverse
- rotate
- swap based rearrangement
- Dutch National Flag
- cyclic placement

In-place useful hota hai kyunki:
- memory bachta hai
- interview me efficient maana jaata hai

## 18. Stable aur unstable behavior

Array transformations me kabhi-kabhi relative order matter karta hai.

### Stable operation

Equal ya existing order preserve rahe.

### Unstable operation

Order change ho sakta hai.

Example thinking:
- move zeros to end stable bhi ho sakta hai
- sort ya swaps order change kar sakte hain

## 19. Frequency array concept

Jab values ka range chhota aur fixed ho, tab frequency array bohot useful hota hai.

Use cases:
- counting occurrences
- duplicate checks
- counting sort intuition
- character counting

Restriction:
- value range manageable hona chahiye

## 20. Difference array concept

Difference array range update problems ke liye ek advanced but important idea hai.

Isme individual updates ke bajay boundary markers use karte hain. Baad me cumulative processing se final values milti hain.

Useful when:
- bohot saare range increments/decrements hon
- final array ek baar me reconstruct karna ho

## 21. Kadane's Algorithm

Ye array theory ka iconic concept hai.

Use:
- maximum subarray sum

Core idea:
- negative running sum ko carry karna bekaar ho sakta hai
- better hota hai naya start lena

Ye batata hai ki har subarray problem brute force se nahi karni hoti; running state se optimize kiya ja sakta hai.

## 22. Rotation concept

Array rotation left ya right dono direction me ho sakti hai.

Important points:
- `k` ko length ke modulo se reduce karte hain
- cyclic movement samajhna padta hai
- rotation problems me reverse technique, extra array, ya cyclic replacement aa sakta hai

## 23. Duplicate handling

Arrays me duplicates bahut important effect daalte hain.

Problem me pehle clear karo:
- duplicates allowed hain?
- duplicates count karne hain ya ignore?
- unique answer chahiye?

Ye especially important hota hai:
- 3Sum
- remove duplicates
- frequency map
- sorting based scans

## 24. Negative numbers ka effect

Negative values problem pattern ko change kar sakti hain.

Examples:
- sliding window on positives easy hota hai
- negatives aate hi prefix sum ya hashing lag sakta hai
- product problems me negatives sign flip karte hain
- maximum/minimum tracking dono important ho jaata hai

## 25. Zero ka special role

Zero bohot problems me edge case hota hai.

Examples:
- product except self
- move zeros
- matrix zeroes
- prefix/sum reset logic
- duplicate ya missing positive style arrangements

## 26. Cyclic sort type idea

Jab array values kisi limited index-based range ko represent karti hain, tab values ko "correct index" par place karne ka idea aata hai.

Typical use:
- first missing positive
- missing number
- duplicate in range-based arrays

Important:
- har number ka ek expected index hota hai
- swaps tab tak chalte hain jab tak value sahi jagah na aa jaye

## 27. Interval thinking in arrays

Kabhi array direct numbers ka hota hai, kabhi har element ek interval hota hai.

Interval problems me:
- sorting by start or end
- overlap condition
- merge logic
- room allocation
- meeting scheduling

ye sab core ideas hote hain.

## 28. Matrix theory essentials

2D array problems me ye cheezein strong honi chahiye:

- dimensions ka clear understanding
- boundaries out of range na ho
- neighbors ka traversal
- diagonals ki understanding
- transpose relation
- row-wise aur column-wise behavior

## 29. Common mistakes in arrays

- `length()` likh dena instead of `length`
- off-by-one errors
- last index galat lena
- empty array case ignore karna
- single element case bhool jaana
- duplicates ko handle na karna
- sorted/unsorted distinction miss karna
- negative numbers aur zero ke edge cases miss karna
- matrix me row aur column boundaries confuse karna

## 30. Off-by-one error kya hota hai?

Ye arrays me sabse common mistake hai.

Reasons:
- loop condition me `<` aur `<=` ka confusion
- `n - 1` ka dhyan na rakhna
- prefix aur suffix boundaries galat lena
- left/right pointers ko galat update karna

## 31. Array problem ka interview approach

Array question dekhte hi ye flow sochna useful hota hai:

1. Kya brute force obvious hai?
2. Kya array sorted hai?
3. Kya hashing helpful hogi?
4. Kya contiguous condition hai?
5. Kya two pointers lag sakta hai?
6. Kya prefix sum helpful hai?
7. Kya in-place karna hai?
8. Kya matrix/interval interpretation hai?

## 32. Brute force, better, optimal thinking

Array interviews me direct optimal answer bolne se pehle approach ladder samajhna zaroori hai:

### Brute Force

Sab possibilities check karna. Usually easy to think, but slow.

### Better

Hashing, sorting, ya extra structure use karke time improve karna.

### Optimal

Problem pattern identify karke best possible solution dena.

Ye progression samajhna actual coding se bhi zyada important hota hai.

## 33. Real interview value of arrays

Arrays sirf ek topic nahi hain. Ye problem solving ka foundation hain. Agar arrays strong hain to tum:

- loop logic strong kar loge
- indexing mistakes kam kar doge
- patterns jaldi identify kar paoge
- hashing aur binary search better samjhoge
- matrices aur grids se comfortable ho jaoge

## 34. Quick revision sheet

- Array same type values ka fixed-size structure hai.
- Java me indexing `0` se start hoti hai.
- `arr.length` property hoti hai.
- Access aur update fast hote hain.
- Insertion/deletion costly ho sakte hain.
- Sorted array extra power deta hai.
- Contiguous word ka matlab subarray hota hai.
- Two pointers, sliding window, prefix sum, hashing, sorting, binary search aur matrix handling arrays ke core patterns hain.
- Edge cases arrays me bohot important hote hain.

## 35. Final takeaway

Array mastery ka matlab sirf syntax ya loops yaad karna nahi hai. Actual mastery tab hoti hai jab tum problem dekhkar turant identify kar pao ki:

- direct traversal chalega
- two pointers chahiye
- sliding window lagega
- prefix sum useful hai
- hashing se answer niklega
- sorting zaroori hai
- binary search apply hogi
- ya problem 2D matrix logic me convert ho rahi hai

Jitna array theory strong hoga, utni hi DSA ki baaki journey smooth hogi.
