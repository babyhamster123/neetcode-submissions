class MedianFinder {

    private final PriorityQueue<Integer> maxHeap;
    private final PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // add num to max heap
        maxHeap.offer(num);

        // balance the size between the heaps that size of max heap >= min heap
        balance();
    }
    
    private void balance() {
        if (maxHeap.size() == minHeap.size()) {
            return;
        }

        if (maxHeap.size() == minHeap.size() + 1) {
            if (minHeap.isEmpty()) {
                return;
            } 
            
            if (maxHeap.peek() > minHeap.peek()) {
                swap();
            }
            return;
        }

        if (maxHeap.size() == minHeap.size() + 2) {
            minHeap.offer(maxHeap.poll());
        }
    }

    private void swap() {
        int a = maxHeap.poll();
        int b = minHeap.poll();
        maxHeap.offer(b);
        minHeap.offer(a);
    }
    
    public double findMedian() {
        // sanity check
        int size = maxHeap.size() + minHeap.size();
        if (size == 0) {
            return 0;
        }

        // even
        if (size % 2 == 0) {
            return ((double)(maxHeap.peek()) + minHeap.peek()) / 2;
        }

        // odd
        return (double)maxHeap.peek();
    }
}
