class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> target = new HashMap<>();

        for (char c : t.toCharArray()) {
            target.merge(c, 1, Integer::sum);
        }

        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        int start = 0;

        int have = 0;
        int required = target.size();
        int minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);
            window.merge(c, 1, Integer::sum);

            if (target.containsKey(c) && target.get(c).equals(window.get(c))) {
                have++;
            }

            while (have == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char charLeft = s.charAt(left);
                window.merge(charLeft, -1, Integer::sum);

                if (target.containsKey(charLeft) && target.get(charLeft) > window.get(charLeft)) {
                    have--;
                }
                left++;
            }

            right++;
        }


        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(start, start + minLen);
    }
}
