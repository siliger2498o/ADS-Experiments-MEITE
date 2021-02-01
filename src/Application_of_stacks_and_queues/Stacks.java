package Application_of_stacks_and_queues;

import java.util.Scanner;

public class Stacks {
    
    public static String originalString="";
    public static int length,top=-1,unbalanced;
    public static char arrayChar[];
    
    public static boolean isfull(){
        if(top<length-1){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static boolean isEmpty() {
            return (top == -1);
    }       
        
    public static void push(char characters){                
        if(top<length){                        
         arrayChar[++top]=characters;               
        }        
    }
     
    public static char pop() {
            return arrayChar[top--];
    }
    
    
    public static char getTopOfStack(){      
        char c='*';
        if(!isEmpty()){
            return arrayChar[top];        
        }
        else{
            return c;        
        }
    }
    public static void displayStack() {
        System.out.println("Stack is : ");
        if(!isEmpty()){
         for (int i = 0; i <= top; i++) {
            System.out.print(arrayChar[i] + " ");
         }
         System.out.println("\n");   
        }        
    }
    
    public static void displayOriginalString() {
        System.out.println("Original string is : "+originalString);                        
    }
    
    public static void balance(char inputChar){                          
          if (inputChar == '[' || inputChar == '{' || inputChar == '(')
          {
              push(inputChar);
          }
          else if (inputChar == '}' && getTopOfStack() == '{')
          {
              pop();
          }
          else if (inputChar == ']' && getTopOfStack() == '[')
          {
              pop();
          }
          else if (inputChar == ')' && getTopOfStack() == '(')
          {
              pop();
          }
          else {              
              unbalanced=1;                         
          }        
    }      
    
    public static void main(String args[]){
        System.out.println("Enter the length of your string : ");
        Scanner scan1= new Scanner(System.in);
        length=scan1.nextInt();
        arrayChar=new char[length];
        
        char character;        
        Scanner scan= new Scanner(System.in);
        
        int j=0;
        
        while(j<length && unbalanced!=1){
            System.out.println("Enter character : ");                        
            character=scan.next().charAt(0);
            originalString=originalString+character;
            j++;
            balance(character);            
        }        
       
        displayOriginalString();        
       
        if(top==-1 && unbalanced!=1){
            System.out.println("String is balanced");    
        }
        else if (top>-1 || unbalanced==1){
         System.out.println("String is not balanced");   
        }             
    }     
}
