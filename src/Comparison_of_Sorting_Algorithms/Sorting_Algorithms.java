package Comparison_of_Sorting_Algorithms;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sushma r iliger
 */
public class Sorting_Algorithms {
    public static int[] inputArray;
 
  public int[] bubbleSort(int Array[]){                  
     for(int i=0;i<Array.length;i++){
         for(int j=1;j<(Array.length-i);j++){
             if(Array[j-1] > Array[j]){
                int temp = Array[j-1];
                Array[j-1]=Array[j];
                Array[j]=temp;
             }
         }
     }
     return Array;
 }
 
 public  int[] insertionSort(int Array[]){     
     for(int i=0;i<Array.length;i++){
         for(int j=i;j>0;j--){             
             if(Array[j]<Array[j-1]){
                 int temp=Array[j-1];
                 Array[j-1]=Array[j];
                 Array[j]=temp;                 
             }
         }
     }
     return Array;
 }
 
 public  int[] imrovisedInsertionSort(int Array[]){
     boolean swapped=false;
     for(int i=0;i<Array.length;i++){
         for(int j=i;j>0;j--){
             swapped=false;
             if(Array[j]<Array[j-1]){
                 int temp=Array[j-1];
                 Array[j-1]=Array[j];
                 Array[j]=temp;
                 swapped=true;
             }
             if(!swapped){
                 break;
             }
         }
     }
     return Array;
 }
 
 public int[] selectionSort(int Array[]){
     for(int p=0;p<Array.length;p++){
         int minIndex=p;
         for(int q=p+1;q<Array.length;q++){
             if(Array[q]<Array[minIndex]){
                 minIndex=q;
             }
         }
         if(minIndex!=p){
             int temp=Array[p];
             Array[p]=Array[minIndex];
             Array[minIndex]=temp;
         }
     }
     return Array;
 }
 
 public int[] mergeSort(int Array[]){
     inputArray=Array.clone();
     mergeSort(inputArray,0,(inputArray.length-1)); 
     return inputArray;
 }
 
  private void merge(int array[], int left, int mid, int right) {
    int n1 = mid - left + 1, n2 = right - mid;
    int subArray1[] = new int[n1], subArray2[] = new int[n2];
    
    for (int i = 0; i < n1; i++)
      subArray1[i] = array[left + i];
    for (int j = 0; j < n2; j++)
      subArray2[j] = array[mid + 1 + j];
    int i = 0,  j = 0, k = left;    
    
    while (i < n1 && j < n2) {
      if (subArray1[i] <= subArray2[j]) {
        array[k] = subArray1[i];
        i++;
      } else {
        array[k] = subArray2[j];
        j++;
      }
      k++;
    }
    while (i < n1) {
      array[k] = subArray1[i];
      i++;  k++;
    }
    while (j < n2) {
      array[k] = subArray2[j];
      j++;  k++;
    }
  }
 
  private void mergeSort(int array[], int left, int right) {
    if (left < right) {     
      int mid = (left + right) / 2;     
      mergeSort(array, left, mid);
      mergeSort(array, mid + 1, right);   
      merge(array, left, mid, right);
    }
  }

public  int[] quickSort(int arr[], int start, int end) {
    if (start < end) {
        int pIndex = partition(arr, start, end);
        quickSort(arr, start, pIndex - 1);
        quickSort(arr, pIndex + 1, end);
    }
    return arr;   
}

private int partition(int arr[], int start, int end) {
    int pivot = arr[end];
    int pIndex = start;
	for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                    swap(arr, i, pIndex);
                    pIndex++;
            }		
        }			
	swap(arr, pIndex, end);
	return pIndex;
	}

private void swap(int arr[], int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
}


}