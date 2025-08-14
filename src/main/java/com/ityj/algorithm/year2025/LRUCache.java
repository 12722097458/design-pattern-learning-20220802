package com.ityj.algorithm.year2025;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int value;
    Node pre;
    Node next;
    public Node() {
        this.key = 0;
        this.value = 0;
        pre = null;
        next = null;
    }
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        pre = null;
        next = null;
    }
}

class LRUCache {
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    int capacity;
    int size;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        map = new HashMap<>();
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            addNodeToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            map.remove(key);
            size--;
        }
        if (size == capacity) {
            Node toRemove = tail.pre;
            removeNode(toRemove);
            map.remove(toRemove.key);
            size--;
        }
        Node node = new Node(key, value);
        addNodeToHead(node);
        map.put(key, node);
        size++;
    }

    public void removeNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    public void addNodeToHead(Node node) {
        Node tmp = head.next;
        node.pre = head;
        head.next = node;
        node.next = tmp;
        tmp.pre = node;
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        int i = cache.get(1);
        cache.put(3, 3);
        int i2 = cache.get(2);
        cache.put(4, 4);
        int i3 = cache.get(1);
        int i4 = cache.get(3);
        int i5 = cache.get(4);
        System.out.println("i5 = " + i);
        System.out.println("i5 = " + i2);
        System.out.println("i5 = " + i3);
        System.out.println("i5 = " + i4);
        System.out.println("i5 = " + i5);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */