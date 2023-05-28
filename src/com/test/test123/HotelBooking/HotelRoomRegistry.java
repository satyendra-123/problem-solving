package com.test.test123.HotelBooking;

import java.util.HashMap;

public class HotelRoomRegistry {
  private HashMap<String, Room> hm = new HashMap<>();

  public void populate(String name, Room room){
      hm.put(name, room);
  }

  public HashMap<String, Room> getRegistry(){
    return hm;
  }
}
