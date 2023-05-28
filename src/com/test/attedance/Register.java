package com.test.attedance;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Register  implements Cloneable {

    private String type;

    private String name;

    private List<Attedance> attedances;

    private HashMap<String, List<Attedance>> monthlyRegister;

    Register(String name){
        this.name = name;
        attedances = new ArrayList<>();
    }


    public void preFillRegister(){

    }

    public void markAttedance(Student student){
        Attedance at = new Attedance();
        at.setStatus(AttendanceStatus.PRESENT);
        //at.setStudent(student);
        at.setAttedanceDate(new Date());
        attedances.add(at);
    }

    public List<Attedance> getAttedances(Student student, int month){

      return null;
    }



}
