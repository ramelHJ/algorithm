package 쇼미더코드;

import java.io.*;
import java.util.*;

public class test2 {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] check;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());

        arr = new int[N][M];
        check = new boolean[N][M];

        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.valueOf(str.nextToken());
            }
        }

        int result = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == 0 && !check[i][j]) {
                    findArea(i, j);
                    result++;
                }

            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static void findArea(int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i,j));
        check[i][j] = true;

        while(!queue.isEmpty()){
            Point point = queue.poll();

            for(int k = 0; k < 4; k++){
                int x = point.x + dx[k];
                int y = point.y + dy[k];

                if(x < 0) x += N;
                else if(x >= N) x -= N;
                else if(y < 0) y += M;
                else if(y >= M) y -= M;

                if(arr[x][y] == 1 || check[x][y]) continue;

                check[x][y] = true;
                queue.add(new Point(x,y));
            }
        }
    }

    public static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
