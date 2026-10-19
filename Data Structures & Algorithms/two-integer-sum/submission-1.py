class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}

        for i, num in enumerate(nums):
            pair = target - num
            if pair in map:
                return [map.get(pair), i]
            else:
                map[num] = i
        
        return 
            
        