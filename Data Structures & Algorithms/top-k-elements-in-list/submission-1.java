class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.frequency, a.frequency));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll().number;
        }

        return result;
    }

    class Pair {
        int number;
        int frequency;

        Pair(int number, int frequency) {
            this.number = number;
            this.frequency = frequency;
        }
    }
}
