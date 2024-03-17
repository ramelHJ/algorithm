package Baekjoon;

import java.io.*;
import java.util.*;

public class sa1780 {
    static int N;
    static int[][] arr;
    static int x, y, z;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;
        //입력값 넣기
        str = new StringTokenizer(br.readLine());
        N = Integer.valueOf(str.nextToken());
        arr = new int[N + 1][N + 1];
        x = y = z = 0;

        for(int i = 1; i <= N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.valueOf(str.nextToken());
            }
        }

        dfs(1, 1, N);

        bw.write(String.valueOf(x));
        bw.newLine();
        bw.write(String.valueOf(y));
        bw.newLine();
        bw.write(String.valueOf(z));
        bw.newLine();
        bw.flush();
    }

    public static void dfs(int r, int c, int size){
        //확인하는 부분
        int aa = 0;
        int bb = 0;
        int cc = 0;

        for(int i = r; i < r + size; i++){
            for(int j = c; j < c + size; j++){
                if(arr[i][j] == -1) aa++;
                if(arr[i][j] == 0) bb++;
                if(arr[i][j] == 1) cc++;
            }
        }
        int value = size * size;
        if(aa == value) {
            x++;
            return;
        }

        if(bb == value) {
            y++;
            return;
        }

        if(cc == value){
            z++;
            return;
        }

        //재귀하는 부분
        int smallSize = size / 3;
        for(int i = r; i < r + size; i += smallSize){
            for(int j = c; j < c + size; j += smallSize){
                dfs(i, j, smallSize);
            }
        }
    }
}
