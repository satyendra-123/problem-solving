package com.test.dsa.linkedist;

/**
 * Given a linked list of integers. Find and return the length of the longest palindrome list that exists in that linked list.
 *
 * A palindrome list is a list that reads the same backward and forward.
 *
 * Expected memory complexity : O(1)
 *
 * 1 <= length of the linked list <= 2000
 *
 * 1 <= Node value <= 100
 *
 *  2 -> 1 -> 2 -> 1 ->  2 -> 2 -> 1 -> 3 -> 2 -> 2
 *
 * ans: 5
 */
public class Longest_Palindromic_List {
    public static void main(String[] args) {
        Longest_Palindromic_List lpl = new Longest_Palindromic_List();
        ListNode2 list = lpl.createLinkedList();
        lpl.approach1(list);
    }


    private ListNode2 createLinkedList(){
        ListNode2 head = new ListNode2(2);
        ListNode2 temp = head;
        int [] arr = new int[]{2,1,2,1,2,2,1,3,2};
        int i =1;
        while(i < arr.length){
             ListNode2 n = new ListNode2(arr[i]);
             temp.next = n;
             temp = temp.next;
             i++;
        }
        return head;
    }


    //Brute Force:
    //O(N*N + N)
    //O(N)
    //put the list data into an array and check by going left/right for each index if it forms a palindromic list
    //return maxlength


    /**
     we need to have two pointers

     first keep moving the pointer to check the left / rigth side palindrom

     keep checking left/rigth of current pointer max length. even and odd.

     here to move backward for left need to keep reversing the prev list before current node.

     TC: O(N*N)
     */

    private int approach1(ListNode2 head){

        //iterate over head for each current pointer
        ListNode2 curr = head;
        ListNode2 prev = null;

        ListNode2 temp = null;
        int len1 = 0;
        int len2 = 0;
        int ans = 0;

        while(curr != null){

            //here reverse the head to curr and curr to next part should be extracted
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;

            if(curr == null || prev == null)
                break;
            //check the rev node and c3 node longest palindrom for even/odd size
            len1 = checkPalindrom(prev, curr);
            //check for odd length also;
            if(curr.next != null)
                len2 = checkPalindrom(prev, curr.next)+1;

            ans = Math.max(ans, Math.max(len1, len2));
        }
        return ans;
    }


    private int checkPalindrom(ListNode2 prev, ListNode2 curr){
        int len = 0;
        int count = 0;

        ListNode2 p1 = prev;
        ListNode2 c1 = curr;

        while( p1 != null && c1 != null && p1.val == c1.val){
            p1 = p1.next;
            c1 = c1.next;
            count++;
        }

        if(count > 0)
            return count * 2;
        return 1;
    }
}


/**
 * Definition for singly-linked list.
 *
 */

class ListNode2 {
    public int val;
    public ListNode2 next;
    ListNode2(int x) { val = x; next = null; }
}
