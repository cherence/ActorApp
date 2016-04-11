package com.example.cher.actorapp;

/**
 * Created by adao1 on 4/11/2016.
 */
public class Actor {
    private String name;
    private String dob;
    private String oscars;

    public Actor(String name, String dob, String oscars) {
        this.name = name;
        this.dob = dob;
        this.oscars = oscars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getOscars() {
        return oscars;
    }

    public void setOscars(String oscars) {
        this.oscars = oscars;
    }
}
