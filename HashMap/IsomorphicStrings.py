"""
Pattern: HashMap (Dictionary) And also We have used python basics
Leetcode #205: Isomorphic Strings

Problem: Kya dono strings ka structure same hai [Dono strings mai character aur frequency ka sequence match karna chahiye]

Kaise solve kiya ?
1. Dono strings ka length same hona chahiye otherwise False return kardo
2. 's' string ke characters ko map karte hai 't' string ke characters ke sath {through zip method}
3. Since HashMap/Dictionary mai key-value pairs hota hai, 's' string ke characters keys banenge aur 't' string ke characters values{through zip method}
ex: s="egg" t="add" hashmap = { e:a, g:d, g:d}
4. Dictionary,s,t ko set mai convert karna aur tino ka length check karna hai because 
's' ka har ek unique character 't' ke bilkul ek hi unique character se match karta hai, aur iska ulta bhi sahi hai, bina kisi overlap ya duplicate ke.
set(s) = set(egg) = e,g length = 2
set(t) = set(add) = a,d length = 2
set(hashmap) = e:a, g:d length = 2 

Time Complexity: O(n)
Space Complexity: O(n)
"""
class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        return len(s) == len(t) and len(set(zip(s, t))) == len(set(s)) == len(set(t))
