/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author sushma r iliger
 */
public class EdgeInformation{
        String start,end;
        int edgeWeight;
        
        public void setNodeInformation(String s,String e,int cost){
            this.start=s;
            this.end=e;
            this.edgeWeight=cost;
        }
        public String getStart(){
            return this.start;
        }
        public String getEnd(){
            return this.end;
        }
        public int getEdgeWeight(){
            return this.edgeWeight;
        }
        public String getNodeInfo(){
            return "Start :"+this.start+"--"+this.edgeWeight+"--"+"End"+this.end;
        }
    }