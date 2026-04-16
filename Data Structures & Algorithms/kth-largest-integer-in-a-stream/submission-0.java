class KthLargest {

    int k;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        if (val <= minHeap.peek()) return minHeap.peek();

        minHeap.offer(val);
        minHeap.poll();

        return minHeap.peek();
    }
}
