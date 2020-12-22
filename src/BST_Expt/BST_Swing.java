package BST_Expt;


import java.io.*;
import java.util.Iterator;
import java.util.logging.*;
import javafx.stage.FileChooser;
import javax.swing.*;
import org.json.simple.parser.*;
import org.json.simple.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sushma r iliger
 */
public class BST_Swing extends javax.swing.JFrame {
    private FileReader file;
    public static BSTNodes root;
    public static boolean insertionFlag=false,nodeFoundFlag=false;
    private static JSONArray jsonObjectHolder=new JSONArray();
    
    public BST_Swing() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_Browse = new javax.swing.JButton();
        lb_FilePath = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lb_SSN = new javax.swing.JLabel();
        lb_Name = new javax.swing.JLabel();
        lb_Department = new javax.swing.JLabel();
        lb_Salary = new javax.swing.JLabel();
        tf_SSN = new javax.swing.JTextField();
        tf_Name = new javax.swing.JTextField();
        tf_Department = new javax.swing.JTextField();
        tf_Salary = new javax.swing.JTextField();
        bt_Submit = new javax.swing.JButton();
        bt_Update = new javax.swing.JButton();
        bt_Search = new javax.swing.JButton();
        bt_DeleteNode = new javax.swing.JButton();
        bt_ResetFields = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        bt_Display = new javax.swing.JButton();
        cmb_BstTraversing = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_DislayTraversal = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        bt_SaveChanges = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bt_Browse.setText("Browse File");
        bt_Browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_BrowseActionPerformed(evt);
            }
        });

        lb_FilePath.setText("File name...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Insert/Search/Update New Employee Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lb_SSN.setText("SSN :");

        lb_Name.setText("Name :");

        lb_Department.setText("Department :");

        lb_Salary.setText("Salary :");

        bt_Submit.setText("Insert");
        bt_Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SubmitActionPerformed(evt);
            }
        });

        bt_Update.setText("Update");
        bt_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_UpdateActionPerformed(evt);
            }
        });

        bt_Search.setText("Search");
        bt_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SearchActionPerformed(evt);
            }
        });

        bt_DeleteNode.setText("Delete");
        bt_DeleteNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_DeleteNodeActionPerformed(evt);
            }
        });

        bt_ResetFields.setText("Reset Fields");
        bt_ResetFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ResetFieldsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lb_SSN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tf_SSN, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(lb_Name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lb_Department))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt_Submit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Update)
                        .addGap(44, 44, 44)
                        .addComponent(bt_Search)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tf_Department, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lb_Salary))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(bt_DeleteNode)
                        .addGap(40, 40, 40)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_ResetFields)
                    .addComponent(tf_Salary, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_SSN)
                    .addComponent(tf_SSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_Name)
                    .addComponent(tf_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_Department)
                    .addComponent(tf_Department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_Salary)
                    .addComponent(tf_Salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Submit)
                    .addComponent(bt_Update)
                    .addComponent(bt_Search)
                    .addComponent(bt_DeleteNode)
                    .addComponent(bt_ResetFields))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Diplay BST ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        bt_Display.setText("Display");
        bt_Display.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_DisplayActionPerformed(evt);
            }
        });

        cmb_BstTraversing.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Preorder", "Inorder", "Postorder", "Levelorder" }));

        ta_DislayTraversal.setColumns(20);
        ta_DislayTraversal.setLineWrap(true);
        ta_DislayTraversal.setRows(5);
        jScrollPane1.setViewportView(ta_DislayTraversal);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bt_Display)
                        .addGap(29, 29, 29)
                        .addComponent(cmb_BstTraversing, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 422, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Display)
                    .addComponent(cmb_BstTraversing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("BINARY SEARCH TREE");

        bt_SaveChanges.setText("Save Changes");
        bt_SaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SaveChangesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(bt_Browse, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lb_FilePath, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_SaveChanges)
                        .addGap(47, 47, 47))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Browse)
                    .addComponent(lb_FilePath)
                    .addComponent(bt_SaveChanges))
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public  void insertNode(BSTNodes currentParent,BSTNodes newnode){         
        if(currentParent==null){
           root=newnode;
        }
        else{                          
            if(currentParent.getSocialSecurityNumber()<newnode.getSocialSecurityNumber()){
                if(currentParent.getRightChild()==null){                        
                    currentParent.setRightChild(newnode);
                    insertionFlag=true;
                }
                else{
                    insertNode(currentParent.getRightChild(),newnode);
                }
            }
            else if(currentParent.getSocialSecurityNumber()>newnode.getSocialSecurityNumber()){
                if(currentParent.getLeftChild()==null){                    
                    currentParent.setLeftChild(newnode);
                    insertionFlag=true;                    
                }
                else{
                    insertNode(currentParent.getLeftChild(),newnode);
                }
            }
        }          
    }
       
    public static BSTNodes search(int ssn, BSTNodes currentNode){    
    if (currentNode==null)
    {
        nodeFoundFlag=false;
        return null;
    }
    else if(currentNode.getSocialSecurityNumber()<ssn)
    {
        return search(ssn, currentNode.getRightChild()); 
    }
    else if(currentNode.getSocialSecurityNumber()>ssn)
    {
        return search(ssn, currentNode.getLeftChild());
    }
    else if(currentNode.getSocialSecurityNumber()==ssn)
    {
        nodeFoundFlag=true;                
        return currentNode;
    }
    return null;
    }
    
    public static BSTNodes delete(BSTNodes currentNode, int x){        
        int ssn=currentNode.getSocialSecurityNumber();
        if(currentNode==null)
        {  
            return null;
        }
        else if (ssn>x)
        {               
             currentNode.setLeftChild(delete(currentNode.getLeftChild(), x));            
        }
        else if(ssn<x)
        {                     
            currentNode.setRightChild(delete(currentNode.getRightChild(), x));
        }
        else if(x==ssn)
        {                        
            if(currentNode.getLeftChild()==null && currentNode.getRightChild()==null)
            {
                currentNode = null;
                return null;
            }          
            else if(currentNode.getLeftChild()==null || currentNode.getRightChild()==null)
            {
                BSTNodes temp;
                if(currentNode.getLeftChild()==null)
                {    temp = currentNode.getRightChild();
                    currentNode = null;
                    return temp;
                }
                else
                { 
                    temp = currentNode.getLeftChild();
                    currentNode = null;
                    return temp;
                }
            }
            else
            {                                           
                BSTNodes temp = findMinimum(currentNode.getRightChild());                                
                currentNode.setSocialSecurityNumber(temp.getSocialSecurityNumber());
                currentNode.setEmployeeDetails(temp.getEmloyeeDetails());
                currentNode.setRightChild(delete(currentNode.getRightChild(), temp.getSocialSecurityNumber()));
            }
        }                
        return currentNode;
    }

    
     public static BSTNodes findMinimum(BSTNodes currentNode){
        if(currentNode==null)
        {    return null;}
        else if(currentNode.getLeftChild() != null) 
        {  System.out.println(currentNode.getLeftChild().getSocialSecurityNumber());
            return findMinimum(currentNode.getLeftChild());
        }
        return currentNode;
    }

    public void preorderTraverse(BSTNodes currentParent){          
        if(currentParent!=null){             
            String nodedata="\n"+currentParent.getSocialSecurityNumber()+"->"+currentParent.getEmloyeeDetails();           
            ta_DislayTraversal.append(nodedata);           
            preorderTraverse(currentParent.getLeftChild());            
            preorderTraverse(currentParent.getRightChild());
            
        }            
    }
    
    public  void inorderTraverse(BSTNodes currentParent){                                 
        if(currentParent!=null){ 
            inorderTraverse(currentParent.getLeftChild());            
            String nodedata="\n"+currentParent.getSocialSecurityNumber()+"->"+currentParent.getEmloyeeDetails();            
            ta_DislayTraversal.append(nodedata);           
            inorderTraverse(currentParent.getRightChild());
        }            
    }
    
    public  void postorderTraverse(BSTNodes currentParent){                          
        if(currentParent!=null){ 
            postorderTraverse(currentParent.getLeftChild());                        
            postorderTraverse(currentParent.getRightChild());            
            String nodedata="\n"+currentParent.getSocialSecurityNumber()+"->"+currentParent.getEmloyeeDetails();            
            ta_DislayTraversal.append(nodedata);            
        }            
    }
    public void writeJsonFile(){
        try{             
            JFileChooser j = new JFileChooser();
            int r=j.showOpenDialog(null);                                                             
            try {            
                if (r == JFileChooser.APPROVE_OPTION)
            {
                FileWriter fileWriter = new FileWriter(j.getSelectedFile().getAbsolutePath());                                           
                readJsonFile(this.file);
                JSONObject jsonObjectMain=new JSONObject();
                jsonObjectMain.put("Employee",jsonObjectHolder);
                fileWriter.write(jsonObjectMain.toJSONString());                        
                fileWriter.close();            
            }                        
            }catch(Exception e){}                             
            
           
        }catch(Exception e){}              
    }
    public  void storeJson(BSTNodes currentParent){                          
        //Root, Left, Right
        if(currentParent!=null){                         
            JSONObject newdata=new JSONObject();
            JSONObject empDetails=new JSONObject();            
            
            try {                     
                JSONParser parser = new JSONParser();  
                JSONObject json= (JSONObject) parser.parse(currentParent.getEmloyeeDetails());                
                empDetails.put("name",json.get("name").toString());
                empDetails.put("department",json.get("department").toString());
                empDetails.put("salary",json.get("salary").toString());            
            } catch (ParseException ex) {
                Logger.getLogger(BST_Swing.class.getName()).log(Level.SEVERE, null, ex);
            }                       
            
            newdata.put("socialSecurityNumber",currentParent.getSocialSecurityNumber());
            newdata.put("empDetails",empDetails);            
            jsonObjectHolder.add(newdata);
            storeJson(currentParent.getLeftChild());            
            storeJson(currentParent.getRightChild());
        }            
    }
    
    
    public void readJsonFile(FileReader file){
    try{
     JSONParser jsonParser = new JSONParser();            
            Object obj = jsonParser.parse(file);
            JSONObject jsonObject = (JSONObject) obj;                    
            JSONArray jsonArray = new JSONArray();
            Object obj1=jsonObject.get("Employee");   
            jsonArray= (JSONArray)obj1;   
            root=new BSTNodes();
            root=null;          
             for(int i=0;i<jsonArray.size();i++){                 
                 BSTNodes newnode=new BSTNodes();
                 System.out.println(jsonArray.get(i).toString());
                 newnode.setNodeDetails(jsonArray.get(i).toString());
                 insertNode(root,newnode);            
             }             
             file.close();
        }catch(Exception e){}    
    }

    public void reset(){
            tf_SSN.setText("");
            tf_Department.setText("");
            tf_Name.setText("");
            tf_Salary.setText("");                               
    }
    private void bt_BrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_BrowseActionPerformed
