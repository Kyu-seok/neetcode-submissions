class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map = {}

        for str in strs:
            serial = "".join(sorted(str))

            if serial in map:
                map[serial].append(str)
            else: 
                map[serial] = [str]
        
        result = []

        for key, value in map.items():
            result.append(value)

        return result


