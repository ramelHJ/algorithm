package Baekjoon;

import java.io.*;
import java.util.*;

public class sa2667 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer str;
    static int N;
    static int[][] arr;
    static boolean[][] check;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        str = new StringTokenizer(br.readLine());
        N = Integer.valueOf(str.nextToken());

        arr = new int[N][N];
        check = new boolean[N][N];

        for(int i =0 ; i < N; i++){
            str = new StringTokenizer(br.readLine());
            String s = str.nextToken();
            for(int j = 0; j < N; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(check[i][j] || arr[i][j] == 0) continue;

                Queue<Edge> edge = new LinkedList<>();
                edge.add(new Edge(i,j));

                int count = 0;
                while(!edge.isEmpty()){
                    count++;
                    Edge e = edge.poll();
                    check[e.x][e.y] = true;
                    for(int k = 0; k < 4; k++){
                        int xx = e.x + dx[k];
                        int yy = e.y + dy[k];

                        if(xx < 0 || xx >= N || yy < 0 || yy >= N || check[xx][yy] || arr[xx][yy] == 0) continue;

                        edge.add(new Edge(xx,yy));
                        check[xx][yy] = true;
                    }
                }

                list.add(count);
            }
        }

        Collections.sort(list);
        bw.write(String.valueOf(list.size()));
        bw.newLine();
        for(int i = 0; i < list.size(); i++){
            bw.write(String.valueOf(list.get(i)));
            bw.newLine();
        }
        bw.flush();
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
