package com.test.test123;

public abstract class SumNumber {
  public abstract void sum(Object a, Object b);
}

class IntSum extends SumNumber{

  public void sum(Object a, Object b){
      if(a instanceof Integer && b instanceof Integer)
        System.out.println( (Integer)a + (Integer) b);
      else
        throw new RuntimeException("");
  }
}
