package ttInfo;

import java.util.ArrayList;

/**
 *
 * @author imran
 */
public class Timetable {

    Data data;

    public Timetable(){

        int i, j, k;
        int x, z;
        int fitnessFactor = 0;

            do {
                fitnessFactor = 0;

                data = new Data();

                ArrayList<Integer> random = new ArrayList<Integer>();

            /* do{
            x = (int)(Math.random()*3);
            data.getYears().get(x).setIsChoosen(true);
            //System.out.println(x);
            int flag=0;
            if(!random.contains(x))
            {
            random.add(x);
            }
            }while(!data.getYears().get(0).isIsChoosen() || !data.getYears().get(1).isIsChoosen() || !data.getYears().get(2).isIsChoosen());
            */
        /*for(z=0;z<3;z++)
        {
            System.out.println(random.get(z));
        }*/

                for (i = 2; i >= 0; i--) {
                    x = i;
                    for (j = 0; j < 5; j++) {
                        int max = 7;
                        k = 0;
                        while (k < max) {
                            final int setx = j;
                            final int sety = k;
                            final int prac = x;

                                if (((x == 2) && (k == 1 || k == 2)) || ((x == 1) && (k == 3 || k == 4)) || ((x == 0) && (k == 5 || k == 6))) {
                                    System.out.print("Lab!  ");
                                    data.getYears().get(x).setTime(j, k, "Lab!");
                                    data.getYears().get(x).getPracticals().forEach(m -> {

                                        m.setPersonal(setx, sety, m.getPrac_lectures().get(prac));
                                        m.setIsBusy(setx, sety, true);

                                    });
                                }
                                k =k+1;
                        }
                    }
                }


                for (i = 2; i >= 0; i--) {
                    x = i;
                    System.out.println("");
                    System.out.println(x);
                    System.out.println("");
                    for (j = 0; j < 5; j++) {
                        System.out.println("");
                        int max = 7;
                        if (x == 0) max = 7;
                        k = 0;
                        /*for(k=0; k<max; k++)*/
                        while (k < max) {
                    /*int y = (int)(Math.random()*data.getYears().get(x).getProfessors().size());
                    System.out.print(data.getYears().get(x).getProfessors().get(y).getProfName()+"  ");
                    String prof=data.getYears().get(x).getProfessors().get(y).getProfName();
                    data.getYears().get(x).setTime(j,k,prof);*/
                            int Conflict = 0;

                            do {
                                int y = (int) (Math.random() * data.getYears().get(x).getProfessors().size());
                                if (((x == 2) && (k == 1 || k == 2)) || ((x == 1) && (k == 3 || k == 4)) || ((x == 0) && (k == 5 || k == 6))) {
                                    Conflict=1;
                                    System.out.print("Lab!  ");
                                    k=k+1;
                                }
                                else if (!data.getYears().get(x).getProfessors().get(y).getIsBusy(j, k)) {

                                /*System.out.print(data.getYears().get(x).getProfessors().get(y).getProfName()+"  ");
                                String prof=data.getYears().get(x).getProfessors().get(y).getProfName();
                                data.getYears().get(x).setTime(j,k,prof);
                                Conflict = 1;*/

                                    if (data.getYears().get(x).getProfessors().get(y).getLectures().get(x) > 0) {
                                        data.getYears().get(x).getProfessors().get(y).getLectures().set(x, data.getYears().get(x).getProfessors().get(y).getLectures().get(x) - 1);
                                        data.getYears().get(x).getProfessors().get(y).setIsBusy(j, k, true);

                                        String subLecture = data.getYears().get(x).getProfessors().get(y).getSub_lectures().get(x);
                                        data.getYears().get(x).getProfessors().get(y).setPersonal(j, k, subLecture);

                                        System.out.print(data.getYears().get(x).getProfessors().get(y).getProfName() + "  ");
                                        String prof = data.getYears().get(x).getProfessors().get(y).getProfName();
                                        data.getYears().get(x).setTime(j, k, subLecture);

                                    /*if(data.getYears().get(x).getProfessors().get(y).isIsLab()){
                                    System.out.print("  "+data.getYears().get(x).getProfessors().get(y).getProfName()+"  ");
                                    data.getYears().get(x).getPracticals().forEach(m ->{
                                    m.setIsBusy(setx,sety, true);
                                    m.setIsBusy(setx,sety+1, true);
                                    });
                                    data.getYears().get(x).getProfessors().get(y).setIsBusy(j, k+1, true);
                                    data.getYears().get(x).setTime(j,k+1,prof);
                                    k=k+2;
                                    }*/
                                        k = k + 1;
                                        Conflict = 1;
                                    } else if ((Math.random()) < 0.1) {
                                        data.getYears().get(x).setTime(j, k, "Free");
                                        System.out.print("Free   ");
                                        Conflict = 1;
                                        k = k + 1;
                                        fitnessFactor++;
                                    }
                                }

                            } while (Conflict == 0);

                        }
                    }

                }

                System.out.println("");
                System.out.println(fitnessFactor);
            } while (fitnessFactor > data.getNoofFrees());

            System.out.println("");
            System.out.println(fitnessFactor);

       /*for(i=0;i<5;i++)
       {
       for(j=0;j<7;j++)
       {
       String subject="";
       String prof=data.getYears().get(0).getTime(i, j);
       switch(prof){
       case "Deshmukh Mam":
       subject="DSA";
       break;
       case "Agrwal":
       subject="DM";
       break;
       case "Sandbhor R":
       subject="COA";
       break;
       case "Sandbhor AK":
       subject="DELD";
       break;
       case "Borade Sir":
       subject="OOP";
       break;
       case "Lab!":
       subject="Lab!";
       break;
       case "Free":
       subject="Free";
       break;
       }

       data.getYears().get(0).setTime(i, j, subject);
       System.out.print(data.getYears().get(0).getTime(i, j)+"   ");
       }
       System.out.println("   ");
       }
       System.out.println("   ");
       System.out.println("   ");
       System.out.println("   ");

       for(i=0;i<5;i++)
       {
       for(j=0;j<7;j++)
       {
       String subject="";
       String prof=data.getYears().get(1).getTime(i, j);
       switch(prof){
       case "Perira sir":
       subject="TOC";
       break;
       case "Ghumare Sir":
       subject="SEPM";
       break;
       case "Deshmukh Sir":
       subject="ISEE";
       break;
       case "Ghumatkar mam":
       subject="DBMS";
       break;
       case "Hande sir":
       subject="CN";
       break;
       case "Lab!":
       subject="Lab!";
       break;
       case "Free":
       subject="Free";
       break;
       }

       data.getYears().get(1).setTime(i, j, subject);
       System.out.print(data.getYears().get(1).getTime(i, j)+"   ");
       }
       System.out.println("   ");
       }
       System.out.println("   ");
       System.out.println("   ");
       System.out.println("   ");

       for(i=0;i<5;i++)
       {
       for(j=0;j<7;j++)
       {
       String subject="";
       String prof=data.getYears().get(2).getTime(i, j);
       switch(prof){
       case "Perira sir":
       subject="HPC";
       break;
       case "Datta chille":
       subject="AIR";
       break;
       case "Deshmukh Mam":
       subject="DA";
       break;
       case "Deshmukh Sir":
       subject="EL1";
       break;
       case "Mate":
       subject="EL2";
       break;
       case "Lab!":
       subject="Lab!";
       break;
       case "Free":
       subject="Free";
       break;
       }

       data.getYears().get(2).setTime(i, j, subject);
       System.out.print(data.getYears().get(2).getTime(i, j)+"   ");
       }
       System.out.println("   ");
       }
       System.out.println("   ");*/


            for (i = 0; i < 3; i++) {
                for (j = 0; j < 5; j++) {
                    for (k = 0; k < 7; k++) {
                        System.out.print(data.getYears().get(i).getTime(j, k) + "    ");
                    }
                    System.out.println("");
                }

                System.out.println("");

                System.out.println("");

                System.out.println("");
            }

            /*for (i = 0; i < data.getProfessors().size(); i++) {
                System.out.println(data.getProfessors().get(i).getProfName());
                for (j = 0; j < 5; j++) {
                    for (k = 0; k < 7; k++) {

                        System.out.print(data.getProfessors().get(i).getPersonal(j, k) + "    ");
                    }
                    System.out.println("");
                }

                System.out.println("");

                System.out.println("");

                System.out.println("");
            }*/
    }
    public Data getData() {
        return data;
    }
    
    
}
