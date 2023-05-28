package com.test.dsa.Arrays;

import java.util.ArrayList;

public class ArrayProblems {
    public static void main(String[] args) {
        ArrayList<Integer> res = flatten(createList(), new ArrayList<Integer>());
        for (Integer i: res)
            System.out.println(i);
    }

    private static ArrayList<Object> createList(){
        ArrayList<Object> res = new ArrayList<>();

        ArrayList<Object> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        //a.add(a);
        ArrayList<Object> b = new ArrayList<>();
        ArrayList<Object> c = new ArrayList<>();

        b.add(a);
        c.add(b);
        c.add(a);
        res.add(a);
        res.add(b);
        res.add(c);
        return res;
    }

    //next greater element
    /**
     * given an unsorted array find next greater element towards its right
     * [2,1,4,3,7]
     * [4,4,7,7,-1]
     *
     * Brute Force
     * for each element need to check its right immediate greater element and add to response.
     * TC: O(N*N)
     * SC: O(1)
     *
     *
     * approach 2
     *  using stack
     *  1) push element to stack
     *  2) if top element in stack is smaller than current element
     * */
    private void approach1(int[] arr){
        int[][] res = new int[arr.length][2];
        int i = 0;

        while(i < arr.length){

            i++;
        }
    }



    private static ArrayList<Integer> flatten(ArrayList<Object> list, ArrayList<Integer> res){
        for(int i =0; i<list.size(); i++){
            if(list.get(i) instanceof Integer) {
                res.add((Integer) list.get(i));
                continue;
            }
             else
                res  = flatten((ArrayList<Object>) list.get(i), res);
        }
        return res;
    }
}
