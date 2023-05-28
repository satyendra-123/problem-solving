package com.test.test123;

public class Singleton {

  private static Singleton singleton;
  private Singleton(){

  }

  public static Singleton getInstance(){
    if(singleton != null)
      return singleton;
    synchronized (Singleton.class){
      if(singleton == null)
        singleton = new Singleton();
      return singleton;
    }
  }
}
