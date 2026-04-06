# Searching Theory Notes

## 1. Searching kya hota hai?

Searching ka matlab hota hai kisi data structure me required value, position, condition, ya answer ko dhoondhna. Simple terms me, jab hum poochte hain:

- target element present hai ya nahi
- target kis index par hai
- first ya last occurrence kya hai
- smallest valid answer kya hai
- largest possible feasible answer kya hai

to hum searching kar rahe hote hain.

## 2. Searching kyun important hai?

Searching DSA ka core topic hai kyunki:
- arrays aur strings me frequently use hota hai
- binary search interviews ka favorite topic hai
- optimization problems ko efficient bana sakta hai
- sorted data ka full benefit tab milta hai jab searching strong ho
- many advanced topics monotonicity aur decision logic par based hote hain

## 3. Searching ke basic goals

Searching problem me output alag-alag type ka ho sakta hai:

- exact value ka index
- element present hai ya nahi
- first occurrence
- last occurrence
- smallest element greater than target
- largest element smaller than target
- minimum feasible answer
- maximum feasible answer
- peak, pivot, ya turning point

Ye samajhna bahut important hota hai ki problem actual me kis type ki search maang rahi hai.

## 4. Search problem dekhte hi kya sochna chahiye?

Sabse pehle ye questions poochho:

- data sorted hai ya unsorted?
- duplicates allowed hain?
- exact match chahiye ya boundary answer?
- monotonic condition hai?
- answer space integer range me hai?
- 1D structure hai ya 2D?
- directly data par search karni hai ya answer par?

Yahi questions decide karte hain ki linear search lagegi, binary search lagegi, ya binary search on answer lagega.

## 5. Linear Search

Linear search sabse simple search hoti hai. Isme hum data ko start se end tak dekhte hain aur har element ko target se compare karte hain.

Use cases:
- unsorted array
- chhota input size
- one-time direct scan
- exact match check

Advantages:
- simple
- sorted hona zaroori nahi
- implementation easiest hoti hai

Disadvantages:
- large data par slow hoti hai
- worst case me poora array dekhna padta hai

Time intuition:
- best case `O(1)`
- worst case `O(n)`

## 6. Binary Search

Binary search efficient searching algorithm hai jo tab use hota hai jab search space sorted ho ya monotonic behavior follow kare.

Main idea:
- beech ka point choose karo
- compare karo
- aadha search space eliminate kar do

Binary search ka power isi me hai ki har step me search space half ho jata hai.

## 7. Binary Search ke liye necessary condition

Binary search blind formula nahi hai. Iske liye ye cheez chahiye hoti hai:

- sorted data
ya
- monotonic answer behavior

Matlab tumhare paas aisa structure hona chahiye jahan comparison ke baad safely ek side ko discard kiya ja sake.

## 8. Sorted array kya advantage deta hai?

Sorted array me:
- chhote values ek side hoti hain
- bade values doosri side hoti hain

Isliye:
- agar `mid` target se chhota hai to left side useless ho jaati hai
- agar `mid` target se bada hai to right side useless ho jaati hai

Ye elimination hi binary search ka foundation hai.

## 9. Binary search ka intuition

Binary search sirf element dhoondhne ka algorithm nahi hai. Ye ek thinking pattern hai.

Pattern:
- condition check karo
- decide karo answer left side me ho sakta hai ya right side me
- unnecessary half ko hata do

Jahan bhi half elimination valid ho, binary search possible ho sakti hai.

## 10. Iterative vs Recursive Binary Search

### Iterative Binary Search

- practical aur commonly used
- space efficient
- interviews me preferred

### Recursive Binary Search

- conceptually neat
- call stack use karti hai
- thoda extra space lagta hai

Real coding me iterative version usually zyada better maana jaata hai.

## 11. Mid calculation important kyun hai?

Binary search me mid carefully calculate kiya jaata hai.

Important intuition:
- direct average calculation overflow risk de sakti hai in some languages
- safer logic use karna standard practice hota hai

Core point:
- mid hamesha search space ke beech ka representative hota hai
- uske basis par decision liya jaata hai

## 12. Binary Search ka time complexity intuition

Har step me search space aadha hota hai.

Example thinking:
- `n`
- `n/2`
- `n/4`
- `n/8`

Isliye total steps approximately `log n` hote hain.

Yahi reason hai ki binary search large sorted data par bahut powerful hoti hai.

