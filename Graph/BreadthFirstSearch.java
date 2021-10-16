package AizuOJ.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearch {
    static int[][] M;
    static int[] find;
    static int N;
    static int[] val;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = new int[N+1][N+1];
        find = new int[N+1];
        val = new int[N+1];
        for(int i = 1;i<=N;i++){
            in.nextInt();
            int deg = in.nextInt();
            val[i] = -1;
            for(int j = 1;j<=deg;j++){
                int index = in.nextInt();
                M[i][index] = 1;
                M[i][i] = 1;
            }
        }
        bfs(1);
        for(int i = 1;i<=N;i++)
        {
            System.out.println(i+" "+val[i]);
        }
    }

    private static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        int d = 0;
        val[index] = d;
        find[index] = 1;
        while(!queue.isEmpty()){
            int item = queue.poll();
            for(int i = 1;i<=N;i++){
                if(M[item][i] == 1 && find[i] == 0){
                    queue.offer(i);
                    val[i] = val[item]+1;
                    find[i] = 1;
                }
            }
        }
    }


}
