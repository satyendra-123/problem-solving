package com.test.dsa.Arrays;

import java.util.Arrays;

public class Arrays_Carray_Forward {

    public static void main(String[] args) {
        Arrays_Carray_Forward acf = new Arrays_Carray_Forward();
        acf.turnOnBulbs(new int[]{1, 0, 1, 0, 1, 0, 0 });
    }

    /**
     * given n size array
     * find a subarray which has max and min both elemeents in it.
     * [1, 2, 3, 1, 4, 5, 6, 2, 3, 6]
     */
    private int findSubArrayWithMinAndMax(){

        return 0;
    }


    /**
     * Amazon
     * given n bulbs
     * all bulbs are connected through a faulty wire
     * on pressing ith switch it toggles all the switches to its right
     * 1, 0, 1, 0, 1
     *
     * find min press required to turn all the bulbs on
     *
     * Brute Force:
     * for ith switch toggle the right side bulbs if bulb is not on (a[i] == 0) in the array and at last check if all the bulbs has become on
     *
     */
    private void turnOnBulbs(int[] arr){
        //Brute Force
        int i = 0;
        int j = 0;
        int count = 0;

        int[] arr2 = Arrays.copyOf(arr, arr.length);

        while(i<arr.length){
            j = i;
            if(arr[i] == 0) {
                while (j < arr.length) {
                    arr[j] = arr[j] == 1 ? 0 : 1;
                    j++;
                }
                count++;
                System.out.println(Arrays.toString(arr));
            }
            i++;
        }
        System.out.println(count);
        System.out.println(approach1(arr2));
    }

    private int approach1(int[] arr){
        int i = 0;
        int count = 0;
        for(; i<arr.length; i++){
            if(arr[i] == 0 && (count & 1) == 0){
                count++;
            }else if(arr[i] == 1 && (count & 1) == 1){
                count++;
            }
        }
        return  count;
    }

}
