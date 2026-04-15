class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minSize = 0;
        int maxSize = 0;

        for (int weight : weights) {
            minSize = Math.max(minSize, weight);
            maxSize += weight;
        }

        while (minSize < maxSize) {
            int midSize = (minSize + maxSize) / 2;

            if (canShip(weights, days, midSize)) {
                maxSize = midSize;
            } else {
                minSize = midSize + 1;
            }
        }

        return minSize;
    }

    private boolean canShip(int[] weights, int days, int size) {
        int daysTaken = 1;
        int currentWeight = 0;

        for (int weight : weights) {
            if (currentWeight + weight > size) {
                daysTaken++;
                currentWeight = 0;
            }

            currentWeight += weight;
        }

        return daysTaken <= days;
    }
}