class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int gift : gifts) {
            maxHeap.offer(gift);
        }

        for (int i = 0; i < k; i++) {
            int num = maxHeap.poll();
            maxHeap.offer((int) Math.sqrt(num));
        }

        long result = 0;

        while (!maxHeap.isEmpty()) {
            result += maxHeap.poll();
        }

        return result;
    }
}