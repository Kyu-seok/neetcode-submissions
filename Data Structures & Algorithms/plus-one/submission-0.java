class Solution {
    public int[] plusOne(int[] digits) {
        int sum = 0;

        for (int digit : digits) {
            sum = (sum * 10) + digit;
        }

        sum++;

        List<Integer> list = new ArrayList<>();

        while (sum != 0) {
            list.add(sum % 10);
            sum /= 10;
        }

        Collections.reverse(list);

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;

    }
}