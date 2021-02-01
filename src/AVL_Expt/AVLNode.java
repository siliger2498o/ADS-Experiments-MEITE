/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AVL_Expt;

import static jdk.nashorn.internal.runtime.Context.printStackTrace;
import org.json.JSONObject;

/**
 *
 * @author sushma r iliger
 */
public class AVLNode {
public int socialSecurityNumber;
public String employeedetails;
public AVLNode leftChild;
public AVLNode right;
public AVLNode parent;
public int height;

public AVLNode(){   }

public AVLNode(int data,String empDetails) {
  this.socialSecurityNumber = data;
  this.employeedetails=empDetails;
  this.leftChild = null;
  this.right = null;
  this.parent = null;
  this.height = 0;
}

public void setEmployeeDetails(String empDetails){this.employeedetails=empDetails;}

public int getSocialSecurityNumber(){return this.socialSecurityNumber;}

public String getEmloyeeDetails(){return this.employeedetails;}

public AVLNode getLeftChild(){return this.leftChild;}

public AVLNode getRightChild(){return this.right;}

}
