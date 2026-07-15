class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        for (int[] trip : trips) {
            int passengers = trip[0];
            int to = trip[1];
            int from = trip[2];

            while (!minHeap.isEmpty() && minHeap.peek()[2] <= to) {
                int[] curr = minHeap.poll();
                capacity += curr[0];
            }

            if (passengers > capacity) return false;
            capacity -= passengers;
            minHeap.offer(trip);
        }

        return true;
    }
}