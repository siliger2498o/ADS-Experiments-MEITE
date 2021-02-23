/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author sushma r iliger
 */
public class MST_Algorithms {
    public static List <EdgeInformation> unvisitedEdgeList =new ArrayList<EdgeInformation>();
    public static List <EdgeInformation> Queue =new ArrayList<EdgeInformation>();
    public static List <String> visitedNode=new ArrayList<String>();
    public static List <String> VisitedEdge=new ArrayList<String>(); 
            
    public static void readJsonFile(FileReader file){
    try{    
     JSONParser jsonParser = new JSONParser();            
     Object obj = jsonParser.parse(file);
     JSONObject jsonObject = (JSONObject) obj;                         
     Object obj1=jsonObject.get("edges");
     JSONArray jsonArray = new JSONArray();           
     jsonArray= (JSONArray)obj1;          
     for(int i=0;i<jsonArray.size();i++){     
                 EdgeInformation newnode=new EdgeInformation();                 
                 JSONObject nodeDetails= (JSONObject)(jsonArray.get(i));            
                 String start=nodeDetails.get("start").toString();
                 String end=nodeDetails.get("end").toString();
                 int edge=Integer.parseInt(nodeDetails.get("edge").toString());
                 newnode.setNodeInformation(start,end,edge);                 
                 unvisitedEdgeList.add(newnode);                 
     }      
     file.close();
    }catch(Exception e){}    
    }
    
    public  static void sortUnvisitedList(){        
        for(int i=0; i < unvisitedEdgeList.size(); i++){  
            for(int j=1; j < (unvisitedEdgeList.size()-i); j++){  
                if(unvisitedEdgeList.get(j-1).getEdgeWeight()> unvisitedEdgeList.get(j).getEdgeWeight()){  
                    EdgeInformation temp=new EdgeInformation();EdgeInformation temp2=new EdgeInformation();
                    temp=unvisitedEdgeList.get(j-1);  temp2=unvisitedEdgeList.get(j);
                    unvisitedEdgeList.set(j-1,temp2); unvisitedEdgeList.set(j, temp);                                 
                }}}}
    
     public static List KruskalsAlgorithm(){
        sortUnvisitedList();
        for(int i=0;i<unvisitedEdgeList.size();i++){
            String start=unvisitedEdgeList.get(i).getStart();
            String end=unvisitedEdgeList.get(i).getEnd();
            int cost=unvisitedEdgeList.get(i).getEdgeWeight();
            
            if(!visitedNode.contains(start) && !visitedNode.contains(end)){
                visitedNode.add(start);
                visitedNode.add(end);
                VisitedEdge.add(start+"--"+cost+"--"+end);                }
            else if(visitedNode.contains(start) && !visitedNode.contains(end)){                
                visitedNode.add(end);
                VisitedEdge.add(start+"--"+cost+"--"+end);                }
            else if(!visitedNode.contains(start) && visitedNode.contains(end)){                
                visitedNode.add(end);
                VisitedEdge.add(start+"--"+cost+"--"+end);                }                        
        }
        return VisitedEdge;
    }
    
     public static void discoverNeighbors(String node){
        for(int i=0;i<unvisitedEdgeList.size();i++){
            if(unvisitedEdgeList.get(i).getStart().equals(node)){
                Queue.add(unvisitedEdgeList.get(i));
            }
        }
    }
    
    public  static void sortQueue(){             
        for(int i=0; i < Queue.size(); i++){  
            for(int j=1; j < (Queue.size()-i); j++){  
                if(Queue.get(j-1).getEdgeWeight()> Queue.get(j).getEdgeWeight()){  
                    EdgeInformation temp=new EdgeInformation();EdgeInformation temp2=new EdgeInformation();
                    temp=Queue.get(j-1);
                    temp2=Queue.get(j);
                    Queue.set(j-1,temp2);
                    Queue.set(j, temp);                                 
                }                            
            }  
        } 
    }
    
    
    
    public static List PrimsAlgorithm(String node){        
         discoverNeighbors(node);                           
         sortQueue();         
         String start="",end="";         
         
         for(int i=0;i<Queue.size();i++){                      
            start=Queue.get(i).getStart();
            end=Queue.get(i).getEnd();
            int cost=Queue.get(i).getEdgeWeight();
            
            if(!visitedNode.contains(start) && !visitedNode.contains(end)){
                visitedNode.add(start);
                visitedNode.add(end);
                VisitedEdge.add(start+"--"+cost+"--"+end);                
                Queue.remove(i);
                break; }
            else if(visitedNode.contains(start) && !visitedNode.contains(end)){                
                visitedNode.add(end);
                VisitedEdge.add(start+"--"+cost+"--"+end);     
                Queue.remove(i);
                break; }
            else if(!visitedNode.contains(start) && visitedNode.contains(end)){                
                visitedNode.add(end);
                VisitedEdge.add(start+"--"+cost+"--"+end);          
                Queue.remove(i);
                break; }            
         }
         if(visitedNode.size()<5){PrimsAlgorithm(end);   }                  
         return VisitedEdge;
    }
    
    public static void main(String args[]){        
        Scanner scan= new Scanner(System.in);
        Scanner scan2= new Scanner(System.in);
        FileReader file;
        System.out.println("Read from the file");
        
        try {
            file= new FileReader("C:\\Users\\sushma r iliger\\Desktop\\edgeList2.json");              
            readJsonFile(file);
        } catch (FileNotFoundException ex) {}               
        
        System.out.println("Enter 1-> Kruskal's Algorithm or 2->Prims Algorithm :");
        int choice= scan.nextInt();
        
        List <String> result= new ArrayList<String>();
        
        switch(choice){
            case 1:
                result=KruskalsAlgorithm();
                System.out.println("Kruskal's Algorithm Path is : "+result.toString());
                break;
            case 2:
                System.out.println("Enter the starting node name:");
                String startNode=scan2.nextLine();                 
                result=PrimsAlgorithm(startNode);
                System.out.println("Prim's Algorithm Path is : "+result.toString());
                break;
        }
        
    }
}
