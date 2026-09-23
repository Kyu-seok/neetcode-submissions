class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> target = new HashMap<>();

        for (char c : t.toCharArray()) {
            target.merge(c, 1, Integer::sum);
        }

        Map<Character, Integer> window = new HashMap<>();

        int required = target.size();
        int have = 0;
        int minLength = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;
        int start = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            window.merge(c, 1, Integer::sum);

            if (target.containsKey(c) && target.get(c).equals(window.get(c))) {
                have++;
            }
 
            while (have == required) {
                if (right - left + 1 < minLength) {
                    start = left;
                    minLength = right - left + 1;
                }

                char charLeft = s.charAt(left);
                window.merge(charLeft, -1, Integer::sum);

                if (target.containsKey(charLeft) && target.get(charLeft).intValue() > window.get(charLeft).intValue()) {
                    have--;
                }
                left++;
            }
            right++;
        }

        return (minLength == Integer.MAX_VALUE) ? "" : s.substring(start, start + minLength);
    }
}
