package com.test.dsa.linkedist;

import java.util.HashMap;
import java.util.List;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
 * The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.
 *
 * Definition of "least recently used" : An access to an item is defined as a get or a set operation of the item. "Least recently used" item is the one with the oldest access time.
 *
 * Input :
 *          capacity = 2
 *          set(1, 10)
 *          set(5, 12)
 *          get(5)        returns 12
 *          get(1)        returns 10
 *          get(10)       returns -1
 *          set(6, 14)    this pushes out key = 5 as LRU is full.
 *          get(5)        returns -1
 *
 *
 */
public class LRU_Cache {
    public static void main(String[] args) {
        LRU lru = new LRU(4);

        //if encounter s look for two numbers else look for a single number if G
        //String inp = "S 2 1 S 1 10 S 8 13 G 12 S 2 8 G 11 G 7 S 14 7 S 12 9 S 7 10 G 11 S 9 3 S 14 15 G 15 G 9 S 4 13 G 3 S 13 7 G 2 S 5 9 G 6 G 13 S 4 5 S 3 2 S 4 12 G 13 G 7 S 9 7 G 3 G 6 G 2 S 8 4 S 8 9 S 1 4 S 2 9 S 8 8 G 13 G 3 G 13 G 6 S 3 8 G 14 G 4 S 5 6 S 10 15 G 12 S 13 5 S 10 9 S 3 12 S 14 15 G 4 S 10 5 G 5 G 15 S 7 6 G 1 S 5 12 S 1 6 S 11 8";
        String inp = "S 5 13 S 9 6 S 4 1 G 4 S 6 1 S 8 11 G 13 G 1 S 12 12 G 10 S 15 13 S 2 13 S 7 5 S 10 3 G 6 G 10 S 15 14 S 5 12 G 5 G 7 G 15 G 5 G 6 G 10 S 7 13 G 14 S 8 9 G 4 S 6 11 G 9 S 6 12 G 3";
        String[] inpAr = inp.split(" ");
        int i =0;
        while(i < inpAr.length){
            if(inpAr[i].equals("S") && i < inpAr.length-1){
                lru.set(Integer.parseInt(inpAr[i+1]), Integer.parseInt(inpAr[i+2]));
                i +=2;
            }else if(inpAr[i].equals("G")){
                System.out.print(lru.get(Integer.parseInt(inpAr[i+1])));
                System.out.print(" ");
                i += 1;
            }
            i++;
        }
    }
}


class LRU {

    int capacity = 0;
    HashMap<Integer, ListNode> map = new HashMap<>();
    ListNode head = null;

    public LRU(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            //it is a cache hit hence its been accessed recently should be moved to mru.
            ListNode tn = map.get(key);
            remove(tn);
            addAtMRU(key, tn.val);
            //printList();
            return tn.val;
        }

        return -1;
    }

    /**
     1. if key is already present
     get the existing key Node.
     traverse backward remove the Node.
     create a new node. insert at the current pointer. update the prev pointer for it.
     update node in map.
     2. else
     if map size == capacity
     remove the present at last Node. remove from map.
     add a new node at head (MRU) update the prev pointer. insert key and new node in map
     else
     just add the new node at head. move the head pointer. update the prev node.
     insert new node in the map.
     */
    public void set(int key, int value) {

        if(map.containsKey(key)){
            //System.out.print(capacity+ " "+map.size()+ " key "+key);
            // System.out.print("map containsKey "+key);
            //printMap();
            ListNode tn = map.get(key);

            //System.out.print("remove "+tn.val);

            remove(tn);
            addAtMRU(key, value);

            // System.out.println("after remove /add ");
            // printMap();
        }else{
            if(map.size() == capacity){
                //the new node need to placed at MRU but before need to remove the node present at LRU.
                ///System.out.println("capacity is reached" +capacity+ " "+map.size());
                ListNode temp = head;
                while(temp.next != null)
                    temp = temp.next;

                // System.out.print(" before removing "+temp.val);
                //System.out.print("remove "+temp.val);
                remove(temp);
                addAtMRU(key, value);

                //printMap();
            }else{

                addAtMRU(key, value);

                //    System.out.print(" put at MRU NEW entry");
                //    printMap();
            }

        }
        //printList();

        //
    }

    private void remove(ListNode curr){
        ListNode t1N = curr.prev;
        if(t1N == null) {
            //curr next has any nodes
            ListNode cn = curr.next;
            //we need to make cn as new head
            if(cn != null)
                cn.prev = null;
            //this is head you want to remove.
            head = cn;
            //update this new head in map too ?
            if(head !=  null)
                map.put(head.id, head);
        }
        else {
            t1N.next = t1N.next.next;
            ListNode t2N = t1N.next;
            if(t2N != null)
                //it is not at head;
                t2N.prev = t1N;
        }
        map.remove(curr.id);
    }

    private void printMap(){
        for(Integer key: map.keySet()){
            System.out.println(" id "+map.get(key).id+" key "+key+" "+map.get(key).val);
        }
        System.out.println("---"+map.size());
    }

    private void printList(){
        ListNode t = head;
        while(t!=null){
            System.out.print( " id "+ t.id+ " val "+t.val+" -> ");
            t = t.next;
        }
        System.out.println();
    }

    private void addAtMRU(int key, int value){
        //insert node at MRU
        ListNode n = new ListNode(key, value, null, head);
        if( null != head)
            head.prev = n;
        head = n;
        //make map aware about new node
        map.put(key, head);
    }


    static class ListNode{
        int id;
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int id, int val){
            this.id = id;
            this.val = val;
        }

        ListNode(int id, int val, ListNode prev, ListNode next){
            this.id = id;
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

}



