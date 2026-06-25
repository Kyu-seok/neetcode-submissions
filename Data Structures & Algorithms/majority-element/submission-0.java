class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int result = 0;
        int maxFreq = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            if (freq > maxFreq) {
                result = entry.getKey();
                maxFreq = freq;
            }
        }

        return result;
    }
}