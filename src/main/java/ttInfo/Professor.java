package ttInfo;


import java.util.ArrayList;

/**
 *
 * @author imran
 */
public class Professor {
    public int id;
    public String profName;
    public int[][] isFree;
    public boolean[][] isBusy;
    public int noPerWeek;
    public boolean isLab;
    public ArrayList<Integer> lectures;
    public ArrayList<String> sub_lectures;
    public ArrayList<String> prac_lectures;
    public String[][] person;

    public Professor(int id, String profName, ArrayList<Integer> lectures,ArrayList<String> sub_lectures,ArrayList<String> prac_lectures, boolean isLab) {
        this.id = id;
        this.profName = profName;
        this.lectures= lectures ;
        this.isLab = isLab;
        this.isBusy=new boolean[5][7];

        this.person = new String[5][7];
        this.sub_lectures=sub_lectures;
        this.prac_lectures=prac_lectures;
        for(int i=0; i<5;i++)
            for(int j=0; j<7;j++){
                this.person[i][j]="--";
                this.isBusy[i][j]=false;
            }
    }


    public void decNoPerWeek(){
        noPerWeek = noPerWeek -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    public int[][] getIsFree() {
        return isFree;
    }

    public void setIsFree(int[][] isFree) {
        this.isFree = isFree;
    }

    public int getNoPerWeek() {
        return noPerWeek;
    }

    public void setNoPerWeek(int noPerWeek) {
        this.noPerWeek = noPerWeek;
    }

    public boolean isIsLab() {
        return isLab;
    }

    public void setIsLab(boolean isLab) {
        this.isLab = isLab;
    }

    public boolean getIsBusy(int x,int y) {
        return isBusy[x][y];
    }

    public void setIsBusy(int x,int y,boolean isBusy) {
        this.isBusy[x][y] = isBusy;
    }

    public ArrayList<Integer> getLectures() {
        return lectures;
    }

    public void setLectures(ArrayList<Integer> lectures) {
        this.lectures = lectures;
    }

    public ArrayList<String> getSub_lectures() {
        return sub_lectures;
    }

    public void setSub_lectures(ArrayList<String> sub_lectures) {
        this.sub_lectures = sub_lectures;
    }

    public ArrayList<String> getPrac_lectures() {
        return prac_lectures;
    }

    public void setPrac_lectures(ArrayList<String> prac_lectures) {
        this.prac_lectures = prac_lectures;
    }

    public String[][] getPerson() {
        return person;
    }

    public void setPerson(String[][] person) {
        this.person = person;
    }

    public String getPersonal(int x, int y){
        return person[x][y];
    }

    public void setPersonal(int x, int y, String personal){
        this.person[x][y] = personal;
    }

}
