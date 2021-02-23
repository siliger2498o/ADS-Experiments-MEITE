/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.List;
import static jdk.nashorn.internal.runtime.Context.printStackTrace;

/**
 *
 * @author sushma r iliger
 */
    public class Node{
        String nodeName;
        List <String>neighbors;
        
        public void setNodeDetails(String nName,List list){
        try{                     
            this.nodeName=nName;
            this.neighbors =list;
        }                
        catch(Exception e){
            printStackTrace(e);
        }
    }
        public String getNodeName(){
            return this.nodeName;
        }
        public List getNodeNeighbor(){
            return this.neighbors;
        }
    }

