class Solution {
    public int minOperations(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int operations = 0;

        for (int count : map.values()) {
            while (count > 0) {
                if (count == 1) return -1;

                if (count % 3 == 0) {
                    count -= 3;
                    operations++;
                } else if (count % 2 == 1) {
                    count -= 3;
                    operations++;
                } else {
                    count -= 2;
                    operations++;
                }
            }
        }

        return operations;
    }
}