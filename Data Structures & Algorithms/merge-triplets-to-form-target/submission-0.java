class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] triplet = new int[3];

        for (int i = 0; i < triplets.length; i++) {

            if ( triplets[i][0] > target[0] || triplets[i][1] > target[1] || triplets[i][2] > target[2]) {
                continue;
            }

            triplet[0] = Math.max(triplet[0], triplets[i][0]);
            triplet[1] = Math.max(triplet[1], triplets[i][1]);
            triplet[2] = Math.max(triplet[2], triplets[i][2]);

            if (triplet[0] == target[0] && triplet[1] == target[1] && triplet[2] == target[2]) return true;
        }

        return false;
    }
}
