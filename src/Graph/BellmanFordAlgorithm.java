/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

/**** @author sushma r iliger*/
public class BellmanFordAlgorithm {
    static class node{
        String nodename,parent;        
        int weight;
        node(){}
        node(String n,int w,String p){
            this.parent=p;this.nodename=n; this.weight=w;
        }
        public String getname(){return this.nodename;}
        public String getParent(){return this.parent;}
        public int getweight(){return this.weight;}
        public String setParent(String p){return this.parent=p;}
        public int setweight(int w){return this.weight=w;}        
    }
    public static int j=0;
    public static List <EdgeInformation> unvisitedEdgeList =new ArrayList<EdgeInformation>();
    public static List <node> nodeList=new ArrayList<node>();
    public static List <String> visitedNode=new ArrayList<String>();
    
    public static void readJsonFile(FileReader file){
    try{    
     JSONParser jsonParser = new JSONParser();            
     Object obj = jsonParser.parse(file);
     JSONObject jsonObject = (JSONObject) obj;                         
     
     Object obj1=jsonObject.get("node");
     JSONArray jsonArray2 = new JSONArray();           
     jsonArray2= (JSONArray)obj1;          
     for(int i=0;i<jsonArray2.size();i++){              
         node newnode=new node(jsonArray2.get(i).toString(),1000,"-");         
         nodeList.add(newnode);                 
     }
    
     Object obj2=jsonObject.get("edge");
     JSONArray jsonArray = new JSONArray();           
     jsonArray= (JSONArray)obj2;          
     for(int i=0;i<jsonArray.size();i++){     
                 EdgeInformation newnode=new EdgeInformation();                 
                 JSONObject nodeDetails= (JSONObject)(jsonArray.get(i));            
                 String start=nodeDetails.get("Start").toString();
                 String end=nodeDetails.get("End").toString();
                 int edge=Integer.parseInt(nodeDetails.get("cost").toString());
                 newnode.setNodeInformation(start,end,edge);                 
                 unvisitedEdgeList.add(newnode);                 
     }              
     file.close();
    }catch(Exception e){}    
    }
    
    public static void FirstDistanceMatrix(String nodeName,int weight){        
        node temp= new node(); 
        for(int i=0;i<nodeList.size();i++){
            if(nodeList.get(i).getname().equals(nodeName)){
                nodeList.get(i).setweight(weight);
                temp=nodeList.get(i);
            }
        }
        int w=weight;
        String start=nodeName;  
        for(int i=0;i<unvisitedEdgeList.size();i++){
            String end=unvisitedEdgeList.get(i).getEnd();              
            if(unvisitedEdgeList.get(i).getStart().equals(start)){
                int cost1= w+unvisitedEdgeList.get(i).getEdgeWeight();   
                int cost2=getWeight(end);                
                if(cost1<cost2){setParentAndWeight(start,end,cost1);}
                else if(cost1>cost2){setParentAndWeight(start,end,cost2);}
            }            
        }                
        j++;
        if(j<nodeList.size()){                                 
            visitedNode.add(nodeList.get(j).getname());            
            FirstDistanceMatrix(nodeList.get(j).getname(),nodeList.get(j).getweight());                     
        }                
    }
    
    
    public static void BellmanFordAlgo(String nodeName){        
        node temp= new node(); 
        for(int i=0;i<nodeList.size();i++){
            if(nodeList.get(i).getname().equals(nodeName)){                
                temp=nodeList.get(i);
            }
        }
        int w=temp.getweight();
        String start=nodeName;  
        for(int i=0;i<unvisitedEdgeList.size();i++){
            String end=unvisitedEdgeList.get(i).getEnd();              
            if(unvisitedEdgeList.get(i).getStart().equals(start)){
                int cost1= w+unvisitedEdgeList.get(i).getEdgeWeight();   
                int cost2=getWeight(end);                
                if(cost1<cost2){setParentAndWeight(start,end,cost1);}
                else if(cost1>cost2){setParentAndWeight(start,end,cost2);}
            }            
        }                
        j++;
        if(j<nodeList.size()){  BellmanFordAlgo(visitedNode.get(j));    }                
    }
    public static List BubbleSort(List<node> t){
        int n = t.size();  
        node temp = new node();  
        for(int i=0; i < n; i++){  
            for(int j=1; j < (n-i); j++){  
                if(t.get(j-1).getweight() > t.get(j).getweight()){                                     
                    temp = t.get(j-1);  
                    t.set(j-1, t.get(j));  
                    t.set(j, temp);
                }                            
            }  
        } 
        return t;
    }
    
public static void printTheCurrent(){        
        System.out.print("\nVisited nodes : [ ");
        for(int i=0;i<visitedNode.size();i++){
            System.out.print(visitedNode.get(i)+" ");
        }        
        System.out.print(" ]"); System.out.println("");
        System.out.println("Distance Matrix :");
        for(int i=0;i<nodeList.size();i++){
            System.out.print(nodeList.get(i).getname()+"("+nodeList.get(i).parent+"->"+nodeList.get(i).getweight()+") || ");
        }
        System.out.println("");
    }    
    
    public static node getNextMin(){
        List <node> temp=new ArrayList<node>();
        temp=nodeList;
        temp=BubbleSort(temp);
        node n=new node();
        for(int i=0;i<temp.size();i++){                        
            if(!visitedNode.contains(temp.get(i).getname())){
                n=temp.get(i);
                break;
            }            
        }    
        return n;
    }    
    public static int getWeight(String e){
        for(int i=0;i<nodeList.size();i++){
            if(nodeList.get(i).getname().equals(e)){
                return nodeList.get(i).getweight();                        
            }
        }
        return 0;
    }
    public static void setParentAndWeight(String s,String e,int c){
        for(int i=0;i<nodeList.size();i++){
            if(nodeList.get(i).getname().equals(e)){
                 nodeList.get(i).setParent(s);                        
                 nodeList.get(i).setweight(c);
        }
        }        
    }
    
    public static void main(String args[]){
        Scanner scan= new Scanner(System.in);        
        FileReader file;                
        try {
            file= new FileReader("C:\\Users\\sushma r iliger\\Desktop\\BellmanFordAlgo_edgelist.json");              
            readJsonFile(file);
        } catch (FileNotFoundException ex) {}  
        
        System.out.print("Choose the start node : ");        
        String choice= scan.next();
        visitedNode.add(choice);
        FirstDistanceMatrix(choice, 0);        
        int i=0;
        do{
            j=0;
            printTheCurrent();
            BellmanFordAlgo(choice);            
            i++;
        }while(i<nodeList.size()-1);
    }
}
