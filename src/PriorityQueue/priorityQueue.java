package PriorityQueue;
import java.util.ArrayList;
import java.util.Scanner;
/**** @author sushma r iliger*/
public class priorityQueue {
    public static int[] priorityQ;
    public static int top=0,rear=0,length;
    
    public static void Insert(int no,int type){
        if(top==0 && rear==0){
            top=1;rear=1;
            priorityQ[rear]=no;
        }
        else if(rear<length-1){         
            priorityQ[++rear]=no;
            if(type==0){
                checkMinHeapAfterInsertion(rear);
            }else{
             checkMaxHeapAfterInsertion(rear);   
            }            
        }
        else{
            System.out.println("Queue is full");
        }
    }
    
    public static void checkMaxHeapAfterInsertion(int position){    
        int parentIndex=position/2;
        if(priorityQ[parentIndex]<priorityQ[position]){
            int temp=priorityQ[parentIndex];
            priorityQ[parentIndex]=priorityQ[position];
            priorityQ[position]=temp;
            
            if(parentIndex>top){
                checkMaxHeapAfterInsertion(parentIndex);
            }            
        }        
    }
    
    public static void checkMinHeapAfterInsertion(int position){    
        int parentIndex=position/2;
        if(priorityQ[parentIndex]>priorityQ[position]){
            int temp=priorityQ[parentIndex];
            priorityQ[parentIndex]=priorityQ[position];
            priorityQ[position]=temp;
            
            if(parentIndex>top){
                checkMaxHeapAfterInsertion(parentIndex);
            }            
        }        
    }
    
    public static void display(){
        if(rear!=0){
            System.out.print("Queue is :");
            for(int i=1;i<=rear;i++){
                System.out.print(priorityQ[i]+" ");
        }   
        }        
        System.out.println("\n");
    }
    
    public static int getMax(int left,int right){            
        if(priorityQ[left]>priorityQ[right]){return left;}
        else{return right;}
    }
    public static int getMin(int left,int right){            
        if(priorityQ[left]<priorityQ[right]){return left;}
        else{return right;}
    }
    
    public static void checkMaxHeapAfterDeletion(int position){    
        int leftChildIndex=2*position;
        int rightChildIndex=(2*position)+1;
        int maxIndex=getMax(leftChildIndex,rightChildIndex);
        if(priorityQ[position]<priorityQ[maxIndex]){
            int temp=priorityQ[maxIndex];
            priorityQ[maxIndex]=priorityQ[position];
            priorityQ[position]=temp;                                    
        }        
    }    
    public static void checkMinHeapAfterDeletion(int position){    
        int leftChildIndex=2*position;
        int rightChildIndex=(2*position)+1;
        int maxIndex=getMin(leftChildIndex,rightChildIndex);
        if(priorityQ[position]>priorityQ[maxIndex]){
            int temp=priorityQ[maxIndex];
            priorityQ[maxIndex]=priorityQ[position];
            priorityQ[position]=temp;                        
        }}    
    public static void Delete(int type){        
        System.out.println("The element to be deleted :"+priorityQ[1]);        
        priorityQ[top]=priorityQ[rear];
        rear--;        
        if(rear>top){
            if(type==1){checkMaxHeapAfterDeletion(top);}        
            else{checkMinHeapAfterInsertion(rear);}
        }
        else if(rear==0){
            top=0;System.out.println("The priority queue is Empty");}        
    }
    
    public static void main(String args[]){
        Scanner scan= new Scanner(System.in);
        Scanner scan1= new Scanner(System.in);
        String option;
        System.out.println("Priority Queue using max heap");        
        System.out.println("Press 1-> Max Heap 0-> Min Heap: ");   
        int type=scan.nextInt();
        System.out.print("Enter the length of the queue : ");        
        length=scan.nextInt()+1;        priorityQ=new int[length];
        System.out.print("\n");                        
        do{
        System.out.print("\nEnter 1-> Insertion 2->Deletion 3-> Dislay Queue : ");        
        int choice=scan1.nextInt(); System.out.print("\n");        
        switch (choice){
            case 1:
                int number=0;
                for(int i=0;i<length-1;i++){
                System.out.print("Enter the number to be inserted : ");
                number= scan1.nextInt();
                Insert(number,type);   
                }                
                break;
            case 2: Delete(type);   break;
            case 3: display();  break;
        }        
        System.out.print("\nEnter y->continue or n->stop :");
        option=""+scan1.next().charAt(0);        
        }while(!option.equals("n"));
    }
}