## 13. Binary Search ke common types

Binary search ek hi problem ke liye nahi hoti. Iske multiple forms hote hain.

Main variants:
- exact element search
- first occurrence
- last occurrence
- lower bound
- upper bound
- floor
- ceil
- rotated array search
- peak search
- minimum in rotated array
- binary search on answer

## 14. Exact match search

Ye simplest form hoti hai.

Question type:
- target present hai ya nahi?
- target ka index kya hai?

Agar duplicates hain, to normal binary search koi bhi valid matching index de sakti hai.

## 15. First occurrence aur last occurrence

Jab duplicates ho, tab sirf target milna enough nahi hota.

Possible questions:
- target ka first index
- target ka last index
- target kitni baar aaya

Idea:
- answer milne par bhi search continue karte hain
- first occurrence ke liye left side check karte hain
- last occurrence ke liye right side check karte hain

## 16. Lower Bound aur Upper Bound

Ye searching ka important concept hai.

### Lower Bound

Pehla aisa position jahan value target ke greater ya equal ho.

### Upper Bound

Pehla aisa position jahan value target se strictly greater ho.

Inka use hota hai:
- insertion position
- occurrence counting
- range queries
- sorted containers

## 17. Floor aur Ceil

### Floor

Target se chhota ya equal sabse bada element.

### Ceil

Target se bada ya equal sabse chhota element.

Ye concepts real-world search aur ordered data problems me bahut kaam aate hain.

## 18. Duplicates ka effect

Duplicates hone par binary search trickier ho sakti hai.

Important questions:
- target ka first index kya hai?
- last index kya hai?
- duplicates count kitna hai?
- rotated array me duplicates ke saath ambiguity ho sakti hai?

Binary search me equality handling carefully karni padti hai.

## 19. Binary Search on Answer

Ye searching ka sabse important advanced concept hai.

Yahan hum directly array me target nahi dhoondhte. Hum answer space me search karte hain.

Question type:
- minimum possible answer kya hai?
- maximum feasible answer kya hai?

Examples:
- minimum pages
- shipping capacity
- minimum eating speed
- smallest divisor
- allocate resources

## 20. Binary Search on Answer ka core logic

Isme do cheezein hoti hain:

1. search space define karna
2. feasibility check likhna

Feasibility function usually bolti hai:
- kya given answer valid hai?
- kya given answer ke saath kaam ho sakta hai?

Phir binary search use karke smallest ya largest valid answer dhoondha jaata hai.

## 21. Monotonicity kya hoti hai?

Binary search on answer tab lagti hai jab feasibility monotonic ho.

Example pattern:
- false false false true true true
ya
- true true true false false false

Matlab ek point ke baad behavior change hota hai aur fir consistent rehta hai.

Ye monotonic pattern hi binary search on answer ko possible banata hai.

## 22. Feasibility function kya hoti hai?

Feasibility function ek decision function hoti hai jo kisi candidate answer par `possible` ya `not possible` batati hai.

Examples:
- kya itni capacity enough hai?
- kya itne time me kaam ho jayega?
- kya itne pages me allocation possible hai?

Agar feasibility monotonic hai, to answer par binary search lag sakti hai.

## 23. Search Space ka selection

Binary search on answer me sabse common mistake hoti hai galat low aur high lena.

Search space define karte waqt socho:
- minimum answer logically kitna ho sakta hai?
- maximum answer logically kitna ho sakta hai?

Agar bounds galat liye, to binary search correct answer miss kar sakti hai.

## 24. Rotated Sorted Array

Rotated sorted array ka matlab:
- originally sorted array ko kisi pivot par rotate kiya gaya hai

Important observation:
- poora array unsorted jaisa lag sakta hai
- lekin har step par kam se kam ek side sorted hoti hai

Ye property modified binary search allow karti hai.

## 25. Rotated sorted array me search

Question:
- target rotated array me kahan hai?

Key idea:
- mid nikalo
- identify karo kaunsa half sorted hai
- decide karo target us sorted half ke andar aata hai ya nahi

Is problem me normal binary search se zyada condition analysis chahiye hoti hai.

## 26. Minimum in Rotated Sorted Array

Yahan target fixed value nahi hota. Humein pivot ke baad ka minimum element dhoondhna hota hai.

Observation:
- agar mid value right se badi hai to minimum right side me hai
- warna minimum left side including mid ho sakta hai

