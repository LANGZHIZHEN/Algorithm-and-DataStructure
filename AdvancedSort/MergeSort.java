package AizuOJ.AdvancedSort;

import java.util.Scanner;

public class MergeSort {
    public static int sum = 0;
    public static void merge(int[] A, int left, int mid, int right)
    {
        int l1 = mid - left + 1;
        int l2 = right - mid;
        int []L1 = new int[l1];
        int []L2 = new int[l2];
        for(int i=0;i<l1;i++)
        {
            L1[i] = A[i+left];
        }
        for(int i=0;i<l2;i++)
        {
            L2[i] = A[i+mid+1];
        }
        int i=0,j=0,k=left;
        while(i<l1 && j<l2)
        {
            if(L1[i]<L2[j])
                A[k++] = L1[i++];
            else
                A[k++] = L2[j++];
        }
        while(i<l1)
        {
            A[k++] = L1[i++];
        }
        while(j<l2)
        {
            A[k++] = L2[j++];
        }

    }
    public static void mergeSort(int[] A, int left, int right)
    {
        if(left<right)
        {
            int mid = (left+right)/2;
            mergeSort(A,left,mid);
            mergeSort(A,mid+1,right);
            merge(A,left,mid,right);
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int[] A = new int[n];
        for(int i=0;i<n;i++){
            A[i] = in.nextInt();
        }
        mergeSort(A,0,n-1);
        for(int item : A){
            System.out.print(item);
            System.out.print(" ");
        }
    }
}
