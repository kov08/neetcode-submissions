class TimeMap {
    Map<String, List<Obj>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            map.get(key).add(new Obj(value, timestamp));
        }else{
            List<Obj> lst = new ArrayList<>();
            lst.add(new Obj(value, timestamp));
            map.put(key, lst);
        }
        // map.computeIfAbsent(key, key -> new ArrayList<>(new Obj(value, timestamp)));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        return bs(map.get(key), timestamp);
    }

    private String bs(List<Obj> lst, int ts){
        int r = lst.size();

        // O(n)
        for(int i = r-1; i >= 0; i--){
            Obj ans = lst.get(i);
            if(ans.time <= ts){
                return ans.val;
            }
        }

        return "";
    }
}

class Obj{
    String val;
    int time;

    public Obj(){};

    public Obj(String val, int time){
        this.val = val;
        this.time = time;
    }
}
