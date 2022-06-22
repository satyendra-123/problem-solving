package com.test.dsa.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
      //  System.out.println(Arrays.toString(new int[]{1, 2, 3}));
        System.out.println(countSlots());
        //System.out.println("000".matches("[1-9]+"));
    }

    //find submetrices sum

    //find max submetrices sum

    //prefix sum for matrix

    //find all columsn sum for row = 0 to N-1


    //slot machine question

    private static int countSlots(){
        ArrayList<String> history = new ArrayList<>();
        history.add("137");
        history.add("364");
        history.add("115");
        history.add("724");

        int sum = 0;
        int max = 0;
        int val = 0;
        int t = history.get(0).length()-1;
        while(t >= 0){
            max = 0;
            for(int i=0; i<history.size(); i++){
                //find the max and remove
                String s = history.get(i);
                val = s.charAt(t)-'0';
                max = max < val ? val : max;
            }
            sum += max;
            t--;
        }
        return sum;
    }

    //hard problem
}
