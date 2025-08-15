package com.ityj.algorithm.year2025;

import java.util.HashMap;
import java.util.Map;

class LRUCache0815 {

    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;
    private int size;

    public LRUCache0815(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
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
        Node curr = new Node(key, value);
        if (map.containsKey(key)) {
            removeNode(map.get(key));
            map.remove(key);
            size--;
        }
        while (true) {
            if (size < capacity) {
                break;
            }
            Node last = tail.pre;
            removeNode(last);
            map.remove(last.key);
            size--;
        }
        addNodeToHead(curr);
        map.put(key, curr);
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
        head.next = node;
        node.pre = head;
        node.next = tmp;
        tmp.pre = node;
    }

    class Node {
        private Node pre;
        private Node next;
        private int key;
        private int value;

        public Node() {
            this.value = 0;
            this.key = 0;
            this.next = null;
            this.pre = null;
        }

        public Node(int key, int value) {
            this.value = value;
            this.key = key;
            this.next = null;
            this.pre = null;
        }
    }


    public static void main(String[] args) {
        LRUCache0815 cache = new LRUCache0815(2);
        cache.put(2, 1);
        cache.put(2, 2);
        int i = cache.get(2);
        cache.put(1, 1);
        cache.put(4, 1);
        int i2 = cache.get(2);
        System.out.println("i5 = " + i);
        System.out.println("i5 = " + i2);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */