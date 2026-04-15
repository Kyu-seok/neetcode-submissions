class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int removeCount = 0;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (lastEnd <= start) {
                // do not overlap, keep
                lastEnd = end;
            } else {
                // does overlap, remove this interval and continue the loop
                removeCount++;
            }
        }

        return removeCount;
    }
}
