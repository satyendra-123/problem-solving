package com.test.dsa;


import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User implements Cloneable, Serializable {
    private String name;
    User(String name){
        this();
        this.name = name;
    }

    private User(){

    }

    private Employee emp;

    @Override
    public int hashCode() {
        return 1;
    }

    public User getInstance(String name){
        return new User(name);
    }

    //NO Equal overriding will cause duplicate entries for user in a map

    public String getName(){
        return name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();//shallow copy
    }
}

class Employee extends User{

    Employee(){
        this(1);
    }

    Employee(int i){
        //compile err in case parent default constructor is not visible uncomment below line to fix
        super("t");
    }

    //custom exceptional Employee object to not serialize when is serializable btw it can be used when custom serialization
    //this method is executed by jvm when writeObject() by oos
    private void writeObject(ObjectOutputStream oos)throws Exception {
        throw new NotSerializableException();
    }

    private void readObject(ObjectInputStream ois)throws Exception {
        throw new NotSerializableException();
    }

}