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
public class FloydWarshallAlgorithm {
    public static List <EdgeInformation> unvisitedEdgeList =new ArrayList<EdgeInformation>();
    public static List <String> nodeList=new ArrayList<String>();
    public static int iterator=0,distanceMatrix[][];
    public static void readJsonFile(FileReader file){
    try{    
     JSONParser jsonParser = new JSONParser();            
     Object obj = jsonParser.parse(file);
     JSONObject jsonObject = (JSONObject) obj;                         
     
     Object obj1=jsonObject.get("node");
     JSONArray jsonArray2 = new JSONArray();           
     jsonArray2= (JSONArray)obj1;          
     for(int i=0;i<jsonArray2.size();i++){              
         String newnode=jsonArray2.get(i).toString();
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
    
    public static void createFirstDistance(){
        for(int i=0;i<nodeList.size()-1;i++){
            for(int j=0;j<nodeList.size()-1;j++){
                if(i==j){
                    distanceMatrix[i][j]=0;
                }
                else{
                    String start=Integer.toString(i),end=Integer.toString(j); int w=1000;
                    for(int k=0;k<unvisitedEdgeList.size();k++){
                        if(unvisitedEdgeList.get(k).getStart().equals(start) && 
                                unvisitedEdgeList.get(k).getEnd().equals(end)){
                            w=unvisitedEdgeList.get(k).getEdgeWeight();
                            break;
                        }
                    }
                    distanceMatrix[i][j]=w;
                }
            }
        }        
        printMatrix(distanceMatrix);        
    }
    
    public static void FloydWarshallAlgo(){
        int distMatrix[][]=new int[nodeList.size()][nodeList.size()];
        for(int i=0;i<nodeList.size()-1;i++){
            for(int j=0;j<nodeList.size()-1;j++){
                if(i==j){
                    distMatrix[i][j]=0;
                }
            }
        }
        for(int i=0;i<nodeList.size();i++){
            distMatrix[iterator][i]=distanceMatrix[iterator][i];
            distMatrix[i][iterator]=distanceMatrix[i][iterator];
        }
        for(int i=0;i<nodeList.size();i++){
            for(int j=0;j<nodeList.size();j++){
                if(i!=iterator && j!=iterator){
                    int cost1=distanceMatrix[i][iterator]+distanceMatrix[iterator][j];
                    int cost2=distanceMatrix[i][j];
                    distMatrix[i][j]=getMin(cost1,cost2);
                }
            }
        }
        System.out.println("\nIteration "+iterator);
        printMatrix(distMatrix);
        copyMatrix(distMatrix);
        iterator++;
        if(iterator<nodeList.size()-1){
            FloydWarshallAlgo();
        }
    }    
    public static int getMin(int c1,int c2){
        if(c1<c2){return c1;}
        else if(c1>c2){return c2;}
        else{return c1;}
    }
    public static void copyMatrix(int distMat[][]){
        for(int i=0;i<nodeList.size()-1;i++){
            for(int j=0;j<nodeList.size()-1;j++){
                distanceMatrix[i][j]=distMat[i][j];
            }            
        }
    }
    public static void printMatrix(int distMat[][]){
        for(int i=0;i<nodeList.size()-1;i++){
            for(int j=0;j<nodeList.size()-1;j++){
                System.out.print(distMat[i][j]+"\t");
            }
            System.out.println("");
        }
    }
    public static void main(String args[]){
         Scanner scan= new Scanner(System.in);           
           FileReader file;                
           try {
               file= new FileReader("C:\\Users\\sushma r iliger\\Desktop\\FloydWarshallAlgo_edgelist.json");              
               readJsonFile(file);
           } catch (FileNotFoundException ex) {}                       
           distanceMatrix=new int[nodeList.size()][nodeList.size()];
           createFirstDistance();
           FloydWarshallAlgo();

    }

}
