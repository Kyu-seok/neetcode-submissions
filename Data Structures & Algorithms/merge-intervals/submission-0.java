class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        int i = 0;
        int start = Integer.MAX_VALUE;
        int end = 0;

        while (i < intervals.length) {
            if (start == Integer.MAX_VALUE || intervals[i][0] <= end) {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(start, intervals[i][1]);
            } else {
                list.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
            i++;
        }

        list.add(new int[] {start, end});

        return list.toArray(new int[list.size()][]);
    }
}
