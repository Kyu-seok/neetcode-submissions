class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> oceanViews = new ArrayList<>();

        int n = heights.length;

        int maxHeight = heights[n - 1];
        oceanViews.add(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                oceanViews.add(i);
            }
        }

        int[] result = new int[oceanViews.size()];

        for (int i = 0; i < oceanViews.size(); i++) {
            result[i] = oceanViews.get(oceanViews.size() - i - 1);
        }

        return result;
    }
}