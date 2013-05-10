package grid;

import PetriObj.PetriNet;
import PetriObj.PetriP;
import PetriObj.PetriT;
import PetriObj.TieIn;
import PetriObj.TieOut;
import java.util.ArrayList;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Стеценко Інна
 */
public class NetLibrary {


public static PetriNet CreateNetPlan(double timeModeling)
{

      ArrayList<PetriP> d_P = new ArrayList<PetriP>();
      ArrayList<PetriT> d_T = new ArrayList<PetriT>();
      ArrayList<TieIn> d_In = new ArrayList<TieIn>();
      ArrayList<TieOut> d_Out = new ArrayList<TieOut>();
     
     d_P.add(new PetriP("новий такт",0));
     d_P.add(new PetriP("початок такту управління",1));
     d_P.add(new PetriP("триває розподіл",0));
     d_P.add(new PetriP("кінець розподілу",0));
     d_P.add(new PetriP("обсяг вільного віртуального ОР",1000));
     d_P.add(new PetriP("інформація про кількість активних користувачів",0));

     d_P.add(new PetriP("інформація про доступний ресурс користувача А",0));
     d_P.add(new PetriP("інформація про доступний ресурс користувача В",0));
     d_P.add(new PetriP("інформація про доступний ресурс користувача С",0));
     d_P.add(new PetriP("інформація про доступний ресурс користувача D",0));
    
     d_P.add(new PetriP("кількість активних користувачів",4));
     d_P.add(new PetriP("інформація про обсяг вільного віртуального ОР",0));

     d_P.add(new PetriP("загальний наданий ресурс користувача А",0));
     d_P.add(new PetriP("загальний наданий ресурс користувача В",0));
     d_P.add(new PetriP("загальний наданий ресурс користувача С",0));
     d_P.add(new PetriP("загальний наданий ресурс користувача D",0));

     d_P.add(new PetriP("копія обсягу вільного віртуального ОР",0));
     d_P.add(new PetriP("копія кількості активних користувачів",0));
     


  //   for(int i=0; i<d_P.size(); i++)
    //        d_P.get(i).SetNumber(i); //Без цього не буде працювати конструктор зв'язків для об'єктів перехід і позиція

      d_T.add(new PetriT("розпочати розподіл ",10, timeModeling));
      d_T.add(new PetriT("розрахунок частки доступного ресурсу ",0, timeModeling));
      d_T.add(new PetriT("триває розподіл ресурсів ",0, timeModeling));
      d_T.add(new PetriT("завершити розподіл ",0, timeModeling));
      d_T.add(new PetriT("А ",0, timeModeling,0.5)); // або встановлюється при конструюванні моделі
      d_T.add(new PetriT("В ",0, timeModeling,0.2));
      d_T.add(new PetriT("С ",0, timeModeling,0.1));
      d_T.add(new PetriT("D ",0, timeModeling,0.1));
      d_T.add(new PetriT("передати інформацію про кількість активних користувачів ",0, timeModeling));
      d_T.add(new PetriT("передати інформацію про вільний віртуальний ОР ",0, timeModeling));

      d_T.add(new PetriT("витерти інформацію А",0, timeModeling));
      d_T.add(new PetriT("витерти інформацію В",0, timeModeling));
      d_T.add(new PetriT("витерти інформацію С",0, timeModeling));
      d_T.add(new PetriT("витерти інформацію D",0, timeModeling));

      d_T.add(new PetriT("зберегти обсяг вільного віртуального ресурсу",0, timeModeling));
      d_T.add(new PetriT("зберегти кількість активних користувачів",0, timeModeling));

      d_T.get(4).setPriority(1);
      d_T.get(5).setPriority(1);
      d_T.get(6).setPriority(1);
      d_T.get(7).setPriority(1);
      d_T.get(8).setPriority(1);
      d_T.get(9).setPriority(1);
      d_T.get(10).setPriority(1);
      d_T.get(11).setPriority(1);
      d_T.get(12).setPriority(1);
      d_T.get(13).setPriority(1);

    // for(int i=0; i<d_T.size(); i++)
     //       d_T.get(i).SetNumber(i); //Без цього не буде працювати конструктор зв'язків для об'єктів перехід і позиція

    
      d_In.add(new TieIn(d_P.get(0),d_T.get(0),1));
      d_In.add(new TieIn(d_P.get(1),d_T.get(1),1));
      d_In.add(new TieIn(d_P.get(2),d_T.get(2),1));
      d_In.add(new TieIn(d_P.get(3),d_T.get(3),1));
      
      d_In.add(new TieIn(d_P.get(11),d_T.get(4),1));
      d_In.add(new TieIn(d_P.get(2),d_T.get(4),1,true));
      d_In.add(new TieIn(d_P.get(11),d_T.get(5),1));
      d_In.add(new TieIn(d_P.get(2),d_T.get(5),1,true));
      d_In.add(new TieIn(d_P.get(11),d_T.get(6),1));
      d_In.add(new TieIn(d_P.get(2),d_T.get(6),1,true));
      d_In.add(new TieIn(d_P.get(11),d_T.get(7),1));
      d_In.add(new TieIn(d_P.get(2),d_T.get(7),1,true));

      d_In.add(new TieIn(d_P.get(1),d_T.get(8),1,true));
      d_In.add(new TieIn(d_P.get(10),d_T.get(8),1));

      d_In.add(new TieIn(d_P.get(1),d_T.get(9),1,true));
      d_In.add(new TieIn(d_P.get(4),d_T.get(9),1));

      d_In.add(new TieIn(d_P.get(1),d_T.get(10),1,true));
      d_In.add(new TieIn(d_P.get(6),d_T.get(10),1));

      d_In.add(new TieIn(d_P.get(1),d_T.get(11),1,true));
      d_In.add(new TieIn(d_P.get(7),d_T.get(11),1));

      d_In.add(new TieIn(d_P.get(1),d_T.get(12),1,true));
      d_In.add(new TieIn(d_P.get(8),d_T.get(12),1));

      d_In.add(new TieIn(d_P.get(1),d_T.get(13),1,true));
      d_In.add(new TieIn(d_P.get(9),d_T.get(13),1));

      d_In.add(new TieIn(d_P.get(16),d_T.get(14),1));

      d_In.add(new TieIn(d_P.get(17),d_T.get(15),1));


      d_Out.add(new TieOut(d_T.get(0),d_P.get(1),1));
      d_Out.add(new TieOut(d_T.get(1),d_P.get(2),1));
      d_Out.add(new TieOut(d_T.get(2),d_P.get(3),1));
      d_Out.add(new TieOut(d_T.get(3),d_P.get(0),1));

      d_Out.add(new TieOut(d_T.get(4),d_P.get(6),1));
      d_Out.add(new TieOut(d_T.get(5),d_P.get(7),1));
      d_Out.add(new TieOut(d_T.get(6),d_P.get(8),1));
      d_Out.add(new TieOut(d_T.get(7),d_P.get(9),1));

      d_Out.add(new TieOut(d_T.get(8),d_P.get(5),1));
      d_Out.add(new TieOut(d_T.get(8),d_P.get(17),1));

      d_Out.add(new TieOut(d_T.get(9),d_P.get(11),1));
      d_Out.add(new TieOut(d_T.get(9),d_P.get(16),1));

      d_Out.add(new TieOut(d_T.get(10),d_P.get(12),1));
      d_Out.add(new TieOut(d_T.get(11),d_P.get(13),1));
      d_Out.add(new TieOut(d_T.get(12),d_P.get(14),1));
      d_Out.add(new TieOut(d_T.get(13),d_P.get(15),1));

      d_Out.add(new TieOut(d_T.get(14),d_P.get(4),1));

      d_Out.add(new TieOut(d_T.get(15),d_P.get(10),1));


        PetriNet d_Net = new PetriNet("Планувальник ",d_P,d_T,d_In,d_Out);
       
       PetriP.initNext();
       PetriT.initNext();
       TieIn.initNext();
       TieOut.initNext();
       
      return d_Net;
}
public static PetriNet CreateNetTask(double timeServ,double timeModeling)
{

      ArrayList<PetriP> d_P = new ArrayList<PetriP>();
      ArrayList<PetriT> d_T = new ArrayList<PetriT>();
      ArrayList<TieIn> d_In = new ArrayList<TieIn>();
      ArrayList<TieOut> d_Out = new ArrayList<TieOut>();

     d_P.add(new PetriP("інформація про доступний обсяг віртуального ОР користувача",0)); //Спільна з Планувальником
     d_P.add(new PetriP("потреба  завдання в обчислювальному ресурсі",0));
     d_P.add(new PetriP("є завдання",0));
     d_P.add(new PetriP("найменше зі значень потреба і доступний ресурс",0));
     d_P.add(new PetriP("достатньо ресурсу",0));
     d_P.add(new PetriP("недостатньо ресурсу",0));
     d_P.add(new PetriP("обсяг вільного віртуального ОР",1000)); //Спільна з Віртуальний ОР грід-системи
     d_P.add(new PetriP("ресурс зайнятий",0));
     d_P.add(new PetriP("завершилось виконання завдання",0));
     d_P.add(new PetriP("кількість виконанних завдань",0));
     d_P.add(new PetriP("кількість завдань, що отримали відмову",0));
     d_P.add(new PetriP("кількість фактично використаного ресурсу",0)); //фактичне споживання ресурсу
     d_P.add(new PetriP("кількість ОР, що не вистачає",0)); //недоспоживання ресурсу
     d_P.add(new PetriP("немає завдання, що виконується",0));
     d_P.add(new PetriP("кількість невикористаного ОР через його недостатність",0));


    // for(int i=0; i<d_P.size(); i++)
    //        d_P.get(i).SetNumber(i); //Без цього не буде працювати конструктор зв'язків для об'єктів перехід і позиція

      d_T.add(new PetriT("знайти найменше значення ",0, timeModeling,2));//вищий пріоритет
      d_T.add(new PetriT("чи достатньо? ",0, timeModeling));
      d_T.add(new PetriT("чи недостатньо? ",0, timeModeling));
      d_T.add(new PetriT("захопити ресурс",0, timeModeling,1));//вищий пріоритет
      d_T.add(new PetriT("вивільнити ресурс",0, timeModeling,1));//вищий пріоритет
      d_T.add(new PetriT("виконання завдання ",timeServ, timeModeling)); //тривалість виконання завдання
      d_T.add(new PetriT("кінець виконання ",0, timeModeling));
      d_T.add(new PetriT("відмова ",0, timeModeling));
      d_T.add(new PetriT("підрахувати кількість ОР, що не вистачає",0, timeModeling,1));
      d_T.add(new PetriT("підрахувати кількість не використаного ОР через його недостатність",0, timeModeling,1));

      d_T.get(5).setDistribution("exp", d_T.get(5).getTimeServ());


  //   for(int i=0; i<d_T.size(); i++)
    //        d_T.get(i).SetNumber(i); //Без цього не буде працювати конструктор зв'язків для об'єктів перехід і позиція

      d_In.add(new TieIn(d_P.get(0),d_T.get(0),1));
      d_In.add(new TieIn(d_P.get(1),d_T.get(0),1));

      d_In.add(new TieIn(d_P.get(0),d_T.get(1),1,true));
      d_In.add(new TieIn(d_P.get(2),d_T.get(1),1));

      d_In.add(new TieIn(d_P.get(1),d_T.get(2),1,true));
      d_In.add(new TieIn(d_P.get(2),d_T.get(2),1));

      d_In.add(new TieIn(d_P.get(3),d_T.get(3),1));
      d_In.add(new TieIn(d_P.get(6),d_T.get(3),1));
      d_In.add(new TieIn(d_P.get(4),d_T.get(3),1,true));

      d_In.add(new TieIn(d_P.get(7),d_T.get(4),1));
      d_In.add(new TieIn(d_P.get(8),d_T.get(4),1,true));

      d_In.add(new TieIn(d_P.get(4),d_T.get(5),1));

      d_In.add(new TieIn(d_P.get(8),d_T.get(6),1));

      d_In.add(new TieIn(d_P.get(5),d_T.get(7),1));

      d_In.add(new TieIn(d_P.get(5),d_T.get(8),1,true));
      d_In.add(new TieIn(d_P.get(1),d_T.get(8),1));
      
      d_In.add(new TieIn(d_P.get(5),d_T.get(9),1,true));
      d_In.add(new TieIn(d_P.get(4),d_T.get(9),1));



  

      d_Out.add(new TieOut(d_T.get(0),d_P.get(3),1));
      d_Out.add(new TieOut(d_T.get(1),d_P.get(4),1));
      d_Out.add(new TieOut(d_T.get(2),d_P.get(5),1));

      d_Out.add(new TieOut(d_T.get(3),d_P.get(7),1));

      d_Out.add(new TieOut(d_T.get(4),d_P.get(6),1));
      d_Out.add(new TieOut(d_T.get(4),d_P.get(11),1));

      d_Out.add(new TieOut(d_T.get(5),d_P.get(8),1));

      d_Out.add(new TieOut(d_T.get(6),d_P.get(9),1));
      d_Out.add(new TieOut(d_T.get(6),d_P.get(13),1));

      d_Out.add(new TieOut(d_T.get(7),d_P.get(10),1));
      d_Out.add(new TieOut(d_T.get(7),d_P.get(13),1));

      d_Out.add(new TieOut(d_T.get(8),d_P.get(12),1));

      d_Out.add(new TieOut(d_T.get(9),d_P.get(14),1));

      
     

        PetriNet d_Net = new PetriNet("Завдання ",d_P,d_T,d_In,d_Out);
       
       PetriP.initNext();
       PetriT.initNext();
       TieIn.initNext();
       TieOut.initNext();
        
      return d_Net;
}
public static PetriNet CreateNetUser(int buffer, double timeModeling)
{

      ArrayList<PetriP> d_P = new ArrayList<PetriP>();
      ArrayList<PetriT> d_T = new ArrayList<PetriT>();
      ArrayList<TieIn> d_In = new ArrayList<TieIn>();
      ArrayList<TieOut> d_Out = new ArrayList<TieOut>();

     d_P.add(new PetriP("користувач активний і формує завдання",1));
     d_P.add(new PetriP("Р1",1));
     d_P.add(new PetriP("Р2",0));
     d_P.add(new PetriP("Р3",0));
     d_P.add(new PetriP("Р4",1));
     d_P.add(new PetriP("Р5",1));
     d_P.add(new PetriP("замовлення на ОР",0));
     d_P.add(new PetriP("потреба завдання в ОР",0)); //Спільна
     d_P.add(new PetriP("є нове завдання",0));
     d_P.add(new PetriP("немає завдання, що виконується",1)); //Спільна
     d_P.add(new PetriP("Р10",0));
     d_P.add(new PetriP("завдання, що виконується",0)); //Спільна
     d_P.add(new PetriP("кількість активних користувачів",1)); // Спільна
     d_P.add(new PetriP("відмова",0));
     d_P.add(new PetriP("кількість відмов",0));
     d_P.add(new PetriP("обсяг невдоволеного ресурсу",0));
     if (buffer>1)
         for(int j=0;j<buffer-1;j++)
        {
        d_P.add(new PetriP("потреба завдання в ОР",0)); //Спільна
        d_P.add(new PetriP("немає завдання, що виконується",1)); //Спільна
        d_P.add(new PetriP("Р10",0));
        d_P.add(new PetriP("завдання, що виконується",0)); //Спільна
        }



  //   for(int i=0; i<d_P.size(); i++)
    //        d_P.get(i).SetNumber(i); //Без цього не буде працювати конструктор зв'язків для об'єктів перехід і позиція

      d_T.add(new PetriT("користувач формує завдання",1, timeModeling));
      d_T.add(new PetriT("користувач думає ",3, timeModeling));
      d_T.add(new PetriT("активність користувача ",50, timeModeling));
      d_T.add(new PetriT("пасивність користувача",50, timeModeling));
      d_T.add(new PetriT("генерування потреби в ОР",0.05, timeModeling)); //інтервал генерування
      d_T.add(new PetriT("поставити першим у буфер завдань ",0, timeModeling));
      d_T.add(new PetriT("передати потребу в ОР на виконання ",0, timeModeling));
      d_T.add(new PetriT("передати завдання на виконання ",0, timeModeling));
      d_T.add(new PetriT("недостатньо місця в буфері завдань ",0, timeModeling));
      d_T.add(new PetriT("передати невдоволену потребу ",0, timeModeling));
      d_T.add(new PetriT("передати завдання на відмову ",0, timeModeling));
      if (buffer>1)
          for(int j=0;j<buffer-1;j++)
          {
           d_T.add(new PetriT("поставити "+(j+2)+"-им у буфер завдань ",0, timeModeling));
           d_T.add(new PetriT("передати потребу в ОР на виконання ",0, timeModeling));
           d_T.add(new PetriT("передати завдання на виконання ",0, timeModeling));
          }
 

     d_T.get(0).setDistribution("exp", d_T.get(0).getTimeServ());
     d_T.get(1).setDistribution("exp", d_T.get(1).getTimeServ());
     d_T.get(2).setDistribution("exp", d_T.get(2).getTimeServ());
     d_T.get(3).setDistribution("exp", d_T.get(3).getTimeServ());
     
     d_T.get(4).setDistribution("exp", d_T.get(4).getTimeServ());

     d_T.get(5).setPriority(1);
      d_T.get(6).setPriority(10); //дуже високий пріоритет
      d_T.get(9).setPriority(1);
      if (buffer>1)
      {
         d_T.get(5).setPriority(buffer+1);
          for(int j=0;j<buffer-1;j++)
              d_T.get(12+3*j).setPriority(10); //дуже високий пріоритет
          for(int j=0;j<buffer-1;j++)
              d_T.get(11+3*j).setPriority(buffer-j);
      }


  //   for(int i=0; i<d_T.size(); i++)
       //     d_T.get(i).SetNumber(i); //Без цього не буде працювати конструктор зв'язків для об'єктів перехід і позиція

      d_In.add(new TieIn(d_P.get(2),d_T.get(0),1));
      
      d_In.add(new TieIn(d_P.get(0),d_T.get(1),1));
      d_In.add(new TieIn(d_P.get(1),d_T.get(1),1));

      d_In.add(new TieIn(d_P.get(4),d_T.get(2),1));

      d_In.add(new TieIn(d_P.get(0),d_T.get(3),1));
      d_In.add(new TieIn(d_P.get(3),d_T.get(3),1));
      d_In.add(new TieIn(d_P.get(12),d_T.get(3),1));

      d_In.add(new TieIn(d_P.get(0),d_T.get(4),1,true));
      d_In.add(new TieIn(d_P.get(5),d_T.get(4),1));

      d_In.add(new TieIn(d_P.get(8),d_T.get(5),1));
      d_In.add(new TieIn(d_P.get(9),d_T.get(5),1));

      d_In.add(new TieIn(d_P.get(6),d_T.get(6),1));
      d_In.add(new TieIn(d_P.get(10),d_T.get(6),1,true));

      d_In.add(new TieIn(d_P.get(10),d_T.get(7),1));

      d_In.add(new TieIn(d_P.get(8),d_T.get(8),1));

      d_In.add(new TieIn(d_P.get(6),d_T.get(9),1));
      d_In.add(new TieIn(d_P.get(13),d_T.get(9),1,true));

      d_In.add(new TieIn(d_P.get(13),d_T.get(10),1));

      if(buffer>1)
       for(int j=0;j<buffer-1;j++)
      {
         d_In.add(new TieIn(d_P.get(8),d_T.get(11+3*j),1));
         d_In.add(new TieIn(d_P.get(17+4*j),d_T.get(11+3*j),1));

         d_In.add(new TieIn(d_P.get(18+4*j),d_T.get(12+3*j),1,true));
         d_In.add(new TieIn(d_P.get(6),d_T.get(12+3*j),1));

         d_In.add(new TieIn(d_P.get(18+4*j),d_T.get(13+3*j),1));

      }

      d_Out.add(new TieOut(d_T.get(0),d_P.get(1),1));
      d_Out.add(new TieOut(d_T.get(0),d_P.get(8),1));
    
      d_Out.add(new TieOut(d_T.get(1),d_P.get(0),1));
      d_Out.add(new TieOut(d_T.get(1),d_P.get(2),1));
     
      d_Out.add(new TieOut(d_T.get(2),d_P.get(3),1));

      d_Out.add(new TieOut(d_T.get(3),d_P.get(0),1));
      d_Out.add(new TieOut(d_T.get(3),d_P.get(4),1));
      d_Out.add(new TieOut(d_T.get(3),d_P.get(12),1));

      d_Out.add(new TieOut(d_T.get(4),d_P.get(5),1));
      d_Out.add(new TieOut(d_T.get(4),d_P.get(6),1));

      d_Out.add(new TieOut(d_T.get(5),d_P.get(10),1));

      d_Out.add(new TieOut(d_T.get(6),d_P.get(7),1));

      d_Out.add(new TieOut(d_T.get(7),d_P.get(11),1));

      d_Out.add(new TieOut(d_T.get(8),d_P.get(13),1));

      d_Out.add(new TieOut(d_T.get(9),d_P.get(15),1));
      
      d_Out.add(new TieOut(d_T.get(10),d_P.get(14),1));
      if(buffer>1)
       for(int j=0;j<buffer-1;j++)
      {
        d_Out.add(new TieOut(d_T.get(11+3*j),d_P.get(18+4*j),1));
        d_Out.add(new TieOut(d_T.get(12+3*j),d_P.get(16+4*j),1));
        d_Out.add(new TieOut(d_T.get(13+3*j),d_P.get(19+4*j),1));
      }

        PetriNet d_Net = new PetriNet("Користувач ",d_P,d_T,d_In,d_Out);

       PetriP.initNext();
       PetriT.initNext();
       TieIn.initNext();
       TieOut.initNext(); 
        
      return d_Net;
}



}
