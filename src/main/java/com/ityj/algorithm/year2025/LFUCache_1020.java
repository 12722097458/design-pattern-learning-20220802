package com.ityj.algorithm.year2025;

import java.util.*;

// todo 超时
class LFUCache_1020 {

    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> nodeMap;
    private Map<Integer, Integer> countMap;

    public LFUCache_1020(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
    }

    public int get(int key) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            int totalCount = countMap.get(key);
            removeNode(node);
            addNodeToFirst(node, totalCount + 1);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        int totalCount = 0;
        if (nodeMap.containsKey(key)) {
            Node existingNode = nodeMap.get(key);
            totalCount = countMap.get(key);
            removeNode(existingNode);
        }
        if (nodeMap.size() >= capacity) {
            // 删除最不经常使用的node
            Node toRemove = findNodeToRemove();
            removeNode(toRemove);
        }
        addNodeToFirst(node, totalCount + 1);
    }

    private Node findNodeToRemove() {
        int maxCount = countMap.values().stream().min(Comparator.naturalOrder()).get();
        List<Node> candidates = new ArrayList<>();
        Node headNode = new Node();
        headNode.next = head;

        while (headNode.next != null) {
            if (countMap.get(headNode.key) != null && countMap.get(headNode.key) ==  maxCount) {
                candidates.add(headNode);
            }
            headNode = headNode.next;
        }
        return candidates.get(candidates.size() - 1);
    }

    public void removeNode(Node node) {
        Node preNode = node.pre;
        Node nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
        nodeMap.remove(node.key);
        countMap.remove(node.key);
    }

    public void addNodeToFirst(Node node, int count) {
        Node firstNode = head.next;
        head.next = node;
        node.pre = head;
        node.next = firstNode;
        firstNode.pre = node;
        nodeMap.put(node.key, node);
        countMap.put(node.key, count);
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
        LFUCache_1020 obj = new LFUCache_1020(2);
        obj.put(1,1);
        obj.put(2,2);
        int i = obj.get(1);
        obj.put(3,3);
        int i1 = obj.get(2);
        int i2 = obj.get(3);
        obj.put(4,4);
        int i3 = obj.get(1);
        int i4 = obj.get(3);
        int i5 = obj.get(4);
        System.out.println("i = " + i);
        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        System.out.println("i3 = " + i3);
        System.out.println("i4 = " + i4);
        System.out.println("i5 = " + i5);
    }

}

