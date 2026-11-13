class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> { 
            int diffA = Math.abs(x - a); 
            int diffB = Math.abs(x - b); 

            if (diffA != diffB) {
                return Integer.compare(diffA, diffB);
            }

            return Integer.compare(a, b);
        }); 

        for (int num : arr) {
            pq.offer(num);
        }

        for (int i = 0; i < k; i++) {
            result.add(pq.poll());
        }

        Collections.sort(result);

        return result;
    }
}