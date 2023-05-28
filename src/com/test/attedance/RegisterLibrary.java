package com.test.attedance;

import java.util.HashMap;

public class RegisterLibrary {
  HashMap<String, Register> registry = new HashMap<>();

  public void populate(String type, Register register){
      registry.put(type, register);
  }

  public Register getRegister(String type){
    return registry.get(type);
  }
}
