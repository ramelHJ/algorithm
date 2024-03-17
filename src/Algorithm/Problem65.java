package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem65 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int count = 0;
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] array = new int[7][7];
        boolean[][] check = new boolean[7][7];

        StringTokenizer str;
        for(int i = 0; i < 7; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < 7; j++){
                array[i][j] = Integer.valueOf(str.nextToken());
            }
        }
        check[0][0] = true;
        DFS(0, 0, array, check);

        bw.write(String.valueOf(count));
        bw.flush();

    }

    public static void DFS(int x, int y, int[][] array, boolean[][] check){
        if(x == 6 && y == 6){
            count++;
            return;
        }

        for(int i = 0; i < 4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];

            if(xx < 0 || xx > 6 || yy < 0 || yy > 6 || array[xx][yy] == 1 || check[xx][yy])
                continue;

            check[xx][yy] = true;
            DFS(xx,yy,array,check);
            check[xx][yy] = false;
        }
    }
}
