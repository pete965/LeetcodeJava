package Leetcode.ByteDance.No_146_LRU_Cache;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    public static void main(String[] args){
        LRUCache lruCache=new LRUCache(2);
        lruCache.put(1,1);
        System.out.println(lruCache.queue);
        lruCache.put(2,2);
        System.out.println(lruCache.queue);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.queue);
        lruCache.put(3,3);
        System.out.println(lruCache.queue);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.queue);
        lruCache.put(4,4);
        System.out.println(lruCache.queue);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(4));
    }
    Deque<Integer> queue;
    HashMap hashMap;
    int capacity;
    public LRUCache(int cap){
        queue = new LinkedList<>();
        hashMap= new HashMap();
        capacity=cap;
    }
    public int get(int key){
        if (hashMap.containsKey(key)){
            if (!(queue.getLast()==key)){
                queue.remove(key);
                queue.add(key);
            }
            return Integer.parseInt(hashMap.get(key).toString());
        }else{
            return -1;
        }
    }
    public void put(int key, int value){
        if (hashMap.containsKey(key)){
            hashMap.put(key,value);
            if (!(queue.getLast()==key)){
                queue.remove(key);
                queue.add(key);
            }
        }else{
            hashMap.put(key,value);
            if (queue.size()==capacity){
                hashMap.remove(queue.getFirst());
                queue.removeFirst();
                queue.add(key);
            }else{
                queue.add(key);
                hashMap.put(key,value);
            }
        }
    }
}
