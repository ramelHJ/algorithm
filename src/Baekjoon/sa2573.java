package Baekjoon;

import java.io.*;
import java.util.*;

public class sa2573 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer str;
    static int N, M;
    static int[][] arr;
    static Queue<Edge> queue;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = new StringTokenizer(br.readLine());
        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());
        arr = new int[N][M];
        queue = new LinkedList<>();
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.valueOf(str.nextToken());
                if(arr[i][j] != 0) queue.add(new Edge(i,j));
            }
        }

        bw.write(String.valueOf(melt()));
        bw.flush();
    }

    private static int melt() {
        int cnt = 0;


        while(!queue.isEmpty()){
            //빙하가 두 덩어리 이상인지 체크
            if(checkPart()) break;

            //녹을 것 계산하기
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Edge e = queue.poll();
                int meltPoint = 0;
                for(int k = 0; k < 4; k++){
                    int xx = e.x + dx[k];
                    int yy = e.y + dy[k];

                    if(xx < 0 || xx >= N || yy < 0 || yy >= M) continue;
                    if(arr[xx][yy] == 0) meltPoint++;
                }
                queue.add(new Edge(e.x, e.y, meltPoint));
            }

            //녹이기
            for(int i = 0; i < size; i++){
                Edge e = queue.poll();
                arr[e.x][e.y] = arr[e.x][e.y] - e.d > 0 ? arr[e.x][e.y] - e.d : 0;
                if(arr[e.x][e.y] > 0) queue.add(new Edge(e.x, e.y));
            }

            cnt++;

        }

        if(queue.isEmpty()) return 0;
        return cnt;
    }

    private static boolean checkPart() {
        boolean[][] check = new boolean[N][M];
        int cnt = 0;
        int size = queue.size();
        for(int i = 0; i < size; i++){
            Edge e = queue.poll();
            queue.add(e);
            if(check[e.x][e.y]) continue;
            check[e.x][e.y] = true;

            Queue<Edge> edge = new LinkedList<>();
            edge.add(e);
            while(!edge.isEmpty()){
                Edge select = edge.poll();
                for(int k = 0; k < 4; k++){
                    int xx = select.x + dx[k];
                    int yy = select.y + dy[k];

                    if(xx < 0 || xx >= N || yy < 0 || yy >= M || check[xx][yy] || arr[xx][yy] == 0) continue;

                    check[xx][yy] = true;
                    edge.add(new Edge(xx,yy));
                }
            }
            cnt++;
        }

        if(cnt >= 2) return true;
        return false;
    }

    public static class Edge{
        int x;
        int y;
        int d;
        public Edge(int x, int y){
            this.x = x;
            this.y = y;
        }

        public Edge(int x, int y, int d){
          this.x = x;
          this.y = y;
          this.d = d;
        }
    }
}
