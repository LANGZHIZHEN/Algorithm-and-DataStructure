package AizuOJ.BinarySearchTree;

import java.util.Scanner;

public class Insertion {

    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        for(int i=0;i<n;i++)
        {
            String line = in.next();
            int key;
            if(line.charAt(0) == 'i') {
                key = in.nextInt();
                tree.Insert(new Node(key));
            }
            else if(line.charAt(0) == 'f'){
                key = in.nextInt();
                Node node = tree.Find(key, tree.root);
                if(node == null)
                    System.out.println("no");
                else
                    System.out.println("yes");
            }
            else if(line.charAt(0) == 'p')
            {
                tree.InOrder(tree.root);
                System.out.println();
                tree.PreOrder(tree.root);
                System.out.println();
            }
            else{
                key = in.nextInt();
                tree.Delete(key);
//                tree.Delete(tree.Find(key,tree.root));
            }
        }
    }

}
class Node{
    Node left,parent,right;
    int key;

    public Node(int key) {
        this.left = null;
        this.parent = null;
        this.right = null;
        this.key = key;
    }
}
class Tree
{
    Node root;

    Node Insert(Node node)
    {
        Node parent = null;
        Node child = root;
        while(child != null)
        {
            parent = child;
            if(node.key > child.key)
                child = child.right;
            else
                child = child.left;
        }
        node.parent = parent;
        if(parent == null)
            this.root = node;
        else if(node.key < parent.key)
            parent.left = node;
        else
            parent.right = node;
        return node;
    }
    void InOrder(Node node)
    {
        if(node == null)
            return;
        InOrder(node.left);
        System.out.print(" "+node.key);
        InOrder(node.right);
    }
    void PreOrder(Node node)
    {
        if(node == null)
            return;
        System.out.print(" "+node.key);
        PreOrder(node.left);
        PreOrder(node.right);
    }
    Node Find(int x,Node node)
    {
        if(node == null)
        {
            return null;
        }
        if(node.key == x)
            return node;
        else if(node.key < x)
            return Find(x,node.right);
        else
            return Find(x,node.left);
    }
//    Node Minimum(Node x){
//        while(x.left != null)
//            x = x.left;
//        return x;
//    }
//    Node getSuccessor(Node x)
//    {
//        if(x.right != null)
//            return Minimum(x.right);
//        Node y = x.parent;
//        while(y != null && x == y.right)
//        {
//            x = y;
//            y = y.parent;
//        }
//        return y;
//    }
//    void Delete(Node z)
//    {
//        Node y,x;
//        if(z.left == null || z.right == null)
//        {
//            y = z;
//        }else
//            y = getSuccessor(z);
//        if(y.left != null){
//            x = y.left;
//        }else{
//            x = y.right;
//        }
//        if(x != null)
//            x.parent = y.parent;
//        if(y.parent == null) {
//            root = x;
//        }else {
//            if(y == y.parent.left) {
//                y.parent.left = x;
//            }else {
//                y.parent.right = x;
//            }
//        }
//        if(y != z) {
//            z.key = y.key;
//        }
//    }
    void Delete(int data){
        root = _delete(root,data);
    }

    private Node _delete(Node node, int data) {
        if(node == null)
            return null;
        if(data < node.key)
            node.left = _delete(node.left,data);
        else if(data > node.key)
            node.right = _delete(node.right,data);
        else{
            if(node.left == null)
                return node.right;
            if(node.right == null)
                return node.left;
            Node minNode = minNode(node.right);
            node.key = minNode.key;
            node.right = _delete(node.right,minNode.key);
        }
        return node;
    }

    private Node minNode(Node node) {
        while(node.left != null)
            node = node.left;
        return node;
    }
}
