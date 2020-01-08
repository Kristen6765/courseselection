package com.hs.timetable.business.student.entity;

/**
 * @program: courseselection
 * @description: student entity
 * @author: Savilio
 * @create: 2019-08-23 13:50
 **/


public class Student {
    private int id;
    private String FirstName;
    private String LastName;
    private String email;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmmail() {
        return email;
    }

    public void setEmmail(String emmail) {
        this.email = emmail;
    }

}
