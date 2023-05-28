package com.test;

import java.util.HashMap;

/***
 * Integer input[] = new Integer[]{2,4,6,3,0};
 *
 * output=6
 *
 */
public class Test2345 {
  public static void main(String[] args) {
    twosum(new int[]{2,-4,6,3,0}, 6);
  }

  private static void twosum(int[] arr, int k){
    HashMap<Integer, Integer> map = new HashMap<>();
    //int[] res = new int[2];

    for (int i = 0; i < arr.length; i++) {
      if( map.containsKey(k-arr[i])){
        System.out.println(" "+map.get(k-arr[i])+" "+i);
        break;
      }
      map.put(arr[i], i);
    }

  }


}
