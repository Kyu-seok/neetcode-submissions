class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (!map.containsKey(sorted)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sorted, list);
            } else {
                map.get(sorted).add(str);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
