package com.test.dsa.Arrays;

import java.util.Arrays;

public class Arrays_Prefix_Technique {

    public static void main(String[] args) {
        Arrays_Prefix_Technique aft = new Arrays_Prefix_Technique();
        int speicalIndex = aft.findSpeicalIndex(new int[]{2, 3, 1, 4, 0, -1, 2, -2, 10, 8});
        System.out.println(speicalIndex);
    }

    /**
     *  Given a N size array. find a special index such that removing an element makes
     *  sum of even indices equal to sum of odd indices in the array
     *   0  1  2  3  4   5  6   7  8   9
     *  [2, 3, 1, 4, 0, -1, 2, -2, 10, 8]
     *
     *  Brute Force:
     *  1. iterate over the array.
     *  2. remove ith element and form another array either by shifting or dumping into another array with remaining elements
     *  3. if remaining array has the given sum then return the index.
     *
     *  TC: O(N* (N+N)) ~ O(N*N)
     *  SC: O(N*N) if we are creating new array for each element removal
     *
     *  approach 1:
     *
     *  build two prefix sum array
     *  pfxe
     *  pfxo
     *
     *  now if we remove an element we can say that all the elements present at the left to the index will remain at its position.
     *  only the elements which are at right of the index will be shifted (odd to even or even to odd index)
     *
     *  after removing ith element
     *  even-sum
     *  (pfxe) sum(0,i) + sum(i+1,n-1) (pfxo)
     *
     *  odd sum
     *  (pfxo) sum(0,i) + sum(i+1,n-1) (pfxe)
     *
     *  if both sum are equal then its the ith index
     */
    private int findSpeicalIndex(int[] arr){
        int idx = -1;
        int[] pfxe = pfxEven(arr);
        int[] pfxo = pfxOdd(arr);
        System.out.println(Arrays.toString(pfxe));
        System.out.println(Arrays.toString(pfxo));
        int sume = 0;
        int sumo = 0;
        for(int i =0; i<arr.length; i++){
            sume = 0;
            sumo = 0;
            if( i == 0 ){
                sume += pfxo[arr.length-1] - pfxo[i];
                sumo += pfxe[arr.length-1] - pfxe[i];
            }else if( i == arr.length-1){
                sume += pfxo[i-1];
                sumo += pfxe[i-1];
            }else{
                sumo = pfxo[i-1]+pfxe[arr.length-1] - pfxe[i];
                sume = pfxe[i-1]+pfxo[arr.length-1] - pfxo[i];
            }

            if(sume == sumo)
                return idx;
        }

        return idx;
    }

    private int[] pfxEven(int[] arr) {
        int[] pfxe = new int[arr.length];
        pfxe[0] = arr[0];
        for (int i = 1; i < arr.length; i++){
            if ((i & 1) == 0)
                pfxe[i] = pfxe[i-2] + arr[i];
            else
                pfxe[i] = pfxe[i-1];
        }
        return pfxe;
    }

    private int[] pfxOdd(int[] arr){
        int[] pfxo = new int[arr.length];
        pfxo[0] = 0;
        pfxo[1] = arr[1];
        for (int i = 2; i < arr.length; i++){
            if ((i & 1) != 0)
                pfxo[i] = pfxo[i-2] + arr[i];
            else
                pfxo[i] = pfxo[i-1];
        }
        return pfxo;
    }



}
