package AizuOJ.Graph;

import java.util.Scanner;

/****
 * int[] find is to determine whether this point is repeated
 * AdjGraph G is Graph which records the information of points
 * Node is a node and its contents
 * union() is to determine whether the two points are connected by DFS
 * add() is to add two information of point in Graph
 */
public class ConnectedComponents {
    static class AdjGraph{ //
        static class Node{
            Node next;
            int val;

            public Node() {
                val = -1;
                next = null;
            }
        }

        public Node[] vertex;
        public AdjGraph(int Num){
            vertex = new Node[Num];
            for(int i =0;i<Num;i++)
            {
                vertex[i] = new Node();
                vertex[i].val = i;
            }
        }
        public void add(int x,int y){
            Node node = vertex[x].next;
            node = new Node();
            node.val = y;
            node.next = vertex[x].next;
            vertex[x].next = node;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        AdjGraph G = new AdjGraph(N);
        int M = in.nextInt();
        int[] find = new int[N];
        for(int i=0;i<M;i++)
        {
            int x,y;
            x = in.nextInt();
            y = in.nextInt();
            G.add(x,y);
        }
        int Q = in.nextInt();
        for(int i=0;i<Q;i++)
        {
            int x,y;
            x = in.nextInt();
            y = in.nextInt();
            if(union(x,y,find,G,N))
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }

    private static boolean union(int s, int d,int[] find,AdjGraph G,int N) {
        boolean flag = false;
        if(G.vertex[s] == null)
            return false;
        AdjGraph.Node node = G.vertex[s];
        while(node != null){
            if(node.val == d)
                return true;
            else if(find[node.val] != 1)
            {
                find[node.val] = 1;
                flag = union(node.val,d,find,G,N);
                find[node.val] = 0;
                if(flag)
                    return true;
            }
            node = node.next;
        }
        return false;
    }

}
