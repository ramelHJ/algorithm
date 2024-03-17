package Baekjoon;

import java.io.*;
import java.util.*;

public class sa2468 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer str;
    static int N;
    static int[][] arr;
    static int max = 1;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static Set<Integer> height = new HashSet<>();
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        str = new StringTokenizer(br.readLine());
        N = Integer.valueOf(str.nextToken());
        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.valueOf(str.nextToken());
                height.add(arr[i][j]);
            }
        }

        for(int h : height){
            bfs(h);
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static void bfs(int h) {
        int count = 0;
        boolean[][] check = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(check[i][j] || arr[i][j] <= h) continue;
                Queue<Edge> edge = new LinkedList<>();
                edge.add(new Edge(i,j));
                check[i][j] = true;

                while(!edge.isEmpty()){
                    Edge e = edge.poll();
                    for(int k = 0; k < 4; k++){
                        int xx = e.x + dx[k];
                        int yy = e.y + dy[k];

                        if(xx < 0 || xx >= N || yy < 0 || yy >= N || check[xx][yy] || arr[xx][yy] <= h) continue;

                        edge.add(new Edge(xx,yy));
                        check[xx][yy] = true;
                    }
                }
                count++;
            }
        }
        max = Math.max(count, max);
    }

    public static class Edge{
        int x;
        int y;
        public Edge(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
