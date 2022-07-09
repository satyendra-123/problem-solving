package com.test;



// 1-> 2->3-4>

public class Test {
    public static void main(String[] args) {
        LinkedList list =  new LinkedList();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        //list.getHead();
        System.out.println(list.find(2));

        System.out.println(list.find(6));

    }
}


class LinkedList{

    Node head;
    Node tail;
    int size;

    public Node getHead(){
        return head;
    }

    public Node getTail(){
        return tail;
    }

    public void add(int el){
           if(head == null || tail == null){
               Node n = new Node(el);
               head = n;
               tail = head;
               return;
           }
           Node n = new Node(el);
           tail.next = n;
           tail = n;
           size++;
    }

    public boolean find(int element){
        Node temp = head;
        while(temp != null){
            if( element == temp.val){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

}

class Node{
    int val;
    Node next;
    Node(int val){
        this.val= val;
    }
}
