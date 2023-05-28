package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1234 {

  public static void main(String[] args){
    //reorder(new int[] {1,2,3,4,5,6}, 2);
    System.out.println(sum(Stream.of("1","2","9","6").collect(Collectors.toList())));
  }

  private static int sum(List<String> list){
    return list.stream().mapToInt(Integer::parseInt).sum();
  }
  private static void reorder(int[] arr, int N){
    int[] res = new int[arr.length];
    Queue<Integer> q = new LinkedList<>();
    int i = 0;
    for(; i<arr.length; i++){
      q.add(arr[i]);
    }

    i = 0;
    for(; i<N; i++){
      int val = q.poll();
      q.add(val);
    }
    i = 0;
    for(; i< arr.length; i++){
      res[i] = q.poll();
    }
    System.out.print(Arrays.toString(res));

  }

}