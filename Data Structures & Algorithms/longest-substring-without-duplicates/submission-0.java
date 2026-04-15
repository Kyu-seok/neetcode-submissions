class Solution {
    public int lengthOfLongestSubstring(String s) {
       int max = 0;
       Set<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);

            while (set.contains(c) && left < s.length()) {
                char toRemove = s.charAt(left);
                set.remove(toRemove);
                left++;
            }

            set.add(c);
            right++;
            max = Math.max(max, set.size());
        }

       return max; 
    }
}
