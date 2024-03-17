package Baekjoon;

import java.io.*;
import java.util.*;

public class sa1913 {
    static int N, M;
    static int[][] arr;
    static int resultx, resulty;
    //위 -> 오른쪽이 비어있으면 꺾음
    //오 -> 아래가 비어있으면 꺾음
    //아 -> 왼쪽이 비어있으면 꺾음
    //왼 -> 위쪽이 비어있으면 꺾음
    //다음 방향을 체크하면됨
    static int[] dx = {-1,0,1,0}; //위 오 아 왼
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.valueOf(str.nextToken());

        str = new StringTokenizer(br.readLine());
        M = Integer.valueOf(str.nextToken());

        arr = new int[N + 2][N + 2];
        int x = (N / 2) + 1;
        int y = (N / 2) + 1;

        int num = 1;
        int dir = 0;
        while(num <= N * N){
            arr[x][y] = num;
            if(num == M) {
                resultx = x;
                resulty = y;
            }
            //이동
            x = x + dx[dir];
            y = y + dy[dir];
            num++;

            //다음 방향 체크
            int nextDir = (dir + 1) % 4;
            int xx = x + dx[nextDir];
            int yy = y + dy[nextDir];
            if(arr[xx][yy] != 0) continue;

            dir = nextDir;
        }

        for(int i = 1; i <= N; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j <= N; j++){
                sb.append(arr[i][j] + " ");
            }
            bw.write(String.valueOf(sb));
            bw.newLine();
        }
        bw.write(resultx + " " + resulty);
        bw.flush();
    }
}
