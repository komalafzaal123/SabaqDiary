package com.example.sabaq;

public class SabaqDiary {
    private int id;
    private String StudentName;
    private String SabaqPara;
    private String SabaqStatus;
    private String SabaqiiPara;
    private String SabaqiiStatus;
    private String ManzilPara;
    private String ManzilStatus;
    private String Date;

    public SabaqDiary(String studentName, String sabaqPara, String sabaqStatus, String sabaqiiPara, String sabaqiiStatus, String manzilPara, String manzilStatus, String date) {
        StudentName = studentName;
        SabaqPara = sabaqPara;
        SabaqStatus = sabaqStatus;
        SabaqiiPara = sabaqiiPara;
        SabaqiiStatus = sabaqiiStatus;
        ManzilPara = manzilPara;
        ManzilStatus = manzilStatus;
        Date = date;
    }

    public SabaqDiary(int id, String studentName, String sabaqPara, String sabaqStatus, String sabaqiiPara, String sabaqiiStatus, String manzilPara, String manzilStatus, String date) {
        this.id = id;
        StudentName = studentName;
        SabaqPara = sabaqPara;
        SabaqStatus = sabaqStatus;
        SabaqiiPara = sabaqiiPara;
        SabaqiiStatus = sabaqiiStatus;
        ManzilPara = manzilPara;
        ManzilStatus = manzilStatus;
        Date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getSabaqPara() {
        return SabaqPara;
    }

    public void setSabaqPara(String sabaqPara) {
        SabaqPara = sabaqPara;
    }

    public String getSabaqStatus() {
        return SabaqStatus;
    }

    public void setSabaqStatus(String sabaqStatus) {
        SabaqStatus = sabaqStatus;
    }

    public String getSabaqiiPara() {
        return SabaqiiPara;
    }

    public void setSabaqiiPara(String sabaqiiPara) {
        SabaqiiPara = sabaqiiPara;
    }

    public String getSabaqiiStatus() {
        return SabaqiiStatus;
    }

    public void setSabaqiiStatus(String sabaqiiStatus) {
        SabaqiiStatus = sabaqiiStatus;
    }

    public String getManzilPara() {
        return ManzilPara;
    }

    public void setManzilPara(String manzilPara) {
        ManzilPara = manzilPara;
    }

    public String getManzilStatus() {
        return ManzilStatus;
    }

    public void setManzilStatus(String manzilStatus) {
        ManzilStatus = manzilStatus;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
