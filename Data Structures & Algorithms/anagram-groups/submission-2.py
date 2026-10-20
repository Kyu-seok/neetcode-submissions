class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagram_groups = {}

        for s in strs:
            key = "".join(sorted(s))

            if key not in anagram_groups:
                anagram_groups[key] = []
            
            anagram_groups[key].append(s)

        return list(anagram_groups.values())