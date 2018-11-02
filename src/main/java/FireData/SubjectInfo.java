package FireData;

public class SubjectInfo {
    String subjectName;
    String professorName;
    int noPerWeek;
    boolean isLab;

    public SubjectInfo() {
    }

    public SubjectInfo(String subjectName, String professorName, int noPerWeek, boolean isLab) {
        this.subjectName = subjectName;
        this.professorName = professorName;
        this.noPerWeek = noPerWeek;
        this.isLab = isLab;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public int getNoPerWeek() {
        return noPerWeek;
    }

    public void setNoPerWeek(int noPerWeek) {
        this.noPerWeek = noPerWeek;
    }

    public boolean isLab() {
        return isLab;
    }

    public void setLab(boolean lab) {
        isLab = lab;
    }
}
