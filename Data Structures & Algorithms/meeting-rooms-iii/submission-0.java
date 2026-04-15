class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
            (a, b) -> (a[0] != b[0])
                ? Long.compare(a[0], b[0])
                : Long.compare(a[1], b[1])
        );

        for (int i = 0; i < n; i++) {
            freeRooms.offer(i);
        }

        int[] counts = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                int roomId = (int) busyRooms.poll()[1];
                freeRooms.offer(roomId);
            }

            if (!freeRooms.isEmpty()) {
                int roomId = freeRooms.poll();
                counts[roomId]++;
                busyRooms.offer(new long[] {end, roomId});
            } else {
                long[] earliest = busyRooms.poll();
                long prevEnd = earliest[0];
                int roomId = (int) earliest[1];
                counts[roomId]++;
                int duration = end - start;
                busyRooms.offer(new long[] {prevEnd + duration, roomId});
            }
        }

        int res = 0;

        for (int i = 1; i < n; i++) {
            if (counts[res] < counts[i]) {
                res = i;
            }
        }

        return res;
    }
}