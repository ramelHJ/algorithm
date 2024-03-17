package Baekjoon;

import java.io.*;
import java.util.*;

public class sa17390 {
    static int N, Q;
    static int[] arr;
    static int[] total;
    static int L, R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.valueOf(str.nextToken());
        Q = Integer.valueOf(str.nextToken());

        arr = new int[N + 1];
        total = new int[N + 1];

        str = new StringTokenizer(br.readLine());
        for(int i = 1; i <=N; i++){
            arr[i] = Integer.valueOf(str.nextToken());
        }
        Arrays.sort(arr);
        for(int i = 1; i <= N; i++){
            total[i] = arr[i] + total[i-1];
        }

        for(int i = 0;i < Q; i++){
            str = new StringTokenizer(br.readLine());
            L = Integer.valueOf(str.nextToken());
            R = Integer.valueOf(str.nextToken());
            bw.write(String.valueOf(total[R] - total[L - 1]));
            bw.newLine();
        }
        bw.flush();
    }
}
