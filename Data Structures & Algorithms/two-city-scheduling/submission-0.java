class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> Integer.compare(a[0] - a[1], b[0] - b[1]));

        int result = 0;
        int n = costs.length / 2;

        for (int i = 0; i < n; i++) {
            result += costs[i][0];
        }

        for (int i = n; i < costs.length; i++) {
            result += costs[i][1];
        }

        return result;
    }
}