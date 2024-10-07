package com.LinkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;
            length = 1;
        } else {
            tail.next = newNode;
            tail = newNode;
            length++;
        }
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        Node pre = head;

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }

        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;
            length = 1;
        }

        newNode.next = head;
        head = newNode;
        length++;
    }

    public Node removeFirst() {
        if (length == 0) {
            return null;
        }

        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;

        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);

        if (temp != null) {
            temp.value = value;

            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        Node newNode = new Node(value);
        if (index < 0 || index > length) {
            return false;
        }
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }

        Node temp = get(length - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;

        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == length - 1) {
            return removeLast();
        }

        Node pre = get(index - 1);
        Node temp = pre.next;

        pre.next = temp.next;
        temp.next = null;
        length--;

        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;

        Node before = null;
        Node after = temp.next;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public void reverseHelp (Node current) {
        if(current == null) {
            return;
        }

        reverseHelp(current.next);
        System.out.println(current.value);
    }

    public void reversePrint () {
        reverseHelp(head);
        System.out.println();
    }
}