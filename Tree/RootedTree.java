package AizuOJ.Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class RootedTree {
    private static final int BIG_NUM  = 2000000000;
    private static final int MOD  = 1000000007;

    private static Node nodes[];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        nodes = new Node[N];
        for(int i = 0; i < N; i++)nodes[i] = new Node();

        int id,num,child_id;
        for(int loop = 0; loop < N; loop++){
            id = scanner.nextInt();
            num = scanner.nextInt();

            for(int i = 0; i < num; i++){
                child_id = scanner.nextInt();
                nodes[id].children.add(child_id);
                nodes[child_id].setParent_id(id);
            }
        }

        for(int i = 0; i < N; i++){
            if(nodes[i].getParent_id() == -1){
                calcDepth(i,0);
            }
        }

        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < N; i++){
            ans.append("node ").append(Integer.toString(i)).append(": parent = ").append(Integer.toString(nodes[i].getParent_id()))
                    .append(", depth = ").append(Integer.toString(nodes[i].getDepth())).append(", ");

            if(nodes[i].getParent_id() == -1){
                ans.append("root, ");
            }else if(nodes[i].children.size() == 0){
                ans.append("leaf, ");
            }else{
                ans.append("internal node, ");
            }

            ans.append("[");
            if(nodes[i].children.size() > 0){
                ans.append(Integer.toString(nodes[i].children.get(0)));
                for(int k = 1; k < nodes[i].children.size(); k++){
                    ans.append(", ").append(Integer.toString(nodes[i].children.get(k)));
                }
            }
            ans.append("]\n");
        }
        System.out.print(ans.toString());
    }

    static void calcDepth(int id,int value){
        nodes[id].setDepth(value);

        for(int i = 0; i < nodes[id].children.size(); i++){
            calcDepth(nodes[id].children.get(i),value+1);
        }
    }
}
class Node{
    private int parent_id;
    private int depth;
    public ArrayList<Integer> children;

    Node(){
        children = new ArrayList<Integer>();
        parent_id = -1;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
