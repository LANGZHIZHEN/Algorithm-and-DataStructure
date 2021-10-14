package AizuOJ.Heap;

import java.util.Scanner;

public class MaximumHeap {
    static int n = 0;
    static int[] A = new int[500011];
    static void buildMaxHeap(int[] A){
        for(int i = n/2;i>=1;i--)
        {
            maxHeap(A,i);
        }
    }
    static void swap(int x,int y){
        int item = A[x];
        A[x] = A[y];
        A[y] = item;
    }
    static void maxHeap(int[] A,int index){
        int left = index*2;
        int right = 2*index+1;
        int H = n;
        int largest;
        if(left <= H && A[left] > A[index]){
            largest = left;
        }
        else{
            largest = index;
        }
        if(right <= H && A[largest] < A[right])
        {
            largest = right;
        }
        if(largest != index)
        {
            swap(index,largest);
            maxHeap(A,largest);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for(int i=1;i<=n;i++){
            int key = in.nextInt();
            A[i] = key;
        }
        buildMaxHeap(A);
        for(int i=1;i<=n;i++){
            System.out.print(" "+A[i]);
        }
    }
}
