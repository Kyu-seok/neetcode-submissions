class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        dict1 = {}
        dict2 = {}

        for char in s:
            dict1[char] = dict1.get(char, 0) + 1
        
        for char in t:
            dict2[char] = dict2.get(char, 0) + 1

        return dict1 == dict2

