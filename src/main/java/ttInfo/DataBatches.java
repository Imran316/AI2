package ttInfo;


import FireData.InitailizeData;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author imran
 */
public class DataBatches {
    public ArrayList<Batches> batches;
    public ArrayList<Professor> professors;
    public InitailizeData initailizeData;
    ArrayList<Professor> dataSE, dataTE, dataBE;
    
    public DataBatches() {
        dataSE =  new ArrayList<>();
        dataTE =  new ArrayList<>();
        dataBE =  new ArrayList<>();

        try {
            initailizeData = new InitailizeData();
            initailizeData.ghyachaData();
            initailizeData.data();
            initailizeData.dataPratical();
            initailizeData.retrivePraticalSubject();
            dataSE = initailizeData.getDataSEBatches();
            dataTE = initailizeData.getDataTEBatches();
            dataBE = initailizeData.getDataBEBatches();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        initialize();
    }
    
    public void initialize(){
        Professor professor0 = new Professor(0,"LP1B", new ArrayList<>(Arrays.asList(0,5,4)),new ArrayList<>(Arrays.asList("","TOC","HPC")), new ArrayList<>(Arrays.asList("","","LP1_Per")), false);//BE
        Professor professor1 = new Professor(1,"LP2B", new ArrayList<>(Arrays.asList(0,5,4)),new ArrayList<>(Arrays.asList("","TOC","HPC")), new ArrayList<>(Arrays.asList("","","LP1_Per")), false);//BE
        Professor professor2 = new Professor(2,"LP1A", new ArrayList<>(Arrays.asList(0,5,4)),new ArrayList<>(Arrays.asList("","TOC","HPC")), new ArrayList<>(Arrays.asList("","","LP1_Per")), false);//BE
        Professor professor3 = new Professor(3,"LP2A", new ArrayList<>(Arrays.asList(0,5,4)),new ArrayList<>(Arrays.asList("","TOC","HPC")), new ArrayList<>(Arrays.asList("","","LP1_Per")), false);//BE
        Professor professor4 = new Professor(3,"PWS", new ArrayList<>(Arrays.asList(0,5,4)),new ArrayList<>(Arrays.asList("","TOC","HPC")), new ArrayList<>(Arrays.asList("","","LP1_Per")), false);//BE


        Professor professor5 = new Professor(5,"CNL",  new ArrayList<>(Arrays.asList(0,5,4)),new ArrayList<>(Arrays.asList("","TOC","HPC")), new ArrayList<>(Arrays.asList("","","LP1_Per")), false);//TE
        Professor professor6 = new Professor(6,"DBMSL1",  new ArrayList<>(Arrays.asList(0,5,4)),new ArrayList<>(Arrays.asList("","TOC","HPC")), new ArrayList<>(Arrays.asList("","","LP1_Per")), false);//TE
        Professor professor7 = new Professor(7,"DBMSL2",  new ArrayList<>(Arrays.asList(0,5,4)), new ArrayList<>(Arrays.asList("","TOC","HPC")), new ArrayList<>(Arrays.asList("","","LP1_Per")),false);//TE
        Professor professor8 = new Professor(8,"SDL1",  new ArrayList<>(Arrays.asList(0,5,4)),new ArrayList<>(Arrays.asList("","TOC","HPC")), new ArrayList<>(Arrays.asList("","","LP1_Per")), false);//TE
        Professor professor9 = new Professor(8,"SDL2",  new ArrayList<>(Arrays.asList(0,5,4)),new ArrayList<>(Arrays.asList("","TOC","HPC")), new ArrayList<>(Arrays.asList("","","LP1_Per")), false);//TE

        Professor professor10 = new Professor(10,"DELDL",  new ArrayList<>(Arrays.asList(0,5,4)),new ArrayList<>(Arrays.asList("","TOC","HPC")), new ArrayList<>(Arrays.asList("","","LP1_Per")), false);//SE
        Professor professor11 = new Professor(11,"DSAL1",  new ArrayList<>(Arrays.asList(0,5,4)),new ArrayList<>(Arrays.asList("","TOC","HPC")), new ArrayList<>(Arrays.asList("","","LP1_Per")), false);//se
        Professor professor12 = new Professor(12,"DSAL2",  new ArrayList<>(Arrays.asList(0,5,4)),new ArrayList<>(Arrays.asList("","TOC","HPC")), new ArrayList<>(Arrays.asList("","","LP1_Per")), false);//se
        Professor professor13 = new Professor(13,"SSL",  new ArrayList<>(Arrays.asList(0,5,4)),new ArrayList<>(Arrays.asList("","TOC","HPC")), new ArrayList<>(Arrays.asList("","","LP1_Per")), false);//se
        Professor professor14 = new Professor(13,"OOPL1",  new ArrayList<>(Arrays.asList(0,5,4)),new ArrayList<>(Arrays.asList("","TOC","HPC")), new ArrayList<>(Arrays.asList("","","LP1_Per")), false);//se

        Batches batches0 = new Batches(0, "SE",  new ArrayList<>(Arrays.asList(professor10,professor11,professor12,professor13,professor14)));
        Batches batches1 = new Batches(1, "TE", new ArrayList<>(Arrays.asList(professor5,professor6,professor7,professor8,professor9)));
        Batches batches2 = new Batches(2, "BE", new ArrayList<>(Arrays.asList(professor0,professor1,professor2,professor3,professor4)));

        Batches batches3 = new Batches(0, "SE",  dataSE);
        Batches batches4 = new Batches(1, "TE", dataTE);
        Batches batches5 = new Batches(2, "BE", dataBE);

        //batches = new ArrayList<>(Arrays.asList(batches0,batches1,batches2));
        batches = new ArrayList<>(Arrays.asList(batches3,batches4,batches5));
    }

    public ArrayList<Batches> getBatches() {
        return batches;
    }
    
}
