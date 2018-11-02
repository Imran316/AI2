package ttInfo;

import java.util.ArrayList;

/**
 *
 * @author imran
 */
public class Year {
    public int id;
    public String yearName;
    ArrayList<Professor> professors;
    ArrayList<Professor> practicals;
    public boolean isChoosen;
    public String[][] lectures;

    public Year(int id, String yearName, boolean isChoosen, ArrayList<Professor> professors, ArrayList<Professor> practicals) {
        this.id = id;
        this.yearName = yearName;
        this.professors = professors;
        this.practicals=practicals;
        this.isChoosen = isChoosen;
        lectures=new String[5][7];
    }

    public ArrayList<Professor> getPracticals() {
        return this.practicals;
    }

    public void setPracticals(ArrayList<Professor> practicals) {
        this.practicals = practicals;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setYearName(String yearName) {
        this.yearName = yearName;
    }

    public void setProfessors(ArrayList<Professor> professors) {
        this.professors = professors;
    }

    public void setIsChoosen(boolean isChoosen) {
        this.isChoosen = isChoosen;
    }

    public void setLectures(String[][] lectures) {
        this.lectures = lectures;
    }

    public int getId() {
        return id;
    }

    public String getYearName() {
        return yearName;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public boolean isIsChoosen() {
        return isChoosen;
    }

    public String[][] getLectures() {
        return lectures;
    }
    
    public void setTime(int x,int y,String Prof)
    {
        lectures[x][y]=Prof;
    }
    
    public String getTime(int x, int y){
        return lectures[x][y];
    }
}
