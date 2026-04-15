class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((int[] a, int[] b) -> {
            return (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]);
        });

        for (int[] point : points) {
            minHeap.offer(point);
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            int[] point = minHeap.poll();
            result[i][0] = point[0];
            result[i][1] = point[1];
        }

        return result;
    }
}
