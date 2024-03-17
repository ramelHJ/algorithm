package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class sa11066 {
    public static int MAX = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        for(int t = 0; t < testCase; t++){
            int num = Integer.parseInt(br.readLine());

            int[][] dp = new int[num + 1][num + 1];
            int[] novel = new int[num + 1];
            int[] sum = new int[num + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 1; i<= num; i++){
                novel[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + novel[i];
            }

            for (int i = 1; i < num; i++){
                for(int j = 1; j + i <= num; j++){
                    int behind = j + i;
                    dp[j][behind] = MAX;
                    for(int k = j; k < behind; k++){
                        dp[j][behind] = Math.min(dp[j][behind], dp[j][k] + dp[k+1][behind] + sum[behind] - sum[j - 1]);
                    }
                }
            }
            bw.write(String.valueOf(dp[1][num]));
            bw.newLine();
        }
        bw.flush();
    }
}
