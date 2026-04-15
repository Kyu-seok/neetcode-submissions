class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (!map.containsKey(n)) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(n, list);
            } else {
                map.get(n).add(i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int pair = target - nums[i];

            if (map.containsKey(pair)) {
                List<Integer> indices = map.get(pair);
                for (int index : indices) {
                    if (index != i) {
                        return new int[] {i, index};
                    }
                }
            }
        }

        return null;
    }
}
