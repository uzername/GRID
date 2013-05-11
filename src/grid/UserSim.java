/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package grid;

import PetriObj.PetriNet;
import PetriObj.PetriSim;
import grid_servithors.Dat_Printer;
import java.util.ArrayList;

/**
 *
 * @author Инна
 */
public class UserSim extends PetriSim {
    private String name;
    private int MIPS;
    private double part;
    private PetriNet pNet;
    private int buffer;
    private boolean state;
    private ArrayList<TaskSim> taskList = new ArrayList<TaskSim>();



    public UserSim(PetriNet net,double timeMod)
    {
    super(net,timeMod);
    pNet = net;
    name = pNet.getName();
    MIPS=100;
    state =true;

   
    }
    public UserSim(ArrayList<TaskSim> tasklist, PetriNet net,double timeMod)
    {
       super(net,timeMod);
       pNet = net;
       name = pNet.getName();
       taskList  = tasklist;
       buffer = taskList.size();
       MIPS=100;
       state =true;
      
       Dat_Printer.println("Спільні позиції: "+"\n"
     + taskList.get(0).getNet().getListP()[1].getName() +" = ");
       taskList.get(0).getNet().getListP()[1]  = pNet.getListP()[7];
      
                              Dat_Printer.println(pNet.getListP()[7].getName()+"\n");
      Dat_Printer.println(
       taskList.get(0).getNet().getListP()[2].getName()+ " = ");
       taskList.get(0).getNet().getListP()[2]  = pNet.getListP()[11];
      
                              Dat_Printer.println(pNet.getListP()[11].getName()+"\n");
       Dat_Printer.println(
       taskList.get(0).getNet().getListP()[13].getName()+ " = ");
       taskList.get(0).getNet().getListP()[13]  = pNet.getListP()[9];
       
                               Dat_Printer.println(pNet.getListP()[9].getName()+"\n");
       if(buffer>1)
           for(int j=0;j<buffer-1;j++)
           {
               Dat_Printer.println(
               taskList.get(1).getNet().getListP()[1].getName()+" = ");
               taskList.get(1).getNet().getListP()[1]  = pNet.getListP()[16+4*j];
              
                                      Dat_Printer.println(pNet.getListP()[16+4*j].getName()+"\n");
               Dat_Printer.println(
               taskList.get(1).getNet().getListP()[2].getName()+" = ");
               taskList.get(1).getNet().getListP()[2]  = pNet.getListP()[19+4*j];
              
                                      Dat_Printer.println(pNet.getListP()[19+4*j].getName()+"\n");
               Dat_Printer.println(
               taskList.get(1).getNet().getListP()[13].getName()+" = ");
               taskList.get(1).getNet().getListP()[13]  = pNet.getListP()[17+4*j];
             
                                       Dat_Printer.println(pNet.getListP()[17+4*j].getName()+"\n");
           }
      
    }


     @Override
    public String getName() {
        return name;
    }
    public void setName(String newName)
    {
        name=newName;
    }
     @Override
     public PetriNet getNet()
    {
     return pNet;
    }

      @Override
      public void DoT()
     {//System.out.println("стан користувача "+name+"  "+state);
      if (super.getEventMin().getName().equalsIgnoreCase("пасивність користувача"))
        state=true;
      if (super.getEventMin().getName().equalsIgnoreCase("активність користувача "))
        state=false;
      }

     public void setPart(double p)
     {
      part = p;
     }

     public double getPart()
     {
     return part;
     }

     public boolean getState()
     {
     return state;
     }


     public int getMIPS()
     {
     return MIPS;
     }

     public void setMIPS(int mips)
     {
     MIPS = mips;
     }

     public ArrayList<TaskSim> getTaskList()
     {
     return taskList;
     }

     public void setTaskList(ArrayList<TaskSim> tasklist)
     {
     taskList  = tasklist;
     }
     public int getBuffer()
     {
     return buffer;
     }

     public void printInfo()
     {
     Dat_Printer.println(this.getName()+"\n"+
                   "кількість відмов через відсутність місця в буфері = "+pNet.getListP()[14].getMark()+"\n"+
                   "обсяг невдоволеної потреби в ОР = "+pNet.getListP()[15].getMark()+"\n"
                   );
     }
}
