package Baekjoon;

import java.io.*;
import java.util.*;

public class sa9466 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer str;
    static int[] arr;
    static int n;
    static int result;
    static boolean[] check;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        str = new StringTokenizer(br.readLine());
        int tc = Integer.valueOf(str.nextToken());

        for(int i = 0; i < tc; i++){
            str = new StringTokenizer(br.readLine());
            n = Integer.valueOf(str.nextToken());
            result = 0;
            arr = new int[n + 1];
            check = new boolean[n + 1];
            visited = new boolean[n + 1];

            str = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                arr[j] = Integer.valueOf(str.nextToken());
            }

            for(int j = 1; j <= n; j++){
                if(check[j]) continue;
                dfs(j);
            }

            bw.write(String.valueOf(n - result));
            bw.newLine();
        }
        bw.flush();
    }

    private static void dfs(int index) {
        if(check[index]) return;
        if(visited[index]){
            check[index] = true;
            result++;
        }

        visited[index] = true;
        dfs(arr[index]);

        check[index] = true;
        visited[index] = false;
    }
}
