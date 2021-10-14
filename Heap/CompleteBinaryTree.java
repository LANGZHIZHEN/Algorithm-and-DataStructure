package AizuOJ.Heap;

import java.util.Scanner;

public class CompleteBinaryTree {
    static int parent(int i){
        return i/2;
    }
    static int left(int i){
        return 2*i;
    }
    static int right(int i){
        return 2*i+1;
    }
    static int[] A = new int[10000];

    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for(int i=1;i<=n;i++)
        {
            int key = in.nextInt();
            A[i] = key;
        }
        for (int i = 1; i <= n; i++) {
            System.out.printf("node %d: key = %d, ", i, A[i]);
            if (parent(i) >= 1)
                System.out.printf("parent key = %d, ", A[parent(i)]);
            if (left(i) <= n)
                System.out.printf("left key = %d, ", A[left(i)]);
            if (right(i) <= n)
                System.out.printf("right key = %d, ", A[right(i)]);
            System.out.println();
        }
    }
}
