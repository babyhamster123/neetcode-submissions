// There will always be at least k integers in the stream when you search for the kth integer.
class KthLargest {
    
    private int k;
    private PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        // sanity check
        if (k < 1 || nums == null) {
            throw new IllegalArgumentException();
        }

        List<Integer> values = new ArrayList<>();
        for (int num : nums) {
            values.add(num);
        }

        this.k = k;
        this.pq = new PriorityQueue<>(values);
        while (pq.size() > k) {
            pq.poll();
        }
    }
    
    // return the kth largest element after adding val
    // return is a peek withou removing the added values 
    // There will always be at least k integers in the stream when you search for the kth integer.
    public int add(int val) {
        pq.offer(val);
        while (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
