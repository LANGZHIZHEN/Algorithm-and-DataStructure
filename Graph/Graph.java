package AizuOJ.Graph;

import java.util.Scanner;

public class Graph {
    static int[][] M;
    static int N;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = new int[N+1][N+1];
        int deg;
        for(int i = 1;i<=N;i++)
        {
            in.nextInt();
            deg = in.nextInt();
            for(int j=1;j<=deg;j++){
                int vertex = in.nextInt();
                M[i][vertex] = 1;
            }
        }
        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=N;j++)
            {
                if(j > 1)
                    System.out.print(" ");
                System.out.print(M[i][j]);
            }
            System.out.println();
        }
    }
}
