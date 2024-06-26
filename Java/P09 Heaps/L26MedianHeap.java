import java.util.*;

public class L26MedianHeap {
    int size = 0;
    int minHeapSize = 0, maxHeapSize = 0;
    int[] minHeap;
    int[] maxHeap;

    public L26MedianHeap(int x) {
        size = x;
        minHeap = new int[size];
        maxHeap = new int[size];
        Arrays.fill(minHeap, Integer.MAX_VALUE);
        Arrays.fill(maxHeap, Integer.MIN_VALUE);
    }

    public int returnMedian(int x) {
        if (maxHeapSize == 0 || x <= maxHeap[0]) {
            insertMaxHeap(x);
        } else {
            insertMinHeap(x);
        }
        // Rebalance the heaps if necessary
        if (maxHeapSize - minHeapSize > 1) {
            int temp = deleteMaxHeapTop();
            insertMinHeap(temp);
        } else if (minHeapSize > maxHeapSize) {
            int temp = deleteMinHeapTop();
            insertMaxHeap(temp);
        }
        // Calculate median based on the heaps
        if (maxHeapSize == minHeapSize) {
            return (maxHeap[0] + minHeap[0]) / 2;
        } else {
            return maxHeap[0];
        }
    }

    // Insert into max heap
    public void insertMaxHeap(int x) {
        maxHeap[maxHeapSize++] = x;
        heapifyUpMaxHeap(maxHeapSize - 1);
    }

    // Delete top element from max heap
    public int deleteMaxHeapTop() {
        int root = maxHeap[0];
        maxHeap[0] = maxHeap[--maxHeapSize];
        maxHeap[maxHeapSize] = Integer.MIN_VALUE;
        heapifyDownMaxHeap(0);
        return root;
    }

    // Insert into min heap
    public void insertMinHeap(int x) {
        minHeap[minHeapSize++] = x;
        heapifyUpMinHeap(minHeapSize - 1);
    }

    // Delete top element from min heap
    public int deleteMinHeapTop() {
        int root = minHeap[0];
        minHeap[0] = minHeap[--minHeapSize];
        minHeap[minHeapSize] = Integer.MAX_VALUE;
        heapifyDownMinHeap(0);
        return root;
    }

    // Heapify operations for max heap
    public void heapifyUpMaxHeap(int index) {
        while (index > 0 && maxHeap[parent(index)] < maxHeap[index]) {
            swapMaxHeap(index, parent(index));
            index = parent(index);
        }
    }

    public void heapifyDownMaxHeap(int index) {
        int largest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < maxHeapSize && maxHeap[left] > maxHeap[largest]) {
            largest = left;
        }
        if (right < maxHeapSize && maxHeap[right] > maxHeap[largest]) {
            largest = right;
        }
        if (largest != index) {
            swapMaxHeap(index, largest);
            heapifyDownMaxHeap(largest);
        }
    }

    // Heapify operations for min heap
    public void heapifyUpMinHeap(int index) {
        while (index > 0 && minHeap[parent(index)] > minHeap[index]) {
            swapMinHeap(index, parent(index));
            index = parent(index);
        }
    }

    public void heapifyDownMinHeap(int index) {
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < minHeapSize && minHeap[left] < minHeap[smallest]) {
            smallest = left;
        }
        if (right < minHeapSize && minHeap[right] < minHeap[smallest]) {
            smallest = right;
        }
        if (smallest != index) {
            swapMinHeap(index, smallest);
            heapifyDownMinHeap(smallest);
        }
    }

    // Utility methods
    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int leftChild(int i) {
        return 2 * i + 1;
    }

    public int rightChild(int i) {
        return 2 * i + 2;
    }

    public void swapMaxHeap(int i, int j) {
        int temp = maxHeap[i];
        maxHeap[i] = maxHeap[j];
        maxHeap[j] = temp;
    }

    public void swapMinHeap(int i, int j) {
        int temp = minHeap[i];
        minHeap[i] = minHeap[j];
        minHeap[j] = temp;
    }

    public static void main(String[] args) {
        L26MedianHeap mh = new L26MedianHeap(10);
        System.out.println("Median after adding 1: " + mh.returnMedian(1));
        System.out.println("Median after adding 5: " + mh.returnMedian(5));
        System.out.println("Median after adding 2: " + mh.returnMedian(2));
        System.out.println("Median after adding 10: " + mh.returnMedian(10));
        System.out.println("Median after adding 6: " + mh.returnMedian(6));
    }
}
