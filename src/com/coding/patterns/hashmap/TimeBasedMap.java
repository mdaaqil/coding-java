class TimeMap {

    class TimeValue{
        String val;
        int timeStamp;
        public TimeValue(String val, int time)
        {
            this.val = val;
            timeStamp = time;
        }
    }
    Map<String, List<TimeValue>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k-> new ArrayList<>()).add(new TimeValue(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<TimeValue> list = map.getOrDefault(key, null);
        if(list == null) return "";
        int l = 0, r = list.size() - 1;
        String res = "";
        while(l <= r)
        {
            int mid = (l + r) / 2;
            if(list.get(mid).timeStamp == timestamp) 
            {
                return list.get(mid).val;
            }
            if(list.get(mid).timeStamp < timestamp)
            {
                res = list.get(mid).val;
                l = mid + 1;
            }
            else
                r = mid - 1;
        }
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
