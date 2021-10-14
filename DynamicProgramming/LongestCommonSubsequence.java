package AizuOJ.DynamicProgramming;

import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] dp;
        int N = in.nextInt();
        in.nextLine();
        String s1 = null;
        String s2 = null;
        while(N >0)
        {
            N--;
            s1 = in.nextLine();
            s2 = in.nextLine();
            int n = s1.length();
            int m = s2.length();
            dp = new int[n+1][m+1];
            for(int k=1;k<=n;k++){
                dp[k][0] = 0;
            }
            for(int j=1;j<=m;j++){
                dp[0][j] = 0;
            }
            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=m;j++)
                {
                    if(s1.charAt(i-1) == s2.charAt(j-1))
                        dp[i][j] = dp[i-1][j-1] + 1;
                    else
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
            System.out.println(dp[n][m]);
        }

    }
}
