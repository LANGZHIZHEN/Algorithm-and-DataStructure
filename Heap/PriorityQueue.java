package AizuOJ.Heap;

import java.util.Scanner;

public class PriorityQueue {
    static int H;
    static int[] A = new int[2000020];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.next();
        while(!line.equals("end")){
            if(line.charAt(0) == 'i'){
                int data = in.nextInt();
                Insertion(data);
                line = in.next();
            }
            else {
                System.out.println(Extract());
                line = in.next();
            }
        }
    }

    private static int Extract() {
        int data = A[1];
        swap(1,H);
        H--;
        buildMaxHeap(A);
        return data;
    }

    static void buildMaxHeap(int[] A){
        for(int i = H/2;i>=1;i--)
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
    private static void Insertion(int data) {
        H++;
        A[H] = data;
        buildMaxHeap(A);
    }


}
