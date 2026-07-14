class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        int n = x.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(x[i])) {
                map.put(x[i], y[i]);
            } else {
                if (y[i] > map.get(x[i])) {
                    map.put(x[i], y[i]);
                }
            }
        }

        if (map.size() < 3) return -1;

        int first = 0;
        int second = 0;
        int third = 0;

        for (int value : map.values()) {
            if (value > first) {
                third = second;
                second = first;
                first = value;
            } else if (value > second) {
                third = second;
                second = value;
            } else if (value > third) {
                third = value;
            }
        }

        return first + second + third;
    }
}