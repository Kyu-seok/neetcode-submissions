class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;

        int n3 = 0;     // n - 3
        int n2 = 1;     // n - 2
        int n1 = 1;     // n - 1

        for (int i = 3; i <= n; i++) {
            int next = n3 + n2 + n1;
            n3 = n2;
            n2 = n1;
            n1 = next;
        }

        return n1;
    }
}