class Solution {
    
    List<List<String>> result;
    List<String> list;
    String s;

    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        this.list = new ArrayList<>();
        this.s = s;

        backtrack(0);

        return result;
    }

    private void backtrack(int i) {
        if (i >= s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int j = i + 1; j <= s.length(); j++) {
            if (isPalindrome(i, j)) {
                list.add(s.substring(i, j));
                backtrack(j);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(int i, int j) {
        int left = i;
        int right = j - 1;

        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
