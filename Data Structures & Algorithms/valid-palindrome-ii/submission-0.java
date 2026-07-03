class Solution {
    public boolean validPalindrome(String s) {

        return validPalindrome(s, 0, s.length() - 1, 1);
    }

    private boolean validPalindrome(String s, int l, int r, int count) {
        if (l >= r) return true;

        if (s.charAt(l) == s.charAt(r)) {
            return validPalindrome(s, l + 1, r - 1, count);
        } else if (count >= 1) {
            return validPalindrome(s, l, r - 1, count - 1) 
                    || validPalindrome(s, l + 1, r, count - 1);
        } else {
            return false;
        }
    }
}