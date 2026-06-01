class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int furthest = 0;

        while (!queue.isEmpty()) {
            int i = queue.poll();
            int start = Math.max(i + minJump, furthest + 1);

            for (int j = start; j < s.length() && j <= i + maxJump; j++) {
                if (s.charAt(j) == '0') {
                    queue.offer(j);
                    if (j == s.length() - 1) return true;
                }
            }

            furthest = Math.max(furthest, i + maxJump);
        }

        return false;
    }
}