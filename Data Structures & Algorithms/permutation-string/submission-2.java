class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }

        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            char cRight = s2.charAt(right);
            freq2[cRight - 'a']++;

            if (right - left + 1 > s1.length()) {
                char cLeft = s2.charAt(left);
                freq2[cLeft - 'a']--;
                left++;
            }

            if (matches(freq1, freq2)) return true;
        }

        return false;
    }

    private boolean matches(int[] arr1, int[] arr2) {
        if (arr1.length != 26 || arr1.length != arr2.length) return false;

        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) return false;
        }

        return true;
    }
}
