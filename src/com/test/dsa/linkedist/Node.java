package com.test.dsa.linkedist;

public class Node<T> {
    T val;
    Node next;
    Node tail;
    Node(T val, Node next){
        this.val  = val;
        this.next = next;
    }
}
