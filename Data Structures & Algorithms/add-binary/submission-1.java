class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int value = 0;
            if (i >= 0 && a.charAt(i) == '1') {
                value++;
            }
            if (j >= 0 && b.charAt(j) == '1') {
                value++;
            }

            value += carry;

            sb.append(value % 2);
            carry = value / 2;

            i--;
            j--;
        }

        if (carry == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}