//        try {
//            this.file= new FileReader("ur path");
//            lb_FilePath.setText(this.file.toString());                 
//            readJsonFile(this.file);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(BST_Swing.class.getName()).log(Level.SEVERE, null, ex);
//        }
        JFileChooser j = new JFileChooser();
          int r=j.showOpenDialog(null);                                                             
            try {            
                if (r == JFileChooser.APPROVE_OPTION)
            {
                this.file= new FileReader(j.getSelectedFile().getAbsolutePath());
                lb_FilePath.setText(j.getSelectedFile().getAbsolutePath());                 
                readJsonFile(this.file);
            }             
            else
            {
                lb_FilePath.setText("The user cancelled the operation"); 
            } 
            }catch(Exception e){}              
    }//GEN-LAST:event_bt_BrowseActionPerformed

    private void bt_DeleteNodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_DeleteNodeActionPerformed
       int id=Integer.parseInt(tf_SSN.getText());
       root=delete(root, id);       
    }//GEN-LAST:event_bt_DeleteNodeActionPerformed

    private void bt_DisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_DisplayActionPerformed
        
        String choice = cmb_BstTraversing.getSelectedItem().toString();
        switch(choice){
            case "Preorder":
                ta_DislayTraversal.setText("");           
                preorderTraverse(root);
                break;
            case "Inorder":
                ta_DislayTraversal.setText("");           
                inorderTraverse(root);
                break;
            case "Postorder":
                ta_DislayTraversal.setText("");           
                postorderTraverse(root);
                break;
            case "Levelorder":
                break;
        }                
    }//GEN-LAST:event_bt_DisplayActionPerformed

    private void bt_SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SubmitActionPerformed
        if(tf_Name.getText().equals("")|| tf_Department.getText().equals("")|| tf_Salary.getText().equals("")|| tf_SSN.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Fill all the fields");
        }
        else
        {
            JSONObject empDetails=new JSONObject();
            empDetails.put("name", tf_Name.getText());
            empDetails.put("department",tf_Department.getText());
            empDetails.put("salary",tf_Salary.getText());
            JSONObject newdata=new JSONObject();
            newdata.put("socialSecurityNumber",tf_SSN.getText());
            newdata.put("empDetails",empDetails);
            
            BSTNodes newnode=new BSTNodes();
            newnode.setNodeDetails(newdata.toString());
            insertNode(root,newnode);             
            if(insertionFlag){
               JOptionPane.showMessageDialog(rootPane, "Insertion successfull");
               reset();
               insertionFlag=false;
            }
            else if(!insertionFlag){                
               JOptionPane.showMessageDialog(rootPane, "Insertion failed");            
            }
        }        
    }//GEN-LAST:event_bt_SubmitActionPerformed
    
    private void bt_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SearchActionPerformed
        BSTNodes nodeFound=new BSTNodes();
        nodeFound = search((Integer.parseInt(tf_SSN.getText())),root);
        if(nodeFound!=null){            
            tf_SSN.setText(""+nodeFound.getSocialSecurityNumber());
            String nodedData=nodeFound.getEmloyeeDetails();            
            try {                     
                JSONParser parser = new JSONParser();  
                JSONObject json = (JSONObject) parser.parse(nodedData);
                tf_Department.setText(json.get("department").toString());
                tf_Name.setText(json.get("name").toString());
                tf_Salary.setText(json.get("salary").toString());
            } catch (ParseException ex) {
                Logger.getLogger(BST_Swing.class.getName()).log(Level.SEVERE, null, ex);
            }         
        }
        else{
            reset();
            JOptionPane.showMessageDialog(rootPane,"Node not found");
        }
    }//GEN-LAST:event_bt_SearchActionPerformed

    public void update(){
            
        if(tf_Name.getText().equals("")|| tf_Department.getText().equals("")|| 
                tf_Salary.getText().equals("")|| tf_SSN.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Fill all the fields");
        }
        else
        {
            int ssn=Integer.parseInt(tf_SSN.getText());
            BSTNodes currentNode =new BSTNodes();
            currentNode=search(ssn, root);
            
            if(nodeFoundFlag){
            JSONObject empDetails=new JSONObject();
            empDetails.put("name", tf_Name.getText());
            empDetails.put("department",tf_Department.getText());
            empDetails.put("salary",tf_Salary.getText());            
 
            currentNode.setEmployeeDetails(empDetails.toString());
               
               JOptionPane.showMessageDialog(rootPane, "Update successfull"); 
               nodeFoundFlag=false;
            }
            else if(!nodeFoundFlag){
               JOptionPane.showMessageDialog(rootPane, "Updation failed");            
            }
        } 
    }
    
    private void bt_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_UpdateActionPerformed
    update();
    }//GEN-LAST:event_bt_UpdateActionPerformed

    private void bt_ResetFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ResetFieldsActionPerformed
        
        reset();
        
    }//GEN-LAST:event_bt_ResetFieldsActionPerformed

    private void bt_SaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SaveChangesActionPerformed
        jsonObjectHolder.clear();
        storeJson(root);
        writeJsonFile();
    }//GEN-LAST:event_bt_SaveChangesActionPerformed

    public static void main(String args[]) {        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BST_Swing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Browse;
    private javax.swing.JButton bt_DeleteNode;
    private javax.swing.JButton bt_Display;
    private javax.swing.JButton bt_ResetFields;
    private javax.swing.JButton bt_SaveChanges;
    private javax.swing.JButton bt_Search;
    private javax.swing.JButton bt_Submit;
    private javax.swing.JButton bt_Update;
    private javax.swing.JComboBox cmb_BstTraversing;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_Department;
    private javax.swing.JLabel lb_FilePath;
    private javax.swing.JLabel lb_Name;
    private javax.swing.JLabel lb_SSN;
    private javax.swing.JLabel lb_Salary;
    private static javax.swing.JTextArea ta_DislayTraversal;
    private javax.swing.JTextField tf_Department;
    private javax.swing.JTextField tf_Name;
    private javax.swing.JTextField tf_SSN;
    private javax.swing.JTextField tf_Salary;
    // End of variables declaration//GEN-END:variables
}
