package com.ityj.algorithm.year2025;

import java.util.HashMap;
import java.util.Map;

class LRUCache_0821 {

    class Node {
        private Node next;
        private Node pre;
        private int key;
        private int value;

        public Node() {
            this.pre = null;
            this.next = null;
            this.key = 0;
            this.value = 0;
        }

        public Node(int key, int value) {
            this.pre = null;
            this.next = null;
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache_0821(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.next = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            addNodeToFirst(node);
            return node.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)) {
            Node old = map.get(key);
            removeNode(old);
        }
        while (map.size() >= capacity) {
            Node toRemove = tail.pre;
            removeNode(toRemove);
        }
        addNodeToFirst(node);
    }

    public void addNodeToFirst(Node node) {
        Node first = head.next;
        head.next = node;
        node.pre = head;
        node.next = first;
        first.pre = node;
        map.put(node.key, node);
    }

    public void removeNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = node.next;
        next.pre = pre;
        map.remove(node.key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */