package Baekjoon;

import java.io.*;
import java.util.*;

public class sa1260 {
    static int N, M, V;
    static boolean[][] arr;
    static boolean[] check;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());
        V = Integer.valueOf(str.nextToken());
        arr = new boolean[N + 1][N + 1];
        for(int i = 0; i < M; i++){
            str = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(str.nextToken());
            int y = Integer.valueOf(str.nextToken());
            arr[x][y] = true;
            arr[y][x] = true;
        }
        sb = new StringBuilder();
        check = new boolean[N + 1];
        dfs(V);
        bw.write(String.valueOf(sb));
        bw.newLine();

        sb = new StringBuilder();
        check = new boolean[N + 1];
        bfs();
        bw.write(String.valueOf(sb));
        bw.newLine();

        bw.flush();
    }

    private static void dfs(int s) throws IOException {
        check[s] = true;
        sb.append(s + " ");

        for(int i = 1; i <= N; i++){
            if(arr[s][i] && !check[i])
                dfs(i);
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        check[V] = true;

        int num = 0;
        while(!queue.isEmpty()){
            num = queue.poll();
            sb.append(num + " ");

            for(int i = 1; i <= N; i++){
                if(!check[i] && arr[num][i]){
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
    }
}
