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
