package com.example.fitsets.ui.model;

import java.util.ArrayList;

public class BodyTrack {
    String partname, size,time,dte;


    public BodyTrack(ArrayList<BodyTrack> partnam) {
    }

    //Constrctor
    public BodyTrack(String partname, String size, String time, String dte) {
        this.partname=partname;
        this.size=size;
        this.time=time;
        this.dte=dte;
    }

    //Getter and Setter

    public String getPartname() {
        return partname;
    }

    public void setPartname(String partname) {
        this.partname = partname;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDte() {
        return dte;
    }

    public void setDte(String dte) {
        this.dte = dte;
    }
}
