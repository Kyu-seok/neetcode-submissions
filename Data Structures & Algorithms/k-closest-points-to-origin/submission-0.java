class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int[] arr = new int[] {x, y, (x * x) + (y * y)};
            minHeap.offer(arr);
        }

        for (int i =0 ; i < k; i++) {
            int[] arr = minHeap.poll();
            result[i][0] = arr[0];
            result[i][1] = arr[1];
        }

        return result;
    }
}
