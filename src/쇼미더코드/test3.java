package 쇼미더코드;

import java.io.*;
import java.util.*;

public class test3 {
    static int N;
    static int M;
    static int C;
    static int[][] satisfy;
    static int[] A_character;
    static int[] B_character;
    static long[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        getInputData();
        getSatisfy();

        long max = 0;
        for(int i = 0; i < M; i++){
            max = Math.max(max, dp[N - 1][i]);
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static void getSatisfy() {
        dp = new long[N][M];
        for(int i = 0; i < M; i++){
            dp[0][i] = satisfy[A_character[0]][B_character[i]];
        }

        for(int i = 1; i < N; i++){
            for(int j = 0; j < M; j++){
                long max = getMax(dp, i - 1, j);
                dp[i][j] = Math.max(dp[i-1][j], max + satisfy[A_character[i]][B_character[j]]);
            }
        }
    }

    private static long getMax(long[][] dp, int i, int j) {
        long max = 0;
        for(int a = 0; a < j; a++){
            max = Math.max(max, dp[i][a]);
        }

        return max;
    }

    public static void getInputData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());
        C = Integer.valueOf(str.nextToken());

        satisfy = new int[C + 1][C + 1];
        A_character = new int[N];
        B_character = new int[M];

        for(int i = 1; i <= C; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 1; j <= C; j++){
                satisfy[i][j] = Integer.valueOf(str.nextToken());
            }
        }

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A_character[i] = Integer.valueOf(str.nextToken());
        }

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            B_character[i] = Integer.valueOf(str.nextToken());
        }
    }
}
