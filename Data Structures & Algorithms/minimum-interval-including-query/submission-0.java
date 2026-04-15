class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int n = queries.length;
        int[][] sortedQuery = new int[n][2];

        for (int i = 0; i < n; i++) {
            sortedQuery[i][0] = queries[i];
            sortedQuery[i][1] = i;
        }

        Arrays.sort(sortedQuery, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[n];

        int i = 0;
        int q = 0;

        while (q < n) {
            int query = sortedQuery[q][0];
            int originalIndex = sortedQuery[q][1];

            while (i < intervals.length && intervals[i][0] <= query) {
                int left = intervals[i][0];
                int right = intervals[i][1];
                minHeap.offer(new int[] {right - left + 1, right});
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }

            result[originalIndex] = (!minHeap.isEmpty()) ? minHeap.peek()[0] : -1;

            q++;
        }

        return result;
    }
}
