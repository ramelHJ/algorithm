package Baekjoon;

import java.io.*;
import java.util.*;

public class sa13251 {
    static int N, M, K;
    static double answer;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.valueOf(br.readLine());
        arr = new int[M];
        N = 0;
        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            arr[i] = Integer.valueOf(str.nextToken());
            N += arr[i];
        }

        K = Integer.valueOf(br.readLine());
        
        answer = 0;
        for(int i = 0; i < M; i++){
            calc(i);
        }

        if(answer >= 1) System.out.println(1);
        else System.out.println(answer);
    }

    private static void calc(int select) {
        if(arr[select] >= K){
            int tmp = N;
            int _tmp = K;

            double _answer = 1;
            while(_tmp-- > 0){
                _answer *= (arr[select]-- / (double)tmp--);
            }
            answer += _answer;
        }
    }
}
