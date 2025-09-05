package com.ityj.algorithm.year2025;

import java.util.HashMap;
import java.util.Map;

class LRUCache_0905 {

    class Node {
        int key;
        int val;
        Node pre;
        Node next;
        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.pre = null;
            this.next = null;
        }
    }

    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;


    public LRUCache_0905(int capacity) {
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
            addNodeToFirst(node);
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)) {
            Node oldNode = map.get(key);
            removeNode(oldNode);
        }
        while (true) {
            if (map.size() >= capacity ) {
                Node toRemove = tail.pre;
                removeNode(toRemove);
            } else {
                break;
            }
        }
        addNodeToFirst(node);
    }

    public void addNodeToFirst(Node node) {
        Node firstNode = head.next;
        head.next = node;
        node.pre = head;
        node.next = firstNode;
        firstNode.pre = node;
        map.put(node.key, node);
    }

    public void removeNode(Node node) {
        if (map.containsKey(node.key)) {
            Node preNode = node.pre;
            Node nextNode = node.next;
            preNode.next = nextNode;
            nextNode.pre = preNode;
            map.remove(node.key);
        } else {
            System.out.println(node + " is not exist!");
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */