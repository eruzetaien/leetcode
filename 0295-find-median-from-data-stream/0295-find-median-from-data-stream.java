class MedianFinder {
    private PriorityQueue<Integer> smallMaxHeap;
    private PriorityQueue<Integer> largeMinHeap;

    public MedianFinder() {
        smallMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        largeMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (smallMaxHeap.isEmpty() || num <= smallMaxHeap.peek()) {
            smallMaxHeap.offer(num);
        } else {
            largeMinHeap.offer(num);
        }

        if (smallMaxHeap.size() > largeMinHeap.size() + 1) {
            largeMinHeap.offer(smallMaxHeap.poll());
        } else if (largeMinHeap.size() > smallMaxHeap.size()) {
            smallMaxHeap.offer(largeMinHeap.poll());
        }
    }
    
    public double findMedian() {
        if (smallMaxHeap.size() == largeMinHeap.size()) {
            return (smallMaxHeap.peek() + largeMinHeap.peek()) / 2.0;
        } else {
            return smallMaxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */