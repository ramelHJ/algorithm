package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class sa7569 {
    static int[] dx = {-1,0,1,0,0,0};
    static int[] dy = {0,1,0,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int M = Integer.valueOf(str.nextToken());
        int N = Integer.valueOf(str.nextToken());
        int H = Integer.valueOf(str.nextToken());
        int[][][] arr = new int[N][M][H];
        Queue<Point> tomato = new LinkedList<>();

        for(int z = 0; z < H; z++){
            for(int i = 0; i < N; i++){
                str = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++){
                    arr[i][j][z] = Integer.valueOf(str.nextToken());
                    if(arr[i][j][z] == 1) tomato.add(new Point(i,j,z));
                }
            }
        }
        for(int i = 0; i < N; i++){
            for(int z = 0; z < H; z++){
                for(int j = 0; j < M; j++){
                }
            }
        }

        while(!tomato.isEmpty()){
            Point point = tomato.poll();
            for(int i = 0; i < 6; i++){
                int x = point.x + dx[i];
                int y = point.y + dy[i];
                int z = point.z + dz[i];
                if(x < 0 || x >= N || y < 0 || y >= M || z < 0 || z >= H || arr[x][y][z] != 0) continue;

                tomato.add(new Point(x,y,z));
                arr[x][y][z] = arr[point.x][point.y][point.z] + 1;
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                for(int z = 0; z < H; z++) {
                    if (arr[i][j][z] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, arr[i][j][z]);
                }
            }
        }
        System.out.println(max - 1);
    }

    public static class Point{
        int x;
        int y;
        int z;

        public Point(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
