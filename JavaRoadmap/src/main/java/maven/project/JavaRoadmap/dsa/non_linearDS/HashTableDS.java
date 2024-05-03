package maven.project.JavaRoadmap.dsa.non_linearDS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTableDS {
    private List<List<DataItem>> hashTable;
    private int size;

    public HashTableDS(int size) {
        this.size = size;
        hashTable = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            hashTable.add(new LinkedList<>());
        }
    }

    class DataItem {
        private int data;
        private int key;

        public DataItem(int data) {
            this.data = data;
            key = hash(data);
        }

        private int hash(int data) {
            return data % size;
        }
    }

    public void insert(int data) {
        DataItem newItem = new DataItem(data);
        int index = newItem.key;
        List<DataItem> bucket = hashTable.get(index);
        if (!bucket.isEmpty()) {
            // If the bucket is not empty, find the next available slot
            while (!bucket.isEmpty() && bucket.get(0).data != newItem.data) {
                index = (index + 1) % size; // Move to the next slot
                bucket = hashTable.get(index);
            }
        }
        hashTable.get(index).add(newItem);
    }

    public boolean search(int data) {
        int key = data % size;
        List<DataItem> bucket = hashTable.get(key);
        for (int i = 0; i < bucket.size(); i++) {
            DataItem item = bucket.get(i);
            if (item.data == data) {
                return true;
            }
        }
        return false;
    }

    public boolean delete(int data) {
        int key = data % size;
        List<DataItem> bucket = hashTable.get(key);
        for (int i = 0; i < bucket.size(); i++) {
            DataItem item = bucket.get(i);
            if (item.data == data) {
                bucket.remove(i);
                return true;
            }
        }
        return false;
    }

    public void printHashTable() {
        for (int i = 0; i < hashTable.size(); i++) {
            List<DataItem> bucket = hashTable.get(i);
            System.out.print("Bucket " + i + ": ");
            for (DataItem item : bucket) {
                System.out.print(item.data + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashTableDS hashTable = new HashTableDS(10);
        hashTable.insert(10);
        hashTable.insert(25);
        hashTable.insert(15);
        hashTable.insert(35);
        hashTable.insert(45);
        hashTable.insert(206);
        hashTable.insert(154);
        hashTable.insert(23);
        hashTable.insert(28);
        

        System.out.println("Searching for 28: " + hashTable.search(28));
        System.out.println("Searching for 30: " + hashTable.search(30));

        System.out.println("Deleting 25: " + hashTable.delete(25));
        System.out.println("Searching for 25: " + hashTable.search(25));

        System.out.println("Hash Table:");
       hashTable.printHashTable();
    }
}
