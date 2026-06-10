class MedianFinder {

    List<Integer> lst;

    public MedianFinder() {
        lst = new ArrayList<>();
    }
    
    public void addNum(int num) {
        lst.add(num);
        lst.sort(Comparator.naturalOrder());
    }
    
    public double findMedian() {
        double ans;
        int len = lst.size();
        if(len % 2 != 0){
            ans = lst.get(len / 2);
            return ans;
        } else{
            int med = len / 2;
            ans = (lst.get(med - 1) + lst.get(med)) / 2.0;
            return ans;
        }
    }
}
