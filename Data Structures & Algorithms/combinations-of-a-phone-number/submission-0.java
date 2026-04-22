class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        Map<Integer, char[]> map = new HashMap<>();

        map.put(2, new char[] {'a', 'b', 'c'});
        map.put(3, new char[] {'d', 'e', 'f'});
        map.put(4, new char[] {'g', 'h', 'i'});
        map.put(5, new char[] {'j', 'k', 'l'});
        map.put(6, new char[] {'m', 'n', 'o'});
        map.put(7, new char[] {'p', 'q', 'r', 's'});
        map.put(8, new char[] {'t', 'u', 'v'});
        map.put(9, new char[] {'w', 'x', 'y', 'z'});

        StringBuilder sb = new StringBuilder();

        backtrack(result, map, digits, sb, 0);

        return result;
    }

    private void backtrack(List<String> result, Map<Integer, char[]> map, String digits, StringBuilder sb, int i) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        int num = digits.charAt(i) - '0';
        char[] arr = map.get(num);

        for (int j = 0; j < arr.length; j++) {
            sb.append(arr[j]);
            backtrack(result, map, digits, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
