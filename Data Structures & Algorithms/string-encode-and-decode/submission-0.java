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
        System.out.println("str : " + str);

        int i = 0;
        while (i < str.length()) {
            System.out.println("i : " + i);
            int delimeterIndex = str.indexOf('#', i);
            String lengthStr = str.substring(i, delimeterIndex);
            int length = Integer.parseInt(lengthStr);
            int fromIndex = delimeterIndex + 1;
            int toIndex = fromIndex + length - 1;

            list.add(str.substring(fromIndex, toIndex + 1));

            i = toIndex + 1;
        }

        return list;
    }
}
