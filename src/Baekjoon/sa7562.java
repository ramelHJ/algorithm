package Baekjoon;

import java.io.*;
import java.util.*;

public class sa7562 {
    static int tc;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer str;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};

    static boolean[][] check;

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        str = new StringTokenizer(br.readLine());
        tc = Integer.valueOf(str.nextToken());
        for(int i = 0; i < tc; i++){
            bfs();
        }
        bw.flush();
    }

    private static void bfs() throws IOException {
        StringTokenizer str = new StringTokenizer(br.readLine());
        int length = Integer.valueOf(str.nextToken());
        check = new boolean[length][length];

        str = new StringTokenizer(br.readLine());
        Edge start = new Edge(Integer.valueOf(str.nextToken()), Integer.valueOf(str.nextToken()));
        check[start.x][start.y] = true;

        str = new StringTokenizer(br.readLine());
        Edge end = new Edge(Integer.valueOf(str.nextToken()), Integer.valueOf(str.nextToken()));

        Queue<Edge> queue = new LinkedList<>();
        queue.add(start);

        if(start.checkEqual(end)){
            bw.write("0");
            bw.newLine();
            return;
        }

        int count = 0;
        while(!queue.isEmpty()){
            count++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Edge q = queue.poll();
                for(int k = 0; k < 8; k++){
                    int xx = q.x + dx[k];
                    int yy = q.y + dy[k];
                    if(xx < 0 || xx >= length || yy < 0 || yy >= length || check[xx][yy]) continue;

                    Edge newEdge = new Edge(xx, yy);
                    if(end.checkEqual(newEdge)) {
                        bw.write(String.valueOf(count));
                        bw.newLine();
                        return;
                    }

                    queue.add(newEdge);
                    check[newEdge.x][newEdge.y] = true;
                }
            }
        }
    }

    public static class Edge{
        int x;
        int y;

        public Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean checkEqual(Edge e){
            if(this.x == e.x && this.y == e.y) return true;
            return false;
        }
    }
}
