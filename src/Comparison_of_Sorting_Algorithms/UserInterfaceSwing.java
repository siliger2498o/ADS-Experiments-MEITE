package Comparison_of_Sorting_Algorithms;




import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sushma r iliger
 */
public class UserInterfaceSwing extends javax.swing.JFrame {
    private FileReader file;  
    private static int array[];
    
    public UserInterfaceSwing() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_Browse = new javax.swing.JButton();
        lb_FilePath = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        bt_BubbleSort = new javax.swing.JButton();
        bt_InsertionSort = new javax.swing.JButton();
        bt_MergeSort = new javax.swing.JButton();
        bt_QuickSort = new javax.swing.JButton();
        bt_SelectionSort1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_DislaySortedArray = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bt_Browse.setText("Browse File");
        bt_Browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_BrowseActionPerformed(evt);
            }
        });

        lb_FilePath.setText("File name...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sorting Algorithms", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        bt_BubbleSort.setText("Bubble Sort");
        bt_BubbleSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_BubbleSortActionPerformed(evt);
            }
        });

        bt_InsertionSort.setText("Insertion Sort");
        bt_InsertionSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_InsertionSortActionPerformed(evt);
            }
        });

        bt_MergeSort.setText("Merge Sort");
        bt_MergeSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_MergeSortActionPerformed(evt);
            }
        });

        bt_QuickSort.setText("Quick Sort");
        bt_QuickSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_QuickSortActionPerformed(evt);
            }
        });

        bt_SelectionSort1.setText("Selection Sort");
        bt_SelectionSort1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SelectionSort1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_InsertionSort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_BubbleSort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_MergeSort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_QuickSort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_SelectionSort1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_BubbleSort)
                .addGap(8, 8, 8)
                .addComponent(bt_SelectionSort1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_InsertionSort)
                .addGap(18, 18, 18)
                .addComponent(bt_MergeSort)
                .addGap(18, 18, 18)
                .addComponent(bt_QuickSort)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Result", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        ta_DislaySortedArray.setColumns(20);
        ta_DislaySortedArray.setLineWrap(true);
        ta_DislaySortedArray.setRows(5);
        jScrollPane1.setViewportView(ta_DislaySortedArray);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Comparison of Sorting Algorithms");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt_Browse, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lb_FilePath, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Browse)
                    .addComponent(lb_FilePath))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    
    private int[] stringToArray(FileReader fileReader) {
          String str="";
          Scanner sc = new Scanner(fileReader); 
          while (sc.hasNextLine()) 
              str=str+sc.nextLine();            
         int[] Array = Arrays.stream(str.substring(1, str.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();        
         return Array;
    }
    
    private void showResultArray(int result[]){
     
        String resultString="";
        resultString=resultString+"[";         
     for(int i=0;i<result.length;i++){
        resultString=resultString+result[i];         
         if(i<result.length-1){
         resultString=resultString+",";          
         }
      }
        resultString=resultString+"]"; 
       
         ta_DislaySortedArray.setText("");
         ta_DislaySortedArray.setText(resultString);
 }
    
    
    private void bt_BrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_BrowseActionPerformed
        try {
            this.file= new FileReader("C:\\Users\\sushma r iliger\\Desktop\\ME ITE Folder\\ADS Expt\\Expt2 Comparison of sorting algorithms\\Arrayfile.txt");
            lb_FilePath.setText(this.file.toString());                 
            this.array =stringToArray(this.file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserInterfaceSwing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_BrowseActionPerformed

    private void bt_MergeSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_MergeSortActionPerformed
            Instant start = Instant.now();
            Sorting_Algorithms sorting=new Sorting_Algorithms();
            int sortedArray[]=sorting.mergeSort(array);
             Instant end = Instant.now();
             Duration timeElapsed = Duration.between(start, end);
             System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");            
            showResultArray(sortedArray);
              
    }//GEN-LAST:event_bt_MergeSortActionPerformed

    private void bt_BubbleSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_BubbleSortActionPerformed
             Instant start = Instant.now();
             Sorting_Algorithms sorting=new Sorting_Algorithms();
             int sortedArray[]=sorting.bubbleSort(array);
             Instant end = Instant.now();
             Duration timeElapsed = Duration.between(start, end);
             System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
             showResultArray(sortedArray);
             
    }//GEN-LAST:event_bt_BubbleSortActionPerformed

    private void bt_InsertionSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_InsertionSortActionPerformed
             Instant start = Instant.now(); 
            Sorting_Algorithms sorting=new Sorting_Algorithms();
             int sortedArray[]=sorting.insertionSort(array);
              Instant end = Instant.now();
             Duration timeElapsed = Duration.between(start, end);
             System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");            
             showResultArray(sortedArray);             
    }//GEN-LAST:event_bt_InsertionSortActionPerformed

    private void bt_QuickSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_QuickSortActionPerformed
         Instant start = Instant.now();
        Sorting_Algorithms sorting=new Sorting_Algorithms();
             int sortedArray[]=sorting.quickSort(array,0,(array.length-1));
              Instant end = Instant.now();
             Duration timeElapsed = Duration.between(start, end);
             System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");            
             showResultArray(sortedArray);             
    }//GEN-LAST:event_bt_QuickSortActionPerformed

    private void bt_SelectionSort1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SelectionSort1ActionPerformed
        Instant start = Instant.now();
        Sorting_Algorithms sorting=new Sorting_Algorithms();
        int sortedArray[]=sorting.selectionSort(array);
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
        showResultArray(sortedArray);

    }//GEN-LAST:event_bt_SelectionSort1ActionPerformed

    public static void main(String args[]) {        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserInterfaceSwing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Browse;
    private javax.swing.JButton bt_BubbleSort;
    private javax.swing.JButton bt_InsertionSort;
    private javax.swing.JButton bt_MergeSort;
    private javax.swing.JButton bt_QuickSort;
    private javax.swing.JButton bt_SelectionSort1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_FilePath;
    private static javax.swing.JTextArea ta_DislaySortedArray;
    // End of variables declaration//GEN-END:variables

}
