package grid_servithors;

import java.util.ArrayList;
import grid.*;
import PetriObj.PetriObjModel;
import PetriObj.PetriSim;
/**
 * @author Ivan
 * class for incapsulating GRID model
 */
public class UltimateGRIDmodel {
    //these params were in original StIv model. I have no idea about them...
    //TODO change all members to private!
    public double TimeModelling;
    //they were in original model as arrays, but I want them to be ArrayLists...
    public ArrayList<Integer> data; //it's the amount of MIPS for a certain user for the whole big set of experiments
    public ArrayList<Double> result;
    //-----Main Parameters (for imitation) from model...-----
    public ArrayList<PetriSim> ListObj;
        //in original model we had 4 separate ArrayList:
        //ListTaskA, ListTaskB, ListTaskC, ListTaskD, but I've replaced 'em to a single ArrayList 
        //This array contains tasks for each user (I think so) and it's size should be equ to ListUser size
    public ArrayList<ArrayList<TaskSim>> AllTasks;
    public ArrayList<UserSim> ListUser;
    
    public UltimateGRIDmodel(double inp_TimeModelling) {
        TimeModelling=inp_TimeModelling;
        data = new ArrayList<Integer>();
        result= new ArrayList<Double>();
        //формування (поч. ініціалізація) списку імітаційних обєктів
        ListObj = new ArrayList<PetriSim>(); 
        ListUser = new ArrayList<UserSim>();
    }
    
    public void DefineTasksAndUsers(ArrayList<ArrayList<TaskData>> inpTasks, 
                                    ArrayList<UserData> inpUsers) throws Exception  {
        if (inpTasks.size()!=inpUsers.size()) {
            throw new Exception("Tasks Length!=Users Length!");
        }
        
        
    }
}
