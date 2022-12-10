package com.test.dsa.stack;

public class Min_Stack {

    //Brute Force

    // int default_size = 10000000;

    // int[] arr = new int[default_size+1];
    // int idx = -1;
    // int min = Integer.MAX_VALUE;

    // //we need to copy the array also into another array if size increases

    // public void push(int x) {
    //     if(idx == arr.length-1){
    //         //alreday at last index
    //         //copy into a double size array
    //         arr = copy(arr);
    //     }
    //     idx++;
    //     arr[idx] = x;
    //     min = min > x ? x : min;
    // }

    // public void pop() {
    //     if(idx >=0)
    //         idx--;
    //     //we need to update min by finding it
    //     min = Integer.MAX_VALUE;
    //     for(int i =0; i<=idx; i++)
    //         min = min > arr[i] ? arr[i] : min;
    // }

    // public int top() {
    //     if(idx >= 0)
    //         return arr[idx];
    //     return idx;
    // }

    // public int getMin() {
    //     if(min == Integer.MAX_VALUE)
    //         return -1;
    //     return min;
    // }

    // private int[] copy(int[] s){
    //     int[] arr = new int[default_size+s.length];
    //     for(int i =0; i<s.length; i++){
    //         arr[i] = s[i];
    //     }
    //     return arr;
    // }

    //alternative is to. use an object

    int default_size = 10000000;

    Pair[] arr = new Pair[default_size + 1];
    int idx = -1;

    public void push(int x) {
        if (idx == arr.length - 1) {
            //alreday at last index
            //copy into a double size array
            arr = copy(arr);
        }
        int min = arr[idx].min_so_far;
        min = min > x ? x : min;
        idx++;
        arr[idx] = new Pair(x, min);
    }

    public void pop() {
        if (idx >= 0)
            idx--;
    }

    public int top() {
        if (idx >= 0)
            return arr[idx].val;
        return idx;
    }

    public int getMin() {
        return arr[idx].min_so_far;
    }

    private Pair[] copy(Pair[] s) {
        Pair[] arr = new Pair[default_size + s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = s[i];
        }
        return arr;
    }

    static class Pair {
        int val = 0;
        int min_so_far = -1;

        Pair(int val, int min_so_far) {
            this.val = val;
            this.min_so_far = min_so_far;
        }
    }

}
