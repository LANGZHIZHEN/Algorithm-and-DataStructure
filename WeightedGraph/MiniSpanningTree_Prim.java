package AizuOJ.WeightedGraph;

import java.util.Scanner;

public class MiniSpanningTree_Prim {
    static int N;
    static int[][] G;
    static int[] lowCost;
    static int[] find;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        G = new int[N][N];
        lowCost = new int[N];
        find = new int[N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                G[i][j] = in.nextInt();
                if(G[i][j] == -1)
                    G[i][j] = 0xffffff;
            }
        }
        int ans = prim();
        System.out.println(ans);
    }
    public static int prim()
    {
        for(int i=0;i<N;i++)
        {
            lowCost[i] = 0xffffff;
        }
        lowCost[0] = 0;
        find[0] = 1;
        for(int i=1;i<N;i++)
        {
            lowCost[i] = G[0][i];
        }
        for(int i=1;i<N;i++)
        {
            int minCost = 0xffffff;
            int index = 0;
            for(int j=1;j<N;j++)
            {
                if(minCost > lowCost[j] && find[j] != 1)
                {
                    minCost = lowCost[j];
                    index = j;
                }
            }
            find[index] = 1;
            lowCost[index] = minCost;
            for(int k=1;k<N;k++)
            {
                if(G[index][k] < lowCost[k] && find[k] != 1)
                {
                    lowCost[k] = G[index][k];
                }
            }
        }
        int sum = 0;
        for(int i=0;i<N;i++)
        {
            sum += lowCost[i];
        }
        return sum;
    }
}
