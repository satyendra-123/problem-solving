package com.test.attedance;

import java.util.Date;

public class Attedance {
    private Date attedanceDate;

    //private Student student;

    private AttendanceStatus status;

    public void setStatus(AttendanceStatus status) {
        this.status = status;
    }

    public void setAttedanceDate(Date attedanceDate) {
        this.attedanceDate = attedanceDate;
    }

//    public void setStudent(Student student) {
//        this.student = student;
//    }
}
