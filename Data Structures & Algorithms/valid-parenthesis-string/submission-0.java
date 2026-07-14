class Solution {
    public boolean checkValidString(String s) {
        int maxOpen = 0;
        int minOpen = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                maxOpen++;
                minOpen++;
            } else if (c == ')') {
                maxOpen--;
                minOpen--;
            } else {
                maxOpen++;
                minOpen--; 
            }

            if (maxOpen < 0) return false;

            if (minOpen < 0) {
                minOpen = 0;
            }
        }

        return (minOpen == 0) ? true : false;
    }
}
