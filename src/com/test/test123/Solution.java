package com.test.test123;

public class Solution {
  public static void main(String[] args) {
//    SumNumber sumNumber = new IntSum();
//    sumNumber.sum(1, 2);

    Singleton s1 = Singleton.getInstance();
    Singleton s2 = Singleton.getInstance();
    System.out.println(System.identityHashCode(s1));
    System.out.println(System.identityHashCode(s2));

  }

}
