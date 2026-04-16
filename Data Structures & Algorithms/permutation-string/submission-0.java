class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        int n = s1.length();

        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < n - 1; i++) {
            char c = s2.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        for (int i = n - 1; i <= s2.length() - n; i++) {
            char c = s2.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);

            if (isPermutation(map1, map2)) return true;

            char toRemove = s2.charAt(i - n + 1);

            map2.put(toRemove, map2.get(toRemove) - 1);

            if (map2.get(toRemove) == 0) {
                map2.remove(toRemove);
            }
        }

        return false;
    }

    private boolean isPermutation(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if (map1.size() != map2.size()) return false;

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            char c = entry.getKey();
            if (map2.get(c) != entry.getValue()) return false;
        }

        return true;
    }
}
