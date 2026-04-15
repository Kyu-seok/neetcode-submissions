class KthLargest {

    int k;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for (int i = 0; i < k && i < nums.length; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        if (minHeap.size() == k && minHeap.peek() > val) return minHeap.peek();
        
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
