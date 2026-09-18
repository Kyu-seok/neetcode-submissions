class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {
            int delimeterIndex = str.indexOf("#", i);
            int length = Integer.parseInt(str.substring(i, delimeterIndex));
            i = delimeterIndex + 1;
            String word = str.substring(i, i + length);
            i += length;
            list.add(word);
        }

        return list;
    }
}
