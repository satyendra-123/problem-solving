package com.test.dsa.collection;

public class Node {
    private int data;
    public Node(int data){
        this.data = data;
    }

    public Node next;

    public int getData(){
        return data;
    }
}
