class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder[] sbs = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        boolean isDown = true;
        int level = 0;

        for (int i = 0; i < s.length(); i++) {
            sbs[level].append(s.charAt(i));
            if (level == 0) {
                isDown = true;
                level++;
            } else if (level == numRows - 1) {
                isDown = false;
                level--;
            } else {
                if (isDown) {
                    level++;
                } else {
                    level--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            sb.append(sbs[i]);
        }

        return sb.toString();
    }
}