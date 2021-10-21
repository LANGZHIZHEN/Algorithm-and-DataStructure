package AizuOJ.WeightedGraph;

import java.util.Scanner;

public class SingleSourceShortestPath {
    static int N;
    static int[][] G;
    static int[] dist;
    static int[] find;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        G = new int[N][N];
        dist = new int[N];
        find = new int[N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                G[i][j] = 0x7ffffff;
            }
        }
        for(int i=0;i<N;i++)
        {
            in.nextInt();
            int deg = in.nextInt();
            for(int j=0;j<deg;j++)
            {
                int x;
                int val;
                x = in.nextInt();
                val = in.nextInt();
                G[i][x] = val;
            }
        }
        distance();
    }

    private static void distance() {
        dist[0] = 0;
        find[0] = 1;
        for(int i=1;i<N;i++)
        {
            dist[i] = G[0][i];
        }
        int num = N-1;
        while(num > 0)
        {
            int minCost = 0x7ffffff;
            int index = 1;
            for(int j = 1;j<N;j++)
            {
                if(find[j] != 1 && minCost>dist[j])
                {
                    minCost = dist[j];
                    index = j;
                }
            }
            num--;
            find[index] = 1;
            for(int j=1;j<N;j++)
            {
                if(dist[j] > dist[index]+G[index][j])
                {
                    dist[j] = dist[index]+G[index][j];
                }
            }
        }
        for(int i=0;i<N;i++)
        {
            System.out.println(i+" "+dist[i]);
        }
    }

}
