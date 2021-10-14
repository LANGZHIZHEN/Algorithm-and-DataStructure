package AizuOJ.DynamicProgramming;

import java.util.Scanner;

public class MatrixChainMultiplication {
    static int N;
    static int[] matrix;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        matrix = new int[N+2];
        for(int i=1;i<=N;i++){
            matrix[i-1] = in.nextInt();
            matrix[i] = in.nextInt();
        }
        int[][] dp = new int[N+1][N+1];
        for(int i=1;i<=N;i++)
        {
            dp[i][i] = 0;
        }
        for(int l=2;l<=N;l++){
            for(int i= 1;i<=N - l + 1;i++)
            {
                int j = i+l-1;
                dp[i][j] = (1<<21);
                for(int k = i;k<j;k++){
                    dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+matrix[i-1]*matrix[k]*matrix[j]);
                }
            }
        }
        System.out.println(dp[1][N]);
    }
}
