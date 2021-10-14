package AizuOJ.AdvancedSort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MinimumCostSort {
    public static int MAX = 1000;
    public static int VMAX = 10000;
    static int[] B;
    static int[] A;
    static int[] T;
    public static int n;
    public static int s = VMAX;

    public static void main(String[] args) {
        B = new int[MAX];
        A = new int[MAX];
        T = new int[VMAX+1];
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for(int i=0;i<n;i++)
        {
            A[i] = in.nextInt();
            s = Math.min(s,A[i]);
        }
        int ans = solve();
        System.out.println(ans);
    }
    public static int solve()
    {
        int ans = 0;
        boolean[] V = new boolean[n];
        for(int i=0;i<n;i++)
        {
            B[i] = A[i];
            V[i] = false;
        }
        Arrays.sort(B,0,n);
        for(int i=0;i<n;i++)
        {
            T[B[i]] = i;
        }
        for(int i=0;i<n;i++)
        {
            if(V[i])
                continue;
            int cur = i;
            int sum = 0;
            int m = VMAX;
            int an = 0;
            while(true)
            {
                V[cur] = true;
                an++;
                int v = A[cur];
                m = Math.min(v,m);
                sum += v;
                cur = T[v];
                if(V[cur])
                    break;
            }
            ans += Math.min(sum + (an-2)*m,m+sum+(an+1)*s);
        }
        return ans;
    }
}
