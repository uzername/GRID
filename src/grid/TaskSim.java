/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package grid;

import PetriObj.PetriNet;
import PetriObj.PetriSim;

/**
 *
 * @author Инна
 */
public class TaskSim extends PetriSim{
   private String name;
   private PetriNet pNet;


    public TaskSim(PetriNet net,double timeModeling)
    {
        super(net,timeModeling);
        pNet = net;
        name = pNet.getName();
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
    /*  if (super.getEventMin().getName().equalsIgnoreCase("чи недостатньо? "))
      {System.out.println("*****************чи недостатньо?********************* "+this.getTimeCurr());
          this.printMark();}
      if (super.getEventMin().getName().equalsIgnoreCase("відмова "))
      {System.out.println("*******************відмова****************************** "+this.getTimeCurr());
          this.printMark();}*/

    }

     public void printInfo()
     {
     System.out.println("кількість виконаних завдань = "+pNet.getListP()[9].getMark()+"\n"+
                   "кількість завдань, що отримали відмову = "+pNet.getListP()[10].getMark()+"\n"+
                   "кількість фактично використаного ресурсу = "+pNet.getListP()[11].getMark()+"\n"+
                   "кількість ОР, що не вистачає = "+pNet.getListP()[12].getMark()+
                  // "кількість не використаного ОР через його недостатність = "+pNet.getListP()[14].getMark()+"\n"+
                  // "середня кількість в очікуванні = "+(pNet.getListP()[2].getMean()+pNet.getListP()[4].getMean())+
                    "\n");
     }
     
     
     
     public int getNumProcessed()
     {
     return pNet.getListP()[9].getMark();
     }
     public int getNumRefusals()
     {
     return pNet.getListP()[10].getMark();
     }

}
