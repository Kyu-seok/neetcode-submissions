class Solution {
    public int[] sortArray(int[] nums) {
        heapSort(nums);

        return nums;
    }

    private void heapSort(int[] nums) {
        int n = nums.length;

        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        for (int end = n - 1; end >= 0; end--) {
            swap(nums, 0, end);
            heapify(nums, end, 0);
        }
    }

    private void heapify(int[] nums, int heapSize, int i) {
        int largest = i;

        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < heapSize && nums[largest] < nums[left]) {
            largest = left;
        }

        if (right < heapSize && nums[largest] < nums[right]) {
            largest = right;
        }

        if (largest != i) {
            swap(nums, i, largest);
            heapify(nums, heapSize, largest);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}