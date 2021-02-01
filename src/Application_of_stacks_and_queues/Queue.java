package Application_of_stacks_and_queues;

import java.util.Scanner;
import Application_of_stacks_and_queues.process;

/**
 *
 * @author sushma r iliger
 */
public class Queue {
    public static process arrayProcess[];
    public static int top=-1,rear=-1,length;
    public static float avgwt=0,avgta=0;            
        
    public  static void denqueue(){
        while(top<=rear){
            if( top == 0){	
                arrayProcess[top].setCompletionTime(arrayProcess[top].getArrivalTime() + 
                        arrayProcess[top].getBurstTime());
            }
            else{
                if( arrayProcess[top].getArrivalTime() > arrayProcess[top-1].getCompletionTime()){
                    arrayProcess[top].setCompletionTime(arrayProcess[top].getArrivalTime() + 
                            arrayProcess[top].getBurstTime());
                }
                else{
                    arrayProcess[top].setCompletionTime(arrayProcess[top-1].getCompletionTime()+ 
                            arrayProcess[top].getBurstTime());
                }				
            }
            
            arrayProcess[top].setTurnaroundTime(arrayProcess[top].getCompletionTime() - 
                    arrayProcess[top].getArrivalTime());
            arrayProcess[top].setWaitingTime(arrayProcess[top].getTurnaroundTime() - 
                    arrayProcess[top].getBurstTime());
            
            avgwt += arrayProcess[top].getWaitingTime();
            avgta += arrayProcess[top].getTurnaroundTime();
            top++;
        }
    }
        
    public static void enqueue (process p){            
        if(rear<length){
            if(top==-1 && rear==-1){
                top=0;
                rear=0;
                arrayProcess[top]=p;   
            }
            else{
                arrayProcess[++rear]=p;   
            }                
        }
    }
        
    public static boolean isfull(){
        if(rear<length-1){               
            return true;   
        }
        else{
            return false;   
        }            
    }
    public static void main(String args[])
    {
        int no_of_proocesses;
        System.out.println("Enter the number of processes:");
        Scanner sc= new Scanner(System.in);
        no_of_proocesses=sc.nextInt();
        length=no_of_proocesses;
        arrayProcess=new process[no_of_proocesses];
            
        while(isfull()){                
            System.out.println("Enter processId :");int pid=sc.nextInt(); 
            System.out.println("Enter arrival time for process "+pid+" :");int ar=sc.nextInt(); 
            System.out.println("Enter burst time for process "+pid+" :"); int bs=sc.nextInt();
            process p = new process(pid,ar,bs);
            enqueue(p);
        }           
            
        denqueue ();
            
        System.out.println("\npid  arrival  brust  complete turn waiting");
        
        for(int  i = 0 ; i< length;  i++)
        {
            System.out.println(arrayProcess[i].getProcessId() + "\t " + arrayProcess[i].getArrivalTime() + 
                    "\t" + arrayProcess[i].getBurstTime()+ "\t" + arrayProcess[i].getCompletionTime() + 
                    "\t" + arrayProcess[i].getTurnaroundTime() + "\t"  + arrayProcess[i].getWaitingTime() ) ;
        }
        
        System.out.println("\nAverage waiting time: "+ (avgwt/length)+"\nAverage turnaround time:"+(avgta/length));
    }
}
