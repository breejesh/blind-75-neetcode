class MedianFinder {
    private PriorityQueue<Integer> firstHalf = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> secondHalf = new PriorityQueue<>();
    private boolean even = true;

    public double findMedian() {
        if (even) {
            return (firstHalf.peek() + secondHalf.peek()) / 2.0;
        } else {
            return secondHalf.peek();
        }
    }

    public void addNum(int num) {
        if (!even) {
            secondHalf.offer(num);
            firstHalf.offer(secondHalf.poll());
        } else {
            firstHalf.offer(num);
            secondHalf.offer(firstHalf.poll());
        }
        even = !even;
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
