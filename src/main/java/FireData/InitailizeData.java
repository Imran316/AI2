package FireData;

import ttInfo.Professor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class InitailizeData {

    int noofFrees;
    ArrayList<ProfessorInfo> professorInfoAll;
    ArrayList<SubjectInfo> professorInfoSE;
    ArrayList<SubjectInfo> professorInfoTE;
    ArrayList<SubjectInfo> professorInfoBE;

    ArrayList<Professor> dataSE;
    ArrayList<Professor> dataTE;
    ArrayList<Professor> dataBE;

    ArrayList<Professor> dataSEPractical;
    ArrayList<Professor> dataTEPractical;
    ArrayList<Professor> dataBEPractical;

    ArrayList<Professor> dataSEBatches;
    ArrayList<Professor> dataTEBatches;
    ArrayList<Professor> dataBEBatches;

    Firedata firedata;
    ArrayList<Integer> noPerWeek;
    ArrayList<Professor> professors;

    ArrayList<String> subLecture, praLecture;
    Professor prof;

    public InitailizeData() {
        try {
            firedata = new Firedata();
            professorInfoAll = firedata.retriveProfessor();
            professorInfoSE = firedata.retriveSE_SUBJECT();
            professorInfoTE = firedata.retriveTE_SUBJECT();
            professorInfoBE = firedata.retriveBE_SUBJECT();

        } catch (Exception e) {
            e.printStackTrace();
        }


        dataSE = new ArrayList<>();
        dataTE = new ArrayList<>();
        dataBE = new ArrayList<>();
        dataSEPractical = new ArrayList<>();
        dataTEPractical = new ArrayList<>();
        dataBEPractical = new ArrayList<>();

        dataSEBatches = new ArrayList<>();
        dataTEBatches = new ArrayList<>();
        dataBEBatches = new ArrayList<>();


        subLecture = new ArrayList<>();
        praLecture = new ArrayList<>();

        subLecture.add("");
        subLecture.add("");
        subLecture.add("");

        praLecture.add("");
        praLecture.add("");
        praLecture.add("");

        professors = new ArrayList<>();
        noPerWeek = new ArrayList<>();
        noPerWeek.add(0);
        noPerWeek.add(0);
        noPerWeek.add(0);

        noofFrees =0;

    }

    public void ghyachaData(){
        professorInfoAll.forEach(professorInfo -> {
            noPerWeek = new ArrayList<>();
            noPerWeek.add(0);
            noPerWeek.add(0);
            noPerWeek.add(0);

            subLecture = new ArrayList<>();
            praLecture = new ArrayList<>();

            subLecture.add("");
            subLecture.add("");
            subLecture.add("");

            praLecture.add("");
            praLecture.add("");
            praLecture.add("");

            professorInfoSE.forEach(professorInfoSE ->{

                    if(!professorInfoSE.isLab()) {
                        if (professorInfo.getProfName().equals(professorInfoSE.getProfessorName())) {
                            int x = professorInfoSE.getNoPerWeek();
                            noPerWeek.set(0, x);
                            noofFrees = noofFrees +x;
                            String subject = professorInfoSE.getSubjectName();
                            subLecture.set(0, subject);
                        }
                    }

                    if(professorInfoSE.isLab()){
                        if (professorInfo.getProfName().equals(professorInfoSE.getProfessorName())){
                            String practical = professorInfoSE.getSubjectName();
                            praLecture.set(0, practical);
                        }
                    }

            });

            professorInfoTE.forEach(professorInfoTE ->{
                if(!professorInfoTE.isLab()) {
                    if (professorInfo.getProfName().equals(professorInfoTE.getProfessorName())){
                        int x = professorInfoTE.getNoPerWeek();
                        noPerWeek.set(1, x);
                        noofFrees = noofFrees +x;
                        String subject = professorInfoTE.getSubjectName();
                        subLecture.set(1, subject);
                    }
                }
                if(professorInfoTE.isLab()){
                    if (professorInfo.getProfName().equals(professorInfoTE.getProfessorName())){
                        String practical = professorInfoTE.getSubjectName();
                        praLecture.set(1, practical);
                    }
                }
            });

            professorInfoBE.forEach(professorInfoBE ->{
                if(!professorInfoBE.isLab()) {
                    if (professorInfo.getProfName().equals(professorInfoBE.getProfessorName())) {
                        int x = professorInfoBE.getNoPerWeek();
                        noPerWeek.set(2, x);
                        noofFrees = noofFrees +x;
                        String subject = professorInfoBE.getSubjectName();
                        subLecture.set(2, subject);
                    }
                }
                if(professorInfoBE.isLab()){
                    if (professorInfo.getProfName().equals(professorInfoBE.getProfessorName())){
                        String practical = professorInfoBE.getSubjectName();
                        praLecture.set(2, practical);
                    }
                }
            });
            professors.add(new Professor(Integer.parseInt(professorInfo.getId()), professorInfo.getProfName(), noPerWeek,subLecture, praLecture, false));

        });
    }

    public void data (){

        professors.forEach(m->{
            if(m.getLectures().get(0)!=0){
                dataSE.add(m);
            }
            if(m.getLectures().get(1)!=0){
                dataTE.add(m);
            }
            if(m.getLectures().get(2)!=0){
                dataBE.add(m);
            }
        });
    }

    public void dataPratical(){
        professors.forEach(professorInfo->{
            professorInfoSE.forEach(professorInfoSE->{
                if(professorInfoSE.isLab()) {
                    if (professorInfo.getProfName().equals(professorInfoSE.getProfessorName())) {
                        dataSEPractical.add(professorInfo);
                    }
                }
            });

            professorInfoTE.forEach(professorInfoTE ->{
                if(professorInfoTE.isLab()) {
                    if (professorInfo.getProfName().equals(professorInfoTE.getProfessorName())){
                        dataTEPractical.add(professorInfo);
                    }
                }
            });

            professorInfoBE.forEach(professorInfoBE ->{
                if(professorInfoBE.isLab()) {
                    if (professorInfo.getProfName().equals(professorInfoBE.getProfessorName())) {
                        dataBEPractical.add(professorInfo);
                    }
                }
            });
        });
    }

    public void retrivePraticalSubject(){
        professorInfoSE.forEach(m->{
            if(m.isLab()){
                dataSEBatches.add(new Professor(0,m.getSubjectName(),new ArrayList<>(Arrays.asList(0,5,4)),new ArrayList<>(Arrays.asList("","TOC","HPC")), new ArrayList<>(Arrays.asList("","","LP1_Per")), false));
            }
        });
        professorInfoTE.forEach(m->{
            if(m.isLab()){
                dataTEBatches.add(new Professor(0,m.getSubjectName(),new ArrayList<>(Arrays.asList(0,5,4)),new ArrayList<>(Arrays.asList("","TOC","HPC")), new ArrayList<>(Arrays.asList("","","LP1_Per")), false));
            }
        });
        professorInfoBE.forEach(m->{
            if(m.isLab()){
                dataBEBatches.add(new Professor(0,m.getSubjectName(),new ArrayList<>(Arrays.asList(0,5,4)),new ArrayList<>(Arrays.asList("","TOC","HPC")), new ArrayList<>(Arrays.asList("","","LP1_Per")), false));
            }
        });
    }



    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        InitailizeData initailizeData = new InitailizeData();
        initailizeData.ghyachaData();
        initailizeData.data();
        initailizeData.retrivePraticalSubject();
        initailizeData.getProfessors().forEach(m->{
            //System.out.println(m.getProfName()+"   " + m.getLectures().get(0)+"   " + m.getLectures().get(1)+"   " + m.getLectures().get(2));

        });
        System.out.println("\n\nSE");
        initailizeData.getDataSE().forEach(m->{
            System.out.println(m.getProfName()+"   " + m.getLectures().get(0)+"   " + m.getLectures().get(1)+"   " + m.getLectures().get(2));
        });
        System.out.println("\n\nTE");
        initailizeData.getDataTE().forEach(m->{
            System.out.println(m.getProfName()+"   " + m.getLectures().get(0)+"   " + m.getLectures().get(1)+"   " + m.getLectures().get(2));

        });
        System.out.println("\n\nBE");
        initailizeData.getDataBE().forEach(m->{
            System.out.println(m.getProfName()+"   " + m.getLectures().get(0)+"   " + m.getLectures().get(1)+"   " + m.getLectures().get(2));

        });

        initailizeData.dataPratical();
        initailizeData.getProfessors().forEach(m->{
            //System.out.println(m.getProfName()+"   " + m.getLectures().get(0)+"   " + m.getLectures().get(1)+"   " + m.getLectures().get(2));

        });
        System.out.println("\n\nSE Practical");
        initailizeData.getDataSEPractical().forEach(m->{
            System.out.println(m.getProfName()+"   " + m.getLectures().get(0)+"   " + m.getLectures().get(1)+"   " + m.getLectures().get(2));

        });
        System.out.println("\n\nTE Practical");
        initailizeData.getDataTEPractical().forEach(m->{
            System.out.println(m.getProfName()+"   " + m.getLectures().get(0)+"   " + m.getLectures().get(1)+"   " + m.getLectures().get(2));

        });
        System.out.println("\n\nBE Practical");
        initailizeData.getDataBEPractical().forEach(m->{
            System.out.println(m.getProfName()+"   " + m.getLectures().get(0)+"   " + m.getLectures().get(1)+"   " + m.getLectures().get(2));

        });

        System.out.println("\n\nProfessor");
        initailizeData.getProfessors().forEach(m ->{
            System.out.println(m.getProfName()+"  "+m.getSub_lectures().get(0)+"  "+m.getSub_lectures().get(1)+"  "+m.getSub_lectures().get(2)+"        "+
                    m.getPrac_lectures().get(0)+"  "+m.getPrac_lectures().get(1)+"  "+m.getPrac_lectures().get(2)+"  "+
                    m.getPrac_lectures());
        });

        System.out.println("\n\nno of frees\t"+initailizeData.getNoofFrees());

        System.out.println("\n\nSE BATCHES");
        initailizeData.getDataSEBatches().forEach(m->{
            System.out.println(m.getProfName());
        });

        System.out.println("\n\nTE BATCHES");
        initailizeData.getDataTEBatches().forEach(m->{
            System.out.println(m.getProfName());
        });

        System.out.println("\n\nBE BATCHES");
        initailizeData.getDataBEBatches().forEach(m->{
            System.out.println(m.getProfName());
        });

    }

    public ArrayList<ProfessorInfo> getProfessorInfoAll() {
        return professorInfoAll;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public ArrayList<Professor> getDataSE() {
        return dataSE;
    }

    public ArrayList<Professor> getDataTE() {
        return dataTE;
    }

    public ArrayList<Professor> getDataBE() {
        return dataBE;
    }

    public ArrayList<Professor> getDataSEPractical() {
        return dataSEPractical;
    }

    public ArrayList<Professor> getDataTEPractical() {
        return dataTEPractical;
    }

    public ArrayList<Professor> getDataBEPractical() {
        return dataBEPractical;
    }

    public ArrayList<Professor> getDataSEBatches() {
        return dataSEBatches;
    }

    public ArrayList<Professor> getDataTEBatches() {
        return dataTEBatches;
    }

    public ArrayList<Professor> getDataBEBatches() {
        return dataBEBatches;
    }

    public int getNoofFrees() {
        return noofFrees;
    }
}
