package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class MyHashSetV1 {

    static final int DEFAULT_INITIAL_CAPACITY = 16;

    LinkedList<Integer>[] buckets;

    // private int[] elementData = new int[10];
    private int size = 0;
    private int capacity = DEFAULT_INITIAL_CAPACITY;

    public MyHashSetV1(){
        initBuckets();
    }

    public MyHashSetV1(int capacity){
        this.capacity = capacity;
        initBuckets();
    }

    private void initBuckets(){
        buckets = new LinkedList[capacity];
        for (int i =0; i<capacity; i++){
            buckets[i] = new LinkedList<>();
        }
    }


    // O(n)
    public boolean add(int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];
        if (contains(value)) {
            return false;
        }

        bucket.add(value);
        // elementData[size] = value;
        size++;
        return true;
    }

    // O(n)
    public boolean contains(int searchValue) {
        int hashIndex = hashIndex(searchValue);
        LinkedList<Integer> bucket = buckets[hashIndex];
        return bucket.contains(searchValue);

        /**for (int data : elementData) {
            if (data == value) {
                return true;
            }
        }
        return false;
         **/
    }

    public boolean remove(int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];
        boolean result = bucket.remove(Integer.valueOf(value));
        if (result) {
            size--;
            return true;
        } else {
            return false;
        }
    }

    private int hashIndex(int value) {
        return value % capacity;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "MyHashSetV1{" +
                "buckets=" + Arrays.toString(buckets) +
                ", size=" + size +
                '}';
    }
}
