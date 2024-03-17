package Baekjoon;

import java.io.*;
import java.util.*;

public class sa6087 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int W = Integer.valueOf(str.nextToken());
        int H = Integer.valueOf(str.nextToken());
        char[][] arr = new char[H][W];
        int[][][] visited = new int[H][W][4];
        List<Point> laser = new ArrayList<>();

        for(int i = 0; i < H; i++){
            String s = br.readLine();
            for(int j = 0; j < W; j++){
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == 'C') laser.add(new Point(i,j,0,-1));
                for(int k = 0; k < 4; k++){
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        Point start = laser.get(0);
        Point end = laser.get(1);

        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y][0] = 0;
        visited[start.x][start.y][1] = 0;
        visited[start.x][start.y][2] = 0;
        visited[start.x][start.y][3] = 0;

        int min = Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            Point p = queue.poll();

            if(p.x == end.x && p.y == end.y){
                min = Math.min(min, p.mirror);
                continue;
            }

            for(int i = 0; i < 4; i++){
                int x = p.x + dx[i];
                int y = p.y + dy[i];

                if(x < 0 || x >= H || y < 0 || y >= W || arr[x][y] == '*' || visited[x][y][i] <= p.mirror) continue;

                int mirrorCount = p.mirror;
                if(p.dir == i) mirrorCount++;

                visited[x][y][i] = mirrorCount;
                queue.add(new Point(x, y, mirrorCount, i));
            }
        }

        System.out.println(min);
    }

    static class Point{
        int x;
        int y;
        int mirror;
        int dir;

        public Point(int x, int y, int mirror, int dir){
            this.x = x;
            this.y = y;
            this.mirror = mirror;
            this.dir = dir;
        }
    }
}
