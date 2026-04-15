class TimeMap {

    class Pair {
        String value;
        int timestamp;

        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Pair>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        // find the upper bound and return -1 of the upperbound
        List<Pair> list = map.get(key);

        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = left + (right - left) / 2;
            Pair pair = list.get(mid);

            if (pair.timestamp <= timestamp) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (left - 1 < 0) return "";
        return list.get(left - 1).value;
    }
}
