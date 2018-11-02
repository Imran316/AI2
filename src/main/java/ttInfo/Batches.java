package ttInfo;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author imran
 */
public class Batches {
    public int id;
    public String yearName;
    ArrayList<Professor> professors;
    public String[][] lectures;

    public Batches(int id, String yearName, ArrayList<Professor> professors) {
        this.id = id;
        this.yearName = yearName;
        this.professors = professors;
        lectures=new String[5][4];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYearName() {
        return yearName;
    }

    public void setYearName(String yearName) {
        this.yearName = yearName;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(ArrayList<Professor> professors) {
        this.professors = professors;
    }

    public String[][] getLectures() {
        return lectures;
    }

    public void setLectures(String[][] lectures) {
        this.lectures = lectures;
    }
    public void setTime(int x,int y,String Prof)
    {
        lectures[x][y]=Prof;
    }
    
    public String getTime(int x, int y){
        return lectures[x][y];
    }
}
