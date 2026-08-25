class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;

        int maxLength = 0;

        while (right < s.length()) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }

            set.add(s.charAt(right++));

            maxLength = Math.max(maxLength, set.size());
        }

        return maxLength;
    }
}

/*
    Constraints:
    
    0 <= s.length <= 50,000
    s may consist of printable ASCII characters.
*/