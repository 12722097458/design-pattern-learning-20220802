package com.ityj.algorithm.year2025;

import java.util.HashMap;
import java.util.Map;

class LRUCache_1020 {

    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public LRUCache_1020(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
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
            removeNode(map.get(key));
        }
        if (map.size() >= capacity) {
            removeNode(tail.pre);
        }
        addNodeToFirst(node);
    }

    public void removeNode(Node node) {
        Node preNode = node.pre;
        Node nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
        map.remove(node.key);
    }

    public void addNodeToFirst(Node node) {
        Node firstNode = head.next;
        head.next = node;
        node.pre = head;
        node.next = firstNode;
        firstNode.pre = node;
        map.put(node.key, node);
    }



    class Node {
        int key;
        int value;
        Node next;
        Node pre;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {
         LRUCache_1020 obj = new LRUCache_1020(2);
        obj.put(2,1);
        obj.put(2,2);
        obj.get(2);
    }
}

