class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();

        for (int[] car : cars) {
            int p = car[0];
            int s = car[1];

            double finishTime = (double) (target - p) / s;

            if (stack.isEmpty() || finishTime > stack.peek()) {
                stack.push(finishTime);
            }
        }

        return stack.size();
    }
}
