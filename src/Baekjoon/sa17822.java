package Baekjoon;

import java.io.*;
import java.util.*;

public class sa17822 {
    static int N;
    static int M;
    static int T;
    static int[][] circle;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());
        T = Integer.valueOf(str.nextToken());
        circle = new int[N][M];
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                circle[i][j] = Integer.valueOf(str.nextToken());
            }
        }

        for(int i = 0; i < T; i++){
            str = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(str.nextToken());
            int d = Integer.valueOf(str.nextToken());
            int k = Integer.valueOf(str.nextToken());
        }
    }
}
