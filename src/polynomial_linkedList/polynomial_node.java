package polynomial_linkedList;
/**
 *
 * @author sushma r iliger
 */
public class polynomial_node{
       int coeff,power;      
       polynomial_node next;
       
       public polynomial_node() {}

       public polynomial_node(int c,int p) {           
           this.coeff=c;
           this.power=p;
           this.next=null;
       }

       public void setNextNode(polynomial_node newNode) {this.next=newNode;}
       public void setCoeffient(int c) {this.coeff=c;}       
       public polynomial_node getNext() {   return this.next;   }
       public int getPower() {  return this.power;  }
       public int getCoeffient() {  return this.coeff;  }
       public String getInfo() { return "("+this.coeff+"x^"+this.power+")";}
   }
