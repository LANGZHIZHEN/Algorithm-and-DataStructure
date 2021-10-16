package AizuOJ.Graph;

import java.util.Scanner;

public class DepthFirstSearch {
    static int[][] M;
    static int N;
    static int count = 0;
    static int[] find;
    static int[][] val;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = new int[N+1][N+1];
        find = new int[N+1];
        val = new int[N+1][2];
        for(int i=1;i<=N;i++){
            in.nextInt();
            int deg = in.nextInt();
            for(int j=1;j<=deg;j++){
                int index = in.nextInt();
                M[i][index] = 1;
                M[i][i] = 1;
            }
        }
        for(int i=1;i<=N;i++)
        {
            dfs(i);
        }
        for(int i=1;i<=N;i++)
        {
            System.out.println(i+" "+val[i][0]+" "+val[i][1]);
        }
    }

    private static void dfs(int index) {
        for(int j=1;j<=N;j++)
        {
            if(M[index][j] == 1 && find[j] == 0){
                find[j] = 1;
                count++;
                val[j][0] = count;
                dfs(j);
                count++;
                val[j][1] = count;
            }
        }
    }
}
