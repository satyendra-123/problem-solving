package com.test.core.java;

public class PolyMorphism {

  //method overloadin
  public static void main(String[] args) {
    new PolyMorphism().test(null);
  }

  private void test(Object o){
    System.out.println("object");
  }

  private void test(double[] d){
    System.out.println("double");
  }
}
