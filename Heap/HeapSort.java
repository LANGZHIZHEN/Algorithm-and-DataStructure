package AizuOJ.Heap;

import java.util.Scanner;

public class HeapSort {
    static int[] A = new int[1000];
    static int H;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        H = in.nextInt();
        for(int i=1;i<=H;i++){
            int key = in.nextInt();
            A[i] = key;
        }
        heapSort();
        for(int i=1;i<=H;i++){
            System.out.println(A[i]);
        }
    }
    static void buildMaxHeap(int[] A,int len){
        for(int i = len/2;i>=1;i--)
        {
            maxHeap(A,i,len);
        }
    }
    static void swap(int x,int y){
        int item = A[x];
        A[x] = A[y];
        A[y] = item;
    }
    static void maxHeap(int[] A,int index,int len){
        int left = index*2;
        int right = 2*index+1;
        int largest;
        if(left <= len && A[left] > A[index]){
            largest = left;
        }
        else{
            largest = index;
        }
        if(right <= len && A[largest] < A[right])
        {
            largest = right;
        }
        if(largest != index)
        {
            swap(index,largest);
            maxHeap(A,largest,len);
        }
    }
    private static void heapSort() {
        for(int i=H;i>=1;i--) {
            buildMaxHeap(A, i);
            swap(1,i);
        }
    }
}
