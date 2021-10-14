package AizuOJ.AdvancedSort;

import java.util.Scanner;

public class Partition {
    public static void swap(int[] A, int i, int j) {
        int item = A[i];
        A[i] = A[j];
        A[j] = item;
    }

    public static int partition(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, i + 1, r);
        return i + 1;
    }

    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        int res = partition(A, 0, A.length - 1);
        for (int i = 0; i < n; i++) {
            if (i > 0)
                System.out.print(" ");
            if (i == res)
                System.out.print("[" + A[i] + "]");
            else
                System.out.print(A[i]);
        }
        System.out.println();
    }
}
