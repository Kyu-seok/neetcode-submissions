class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        int sum = Arrays.stream(matchsticks).sum();
        int target = sum / 4;

        Arrays.sort(matchsticks);

        if (sum % 4 != 0 || matchsticks[n - 1] > target) return false;

        int[] sides = new int[4];
        return dfs(matchsticks, sides, n - 1, target);
    }

    private boolean dfs(int[] matchsticks, int[] sides, int i, int target) {
        if (i < 0) return true;

        int stick = matchsticks[i];

        for (int side = 0; side < 4; side++) {

            if (sides[side] + stick > target) {
                continue;
            }

            if (side > 0 && sides[side] == sides[side - 1]) {
                continue;
            }

            sides[side] += stick;

            if (dfs(matchsticks, sides, i - 1, target)) {
                return true;
            }

            sides[side] -= stick;
        }

        return false;
    }
}