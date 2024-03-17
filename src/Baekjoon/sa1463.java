package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static java.lang.Math.min;

public class sa1463 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int[] dp = new int[1000005];
        for(int i = 2; i <= num; i++){
            dp[i] = dp[i - 1] + 1;
            if(i % 2 == 0) dp[i] = min(dp[i], dp[i / 2] + 1);
            if(i % 3 == 0) dp[i] = min(dp[i], dp[i / 3] + 1);
        }
        bw.write(String.valueOf(dp[num]));
        bw.flush();
    }
}
