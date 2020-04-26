package Leetcode_Bytedance.No_146_LRU_Cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));  // returns 1
        cache.put(3, 3);  // evicts key 2
        System.out.println(cache.get(2));  // returns -1 (not found)
        cache.put(4, 4);  // evicts key 1
        System.out.println(cache.get(1));  // returns -1 (not found)
        System.out.println(cache.get(3));  // returns 3
        System.out.println(cache.get(4));  // returns 4
    }
    HashMap<Integer,Integer> hashMap;
    int capacity;
    Queue<Integer> queue;
    public LRUCache(int capacity) {
        queue = new LinkedList();
        hashMap = new HashMap();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (hashMap.containsKey(key)){
            queue.remove(key);
            queue.offer(key);
            return hashMap.get(key);
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (queue.size()<capacity){
            if (hashMap.containsKey(key)){
                queue.remove(key);
            }
            hashMap.put(key,value);
            queue.offer(key);
        }else {
            if (!hashMap.containsKey(key)){
                int num = queue.poll();
                hashMap.remove(num);
            }else {
                queue.remove(key);
            }
            queue.offer(key);
            hashMap.put(key,value);
        }
    }
}
