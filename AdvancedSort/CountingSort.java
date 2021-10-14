package AizuOJ.AdvancedSort;

import demo8Internet.InetAddressTest;

import java.util.ArrayList;
import java.util.Scanner;


public class CountingSort {
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int[] A = new int[n];
        int[] C = new int[10010];
        int Max = 0;
        for(int i=0;i<n;i++) {
            int key = in.nextInt();
            A[i] = key;
            Max = Math.max(A[i],Max);
            C[key]++;
        }
        int[] B = new int[n+1];
        for(int i=1;i<=Max;i++)
        {
            C[i] += C[i-1];
        }
        for(int i=0;i<n;i++)
        {
            B[C[A[i]]] = A[i];
            C[A[i]]--;
        }
        for(int i=1;i<=n;i++)
        {
            if(i>1)
                System.out.print(" ");
            System.out.print(B[i]);
        }
        System.out.println();
    }
}
