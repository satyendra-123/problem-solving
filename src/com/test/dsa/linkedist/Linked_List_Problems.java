package com.test.dsa.linkedist;

public class Linked_List_Problems {
    public static void main(String[] args) {
        Linked_List_Problems llp = new Linked_List_Problems();
        //llp.reverseLinkedList();
        llp.reverseFirstK();
    }

    //reverse a linked list
    /**
     *
     */
    private void reverseLinkedList(){
      Node<Integer> head =  createLinkedList();
      printLinkedList(head);
      Node curr = head;
      Node temp = null;
      Node last = null;
      while(curr != null){
          temp = curr.next;
          curr.next = last;
          last = curr;
          curr = temp;
      }
      head = last;
      System.out.println(" after reverse ");
      printLinkedList(head);
    }

    //reverse first k elements in linked list
    /**
     * 1->2->3->4->5->6
     * k = 3
     * 3->2->1->4->5->6
     *
     * approach1
     *
     * @return
     */

    private Node reverseFirstK(){
        Node head = createLinkedList();
        int k = 3;
        int k1 = k;
        System.out.println(" Before k "+k1+" elements reversal ");
        printLinkedList(head);
        Node last = null;
        Node curr = head;
        while(k > 0){
            Node temp = curr.next;
            curr.next = last;
            last = curr;
            curr = temp;
            k--;
        }
        head.next = curr;

        System.out.println("\n After k "+k1+" element reverse at front ");
        printLinkedList(last);
        return head;
    }


    /**
     * reverse k groups in linked list
     * @return
     */



    //create a linked list
    private Node createLinkedList(){
        Node<Integer> head = new Node<>(1, null);
        Node<Integer> curr = head;
        int count = 1;
        for(int i =1; i<5; i++){
            Node temp =  new Node<>(++count, null);
            curr.next = temp;
            curr = curr.next;
        }
        return head;
    }

    //print linekd list
    private void printLinkedList(Node<Integer> head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val);
            if(temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
    }



}


