package AizuOJ.WeightedGraph;

import java.util.*;

/**
 * @author
 * 2019/3/22 17:04
 */
class Edge implements Comparable<Edge> {
    //起始点
    private int begin;
    //终止点
    private int end;
    //权值
    private int weight;

    public Edge(int begin, int end, int weight) {
        this.begin = begin;
        this.end = end;
        this.weight = weight;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        if (o.weight > this.weight) {
            return -1;
        } else {
            return 1;
        }
    }
}

public class MiniSpanningTree_Kruskal {
    static int[][] G;
    public static void main(String[] args) {
        //默认以a为根节点的最小生成树
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        G = new int[N][N];
        List<Edge> list = new ArrayList<>();
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                G[i][j] = in.nextInt();
            }
        }
//        for(int i=0;i<M;i++)
//        {
//            for(int j=0;j<3;j++)
//            {
//                int x,y,val;
//                x = in.nextInt();
//                y = in.nextInt();
//                val = in.nextInt();
//                G[x][y] = val;
//            }
//        }
        for (int i = 0; i <N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (G[i][j] >= 0) {
                    list.add(new Edge(i, j, G[i][j]));
                }
            }
        }
//        for (int i = 0; i <M; i++) {
//            int x,y,val;
//            x = in.nextInt();
//            y = in.nextInt();
//            val = in.nextInt();
//            list.add(new Edge(x,y,val));
//        }
        //数组中每一个节点都只知道他的父节点是什么，-1表示不存在父节点，0位置是根节点
        int[] parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        int m = 0, n = 0;
        int num = 0;
        int sum = 0;
        int len = list.size();
        Collections.sort(list);
        for(int i=0;i<len;i++)
        {
            m = find(parent, list.get(i).getBegin());
            n = find(parent, list.get(i).getEnd());
            if (m != n) {
                parent[m] = n;
                sum += list.get(i).getWeight();
                num++;
            }
            if(num == N-1)
                break;
        }
        System.out.println(sum);
    }

    private static int find(int[] parent, int x) {
        while(x != parent[x])
        {
            x = parent[x];
        }
        return x;
    }
//    public static void unite(int[] parent, int x, int y)
//    {
//        x = find(parent,x);
//        y = find(parent, y);
//        parent[x] = y;
//    }
}