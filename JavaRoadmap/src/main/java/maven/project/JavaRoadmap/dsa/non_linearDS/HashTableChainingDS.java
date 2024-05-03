package maven.project.JavaRoadmap.dsa.non_linearDS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class HashTableChainingDS {
    private List<List<DataItem>> hashTable;
    private int size;

    public HashTableChainingDS(int size) {
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
            return (int)data / size;
        }
    }

    public void insert(int data) {
        DataItem newItem = new DataItem(data);
        int index = newItem.key;
        hashTable.get(index).add(newItem);
    }


    public void sort() {
        for (int i = 0; i < hashTable.size(); i++) {
            List<DataItem> bucket = hashTable.get(i);
            Collections.sort(bucket, (a, b) -> Integer.compare(a.data, b.data));
        }
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
    	HashTableChainingDS hashTable = new HashTableChainingDS(10);
        hashTable.insert(10);
        hashTable.insert(25);
        hashTable.insert(15);
        hashTable.insert(35);
        hashTable.insert(45);
        hashTable.insert(26);
        hashTable.insert(14);
        hashTable.insert(23);
        hashTable.insert(28);
        

        System.out.println("Searching for 25: " + hashTable.search(25));
        System.out.println("Searching for 30: " + hashTable.search(30));

        System.out.println("Deleting 25: " + hashTable.delete(25));
        System.out.println("Searching for 25: " + hashTable.search(25));

        hashTable.sort();
        System.out.println("Sorted Hash Table:");
       hashTable.printHashTable();
    }
}
