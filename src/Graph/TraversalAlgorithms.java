package Graph;

import java.io.*;
import java.util.*;
import static jdk.nashorn.internal.runtime.Context.printStackTrace;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author sushma r iliger
 */
public class TraversalAlgorithms {
    public static Node root;
    public static List <Node> edgeList=new ArrayList<Node>();
    public static List <String> visitedNode=new ArrayList<String>();
    public static List <String> Queue=new ArrayList<String>();        
      
    public static void readJsonFile(FileReader file){
    try{
     JSONParser jsonParser = new JSONParser();            
     Object obj = jsonParser.parse(file);
     JSONObject jsonObject = (JSONObject) obj;                    
     JSONArray jsonArray = new JSONArray();
     Object obj1=jsonObject.get("edge");   
     jsonArray= (JSONArray)obj1;                           
     for(int i=0;i<jsonArray.size();i++){                 
                 Node newnode=new Node();
                 List<String> list = new ArrayList<String>();                  
                 JSONObject nodeDetails= (JSONObject)(jsonArray.get(i));     
                 String nodeName=nodeDetails.get("node").toString();
                 JSONArray jsonList = (JSONArray)nodeDetails.get("neighbors");
                 for (int j = 0; j < jsonList.size(); j++) {
                     list.add(jsonList.get(j).toString());
                 }
                 newnode.setNodeDetails(nodeName,list);
                 edgeList.add(newnode);
     }             
     file.close();
    }catch(Exception e){}    
    }
    
    public static void main(String arg[]){
        Scanner scan= new Scanner(System.in);
        Scanner scan2= new Scanner(System.in);
        FileReader file;
        System.out.println("Read from the file");
        try {
            file= new FileReader("C:\\Users\\sushma r iliger\\Desktop\\adjacencyList2.json");  
            readJsonFile(file);
        } catch (FileNotFoundException ex) {}
        
        System.out.println("Enter 1 -> BFS and 2 -> DFS :");        
        int choice=scan.nextInt();
        System.out.println("Enter the Starting node name :");       
        String startNode=scan2.nextLine();
        List <String> result= new ArrayList<String>();
        result=Traversal(startNode, choice);
                                               
    }
    
    public static void BFS(){     
            String name=Queue.get(0);
            Queue.remove(0);
            Traversal(name,1);                
    }
    
    public static void DFS(){    
            String name=Queue.get(Queue.size()-1);
            Queue.remove(Queue.size()-1);
            Traversal(name,2);                
    }
    public static List Traversal(String nodeName,int choice){
        Node temp=new Node();
        for(int i=0;i<edgeList.size();i++){        
            temp=edgeList.get(i);            
            if(temp.getNodeName().equals(nodeName)){                
               break; 
            }            
        }
        
        visitedNode.add(temp.getNodeName());
        
        List <String> tempList=new ArrayList<String>();        
        tempList=temp.getNodeNeighbor();        
        for(int i=0;i<tempList.size();i++){
            if(!visitedNode.contains(tempList.get(i)) && !Queue.contains(tempList.get(i))){
                Queue.add(tempList.get(i));
            }
        }
        System.out.println("Queue :"+Queue);
        System.out.println("Visited List :"+visitedNode);        
        
        if(Queue.size()!=0){
        if(choice==1){
            BFS();
        }
        else if(choice==2){
            DFS();
        }
        }
        return visitedNode;
    }        
}
