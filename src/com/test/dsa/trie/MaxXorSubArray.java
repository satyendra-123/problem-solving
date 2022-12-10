package com.test.dsa.trie;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Problem Description
 *
 * Given an array, A of integers of size N. Find the subarray AL, AL+1, AL+2, ... AR with 1<=L<=R<=N, which has maximum XOR value.
 *
 * NOTE: If there are multiple subarrays with the same maximum value, return the subarray with minimum length. If the length is the same, return the subarray with the minimum starting index.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 100000
 * 0 <= A[i] <= 10^9
 *  A = [1, 4, 3]
 *  ans = [2, 3]
 */
public class MaxXorSubArray {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        return approach1(A);
    }

    //Brute Force
    /*
        all subarray
        O(N*N*N)
         subarray: n*(n+1)/2
        for each subarray we get its max xor value if xor is maximizing update start/end index
        and if its same for another start/end index then the current length is smaller then choose the new start /end index
        keep doing until we find the max xor subarray with min start index
    */

    /**
     A = [1, 4, 3]
     pfx = [1, 5, 6]
     1  2  3

     xor[l,r] = pfx[r]^pfx[l-1]
     we need to find the max xor value for xor[l,r]

     to get max xor value we need to push the pfx values in a trie in bits format

     building trie:
     [1, 5, 6]

     iterate over the pfx array
     for each number
     as msb will be max number in pfx and the set bit position
     run a loop till the max set bit position and keep checking the ith bit if its set bit or unset bit
     and put the entry in root. move the root and keep moving
     reset the root for each number.

     to get the max initally ans is 0.
     for each value of pfx array we check in trie if it can get any max answer by finding the opposite bits possible. if opposite bit is not present
     we continue with same bit. this number we can update in answer if its greater than answer.
     for this we can calculate each bit and convert to decimal

     now we have got the max xor.

     ans = pfx[r]^pfx[l-1]
     ans^pfx[r] = pfx[l-1]

     first we iterate over prefix array and keep xoring with answer if the result key is not present in map
     push the prefix enty with its index in map
     else
     get the index. this index is L-1 hence l = 1+index
     now update minL, minR and minLength variables.

     the answer can be true if the ans^(such a value which can result) 0

     return the minL, minR
     */

    private ArrayList<Integer> approach1(ArrayList<Integer> A){
        int[] pfx = pfxXor(A);
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        int maxBitLen = maxBitLen(A);
        int maxor = 0;
        int b = 0;
        int val = 0;
        int curxor = 0;

        //populate trie with 0
        int i = 0;
        TrieNode root = new TrieNode();
        TrieNode temp = root;
        while(i < maxBitLen){
            temp.node[0] = new TrieNode();
            temp = temp.node[0];
            i++;
        }

        for(i=0; i<pfx.length; i++){
            //need to put into trie upto max length bits
            temp = root;
            val = pfx[i];
            int k = maxBitLen-1;
            curxor = 0;
            while(k >= 0){
                b = checkSetBit(val, k);
                if(temp.node[b^1] != null){
                    //the root has opposite bit for current bit mean it would be added to answer.
                    curxor = curxor + (1 << k);
                    temp = temp.node[b^1];
                }else{
                    temp = temp.node[b];
                }
                k--;
            }
            //insert the current value into trie
            maxor = maxor < curxor ? curxor : maxor;
            temp = root;
            insert(temp, val, maxBitLen);
        }
        //System.out.print(maxor);

        //ans = pfx[r]^pfx[l-1]
        //ans^pfx[r] = pfx[l-1]
        int curr = 0;
        int minL = Integer.MAX_VALUE;
        int minR = Integer.MAX_VALUE;
        int minLen = Integer.MAX_VALUE;
        map.put(0, -1);
        int l = 0;
        int len = 0;
        for(i=0; i<pfx.length; i++){
            curr = maxor^pfx[i];
            if(map.containsKey(curr)){
                l = map.get(curr)+1;
                len = (i - l)+1;
                if(minLen > len){
                    minLen = len;
                    minL = l;
                    minR = i;
                }
                else if (minLen == len && minL > l){
                    minL = l;
                    minR = i;
                }
            }else
                map.put(pfx[i], i);
        }
        res.add(minL+1);
        res.add(minR+1);
        return res;
    }

    //insert msb to lsb
    private void insert(TrieNode temp, int val, int maxBitLen){
        int i = maxBitLen-1;
        int b = 0;
        while(i>=0){
            b = checkSetBit(val, i);
            if(temp.node[b] == null)
                temp.node[b] = new TrieNode();
            temp = temp.node[b];
            i--;
        }
    }

    private int checkSetBit(int val, int idx){
        if( (val & (1 << idx)) == 0)
            return 0;
        return 1;
    }

    //

    private int maxBitLen(ArrayList<Integer> A){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<A.size(); i++)
            max = max < A.get(i) ? A.get(i) : max;

        int cnt = 0;
        while(max > 0){
            max >>= 1;
            cnt++;
        }
        return cnt;
    }

    private int[] pfxXor(ArrayList<Integer> A){
        int[] pfx = new int[A.size()];
        pfx[0] = A.get(0);
        for(int i=1; i<A.size(); i++)
            pfx[i] = pfx[i-1]^A.get(i);
        return pfx;
    }

    static class TrieNode{
        TrieNode [] node;
        TrieNode(){
            node = new TrieNode[2];
        }
    }

}
