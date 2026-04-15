class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            int pair = target - numbers[i];

            int pairIndex = binarySearch(numbers, pair, i + 1, numbers.length - 1);
            if (pairIndex != -1) {
                result[0] = i + 1;
                result[1] = pairIndex + 1;
                break;
            }
        }

        return result;
    }

    private int binarySearch(int[] numbers, int target, int start, int end) {
        int left = start;
        int right = end;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
