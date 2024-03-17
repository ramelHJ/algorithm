package Baekjoon;

import java.io.*;
import java.util.*;

public class sa2512 {
    static int N, M;
    static int[] arr;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.valueOf(str.nextToken());
        arr = new int[N];
        str = new StringTokenizer(br.readLine());
        int max = -1;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(str.nextToken());
            max = Math.max(max, arr[i]);
        }

        str = new StringTokenizer(br.readLine());
        M = Integer.valueOf(str.nextToken());

        binarySearch(1, max);
        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static void binarySearch(int left, int right){
        while(left <= right){
            int mid = (left + right) / 2;
            long sum = 0;

            for(int i = 0; i < N; i++){
                if(arr[i] > mid) sum += mid;
                else sum += arr[i];
            }

            if(sum <= M) left = mid + 1;
            else right = mid - 1;
        }

        result = right;
    }
}

