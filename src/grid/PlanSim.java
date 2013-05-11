/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package grid;

import PetriObj.PetriNet;
import PetriObj.PetriSim;
import java.util.ArrayList;
import grid_servithors.Dat_Printer;

/**
 *
 * @author Инна
 */
public class PlanSim extends PetriSim {
   private PetriNet pNet;
   private String name;
   private ArrayList<UserSim> userList;
   private int MIPS;

    public PlanSim(PetriNet net,double timeMod)
    {
    super(net,timeMod);
    pNet = net;
    name = pNet.getName();
    userList = null;
    MIPS=0;
    }
    public PlanSim(ArrayList<UserSim> UserList,PetriNet net,double timeMod)
    {
    super(net,timeMod);
    pNet = net;
    name = pNet.getName();
    userList = UserList;
    MIPS=0;
    for (UserSim u : userList)
        MIPS=MIPS+u.getMIPS();

    pNet.getListP()[10].setMark(userList.size());
   


     for(UserSim u: userList)

     {Dat_Printer.println("Спільні позиції ОГО: "+"\n"
       + u.getNet().getListP()[12].getName()+" = ");
         u.getNet().getListP()[12] = pNet.getListP()[10];
        
                  Dat_Printer.println(pNet.getListP()[10].getName()+"\n");
     }
     int     j=0;
     for(UserSim u: userList)
     {
      for (TaskSim task: u.getTaskList())
      { Dat_Printer.println("Спільні позиції: "+"\n"
                            +task.getNet().getListP()[6].getName() +" = ");
          task.getNet().getListP()[6] = pNet.getListP()[4] ;
          
                            System.out.println(pNet.getListP()[4].getName()+"\n");
        System.out.println( task.getNet().getListP()[0].getName()+" = ");
          task.getNet().getListP()[0] = pNet.getListP()[6+j] ;
          
                            System.out.println(pNet.getListP()[6+j].getName()+"\n");
      }
      j++;
     }
   



    }

    public ArrayList<UserSim> getUserList()
    {
      return userList;
    }
    public void setUserList(ArrayList<UserSim> userlist)
    {
     userList = userlist;
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
     { 
      if (super.getEventMin().getName().equalsIgnoreCase("розрахунок частки доступного ресурсу "))
        this.calculate();
    //  System.out.println(" А "+pNet.getListT()[4].getProbability()+" B "+pNet.getListT()[5].getProbability()
          //                  +" C "+pNet.getListT()[6].getProbability()+" D "+pNet.getListT()[7].getProbability());
      }
     private void calculate()
     {
      double sum=0.0;
      for(UserSim u: userList)
        if(u.getState()) sum = sum+u.getPart();  //сума часток активних користувачів

//System.out.println();
      if(sum!=0.0)
       for(int j=0;j<userList.size();j++)
       {
        if(userList.get(j).getState())
           pNet.getListT()[4+j].setProbability(userList.get(j).getPart()/sum);
        else
            pNet.getListT()[4+j].setProbability(0.0);
       }
      else for(int j=0;j<userList.size();j++)
       {
         pNet.getListT()[4+j].setProbability(0);
       }
     /*  if(sum==0.0) 
            System.out.println("усі користувачі неактивні ");
       else
        for(UserSim u: userList)
           if(u.getState())
            System.out.println(u.getState()+"  sum= "+sum+"   u.getPart()/sum = "+(u.getPart()/sum));
    */

       
    }
}
