package BST_Expt;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sushma r iliger
 */
import static jdk.nashorn.internal.runtime.Context.printStackTrace;
import org.json.*;

public class BSTNodes {
    private int socialSecurityNumber;
    private String employeeDetail;   
    private BSTNodes leftChild,rightChild;
        
    
    public void setNodeDetails(String response){
        try{
            JSONObject fullEmployeeDeatils= new JSONObject(response);           
            JSONObject empDetails= new JSONObject();
            empDetails = fullEmployeeDeatils.getJSONObject("empDetails");                                               
            this.socialSecurityNumber= Integer.parseInt(fullEmployeeDeatils.get("socialSecurityNumber").toString());
            this.employeeDetail=empDetails.toString();                                    
            this.leftChild=null;
            this.rightChild=null;           
        }                
        catch(Exception e){
            printStackTrace(e);
        }
    }
    public void setSocialSecurityNumber(int response){
        this.socialSecurityNumber=response;
    }     
    public void setEmployeeDetails(String response){
        this.employeeDetail=response;
    } 
    public void setLeftChild(BSTNodes response){
        this.leftChild=response;
    }    
    public void setRightChild(BSTNodes response){
        this.rightChild=response;
    }    
    public int getSocialSecurityNumber(){
        return this.socialSecurityNumber;
    }
    public String getEmloyeeDetails(){
        return this.employeeDetail;
    }
    public BSTNodes getLeftChild(){
        return this.leftChild;
    }    
    public BSTNodes getRightChild(){
        return this.rightChild;
    }
}
