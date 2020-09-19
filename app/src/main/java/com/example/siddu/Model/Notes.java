package com.example.siddu.Model;

public class Notes {
    private  String pid,date,time,notetitle,note,image;
    private Notes(){

    }
    public Notes( String pid, String date, String time, String note, String notetitle,String image) {

this.image=image;
        this.pid = pid;
        this.date = date;
        this.note=note;
        this.notetitle=notetitle;
        this.time = time;
    }
    public String getImage()
    {

        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPid()
    {

        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNote()
    {

        return note;
    }

    public void setNote(String note) {
        this.note= note;
    }
    public String getNotetitle()
    {

        return notetitle;
    }

    public void setNotetitle(String notetitle) {
        this.notetitle = notetitle;
    }


}
