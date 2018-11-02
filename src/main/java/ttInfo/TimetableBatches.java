package ttInfo;

import java.util.ArrayList;
/**
 *
 * @author imran
 */
public class TimetableBatches {
        DataBatches data;
    public TimetableBatches(){
        data = new DataBatches();
        ArrayList<Integer> random=new ArrayList<Integer>();
        
        int i, j, k, x;
        for(i =0; i<3; i++){
            random=new ArrayList<Integer>();
            System.out.println( "  ");
            System.out.println( "  ");
            do{

                    x = (int)(Math.random()*5);
                    data.getBatches().get(i).getProfessors().get(x).setIsLab(true);
                    //System.out.println("IMU");
                    if(!random.contains(x))
                    {
                        random.add(x);
                    }
            }while(!data.getBatches().get(i).getProfessors().get(0).isIsLab()|| !data.getBatches().get(i).getProfessors().get(1).isIsLab() || !data.getBatches().get(i).getProfessors().get(2).isIsLab()|| !data.getBatches().get(i).getProfessors().get(3).isIsLab()|| !data.getBatches().get(i).getProfessors().get(4).isIsLab());
            
            for(j =0; j< 5; j++){
                
            System.out.println( "  ");
                for(k = 0; k<4; k++){
                    String prof = data.getBatches().get(i).getProfessors().get(random.get(k)).getProfName();
                    data.getBatches().get(i).setTime(j, k, prof);
                    System.out.print(data.getBatches().get(i).getTime(j, k)+ "  ");
                }
                
                int z = random.remove(0);
                random.add(z);
            }
        }
    }

    public DataBatches getData() {
        return data;
    }
}
