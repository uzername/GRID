/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grid;

import PetriObj.PetriObjModel;
import PetriObj.PetriSim;
import java.util.ArrayList;
/**
 *
 * @author Инна
 */
public class GRID {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    System.out.println("Петрi сiмулятор");

      double timeModeling=500;
      int data[]= new int[20];
      double result[] = new double[20];
 //Експеримент...
     //   data[0]=1;
     //   for ( int i=1;i<20;i++)
       //     data[i] = data[i-1]+2;
       data[0]=5;
       data[1]=10;
       data[2]=20;
       data[3]=35;
       data[4]=55;
       data[5]=80;
       data[6]=110;
       data[7]=145;
       data[8]=185;
       data[9]=230;
       data[10]=280;
       data[11]=335;
       data[12]=395;
       data[13]=460;
       data[14]=530;
       data[15]=605;
       data[16]=685;
       data[17]=770;
       data[18]=860;
       data[19]=955;
        
        for ( int i=1;i<20;i++)
            result[i] = 0;
       for(int progon=0;progon<4;progon++)  //20 експериментів по 4 прогони
        for (int i=0;i<20;i++) 
       {int summa=0;
       
       
        System.out.println("summa "+summa);
        
       ArrayList<PetriSim> ListObj = new ArrayList<PetriSim>(); //формування списку імітаційних обєктів
       ArrayList<TaskSim> ListTaskA = new ArrayList<TaskSim>();
       ArrayList<TaskSim> ListTaskB = new ArrayList<TaskSim>();
       ArrayList<TaskSim> ListTaskC = new ArrayList<TaskSim>();
       ArrayList<TaskSim> ListTaskD = new ArrayList<TaskSim>();
       ArrayList<UserSim> ListUser = new ArrayList<UserSim>();

       
       TaskSim Task = new TaskSim(NetLibrary.CreateNetTask(3,timeModeling),timeModeling);
       TaskSim TaskInQueue = new TaskSim(NetLibrary.CreateNetTask(3,timeModeling),timeModeling);
       Task.setName("Перше завдання в буфері");
       TaskInQueue.setName("Друге завдання в буфері");
     
       ListTaskA.add(Task);
       ListTaskA.add(TaskInQueue);

       UserSim UserA = new UserSim(ListTaskA,NetLibrary.CreateNetUser(2,timeModeling),timeModeling);
       ListUser.add(UserA);
      

       ListTaskB.add(new TaskSim(NetLibrary.CreateNetTask(3,timeModeling),timeModeling));
       ListUser.add(new UserSim(ListTaskB,NetLibrary.CreateNetUser(1,timeModeling),timeModeling)); //UserB
        
       
       
       ListTaskC.add(new TaskSim(NetLibrary.CreateNetTask(3,timeModeling),timeModeling));
       ListUser.add(new UserSim(ListTaskC,NetLibrary.CreateNetUser(1,timeModeling),timeModeling));//UserC

       ListTaskD.add(new TaskSim(NetLibrary.CreateNetTask(3,timeModeling),timeModeling));
       ListUser.add(new UserSim(ListTaskD,NetLibrary.CreateNetUser(1,timeModeling),timeModeling));//UserD


       PlanSim Plan = new PlanSim(ListUser,NetLibrary.CreateNetPlan(timeModeling),timeModeling);

      ListUser.get(0).setMIPS(data[i]); // Користувач А бажає розмістити  такий ресурс у грід-системі
      ListUser.get(1).setMIPS(5);
      ListUser.get(2).setMIPS(5);
      ListUser.get(3).setMIPS(5);
      ListUser.get(0).setName(ListUser.get(0).getName()+"  A  ");
       ListUser.get(1).setName(ListUser.get(1).getName()+"  B  ");
        ListUser.get(2).setName(ListUser.get(2).getName()+"  C  ");
         ListUser.get(3).setName(ListUser.get(3).getName()+"  D  ");
      
      

    //  ListUser.get(0).getNet().getListT()[4].setDistribution("exp", 0.005); // Потреба користувача А в ресурсі значно більша
    // ListUser.get(1).getNet().getListT()[2].setDistribution("exp", 150);
      ListUser.get(0).getNet().getListT()[0].setDistribution("exp", 5); // Користувач А формує завдання довше, при цьому кількість завдань зменшується, а потреба в ресурсі збільшується

      int sumMIPS=0;
       for(UserSim u:ListUser)
           sumMIPS = sumMIPS+u.getMIPS(); //Користувачі домовились про об"єднання ресурсів


       Plan.getNet().getListP()[4].setMark(sumMIPS); //Формування спільного ресурсу

       Plan.getNet().getListT()[0].setDistribution(null, 30); //Цикл управління
       
       double sum=0.0;
       for (UserSim u:ListUser)
       {
           sum = sum+u.getMIPS();
       }
       for (UserSim u:ListUser)
       {
           u.setPart(u.getMIPS()/sum); //частка доступного ресурсу за домовленістю
         
           System.out.println("Part: "+u.getPart());
       }
        int j=0;
       for (UserSim u:ListUser)
       {
           Plan.getNet().getListT()[4+j].setProbability(u.getPart()); //передача інформації планувальнику про частку користувача за домовленістю
           //System.out.println("Part in Plan: "+Plan.getNet().getListT()[4+j].getProbability());
           j++;
       }

        for(UserSim u:ListUser)
      { u.setPriority(0);
          ListObj.add(u);}
      for(TaskSim T:ListTaskA)
      { T.setPriority(2);
          ListObj.add(T);}
      for(TaskSim T:ListTaskB)   
      { T.setPriority(2);
          ListObj.add(T);}
      for(TaskSim T:ListTaskC)
      { T.setPriority(2);
          ListObj.add(T);}
      for(TaskSim T:ListTaskD)
       { T.setPriority(2);
          ListObj.add(T);}
     
          ListObj.add(Plan);
          Plan.setPriority(1);
          
System.out.println("Початок моделювання: ");
       for(PetriSim Sim:ListObj)
           Sim.printMark();
        PetriObjModel GridModel = new PetriObjModel(ListObj);
        GridModel.setIsProtokol(false); //НЕ друкувати протокол подій
    
        GridModel.Go(timeModeling);
        for(UserSim U:ListUser)
            for(TaskSim T:U.getTaskList())
                 summa =summa+ T.getNumRefusals();
        result[i] = result[i]+summa;
      // result[i] = result[i]+Plan.getNet().getListP()[4].getMean();
       
     
 /*System.out.println("Кінець моделювання: ");
       for(PetriSim Sim:ListObj)
           Sim.printMark();
       for(UserSim U:ListUser)
          U.printInfo();
       System.out.println("Завдання користувача А ");
       for(TaskSim T:ListTaskA)
            T.printInfo();
       System.out.println("Завдання користувача B");
       for(TaskSim T:ListTaskB)
            T.printInfo();
       System.out.println("Завдання користувача C");
       for(TaskSim T:ListTaskC)
            T.printInfo();
       System.out.println("Завдання користувача D");
       for(TaskSim T:ListTaskD)
            T.printInfo();*/
      
       
    //   System.out.println("Статистика ");
       
    /*   for(UserSim u:ListUser)   
            for(PetriSim s:u.getTaskList())
                   System.out.println(s.getName()+", середня кількість завдань =   "+(1-s.getNet().getListP()[13].getMean())+" , поточне маркірування = "+s.getNet().getListP()[13].getMark());
                            // ділиться на 2, оскільки позиція спільна з "Завдання" і для " Користувач" 
      */         
     // System.out.println( "Середній "+Plan.getNet().getListP()[4].getName()+"  "+Plan.getNet().getListP()[4].getMean()+ " , поточне маркірування = "+Plan.getNet().getListP()[4].getMark());
    }
         for(int i=0;i<20;i++)
         System.out.println("result["+i+"]="+result[i]/4+"  "+data[i]);
    }

    
}
