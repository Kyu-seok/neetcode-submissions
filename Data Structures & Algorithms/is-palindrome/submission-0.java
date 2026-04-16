class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            while (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.isDigit(s.charAt(left))) {
                if (s.charAt(left) != s.charAt(right)) return false;
            } else {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