Ye bhi modified binary search ka classic example hai.

## 27. Peak Element

Peak element wo hota hai jo apne neighbors se greater ho.

Important observation:
- agar sequence rising hai, to peak right side me ho sakti hai
- agar sequence falling start ho gayi, to peak left side me ho sakti hai

Binary search isliye possible hai because slope direction half selection allow karti hai.

## 28. Mountain Array / Bitonic Thinking

Kabhi array pehle increasing aur phir decreasing hoti hai.

Isme common tasks:
- peak find karna
- target find karna
- maximum find karna

Approach:
- peak locate karo
- phir dono sides par required search logic lagao

## 29. Square Root and Root Finding

Jab exact value directly nahi milti, tab binary search approximate ya floor answer dhoondhne me useful hoti hai.

Question type:
- floor sqrt
- nth root
- cube root approximation

Yahan exact element nahi, ek mathematical boundary answer dhoondha ja raha hota hai.

## 30. Infinite Sorted Array / Unknown Size Search

Kabhi question me array effectively infinite maana jaata hai ya size directly available nahi hota.

Is situation me:
- pehle search range expand karte hain
- phir उस range me binary search lagate hain

Ye idea exponential search ka base hai.

## 31. Exponential Search

Exponential search useful hota hai jab:
- target shuru ke paas ho
- search range unknown ho

Idea:
- pehle 1, 2, 4, 8, 16... jaisi doubling se range dhoondo
- phir us bounded range me binary search lagao

Yeh direct full scan se better hota hai.

## 32. Jump Search

Jump search sorted array me ek aur technique hai.

Idea:
- fixed step size me jump karo
- jis block me target fall kare, wahan linear search karo

Theory level par interesting hai, lekin interviews me binary search zyada common hoti hai.

## 33. Interpolation Search

Interpolation search sorted aur roughly uniformly distributed data me useful ho sakti hai.

Idea:
- mid fixed center se nahi, expected position se estimate hota hai

Practical note:
- theory me achhi lagti hai
- interviews me binary search zyada reliable aur common hoti hai

## 34. Ternary Search

Ternary search search space ko 3 parts me divide karti hai.

Most useful when:
- unimodal function ho
- single peak ya single valley ho

Standard sorted discrete array search me binary search usually enough aur better hoti hai.

## 35. Unimodal Function kya hoti hai?

Unimodal ka matlab:
- pehle increase phir decrease
ya
- pehle decrease phir increase

Ternary search aise scenarios me optimum point dhoondhne ke liye useful hoti hai.

## 36. Search in 2D Matrix

2D searching ke bhi alag patterns hote hain.

Possible cases:
- har row sorted hai
- rows bhi globally ordered hain
- matrix row-wise aur column-wise sorted hai

Approach depend karti hai matrix ke exact order rules par.

## 37. Matrix search ke common patterns

### Case 1

Puri matrix logically flattened sorted array jaisi behave karti hai.

Approach:
- total elements ko 1D sorted array jaisa treat karo
- binary search lagao

### Case 2

Rows aur columns individually sorted hain.

Approach:
- top-right ya bottom-left se elimination strategy

## 38. String searching aur searching pattern relation

Searching sirf arrays tak limited nahi hai.
Strings me bhi searching hoti hai:

- character search
- substring search
- pattern matching
- dictionary lookup

Advanced string searching me KMP, Z algorithm, hashing, trie jaise concepts aate hain.

## 39. Decision search vs data search

Searching problems do categories me divide kiye ja sakte hain:

### Data Search

Target data me directly present hai ya nahi.

Example:
- element find karo
- first occurrence find karo

### Decision Search

Kya given answer valid hai ya nahi.

Example:
- capacity enough hai?
- time enough hai?

Binary search on answer decision search ka example hai.

## 40. Search problem me invariants

Binary search me invariant ka matlab hota hai:
- search range ke andar hi answer hai
- ya certain side definitely impossible hai

Jab tak invariant clear nahi hota, binary search me bugs aate rehte hain.

Strong binary search solving ke liye yeh sochna bahut useful hota hai:
- `left` kya represent karta hai?
- `right` kya represent karta hai?
- loop ke end par kaunsa pointer answer par hoga?

## 41. Boundary-driven searching

Bahut saari searching problems actual me boundaries dhoondh rahi hoti hain.

