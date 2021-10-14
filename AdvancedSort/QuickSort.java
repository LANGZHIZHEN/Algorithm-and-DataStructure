package AizuOJ.AdvancedSort;

import java.util.Scanner;
class Card
{
    public String suit;
    public int value;

    public Card(String suit,int value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.suit+" "+this.value;
    }
}
public class QuickSort {
        public static void swap(Card[] A, int i, int j) {
            Card item = A[i];
            A[i] = A[j];
            A[j] = item;
        }
//    public static int partition(int[] A, int p, int r) {
//        int x = A[r];
//        int i = p - 1;
//        for (int j = p; j < r; j++) {
//            if (A[j] <= x) {
//                i++;
//                swap(A, i, j);
//            }
//        }
//        swap(A, i + 1, r);
//        return i + 1;
//    }
    public static void quickSort(Card[] A,int left,int right)
    {
        if(right>left)
        {
//            int mid = partition(A,left,right);
            int i = left,j = right;
            int key = A[right].value;
            while(i<j)
            {
                while(i<j && A[i].value<key)
                    i++;
                while(i<j && A[j].value>key)
                    j--;
                swap(A,i,j);
            }
            A[j].value = key;
            quickSort(A,left,j-1);
            quickSort(A,j+1,right);
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        Card[] A = new Card[n];
        for (int i = 0; i < n; i++) {
            A[i] = new Card(in.next(),in.nextInt());
//            System.out.println(in.next().charAt(0)+" "+in.next());
        }
        quickSort(A,0,n-1);
        for(Card item : A)
        {
            System.out.println(item);
        }
    }
}
