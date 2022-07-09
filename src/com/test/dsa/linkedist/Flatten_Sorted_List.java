package com.test.dsa.linkedist;


/**
 * Given a linked list where every node represents a linked list and contains two pointers of its type:
 *
 * Pointer to next node in the main list (right pointer)
 * Pointer to a linked list where this node is head (down pointer). All linked lists are sorted.
 * You are asked to flatten the linked list into a single list. Use down pointer to link nodes of the flattened list. The flattened linked list should also be sorted.
 * 1 <= Total nodes in the list <= 100000
 *
 * 1 <= Value of node <= 10^9
 *
 *    3 -> 4 -> 20 -> 20 ->30
 *    |    |    |     |    |
 *    7    11   22    20   31
 *    |               |    |
 *    7               28   39
 *    |               |
 *    8               39
 */
public class Flatten_Sorted_List {
    public static void main(String[] args) {
        Flatten_Sorted_List fsl = new Flatten_Sorted_List();
    }

    ListNode flatten(ListNode root) {
        return approach2(root);
    }


    /**
     if we see the list it looks like this
     (we just rotated it right side)

     3->7->7->8
     |
     4->11
     |
     20->22
     |
     20->20->28->39
     |
     30->31->39

     now idea is to just iterate recursively or iteratively on next pointer (which can be seen as downwards)

     and just merge current list with next list (two sorted list merge) O(N+M)

     keep doing it for all N nodes in the main list.

     TC: (N* (N * N)) N^3

     */

    /**

     another way to look at this.

     we can keep splitting this list as in two parts. just like we do in merge sort. we keep on breaking the linked list until we have only one node
     here also we split by mid pointer.

     find the mid pointer by using slow/fast: O(N)

     the call same function to split it .

     now we have the sorted heads of two lists.
     merge them together.

     TC: O( N*N*logN + O(N))

     SC: O(N*N) ?? not sure
     */

    private ListNode approach2(ListNode head){
        //Base Case
        //if head is null or head next is null it is just a single node
        if(head == null || head.right == null)
            return head;
        //Assume the function gets head of a list and whatever lists are associated to it it merges them and returns the head which is sorted

        //divide the list
        ListNode mid = getMid(head);
        ListNode h2 = mid.right;
        mid.right = null;

        head = approach2(head);
        h2 = approach2(h2);

        //print(head);
        //print(h2);

        ListNode res  = mergetSortedList(head, h2);

        //print(res);

        return res;
    }


    private void print(ListNode head){
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.val+ " ->  ");
            curr = curr.down;
        }
        System.out.println();
    }


    private ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.right != null && fast.right.right != null){
            slow = slow.right;
            fast = fast.right.right;
        }
        return slow;
    }

    private ListNode mergetSortedList(ListNode s1, ListNode s2){

        ListNode l1 = s1;
        ListNode l2 = s2;

        ListNode res = null;
        ListNode curr = null;

        ListNode t = null;

        if(s1 == null && s2 != null){
            t = s2.down;
            res = s2;
            curr = res;
            updateSortedListResponse(curr, t);
            return res;
        }
        if(s2 == null && s1 != null){
            t = s1.down;
            res = s1;
            curr = res;
            updateSortedListResponse(curr, t);
            return res;
        }

        if(l1.val <= l2.val){
            res = l1;
            l1 = l1.down;
        }
        else{
            res = l2;
            l2 = l2.down;
        }
        curr = res;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                curr.down = l1;
                l1 = l1.down;
            }
            else{
                curr.down = l2;
                l2 = l2.down;
            }
            curr = curr.down;
        }

        if(l1 == null && l2 != null)
            updateSortedListResponse(curr, l2);

        else if(l2 == null && l1 != null)
            updateSortedListResponse(curr, l1);

        return res;
    }

    private void updateSortedListResponse(ListNode curr, ListNode l2){
        while( l2 != null){
            curr.down = l2;
            l2 = l2.down;
            curr = curr.down;
        }
    }



}


class ListNode {
    int val;
    ListNode right, down;
    ListNode(int x) {
        val = x;
        right = down = null;
    }
}




