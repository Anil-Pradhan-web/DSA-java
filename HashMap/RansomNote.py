"""
Pattern: HashMap (Dictionary)
Leetcode #383: Ransom Note

Problem: Kya magazine ke characters se ransomNote bana sakte hain?

HashMap kyun use karte hain?
1. Magazine mein har character ka count store karte hain (frequency)
2. RansomNote ke har character ko check karte hain
3. Agar character available nahi hai ya count khatam ho gaya -> return False
4. Har use par count 1 se kam karte hain

Example: ransomNote="aaa", magazine="aab"
Magazine: a=2, b=1
RansomNote ko 3 'a' chahiye but sirf 2 available -> False 

Time Complexity: O(m+n) where m=len(magazine), n=len(ransomNote)
Space Complexity: O(k) where k=unique characters in magazine
"""

class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        mag = {}
        for char in magazine:
            mag[char] = mag.get(char, 0) + 1
        
        for char in ransomNote:
            if mag.get(char, 0) <= 0:
                return False
            mag[char] -= 1
    
        return True
