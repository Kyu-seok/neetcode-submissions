class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;

            int digit = columnNumber % 26;

            sb.insert(0, (char) ('A' + digit));

            columnNumber /= 26;
        }

        return sb.toString();
    }
}