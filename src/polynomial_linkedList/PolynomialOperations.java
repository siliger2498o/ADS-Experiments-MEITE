package polynomial_linkedList;

import java.util.Scanner;
/*** * @author sushma r iliger*/
public class PolynomialOperations {
   public static polynomial_node equation1=null;
   public static polynomial_node equation2=null;
   public static polynomial_node result=null;
   
    public static void inputEquation(polynomial_node node,int degree,int equationNumber){    
       Scanner scan2= new Scanner(System.in);
       if(node==null){           
           System.out.print("Enter the coeffient for x^"+(degree)+" :");
           int coeff=scan2.nextInt();
            node=new polynomial_node(coeff,degree);            
            if(equationNumber==1){
             equation1=new polynomial_node();   equation1=node;   }
            else if(equationNumber==2){
             equation2=new polynomial_node();   equation2=node;   }                     
            degree=degree-1;
           if(degree>=0){ inputEquation(node, degree,equationNumber);}
       }
       else{           
           System.out.print("Enter the coeffient for x^"+(degree)+" :");
           int coeff=scan2.nextInt();
           polynomial_node newnode= new polynomial_node(coeff,degree);
           node.setNextNode(newnode);
           degree=degree-1;
           if(degree>=0){
               inputEquation(newnode, degree,equationNumber);
           }
       }
   }
   
   public static void displayEquation(polynomial_node node){                  
               System.out.print(node.getInfo());
               if(node.getNext()!=null){
                   System.out.print("+");
                   displayEquation(node.getNext());
               }               
   }
   
   public static void setresultNode(polynomial_node n,int c,int degree){                                
       if(n==null){           
           result=new polynomial_node(c,degree);                                 
       }
       else{
           while(n.getNext()!=null){                              
               n=n.getNext();               
           }           
           polynomial_node newnode=new polynomial_node(c,degree);
           n.setNextNode(newnode);           
       }       
   }   
   
   public static void multiply(polynomial_node eq1,polynomial_node eq2,int degree){
       polynomial_node temp= new polynomial_node();
       int eq1Coeffient=eq1.getCoeffient();
       int eq1Power=eq1.getPower();
       temp=eq2;
       while(temp!=null){
           int resOfCoeffient=temp.getCoeffient()*eq1Coeffient;
           int resOfPower=temp.getPower()+eq1Power;           
           setresultNode(result, resOfCoeffient,resOfPower);
           temp=temp.getNext();
       }
       degree=degree-1;
       if(degree>=0){
           multiply(eq1.getNext(), eq2, degree);
       }
   }
  
   
   public static polynomial_node add_sub(polynomial_node eq1,polynomial_node eq2,int operation){
       int done=0;
       polynomial_node temp1=new polynomial_node(); temp1=eq1;
       polynomial_node temp2=new polynomial_node(); temp2=eq2;
       while(temp1!=null){
           if(temp2.getPower()==temp1.getPower()){                   
               if(operation==1){
                   temp1.setCoeffient(temp1.getCoeffient()+temp2.getCoeffient());                                 
               }
               if(operation==2){
                   temp1.setCoeffient(temp1.getCoeffient()-temp2.getCoeffient());                                    
               }
               done=1;
               break;
           }                                          
           temp1=temp1.getNext();
       }
       if(done==0){  
           temp1=eq1;
           if(operation==1){
               setresultNode(temp1, temp2.getCoeffient(),temp2.getPower());}
           if(operation==2){
               setresultNode(temp1, -(temp2.getCoeffient()),temp2.getPower());}           
       }                      
       done=0;
       temp1=eq1;    
       if(temp2.getNext()!=null){   add_sub(temp1,temp2.getNext(),operation); }       
       return temp1;
   }
      
   public static void main(String args[]){
       int degree;
       Scanner scan= new Scanner(System.in);
       Scanner scan2= new Scanner(System.in);                     
       System.out.println("Enter the degree of equation one :");
       degree=scan.nextInt();       inputEquation(equation1, degree,1);       
       
       System.out.println("\nEnter the degree of equation two :");       
       degree=scan.nextInt();       inputEquation(equation2, degree,2);
       
       System.out.println("Equation 1: "); displayEquation(equation1);       
       System.out.println("\nEquation 2: "); displayEquation(equation2);       
       
       System.out.println("\n\nEnter 1->Addition 2->Subtraction 3->Multiplication :");       
       int choice=scan2.nextInt();       
       switch(choice){
           case 1:                                                
                result=add_sub(equation1,equation2,1);                 
                displayEquation(result);
               break;
           case 2 :                
                result=add_sub(equation1,equation2,2);      
                displayEquation(result);
               break;
           case 3:
               multiply(equation1, equation2, equation1.getPower());
               displayEquation(result); System.out.print("\n");
               break;
       }
   }   
   
 
}