Examples:
- first true
- last true
- first index >= target
- first index > target
- smallest feasible answer

Ye exact-match binary search se zyada common interview style hai.

## 42. Common searching problem patterns

## 42.1 Exact Match Search

Target present hai ya nahi.

## 42.2 Boundary Search

First/last/lower/upper bound.

## 42.3 Rotated Search

Sorted structure modified form me diya hota hai.

## 42.4 Answer Search

Optimization question hota hai.

## 42.5 Peak / Pivot Search

Special structure point dhoondhna hota hai.

## 42.6 Range Expansion Search

Unknown size ya infinite-like setting hoti hai.

## 42.7 Matrix Search

2D data me search करनी hoti hai.

## 43. Binary Search ka interview checklist

Binary search lagane se pehle:

1. Kya data sorted hai?
2. Agar sorted nahi hai, kya monotonic answer hai?
3. Exact answer chahiye ya boundary?
4. Duplicates hain?
5. Loop condition kya hogi?
6. `left` aur `right` updates sahi hain?
7. Mid ke comparison ke baad kaunsa half eliminate hoga?
8. End me return kya karna hai?

## 44. Common mistakes in searching problems

- unsorted array par binary search laga dena
- exact match aur boundary search ka difference na samajhna
- wrong mid logic
- `left` aur `right` ko galat update karna
- infinite loop create kar dena
- duplicates ke case ko ignore kar dena
- binary search on answer me wrong search space lena
- feasibility monotonic hai ya nahi, check na karna
- integer overflow cases bhool jana

## 45. `left < right` vs `left <= right`

Ye searching ka classic confusion hai.

Important idea:
- exact match search me loop style alag ho sakta hai
- boundary search me style alag ho sakta hai

Rule yaad karne se zyada important hai:
- tumhare invariant kya hain
- loop end par kaunsa pointer answer represent karega

## 46. Infinite loop kaise hota hai?

Binary search me infinite loop tab hota hai jab:
- pointers move hi nahi kar rahe
- mid calculate sahi hai but update wrong hai
- equality case properly handle nahi hua

Isliye mid ke baad pointer update me `+1` ya `-1` ka role important hota hai.

## 47. Time complexity comparison

- linear search = `O(n)`
- binary search = `O(log n)`
- exponential search = typically `O(log i)`
- jump search = around `O(sqrt n)` style intuition
- interpolation search = distribution dependent
- binary search on answer = `O(log range)` multiplied by feasibility cost

## 48. Space complexity intuition

- iterative search methods usually `O(1)` extra space
- recursive binary search call stack use karti hai
- matrix ya helper structure based approaches problem-dependent hoti hain

## 49. Searching aur sorting ka relation

Searching aur sorting closely connected topics hain.

Sorting se fayda:
- binary search possible hoti hai
- boundary logic easy hota hai
- duplicates grouping easy hoti hai
- interval style reasoning easier ho sakti hai

Isliye kabhi-kabhi pehle sort karna aur phir search karna efficient strategy hoti hai.

## 50. Real interview value of searching

Searching mastery ka matlab sirf binary search code yaad hona nahi hai. Real mastery tab hoti hai jab tum problem dekhkar turant identify kar pao:

- linear search enough hai
- binary search possible hai
- boundary search chahiye
- rotated logic chahiye
- peak/pivot logic chahiye
- answer space par search karni hai
- matrix elimination ya flatten search karni hai

## 51. Quick revision sheet

- Searching ka matlab value, index, boundary, ya answer dhoondhna hota hai.
- Unsorted data me linear search common hoti hai.
- Sorted data me binary search powerful hoti hai.
- Binary search ke liye monotonicity ya sorted structure chahiye.
- First/last occurrence aur lower/upper bound alag problems hain.
- Rotated array problems modified binary search maangte hain.
- Optimization questions me binary search on answer lag sakti hai.
- Search space selection aur feasibility function bahut important hote hain.
- 2D search structure ke order rules par depend karti hai.

## 52. Final takeaway

Searching ka core essence hai elimination.

Jab tak tum ye nahi samajhte ki:
- kaunsi information sure hai
- kaunsa half impossible hai
- kaunsi condition monotonic hai
- kaunsi boundary answer represent karti hai

tab tak binary search aur searching patterns weak lagenge.

Agar searching strong ho gayi, to arrays, matrices, optimization, aur many interview hard problems kaafi manageable lagne lagte hain.
