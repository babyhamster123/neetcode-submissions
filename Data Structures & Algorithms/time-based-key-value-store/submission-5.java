class TimeMap {
    // sanity check
    // All the timestamps of set are strictly increasing.

    private final Map<String, TimeMapValues> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TimeMapValues values = this.map.get(key);
        if (values == null) {
            values = new TimeMapValues();
            this.map.put(key, values);
        }
        values.add(value, timestamp);
    }
    
    public String get(String key, int timestamp) {
        TimeMapValues values = this.map.get(key);
        if (values == null) {
            return "";
        }

        return values.getValue(timestamp);
    }

    private class TimeMapValues {
        private final List<Node> list;

        private TimeMapValues() {
            this.list = new ArrayList<>();
        }

        private void add(String value, int timestamp) {
            this.list.add(new Node(value, timestamp));
        }

        // binary search the list
        private String getValue(int timestamp) {
            int left = 0;
            int right = list.size() - 1;
            String result = "";
            while (left <= right) {
                int mid = left + (right - left) / 2;
                Node n = list.get(mid);
                if (n.timestamp == timestamp) {
                    return n.val;
                }

                if (n.timestamp < timestamp) {
                    result = n.val;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return result;
        }
    }

    private class Node {
        private final String val;
        private final int timestamp;

        private Node(String val, int timestamp) {
            this.val = val;
            this.timestamp = timestamp;
        }
    }
}
