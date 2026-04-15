class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();

        while (n != 1) {
            if (visited.contains(n)) return false;

            visited.add(n);

            int result = 0;

            while (n != 0) {
                int digit = n % 10;
                result += (digit * digit);
                n /= 10;
            }

            n = result;
        }

        return true;
    }
}
