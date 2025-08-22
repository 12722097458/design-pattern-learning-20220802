package com.ityj.algorithm.year2025;

import java.util.HashMap;
import java.util.Map;

class LRUCache_0822 {

    private Map<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache_0822(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        this.map = new HashMap<>();
        this.head.next = this.tail;
        this.tail.pre = this.head;
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
            Node toRemove = map.get(key);
            removeNode(toRemove);
        }
        while (true) {
            if (map.size() < capacity) {
                break;
            }
            Node preTail = tail.pre;
            removeNode(preTail);
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
        Node preNode = node.pre;
        Node nextNode = node.next;

        preNode.next = nextNode;
        nextNode.pre = preNode;
        map.remove(node.key);
    }


    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */