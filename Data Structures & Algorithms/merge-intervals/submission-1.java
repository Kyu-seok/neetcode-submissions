class Solution {
    public int[][] merge(int[][] intervals) {
        sort(intervals);
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

    private void sort(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i][0] > arr[j][0]) {
                    int[] temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
