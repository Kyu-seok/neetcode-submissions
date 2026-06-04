class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] scores = new int[n + 1];

        for (int[] t : trust) {
            scores[t[0]]--;
            scores[t[1]]++;
        }

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] == n - 1) return i;
        }

        return -1;
    }
}