package com.test.dsa.collection;



public class LinkedListTester {
    static int i=0;

    public static void main(String[] args) {
        Node root = createLinkedList();
       // testPrintKthElementFromEnd(root, 4);
        //duplicateRemoveFromLinkedList();
        findMiddleElement(root, root);
    }

    private void testReverse(){
    }

    private static Node createLinkedList(){
        Node root = null;
        for(int i=1; i<=5; i++){
            Node ptr = null;
            if(root == null){
                root = new Node(i);
                continue;
            }
            ptr = root;
            while(ptr.next != null){
                ptr = ptr.next;
            }
            ptr.next = new Node(i);
        }
        return root;
    }

    private static void testPrintKthElementFromEnd(Node root, int k){
        int length = 0;
        Node temp = root;
        while(temp != null){
            temp =  temp.next;
            length++;
        }
/*        int begin = length - k;
        int count = 1;
        while(count < begin){
            count++;
           root=  root.next;
        }
        System.out.print(root.getData());*/

        printKthElement(root, k);
    }
    private static void printKthElement(Node root, int n){
        if(root == null){
            return;
        }

        printKthElement(root.next, n);
        if(++i == n){
                //in stack frame last calculated item printed if non tail recursive
             //reverse order print
                System.out.println(root.getData());
        }

    }


    //Detect cycle in a linked list
    /**
     * HashMap is one way to do this but we need to the elements from array which forms cycle
     * 
     */
    private void detectCycleInLinkedList(){

    }

    //
    //1->2->3->4->5->null
    private static void findMiddleElement(Node r1, Node r2){
        Node a = r1.next;
        Node b = r2.next.next;
        if (b != null || b.next != null){
            findMiddleElement(a, b);
        }else{
            System.out.print(a);
            return;
        }
    }

    //remove duplicates from linked list //sorted //including element itself
    private static void duplicateRemoveFromLinkedList(){
          Node root = new Node(1);
          root.next = new Node(2);
          root.next.next = new Node(3);
          root.next.next.next = new Node(3);
          root.next.next.next.next = new Node(4);
          root.next.next.next.next.next = new Node(4);
          root.next.next.next.next.next.next = new Node(5);

           while(root != null){
               Node c = root;
               if(root.next == null){
                   System.out.print(c.getData());
                   break;
               }
             Node n = root.next;
               while(n!= null && c.getData() == n.getData()){
                   n = n.next;
                   c.next = n;
               }
               System.out.print(c.getData());
               root = n;
           }

    }

}
