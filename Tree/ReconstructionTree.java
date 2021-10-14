package AizuOJ.Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class ReconstructionTree {
    static int n;
    static int pos;
    static ArrayList<Integer> Pre = new ArrayList<>();
    static ArrayList<Integer> In = new ArrayList<>();
    static ArrayList<Integer> Post = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for(int i=0;i<n;i++)
        {
            Pre.add(in.nextInt());
        }
        for(int i=0;i<n;i++)
        {
            In.add(in.nextInt());
        }
        solve();
    }
    public static void solve()
    {
        pos = 0;
        Reconstruction(0,n);
        for(int i=0;i<n;i++)
        {
            if(i>0)
                System.out.print(" ");
            System.out.print(Post.get(i));
        }
        System.out.println();
    }
    public static void Reconstruction(int l,int r)
    {
        if(l>=r)
            return;
        int root = Pre.get(pos++);
        int index = In.indexOf(root);
        Reconstruction(l,index);
        Reconstruction(index+1,r);
        Post.add(root);
    }
}
