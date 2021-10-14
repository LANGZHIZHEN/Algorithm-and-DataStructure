package AizuOJ.Tree;

import java.util.Scanner;

public class BinaryTree {
    public static class Node {
        int parent, left, right;

        public Node() {
            this.parent = -1;
            this.left = -1;
            this.right = -1;
        }
    }

    public static int NIL = -1;
    public static int MAX = 10000;
    static Node[] T;
    static int[] H;
    static int[] D;
    public static int n;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        n = input.nextInt();
        T = new Node[n];
        H = new int[n];
        D = new int[n];
        for (int i = 0; i < n; i++) {
            T[i] = new Node();
            T[i].parent = NIL;
        }
        int v, l, r;
        for (int i = 0; i < n; i++) {
            v = input.nextInt();
            l = input.nextInt();
            r = input.nextInt();
            T[v].left = l;
            T[v].right = r;
            if (l != NIL)
                T[l].parent = v;
            if (r != NIL)
                T[r].parent = v;
        }
        int root = 0;
        for (int i = 0; i < n; i++) {
            if (T[i].parent == NIL)
                root = i;
        }
//        setDepth(root, 0);
//        setHeight(root);
//        Print(n);
        System.out.println("Preorder");
        PreOrder(root);
        System.out.println();
        System.out.println("Inorder");
        InOrder(root);
        System.out.println();
        System.out.println("Postorder");
        PostOrder(root);
        System.out.println();
    }

    public static void setDepth(int u, int d) {
        if (u == NIL)
            return;
        D[u] = d;
        setDepth(T[u].left, d + 1);
        setDepth(T[u].right, d + 1);
    }

    public static int setHeight(int u) {
        int h1 = 0;
        int h2 = 0;
        if (T[u].left != NIL)
            h1 = setHeight(T[u].left) + 1;
        if (T[u].right != NIL)
            h2 = setHeight(T[u].right) + 1;
        return H[u] = Math.max(h1, h2);
    }

    public static void Print(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("node " + i + ": parent = " + T[i].parent + ", sibling = " + getSibling(i));
            System.out.print(", degree = " + getDegree(i) + ", ");
            System.out.print("depth = " + D[i] + ", ");
            System.out.print("height = " + H[i] + ", ");
            System.out.print(type(i));
            System.out.println();
        }
    }

    static int getDegree(int u) {
        int d = 0;
        if (T[u].left != NIL)
            d++;
        if (T[u].right != NIL)
            d++;
        return d;
    }

    static String type(int u) {
        String type;
        if (T[u].parent == -1)
            type = "root";
        else if (T[u].left == NIL && T[u].right == NIL)
            type = "leaf";
        else
            type = "internal node";
        return type;
    }

    static int getSibling(int u) {
        if (T[u].parent != -1) {
            int p = T[u].parent;
            if (T[p].left != -1 && T[p].left != u) {
                return T[p].left;
            } else if (T[p].right != -1 && T[p].right != u) {
                return T[p].right;
            }
        }
        return -1;
    }

    static void PreOrder(int u) {
        if(u == NIL)
            return;
        System.out.print(" "+u);
        PreOrder(T[u].left);
        PreOrder(T[u].right);
    }
    static void InOrder(int u) {
        if(u == NIL)
            return;
        InOrder(T[u].left);
        System.out.print(" "+u);
        InOrder(T[u].right);
    }
    static void PostOrder(int u) {
        if(u == NIL)
            return;
        PostOrder(T[u].left);
        PostOrder(T[u].right);
        System.out.print(" "+u);
    }
}

