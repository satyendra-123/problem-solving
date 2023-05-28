package com.test.test123.HotelBooking;

public class Room implements Cloneable{

  public Room(){

  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    Room r = new Room();
    return r;
  }
}
