package ttInfo;

import FireData.InitailizeData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author imran
 */
public class Data {
    public int noofFrees;
    public ArrayList<Year> years;
    public ArrayList<Professor> professors;
    public InitailizeData initailizeData;

    ArrayList<Professor> dataSE, dataTE, dataBE, dataSEPrac, dataTEPrac, dataBEPrac;

    public Data()  {
        dataSE =  new ArrayList<>();
        dataTE =  new ArrayList<>();
        dataBE =  new ArrayList<>();
        dataSEPrac =  new ArrayList<>();
        dataTEPrac =  new ArrayList<>();
        dataBEPrac =  new ArrayList<>();
        professors =  new ArrayList<>();


        try {
            initailizeData = new InitailizeData();
            initailizeData.ghyachaData();
            initailizeData.data();
            initailizeData.dataPratical();
            dataSE = initailizeData.getDataSE();
            dataTE = initailizeData.getDataTE();
            dataBE = initailizeData.getDataBE();
            dataSEPrac = initailizeData.getDataSEPractical();
            dataTEPrac = initailizeData.getDataTEPractical();
            dataBEPrac = initailizeData.getDataBEPractical();
            professors = initailizeData.getProfessors();
            noofFrees=75-initailizeData.getNoofFrees();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        initialize();

    }

    public void initialize(){
        Professor professor0 = new Professor(0,"Perira sir", new ArrayList<>(Arrays.asList(0,5,4)),new ArrayList<>(Arrays.asList("","TOC","HPC")), new ArrayList<>(Arrays.asList("","","LP1_Per")), false);//BE
        Professor professor1 = new Professor(1,"Datta chille", new ArrayList<>(Arrays.asList(0,0,3)), new ArrayList<>(Arrays.asList("","","AIR")), new ArrayList<>(Arrays.asList("","","LP1")), false);//BE
        Professor professor2 = new Professor(2,"Deshmukh Mam", new ArrayList<>(Arrays.asList(4,0,3)), new ArrayList<>(Arrays.asList("DSA","","DA")), new ArrayList<>(Arrays.asList("DSAL","","PWS")), false);//BE
        Professor professor3 = new Professor(3,"Deshmukh Sir", new ArrayList<>(Arrays.asList(0,3,3)), new ArrayList<>(Arrays.asList("","ISEE","EL1")), new ArrayList<>(Arrays.asList("","","LP2_DESH")), false);//BE
        Professor professor4 = new Professor(4,"Mate", new ArrayList<>(Arrays.asList(0,0,3)), new ArrayList<>(Arrays.asList("","","EL2")), new ArrayList<>(Arrays.asList("","","LP2")), false);//BE
        //Professor professor5 = new Professor(5,"Lab!",new ArrayList<>(Arrays.asList(5,7,6)), true);//TE


        Professor professor6 = new Professor(6,"Ghumare Sir", new ArrayList<>(Arrays.asList(0,3,0)), new ArrayList<>(Arrays.asList("","SEPM","")), new ArrayList<>(Arrays.asList("","","PWS")), false);//TE
        Professor professor7 = new Professor(7,"Hande sir", new ArrayList<>(Arrays.asList(0,4,0)), new ArrayList<>(Arrays.asList("","CN","")), new ArrayList<>(Arrays.asList("","CNL","")), false);//TE
        Professor professor8 = new Professor(8,"Ghumatkar mam", new ArrayList<>(Arrays.asList(0,3,0)) , new ArrayList<>(Arrays.asList("","DBMS","")), new ArrayList<>(Arrays.asList("","DBMSL","")), false);//TE


        Professor professor9 = new Professor(9,"Agrwal", new ArrayList<>(Arrays.asList(4,0,0)), new ArrayList<>(Arrays.asList("DM","","")), new ArrayList<>(Arrays.asList("DSAL2","SDL","")),false);//se
        Professor professor10 = new Professor(10,"Sandbhor R", new ArrayList<>(Arrays.asList(4,0,0)),new ArrayList<>(Arrays.asList("COA","","")), new ArrayList<>(Arrays.asList("DELD","","")), false);//se
        Professor professor11 = new Professor(11,"Sandbhor AK", new ArrayList<>(Arrays.asList(4,0,0)),new ArrayList<>(Arrays.asList("DELD","","")), new ArrayList<>(Arrays.asList("","","")), false);//se
        Professor professor12 = new Professor(12,"Borade Sir", new ArrayList<>(Arrays.asList(4,0,0)),new ArrayList<>(Arrays.asList("OOP","","")), new ArrayList<>(Arrays.asList("OOPL","","")), false);//se

        //professors = new ArrayList<Professor>(Arrays.asList(professor0,professor1,professor2,professor3,professor4,professor6,
                //professor7,professor8,professor9,professor10,professor11,professor12));

        Year year0 = new Year(0, "SE", false, new ArrayList<>(Arrays.asList(professor9,professor10,professor11,professor12,professor2)),
                new ArrayList<>(Arrays.asList(professor9,professor2,professor12,professor11,professor10)));

        Year year1 = new Year(1, "TE", false, new ArrayList<>(Arrays.asList(professor6,professor7,professor8,professor3,professor0)),
                new ArrayList<>(Arrays.asList(professor6,professor7,professor9,professor8)));

        Year year2 = new Year(2, "BE", false, new ArrayList<>(Arrays.asList(professor0,professor1,professor2,professor3,professor4)),
                new ArrayList<>(Arrays.asList(professor0,professor1,professor3,professor4)));

        /*try {
            initailizeData = new InitailizeData();
            initailizeData.ghyachaData();
            initailizeData.data();
            initailizeData.dataPratical();
        } catch (Exception e) {
            System.out.println(e.toString());
        }*/
        /*System.out.println("\n\nProfessor");
        initailizeData.getProfessors().forEach(m ->{
            System.out.println(m.getProfName()+"  "+m.getSub_lectures().get(0)+"  "+m.getSub_lectures().get(1)+"  "+m.getSub_lectures().get(2)+"        "+
                    m.getPrac_lectures().get(0)+"  "+m.getPrac_lectures().get(1)+"  "+m.getPrac_lectures().get(2)+"  ");
        });*/
        Year year3 = new Year(0, "SE", false, dataSE, dataSEPrac);
        Year year4 = new Year(1, "TE", false, dataTE, dataTEPrac);
        Year year5 = new Year(2, "BE", false, dataBE,dataBEPrac);
        //years = new ArrayList<Year>(Arrays.asList(year0,year1,year2));
        years = new ArrayList<Year>(Arrays.asList(year3,year4,year5));
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public ArrayList<Year> getYears() {
        return years;
    }

    public int getNoofFrees() {
        return noofFrees;
    }
}
