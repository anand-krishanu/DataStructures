package com.Stack;

public class Stack {
    private Node top;
    int height;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public boolean isEmpty() {
        return height == 0;
    }

    public void push(int value) {
        Node newNode = new Node(value);

        if (height == 0) {
            top = newNode;
            height = 1;
        } else {
            newNode.next = top;
            top = newNode;
            height++;
        }
    }

    public Node pop() {
        Node temp = top;

        if (height == 0) {
            return null;
        }

        top = top.next;
        temp.next = null;

        height--;
        return temp;
    }

    public Integer peek () {
        if (height == 0) {
            return null;
        }
        else {
            return top.value;
        }
    }
}